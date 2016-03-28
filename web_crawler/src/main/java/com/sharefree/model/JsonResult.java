package com.sharefree.model;

import java.io.Serializable;

/**
 * response数据以json格式返回<br>
 * spring会包装JsonResult对象为json格式<br>
 * JsonResult中定义的属性为json数据的节点
 */

public class JsonResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8705605548405060307L;
	/**
	 * 操作结果成功与否
	 */
	private Boolean success = false;
	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * 如果是错误，错误信息
	 */
	private String customMsg;

	/**
	 * 如果是错误，错误信息
	 */
	private String exceptionMsg;

	/**
	 * 符合条件的记录总数
	 */
	private Integer total;
	/**
	 * 返回的数据结果集，如果不需要数据结果集，该值为null
	 */
	private Object results;

	/**
	 * 返回序列号
	 */
	private String token;

	/**
	 * 必须有一个无参构造函数
	 */
	public JsonResult() {
		super();
	}

	public JsonResult(boolean success, String msg, Object results) {
		this.success = success;
		this.msg = msg;
		this.results = results;
	}

	public JsonResult(boolean success, String msg, Integer total, Object results) {
		this.success = success;
		this.msg = msg;
		this.results = results;
		this.total = total;
	}

	public JsonResult(String msg) {
		this.msg = msg;
	}

	public JsonResult(String msg, String customMsg, String exceptionMsg) {
		this.success = false;
		this.msg = msg;
		this.customMsg = customMsg;
		this.exceptionMsg = exceptionMsg;
	}

	public JsonResult(Boolean success, String msg, String customMsg,
			String exceptionMsg, Integer total, Object results, String token) {
		super();
		this.success = success;
		this.msg = msg;
		this.customMsg = customMsg;
		this.exceptionMsg = exceptionMsg;
		this.total = total;
		this.results = results;
		this.token = token;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getResults() {
		return results;
	}

	public void setResults(Object results) {
		this.results = results;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonResult [msg=" + msg + ", results=" + results + ", success="
				+ success + ", total=" + total + "]";
	}

}
