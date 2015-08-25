package com.jike.system.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.bean.DetectInterface;
import com.jike.system.bean.DetectLog;
import com.jike.system.biz.itf.IInterfaceDetectBiz;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.core.QuartzManager;
import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.quartz.InterfaceDetectJob;
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.util.DateUtils;
import com.jike.system.util.HttpClientUtil;
import com.jike.system.util.MD5Util;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;

@Service("interfaceDetectBiz")
@Transactional
public class InterfaceDetectBiz implements IInterfaceDetectBiz {

	private static Logger log = LoggerFactory.getLogger(InterfaceDetectBiz.class);

	@Autowired
	private IDetectInterfaceService diService;
	@Autowired
	private IDetectLogService dlService;

	@Override
	public DetectInterface selectById(String id) throws CommonException {
		return diService.selectById(id);
	}

	@Override
	public List<DetectInterface> selectAll() throws CommonException {
		return diService.selectAll();
	}

	@Override
	public List<DetectInterfaceModel> selectByExample(DetectInterfaceModel dim) throws CommonException {
		return diService.selectByExample(dim);
	}
	
	@Override
	public DetectInterfaceModel insert(DetectInterfaceModel dim) throws CommonException {
		// 新创建之前验证信息
		vaildate(dim);
		// 数据标识符是否重复
		List<DetectInterface> dims = selectAll();
		if(dims != null){
			String newGuid = dim.getItfUrl()+dim.getRequestMethod()+dim.getItfParams();
			for(DetectInterface dime : dims){
				String existGuid = dime.getGuid();
				if(newGuid.equals(existGuid)){
					new CommonException("该条接口检测数据已经存在");
				}
			}
		}
		// 初始化时间
		Date newTime = new Date();
		// 是否是组任务
		if(dim.isTaskGroupFlag()){
			dim.setTaskId(diService.getNextTaskId(InterfaceConsts.TASK_ID_HEAD_GTASK));
		}else{
			dim.setTaskId(diService.getNextTaskId(InterfaceConsts.TASK_ID_HEAD_TASKS));
		}
		// 初始化当前检测失败次数
		dim.setCurrentFailureNum(0);
		// 初始化状态为：关闭
		dim.setState(SysConsts.DETECT_STATE_CLOSE);
		// 初始化累计通知次数为：0次
		dim.setTotalNoticeNum(0);
		// 初始化新建和修改时间
		dim.setCreateTime(newTime);
		dim.setUpdateTime(newTime);
		// 初始化数据标识符
		dim.setGuid(MD5Util.md5(dim.getItfUrl()+dim.getRequestMethod()+dim.getItfParams()).toUpperCase());
		diService.insert(dim);
		return dim;
	}

	@Override
	public DetectInterface updateByPrimaryKey(DetectInterface di) throws CommonException {
		diService.updateByPrimaryKey(di);
		return di;
	}

	@Override
	public DetectInterfaceModel switchState(DetectInterfaceModel dim, String toState)
			throws CommonException {
		DetectInterface di = selectById(dim.getTaskId());
		String jobName = di.getTaskId();
		String jobGroupName = (di.getTaskGroupId()==null?InterfaceConsts.DEFAULT_GROUP:di.getTaskGroupId());
		String triggerName =  di.getTaskId();
		String triggerGroupName = InterfaceConsts.DEFAULT_GROUP;
		di.setState(toState);
		updateByPrimaryKey(di);
		try {
			if(SysConsts.DETECT_STATE_CLOSE.equals(toState)){
				QuartzManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
			}
			else if(SysConsts.DETECT_STATE_RUN.equals(toState)){
				if(QuartzManager.vaildateTriggerExist(triggerName, triggerGroupName)){
					QuartzManager.resume(triggerName, triggerGroupName);
				}else{
					QuartzManager.addSimpleJob(jobName, jobGroupName, triggerName, triggerGroupName, 
							InterfaceDetectJob.class, null, null, SimpleTrigger.REPEAT_INDEFINITELY, di.getFrequency());
					// 添加job连续失败次数
					InterfaceConsts.FAILURE_TIME.put(jobName, 0);
				}
			}
			else if(SysConsts.DETECT_STATE_STOP.equals(toState)){
				QuartzManager.pause(triggerName, triggerGroupName);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			new CommonException("开启接口检测["+jobName+"]定时任务出错：", e);
			log.info("开启接口检测["+jobName+"]定时任务出错：", e);
		}
		return dim;
	}
	
	/*
	 * 主要执行方法
	 */
	@Override
	public void execute(DetectInterface di) throws CommonException {
		log.debug("主要执行方法");
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
	private void executeTaskList(List<DetectInterface> dis) {
		log.debug("执行任务列表，并进行数据库，通知等操作");
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
			DetectLog dl = new DetectLog();
			// 记录检测类型
			dl.setLogType(SysConsts.LOG_TYPE_INTERFACE);
			// 记录检测时间
			dl.setLogTime(new Date());
			// 记录检测编号
			dl.setTaskId(di.getTaskId());
			// 记录传递参数
			try {
				dl.setInputParams(StringUtil.subStrb(params, 500, SysConsts.DATABASE_ENCODING));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			// 如果校验成功
			if(checkSuccess){
				// 初始化当前检测失败次数
//				di.setCurrentFailureNum(0);
				InterfaceConsts.FAILURE_TIME.put(di.getTaskId(), 0);
				// 记录接口检测结果:成功
				dl.setDetectResult(SysConsts.DETECT_RESULT_SUCCESS);
			}else{
				// 当前检测失败次数+1
				int failureNum = InterfaceConsts.FAILURE_TIME.get(di.getTaskId()) + 1;
				// 当前失败次数是否超过阈值
				if(failureNum > di.getThresholdValue()){
					// 如果当日该接口未发送警报
					if(!SysConsts.CURRENT_IS_NOTICE.contains(di.getTaskId())){
						log.info("当前失败次数已超过阈值，将发送短信提示相关人员……");
						// 发送警报
						String[] message = createSms(di);
						SmsHandler.sendMessage(message);
						log.info("提示短信已发送");
						// 记录当日该接口已发送警报
						SysConsts.CURRENT_IS_NOTICE.add(di.getTaskId());
						// 累计警报次数+1
						di.setTotalNoticeNum(di.getTotalNoticeNum() + 1);
						// 设置接口检测状态为：暂停
						di.setState(SysConsts.DETECT_STATE_STOP);
						// 更新到数据库
						diService.updateByPrimaryKey(di);
					}
				}else{
					// 当前失败次数超过阈值不记录
//					di.setCurrentFailureNum(failureNum);
					InterfaceConsts.FAILURE_TIME.put(di.getTaskId(), failureNum);
				}
				// 记录接口检测结果:失败
				dl.setDetectResult(SysConsts.DETECT_RESULT_FAILURE);
				// 记录错误信息
				try {
					dl.setErrorInfo(StringUtil.subStrb(respContent, 500, SysConsts.DATABASE_ENCODING));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 更新到数据库
			dlService.insert(dl);
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
	private boolean vaildateRespContent(String respContent, DetectInterface di) {
		log.debug("校验返回信息");
		// 定义是否校验成功
		boolean checkSuccess = true;
		// 获取校验值1
		String checkValue1 = di.getCheckValue1();
		// 获取校验值2
		String checkValue2 = di.getCheckValue2();
		// 默认第一个校验值不为空
		if(StringUtil.isEmpty(checkValue1)||!respContent.contains(checkValue1)){
			checkSuccess = false;
		}
		if(StringUtil.isNotEmpty(checkValue2)&&!respContent.contains(checkValue2)){
			checkSuccess = false;
		}
		return checkSuccess;
	}
	
	/*
	 * 解析通知对象
	 */
	public static String[] createSms(DetectInterface di) {
		String[] message = new String[2];
		String noticeObject = di.getNoticeObject();
		if(StringUtil.isNotEmpty(noticeObject)){
			noticeObject = noticeObject.replace(SysConsts.NOTICE_OBJECT_SPLIT, SmsHandler.MOBILE_SPLIT);
		}
		// 组装警报对象
		message[0] = noticeObject;
		// 组装警报内容
		StringBuffer sb = new  StringBuffer();
		sb.append("系统["+di.getBelongTo()+"]接口-->");
		sb.append(" URL:"+di.getItfUrl());
		sb.append(" 参数:"+analyzeParams(di.getItfParams()));
		sb.append(" 通过"+di.getRequestMethod()+"请求");
		sb.append("连续访问"+di.getThresholdValue()+"次失败！请及时查看并解决！");
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
	public void vaildate(DetectInterfaceModel dim){
		if(StringUtil.isEmpty(dim.getTaskId())){
			new CommonException("接口检测数据--任务编号不能为空");
		}
		if(StringUtil.isEmpty(dim.getItfUrl())){
			new CommonException("接口检测数据--接口地址不能为空");
		}
		if(StringUtil.isEmpty(dim.getItfParams())){
			new CommonException("接口检测数据--接口参数不能为空");
		}
		if(StringUtil.isEmpty(dim.getRequestMethod())){
			new CommonException("接口检测数据--请求方式不能为空");
		}
		if(StringUtil.isEmpty(dim.getCheckValue1())){
			new CommonException("接口检测数据--校验值1不能为空");
		}
		if(dim.getFrequency() == 0){
			new CommonException("接口检测数据--检测频率不能为空和0");
		}
		if(dim.getThresholdValue() == 0){
			new CommonException("接口检测数据--阈值不能为空和0");
		}
		if(StringUtil.isEmpty(dim.getNoticeObject())){
			new CommonException("接口检测数据--警报对象不能为空");
		}
	}
	
}

