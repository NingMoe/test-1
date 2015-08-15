package com.jike.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.system.web.CommonException;
import com.jike.system.web.JsonResult;
import com.jike.system.web.ResultRender;


/**
 * 基础Controller,捕获后台的错误，返回给前端 ; 可以自定义捕获错误<br>
 * Controller现在的功能： 成功数据的返回，失败信息的返回，错误的捕获
 * 
 * @author Sun
 * 
 */
public abstract class BaseController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 集中异常处理
	 * 
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler
	@ResponseBody
	public JsonResult handlerException(CommonException e) throws Exception {
		log.error("BaseController 捕获异常 并将错误返回前台 ", e);
		log.error("{}\n{}\n{}", e.getExceptionName(), e.getCustomMsg(),
				e.getExceptionMsg());

		return  ResultRender.renderErrorResult(e);
	}

}
