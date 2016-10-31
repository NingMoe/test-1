package com.sharefree.model;

import java.io.Serializable;
import java.util.Date;

/**
 * socket 返回信息
 * 
 * @author luopan
 *
 */
public class SocketResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7969783637711003709L;

	private String optName;

	private String token;

	private Date time;

	private String code;

	private String msg;

	/**
	 * 默认构造方法
	 * 
	 * @param optName
	 *            操作员名称
	 * @param token
	 *            操作员token
	 * @param code
	 *            业务编码
	 * @param msg
	 *            返回消息
	 */
	public SocketResult(String optName, String token, String code, String msg) {
		this.optName = optName;
		this.token = token;
		this.time = new Date();
		this.code = code;
		this.msg = msg;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
