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

import com.jike.system.biz.itf.IInterfaceDetectBiz;
import com.jike.system.consts.InterfaceConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.model.DetectInterfaceModel;
import com.jike.system.web.CommonException;
import com.jike.system.web.JsonResult;
import com.jike.system.web.ResultRender;
/** 
 *  
 * Title: InterfaceDetectController
 *
 * Description: 接口检测控制类
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 12, 2015
 *
 */
@Controller
@RequestMapping("/interfaceDetect")
public class InterfaceDetectController extends BaseController{

	private String modelName = "接口检测数据";

	@Autowired
	private IInterfaceDetectBiz idBiz;
	
	/**
	 * 按ID查询
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/query/{taskId}", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult selectById(HttpServletRequest request,
			@PathVariable String taskId) throws CommonException {
		DetectInterfaceModel dim = idBiz.selectById(taskId);
		dim.setCurrentFailureNum(InterfaceConsts.FAILURE_TIME.get(dim.getTaskId()));
		dim.setCurrentIsNotice(SysConsts.CURRENT_IS_NOTICE.contains(dim.getTaskId()));
		return ResultRender.renderResult(modelName + "：查询成功", dim);
	}
	
	/**
	 * 按条件查询
	 * 
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult selectByExample(HttpServletRequest request,
			@ModelAttribute DetectInterfaceModel dim) throws CommonException {
		List<DetectInterfaceModel> dims = idBiz.selectByExample(dim);
		return ResultRender.renderPagedResult(modelName + "：查询成功", dims,
				dims.size());
	}
	
	/**
	 * 添加
	 * 
	 * @param request
	 * @param dim
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult insert(HttpServletRequest request,
			@RequestBody DetectInterfaceModel dim) throws CommonException {
		dim = idBiz.insert(dim);
		return ResultRender.renderResult(modelName + "添加成功", dim);
	}
	
	/**
	 * 修改
	 * 
	 * @param request
	 * @param di
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResult updateById(HttpServletRequest request,
			@RequestBody DetectInterfaceModel dim)
			throws CommonException {
		dim = idBiz.updateByPrimaryKey(dim);
		return ResultRender.renderResult(modelName + "修改成功", dim);
	}
	
	/**
	 * 切换任务状态
	 * 
	 * @param request
	 * @param toState
	 * @param dim
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/switch", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResult switchState(HttpServletRequest request, @RequestBody DetectInterfaceModel dim)
			throws CommonException {
		dim = idBiz.switchState(dim);
		return ResultRender.renderResult("任务状态切换成功", dim);
	}

}
