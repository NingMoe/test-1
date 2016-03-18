package com.jike.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.system.biz.itf.IDetectAPIBiz;
import com.jike.system.model.DetectAPIConfigModel;
import com.jike.system.model.DetectAPIModel;
import com.jike.system.web.CommonException;
import com.jike.system.web.JsonResult;
import com.jike.system.web.ResultRender;

/**
 * Title: DetectAPIController
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 6, 2015
 *
 */
@Controller
@RequestMapping("/detectAPIController")
public class DetectAPIController extends BaseController{

	@Autowired
	private IDetectAPIBiz detectAPIBiz;

	/**
	 * 启动航班查询任务
	 * 
	 * @param request
	 * @param dapim
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/startTask", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult startTask(HttpServletRequest request, @RequestBody DetectAPIModel dapim)
			throws CommonException {
		detectAPIBiz.startTask(dapim);
		return ResultRender.renderResult("启动任务成功");
	}
	
	/**
	 * 停止航班查询任务
	 * 
	 * @param request
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/stopTask", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult stopTask(HttpServletRequest request)
			throws CommonException {
		detectAPIBiz.stopTask();
		return ResultRender.renderResult("停止任务成功");
	}
	

	@RequestMapping(value = "/configStrategy", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult configStrategy(HttpServletRequest request, @RequestBody DetectAPIConfigModel dapicm)
			throws CommonException {
		dapicm = detectAPIBiz.configStrategy(dapicm);
		return ResultRender.renderResult("配置任务成功", dapicm);
	}
	

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult query(HttpServletRequest request,@ModelAttribute DetectAPIModel dapim)
			throws CommonException {
		List<DetectAPIModel> dapims = detectAPIBiz.selectByExample(dapim);
		int count = detectAPIBiz.countByExample(dapim);
		if(count == 0){
			return ResultRender.renderErrorResult("未查询到检测数据");
		}else{
			List<List<Object>> results = formatData(dapims);
			return ResultRender.renderPagedResult("查询成功", results, count);
		}
	}
	
	public List<List<Object>> formatData(List<DetectAPIModel> dapims){
		List<List<Object>> datas = new ArrayList<List<Object>>();
		for(DetectAPIModel dapim : dapims){
			List<Object> data = new ArrayList<Object>();
			data.add(dapim.getTaskRunTime());
			data.add(dapim.getResultType());
			datas.add(data);
		}
		return datas;
	}

}
