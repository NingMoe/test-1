package com.jike.system.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jike.system.util.StringUtil;


public class CommonException extends RuntimeException {

	static Logger log = LoggerFactory.getLogger(CommonException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 6579921993076657352L;

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

	/**
	 * 通配符的替换
	 * 
	 * @param errorMsg
	 * @param param
	 * @return
	 */
	public static String msg(String errorMsg, String param) {
		if (!StringUtil.isEmpty(errorMsg)) {
			errorMsg = errorMsg.replaceFirst("\\{\\}", param);
		}
		return errorMsg;
	}

	public static String msg(String errorMsg, String param1, String param2) {
		if (!StringUtil.isEmpty(errorMsg)) {
			errorMsg = errorMsg.replaceFirst("\\{\\}", param1);
			errorMsg = errorMsg.replaceFirst("\\{\\}", param2);
		}
		return errorMsg;
	}

	public static String msg(String errorMsg, String... params) {
		for (String param : params) {
			errorMsg = errorMsg.replaceFirst("\\{\\}", param);
		}
		return errorMsg;
	}

	public static void main(String[] args) {
		System.out.println(CommonException.msg("sadfsf{}fsd{}", new String[] {
				"A", "B", "C" }));
	}

}
