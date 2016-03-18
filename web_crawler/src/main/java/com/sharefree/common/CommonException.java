package com.sharefree.common;

import java.util.Map;

public class CommonException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5350916965140356619L;

	private String customMsg;
	private String exceptionMsg;
	private String exceptionName;
	private Map<String, Object> infoMap;

	public CommonException(String customMsg) {
		super();
		this.customMsg = customMsg;
	}

	public CommonException(String customMsg, Map<String, Object> infoMap) {
		super();
		this.customMsg = customMsg;
		this.infoMap = infoMap;
	}

	public CommonException(String customMsg, String exceptionMsg) {
		this(customMsg);
		this.setExceptionMsg(exceptionMsg);
	}

	public CommonException(String customMsg, String exceptionMsg,
			StackTraceElement[] stackTrace) {
		this(customMsg, exceptionMsg);
		this.setStackTrace(stackTrace);
	}

	public CommonException(Exception exception) {
		this(null, exception);
	}

	public CommonException(String customMsg, CommonException exception) {
		super();
		this.customMsg = customMsg;
		this.setExceptionName(exception.toString());
		this.setExceptionMsg(exception.getMessage());
		this.setStackTrace(exception.getStackTrace());
		this.infoMap = exception.infoMap;
	}

	public CommonException(String customMsg, Exception exception) {
		super();
		this.customMsg = customMsg;
		this.setExceptionName(exception.toString());
		this.setExceptionMsg(exception.getMessage());
		this.setStackTrace(exception.getStackTrace());
	}

	public String getCustomMsg() {
		return customMsg;
	}

	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public Map<String, Object> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, Object> infoMap) {
		this.infoMap = infoMap;
	}

}
