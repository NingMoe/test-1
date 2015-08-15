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

import com.jike.system.bean.DetectInterface;
import com.jike.system.service.itf.IDetectInterfaceService;
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

	private String modelName = "检测接口数据";

	@Autowired
	private IDetectInterfaceService diService;
	
	/**
	 * 按ID查询
	 * @param request
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/{itfId}", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult selectById(HttpServletRequest request,
			@PathVariable String itfId) throws CommonException {
		DetectInterface di = diService.selectById(itfId);
		return ResultRender.renderResult(modelName + "：查询成功", di);
	}
	
	/**
	 * 修改
	 * 
	 * @param request
	 * @param id
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/{itfId}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResult updateById(HttpServletRequest request,
			@PathVariable String itfId, @RequestBody DetectInterface di)
			throws CommonException {
//		diService.updateById(m, mqId);
		return ResultRender.renderResult(modelName + "修改成功", di);
	}
	
	/**
	 * 按条件查询
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult selectByExample(HttpServletRequest request,
			@ModelAttribute DetectInterface di) throws CommonException {
		List<DetectInterface> dis = diService.selectAll();
		return ResultRender.renderPagedResult(modelName + "：按条件查询成功", dis,
				dis.size());
	}
	/**
	 * 添加
	 * 
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult insert(HttpServletRequest request,
			@RequestBody DetectInterface di) throws CommonException {
		
		return ResultRender.renderResult(modelName + "添加成功", di);
	}

}
