package com.jike.system.web;

public class ResultRender {

	/**
	 * 操作成功
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @return
	 */
	public static JsonResult renderResult(String msg) {
		return new JsonResult(true, msg, null);
	}
	
	/**
	 * 操作成功
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @param results
	 *            返回的数据
	 * @return
	 */
	public static JsonResult renderResult(String msg, Object results) {
		return new JsonResult(true, msg, results);
	}

	/**
	 * 操作成功<br>
	 * msg默认填“操作成功”
	 * 
	 * @param results
	 *            返回的数据
	 * @return
	 */
	public static JsonResult renderResult(Object results) {
		return new JsonResult(true, "操作成功", results);
	}

	/**
	 * 操作成功
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @param results
	 *            返回的数据
	 * @param total
	 *            返回数据的总条数
	 * @return
	 */
	public static JsonResult renderPagedResult(String msg, Object results,
			Integer total) {
		return new JsonResult(true, msg, total, results);
	}

	/**
	 * 操作成功 <br>
	 * msg默认填“操作成功”
	 * 
	 * @param results
	 *            返回的数据
	 * @param total
	 *            返回数据的总条数
	 * @return
	 */
	public static JsonResult renderPagedResult(Object results, Integer total) {
		return new JsonResult(true, "操作成功", total, results);
	}

	/**
	 * 操作成功
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @param results
	 *            返回的数据
	 * @return
	 */
	public static JsonResult renderLoginResult(String msg, Object results,
			String token) {
		JsonResult jr = new JsonResult(true, msg, results);
		jr.setToken(token);
		return jr;
	}

	/**
	 * 操作失败
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @return
	 */
	public static JsonResult renderErrorResult(String msg) {
		return new JsonResult(msg);
	}

	/**
	 * 操作失败
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @param exception
	 *            抛出的自定义异常
	 * @return
	 */
	public static JsonResult renderErrorResult(String msg,
			CommonException exception) {
		return new JsonResult(msg, exception.getCustomMsg(),
				exception.getExceptionMsg());
	}

	/**
	 * 操作失败
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @param exception
	 *            抛出的自定义异常
	 * @return
	 */
	public static JsonResult renderErrorResult(String msg, String customMsg,
			Object result) {
		JsonResult jr = new JsonResult(false, msg, result);
		jr.setCustomMsg(customMsg);
		return jr;
	}

	/**
	 * 操作失败
	 * 
	 * @param msg
	 *            前台可以直接显示的信息
	 * @param exception
	 *            抛出的自定义异常
	 * @return
	 */
	public static JsonResult renderErrorResult(String msg, Object result) {
		return new JsonResult(false, msg, result);
	}

	/**
	 * 操作失败 <br>
	 * msg默认填“操作失败”
	 * 
	 * @param exception
	 *            抛出的自定义异常
	 * @return
	 */
	public static JsonResult renderErrorResult(CommonException exception) {
		return new JsonResult(false, "操作失败", exception.getCustomMsg(),
				exception.getExceptionMsg(), null, exception.getInfoMap(), null);
	}

}
