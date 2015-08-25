package com.jike.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.system.biz.itf.IDatabaseDetectBiz;
import com.jike.system.model.DetectDatabaseModel;
import com.jike.system.util.StringUtil;
import com.jike.system.web.CommonException;
import com.jike.system.web.JsonResult;
import com.jike.system.web.ResultRender;
/** 
 *  
 * Title: DatabaseDetectController
 *
 * Description: 数据库检测控制类
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 17, 2015
 *
 */
@Controller
@RequestMapping("/databaseDetect")
public class DatabaseDetectController extends BaseController{

	private String modelName = "数据库检测数据";

	@Autowired
	private IDatabaseDetectBiz ddBiz;
	
	/**
	 * 按条件查询
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult selectByExample(HttpServletRequest request,
			@ModelAttribute DetectDatabaseModel ddm) throws CommonException {
		List<DetectDatabaseModel> ddms = ddBiz.selectByExample(ddm);
		return ResultRender.renderPagedResult(modelName + "：查询成功", ddms, ddms.size());
	}
	
	/**
	 * 添加
	 * 
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult insert(HttpServletRequest request,
			@ModelAttribute DetectDatabaseModel ddm) throws CommonException {
		ddBiz.add(ddm);
		return ResultRender.renderResult(modelName + "添加成功", ddm);
	}
	
	/**
	 * 切换任务状态
	 * 
	 * @param request
	 * @param id
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/switch/{toState}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResult switchState(HttpServletRequest request,
			@PathVariable String toState, @RequestBody DetectDatabaseModel ddm)
			throws CommonException {
		if(StringUtil.isNotEmpty(ddm.getTaskId())){
			ddBiz.switchState(ddm.getTaskId(), toState);
			return ResultRender.renderResult("任务状态切换成功", toState);
		}
		return ResultRender.renderErrorResult(modelName + "任务编号不能为空");
	}

}
