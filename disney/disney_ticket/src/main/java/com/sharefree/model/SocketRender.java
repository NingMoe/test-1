package com.sharefree.model;

public class SocketRender {

	/**
	 * 私信用户正常消息
	 * 
	 * @param optName
	 * @param code
	 * @param msg
	 * @return
	 */
	public static SocketResult pointInfoResult(String optName, String code, String msg) {
		return new SocketResult(optName, SocketResult.Type.INFO, code, msg);
	}

	/**
	 * 私信用户错误消息
	 * 
	 * @param optName
	 * @param code
	 * @param msg
	 * @return
	 */
	public static SocketResult pointErrorResult(String optName, String code, String msg) {
		return new SocketResult(optName, SocketResult.Type.ERROR, code, msg);
	}

	/**
	 * 私信系统正常消息
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static SocketResult pointInfoResult(String code, String msg) {
		return new SocketResult(SocketResult.Type.INFO, code, msg);
	}

	/**
	 * 广播系统正常消息
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static SocketResult broadInfoResult(String code, String msg) {
		return new SocketResult(SocketResult.Type.INFO, code, msg);
	}

	/**
	 * 广播系统错误消息
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static SocketResult broadErrorResult(String code, String msg) {
		return new SocketResult(SocketResult.Type.ERROR, code, msg);
	}

}
