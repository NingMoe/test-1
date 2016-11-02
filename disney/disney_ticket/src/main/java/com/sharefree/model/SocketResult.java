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

	private Type type;

	private Date time;

	private String code;

	private String msg;

	public static enum Type {
		INFO, WARN, ERROR
	}

	/**
	 * 默认构造方法
	 */
	public SocketResult() {
	}

	/**
	 * 构造方法
	 * 
	 * @param optName
	 *            操作员名称
	 * @param type
	 *            消息类别
	 * @param code
	 *            业务编码
	 * @param msg
	 *            返回消息
	 */
	public SocketResult(String optName, Type type, String code, String msg) {
		this.optName = optName;
		this.type = type;
		this.time = new Date();
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 构造方法（系统消息）
	 * 
	 * @param type
	 *            消息类别
	 * @param code
	 *            业务编码
	 * @param msg
	 *            返回消息
	 */
	public SocketResult(Type type, String code, String msg) {
		this.optName = "系统";
		this.type = type;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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
