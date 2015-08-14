package com.jike.system.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jike.system.bean.DetectInterface;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.service.itf.IDetectInterfaceService;
import com.jike.system.util.DateUtils;
import com.jike.system.util.HttpClientUtil;
import com.jike.system.util.StringUtil;

@Service("interfaceDetectHandler")
@Transactional
public class InterfaceDetectHandler{

	private static Logger log = LoggerFactory.getLogger(InterfaceDetectHandler.class);
    
    public static final String EXECUTE_RESULT = "executeResult";
    public static final String EXECUTE_COOKIESTORE = "cookieStore";

	@Autowired
	private IDetectInterfaceService diService;
	
	public DetectInterface selectById(String id) throws Exception {
		return diService.selectById(id);
	}
	
	public List<DetectInterface> selectAll() throws Exception {
		return diService.selectAll();
	}
	
	// 主要执行方法
	public void execute(DetectInterface di){
		// 定义任务列表
		List<DetectInterface> dis = new ArrayList<DetectInterface>();
		// 获取任务组编号
		String taskGroupId = di.getTaskGroupId();
		if(StringUtil.isNotEmpty(taskGroupId)){
			DetectInterface diGroup = null;
			try {
				diGroup = selectById(taskGroupId);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	
	// 执行任务列表
	private void executeTaskList(List<DetectInterface> dis){
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
				respObject = HttpClientUtil.sendGetRequest(url, cookieStore);
			}
			else if(InterfaceConsts.REQUEST_METHOD_POST.equals(requestMethod)){
				// POST请求
				respObject = HttpClientUtil.sendPostRequest(url, params, null, encodeCharset);
			}
			// 获取Http请求返回值
			String respContent = (String) respObject.get(HttpClientUtil.RESPONSE_CONTENT);
			// 校验返回信息，并进行数据库，通知等操作
			boolean flag = vaildateRespContent(respContent, di);
			// 如果验证不通过就跳出循环
			if(!flag)
				break;
			// 设置下次执行请求的cookieStore
			cookieStore = (CookieStore)respObject.get(HttpClientUtil.RESPONSE_COOKIESTORE);
		}
	}
	
	// 校验返回信息，并进行数据库，通知等操作
	private boolean vaildateRespContent(String respContent, DetectInterface di){
		boolean checkSuccess = false;
		// 获取校验键
		String checkKey = di.getCheckKey();
		// 获取校验值
		String checkValue = di.getCheckValue();
		
		
		return checkSuccess;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 解析通知对象
	public static String[] analyzeNoticeObject(String noticeObject) {
		if(StringUtil.isNotEmpty(noticeObject)){
			return noticeObject.split(InterfaceConsts.NOTICE_OBJECT_SPLIT);
		}
		return null;
	}
	
	// 解析接口参数
	private static String analyzeParams(String params) {
		if(StringUtil.isNotEmpty(params)){
			Date newDate = new Date();
			String date = DateUtils.formatDayDate(newDate);
			String time = DateUtils.formatFullDate(newDate);
			params = params.replaceAll(InterfaceConsts.ITF_PARAMS_DATE, date);
			params = params.replaceAll(InterfaceConsts.ITF_PARAMS_TIME, time);
			return params;
		}
		return null;
	}

	
	// 解析接口参数
	public void setModel(DetectInterface detectInterface) {
		
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

