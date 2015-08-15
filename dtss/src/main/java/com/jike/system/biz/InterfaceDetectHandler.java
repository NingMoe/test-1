package com.jike.system.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.bean.DetectInterface;
import com.jike.system.bean.DetectInterfaceLog;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.service.itf.IDetectInterfaceLogService;
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.util.DateUtils;
import com.jike.system.util.HttpClientUtil;
import com.jike.system.util.StringUtil;

@Service("interfaceDetectHandler")
@Transactional
public class InterfaceDetectHandler{

	private static Logger log = LoggerFactory.getLogger(InterfaceDetectHandler.class);

	@Autowired
	private IDetectInterfaceService diService;
	@Autowired
	private IDetectInterfaceLogService dilService;
	
	public DetectInterface selectById(String id) throws Exception {
		return diService.selectById(id);
	}
	
	public List<DetectInterface> selectAll() throws Exception {
		return diService.selectAll();
	}
	
	/*
	 * 主要执行方法
	 */
	public void execute(DetectInterface di) throws Exception{
		log.info("主要执行方法");
		// 定义任务列表
		List<DetectInterface> dis = new ArrayList<DetectInterface>();
		// 获取任务组编号
		String taskGroupId = di.getTaskGroupId();
		if(StringUtil.isNotEmpty(taskGroupId)){
			DetectInterface diGroup = selectById(taskGroupId);
			if(diGroup != null){
				// 添加组任务
				dis.add(diGroup);
			}
		}
		// 添加子任务
		dis.add(di);
		// 执行任务列表
		executeTaskList(dis);
	}
	
	/*
	 * 执行任务列表，并进行数据库，通知等操作
	 */
	private void executeTaskList(List<DetectInterface> dis) throws Exception{
		log.info("执行任务列表，并进行数据库，通知等操作");
		// 最先请求无cookieStore对象，设为空
		CookieStore cookieStore = null;
		// 遍历任务列表
		for(DetectInterface di: dis){
			//Http请求接收返回对象
			Map<String, Object> respObject = null;
			// 获取待发送URL
			String url = di.getItfUrl();
			// 获取参数
			String params = analyzeParams(di.getItfParams());
			// 设置编码
			String encodeCharset = InterfaceConsts.REQUEST_ENCODECHARSET;
			// 获取请求方式
			String requestMethod = di.getRequestMethod();
			// 不同请求方式不同方法
			if(InterfaceConsts.REQUEST_METHOD_GET.equals(requestMethod)){
				// GET请求
				url = url + "?" + params;
				respObject = HttpClientUtil.sendGetRequest(url, cookieStore);
			}
			else if(InterfaceConsts.REQUEST_METHOD_POST.equals(requestMethod)){
				// POST请求
				respObject = HttpClientUtil.sendPostRequest(url, params, cookieStore, encodeCharset);
			}
			// 获取Http请求返回值
			String respContent = (String) respObject.get(HttpClientUtil.RESPONSE_CONTENT);
			// 校验返回信息，并进行数据库，通知等操作
			boolean checkSuccess = vaildateRespContent(respContent, di);
			// 记录此次检测数据
			DetectInterfaceLog dil = new DetectInterfaceLog();
			// 记录检测时间
			dil.setDetectTime(new Date());
			// 记录接口编号
			dil.setItfId(di.getItfId());
			// 记录传递参数
			dil.setInputParams(StringUtil.subStrb(params, 500, SysConsts.DATABASE_ENCODING));
			// 如果校验成功
			if(checkSuccess){
				// 初始化当前检测失败次数
				short failureNum = 0;
				di.setThresholdValue(failureNum);

				// 记录接口检测结果:成功
				dil.setDetectResult(InterfaceConsts.DETECT_RESULT_SUCCESS);
			}else{
				// 当前检测失败次数+1
				short failureNum = (short) (di.getCurrentFailureNum() + 1);
				// 当前失败次数是否超过阈值
				if(failureNum > di.getThresholdValue()){
					// 如果当日该接口未发送警报
					if(!InterfaceConsts.CURRENT_IS_NOTICE.contains(di.getItfId())){
						log.info("当前失败次数已超过阈值，将发送短信提示相关人员……");
						// 发送警报
						String[] message = createSms(di);
						SmsHandler.sendMessage(message);
						log.info("提示短信已发送");
						// 记录当日该接口已发送警报
						InterfaceConsts.CURRENT_IS_NOTICE.add(di.getItfId());
						// 累计警报次数+1
						di.setTotalNoticeNum(di.getTotalNoticeNum() + 1);
						// 设置接口检测状态为：暂停
						di.setState(InterfaceConsts.ITF_DETECT_STATE_STOP);
					}
				}else{
					// 当前失败次数超过阈值不记录
					di.setCurrentFailureNum(failureNum);
				}
				
				// 记录接口检测结果:失败
				dil.setDetectResult(InterfaceConsts.DETECT_RESULT_FAILURE);
				// 记录错误信息
				dil.setErrorInfo(StringUtil.subStrb(respContent, 500, SysConsts.DATABASE_ENCODING));
				
			}
			// 更新到数据库
			diService.updateByPrimaryKey(di);
			dilService.insert(dil);
			// 如果验证不通过就跳出循环
			if(!checkSuccess)
				break;
			// 设置下次执行请求的cookieStore
			cookieStore = (CookieStore)respObject.get(HttpClientUtil.RESPONSE_COOKIESTORE);
		}
	}
	
	/*
	 * 校验返回信息
	 */
	private boolean vaildateRespContent(String respContent, DetectInterface di) throws Exception{
		log.info("校验返回信息");
		// 定义是否校验成功
		boolean checkSuccess = false;
		// 获取校验键
		String checkKey = di.getCheckKey();
		// 获取校验值
		String checkValue = di.getCheckValue();
		// 获取respContent中key对应的value
		String value = StringUtil.getKeyValue(respContent, checkKey);
		// 如何相等
		if(checkValue.equals(value))
			checkSuccess = true;
		return checkSuccess;
	}
	
	/*
	 * 解析通知对象
	 */
	public static String[] createSms(DetectInterface di) {
		String[] message = new String[2];
		String noticeObject = di.getNoticeObject();
		if(StringUtil.isNotEmpty(noticeObject)){
			noticeObject = noticeObject.replace(InterfaceConsts.NOTICE_OBJECT_SPLIT, SmsHandler.MOBILE_SPLIT);
		}
		// 组装警报对象
		message[0] = noticeObject;
		// 组装警报内容
		StringBuffer sb = new  StringBuffer();
		sb.append("系统["+di.getBelongTo()+"]接口-->");
		sb.append(" URL:"+di.getItfUrl());
		sb.append(" 参数:"+di.getItfParams());
		sb.append(" 通过"+di.getRequestMethod()+"请求");
		sb.append("连续访问"+di.getDetectFrequency()+"次失败！请及时查看并解决！");
		message[1] = sb.toString();
		return message;
	}
	
	/*
	 * 解析接口参数
	 */
	private static String analyzeParams(String params) {
		if(StringUtil.isNotEmpty(params)){
			Date newDate = new Date();
			String date = DateUtils.formatDayDate(newDate);
			String time = DateUtils.formatFullDate(newDate);
			params = params.replace(InterfaceConsts.ITF_PARAMS_DATE, date);
			params = params.replace(InterfaceConsts.ITF_PARAMS_TIME, time);
			return params;
		}
		return null;
	}
	
	/*
	 * 验证待检测数据合法性
	 */
	public static boolean vaildate(DetectInterface di){
		boolean isLegal = false;
		
		// 待验证条件
		
		return isLegal;
	}
	
}

