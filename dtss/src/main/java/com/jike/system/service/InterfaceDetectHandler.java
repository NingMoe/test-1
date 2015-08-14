package com.jike.system.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.consts.InterfaceConsts;
import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.util.DateUtils;
import com.jike.system.util.StringUtil;

public class InterfaceDetectHandler {

	private static Logger log = LoggerFactory.getLogger(InterfaceDetectHandler.class);
	
	private DetectInterfaceModel detectInterfaceModel;
	
	public static void execute(DetectInterfaceModel detectInterfaceModel){
		
		String newParams = analyzeParams(detectInterfaceModel.getItfParams());
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
	public void setModel(DetectInterfaceModel detectInterfaceModel) {
		
	}
	

	public DetectInterfaceModel getDetectInterfaceModel() {
		return detectInterfaceModel;
	}

	public void setDetectInterfaceModel(DetectInterfaceModel detectInterfaceModel) {
		this.detectInterfaceModel = detectInterfaceModel;
	}
	



	
}

