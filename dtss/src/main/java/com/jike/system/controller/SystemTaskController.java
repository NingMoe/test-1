package com.jike.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.core.Job;
import com.jike.system.core.QuartzManager;
import com.jike.system.web.CommonException;
import com.jike.system.web.JsonResult;
import com.jike.system.web.ResultRender;
/** 
 *  
 * Title: DatabaseDetectController
 *
 * Description: 系统任务控制类
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 17, 2015
 *
 */
@Controller
@RequestMapping("/systemTask")
public class SystemTaskController extends BaseController{

	private String modelName = "系统任务";

	
	private Map<String, Object> masterSwitchResult;

	/**
	 * 系统任务总开关开启状态查询
	 * 
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/masterSwitch", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult masterSwitchQuery(HttpServletRequest request) throws CommonException {
		String flagName = "未知";
		if(SysConsts.MASTER_SWITCH_OPEN){
			flagName = "已开启";
		}else{
			flagName = "已关闭";
		}
		masterSwitchResult = new HashMap<String, Object>();
		masterSwitchResult.put("flag", SysConsts.MASTER_SWITCH_OPEN);
		masterSwitchResult.put("flagName", flagName);
		
		return ResultRender.renderResult(modelName+"总开关状态查询成功", masterSwitchResult);
	}
	
	/**
	 * 开启或关闭接口检测总开关
	 * 
	 * @param request
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	@RequestMapping(value = "/masterSwitch/{flag}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResult switchMaster(HttpServletRequest request,
			@PathVariable boolean flag) throws CommonException {
		String flagName = "未知";
		if(!QuartzManager.isStart()){
			QuartzManager.start();
		}
		if(flag){
			QuartzManager.resumeAll();
			flagName = "已开启";
		}else{
			QuartzManager.pauseAll();
			flagName = "已关闭";
		}
		if(flag!=SysConsts.MASTER_SWITCH_OPEN)
			SysConsts.MASTER_SWITCH_OPEN = flag;
		masterSwitchResult = new HashMap<String, Object>();
		masterSwitchResult.put("flag", SysConsts.MASTER_SWITCH_OPEN);
		masterSwitchResult.put("flagName", flagName);
		
		return ResultRender.renderResult(modelName+"总开关"+flagName, masterSwitchResult);
	}
	

	@RequestMapping(value = "/queryJobs", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult queryJobs(HttpServletRequest request) throws CommonException {
		List<Job> jobs = QuartzManager.queryJobs(DatabaseConsts.DEFAULT_GROUP);
		if(!jobs.isEmpty()){
			for(Job job : jobs){
				job.setFailureTime(Integer.parseInt(DatabaseConsts.DETECT_DATABASE.get(job.getJobName()).get(DatabaseConsts.CURRENT_FAILURE_NUM)));
			}
		}
		return ResultRender.renderPagedResult(modelName+"任务查询成功", jobs, jobs.size());
	}

}
