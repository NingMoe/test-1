package com.jike.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.system.model.DetectLogModel;
import com.jike.system.service.itf.IDetectLogService;
import com.jike.system.web.CommonException;
import com.jike.system.web.JsonResult;
import com.jike.system.web.ResultRender;
/** 
 *  
 * Title: DetectLogController
 *
 * Description: 检测日志控制类
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 24, 2015
 *
 */
@Controller
@RequestMapping("/detectLog")
public class DetectLogController extends BaseController{

	private String modelName = "检测日志";

	@Autowired
	private IDetectLogService dlService;
	
	/**
	 * 查询检测日志信息
	 * 
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult query(HttpServletRequest request, 
			@ModelAttribute DetectLogModel dlm) throws CommonException {
		List<DetectLogModel> dlms = dlService.selectByExample(dlm);
		return ResultRender.renderPagedResult(modelName+"查询成功", dlms, dlms.size());
	}

}
