package com.jike.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jike.system.bean.DetectDatabase;
import com.jike.system.consts.DatabaseConsts;
import com.jike.system.consts.SysConsts;
import com.jike.system.model.DetectDatabaseModel;
import com.jike.system.service.itf.IDetectDatabaseService;
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
	private IDetectDatabaseService ddService;
	
	private Map<String, Object> masterSwitchResult;
	
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
		List<Map<String, String>> dds = new ArrayList<Map<String, String>>();
		if(StringUtil.isNotEmpty(ddm.getTaskId())){
			dds.add(DatabaseConsts.DETECT_DATABASE.get(ddm.getTaskId()));
		}else{
			dds.addAll(DatabaseConsts.DETECT_DATABASE.values());
		}
		List<DetectDatabaseModel> ddms = new ArrayList<DetectDatabaseModel>();
		if(dds.size() > 0){
			for(Map<String, String> dd : dds){
				ddm = new DetectDatabaseModel();
				ddm.setTaskId(dd.get(DatabaseConsts.TASK_ID));
				ddm.setTaskGroupId(dd.get(DatabaseConsts.TASK_GROUP_ID));
				ddm.setDbDriver(dd.get(DatabaseConsts.DB_DRIVER));
				ddm.setDbUrl(dd.get(DatabaseConsts.DB_URL));
				ddm.setDbUsername(dd.get(DatabaseConsts.DB_USERNAME));
				ddm.setDbPassword(dd.get(DatabaseConsts.DB_PASSWORD));
				ddm.setFrequency(dd.get(DatabaseConsts.FREQUENCY));
				ddm.setThresholdValue(Integer.valueOf(dd.get(DatabaseConsts.THRESHOLD_VALUE)));
				ddm.setCurrentFailureNum(Integer.valueOf(dd.get(DatabaseConsts.CURRENT_FAILURE_NUM)));
				ddm.setNoticeLvl(dd.get(DatabaseConsts.NOTICE_LVL));
				ddm.setNoticeObject(dd.get(DatabaseConsts.NOTICE_OBJECT));
				ddm.setState(dd.get(DatabaseConsts.STATE));
				ddm.setCurrentIsNotice(SysConsts.CURRENT_IS_NOTICE.contains(dd.get(DatabaseConsts.TASK_ID)));
				ddms.add(ddm);
			}
		}
		return ResultRender.renderPagedResult(modelName + "：查询成功", ddms, ddms.size());
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
	@RequestMapping(value = "/{taskId}", method = RequestMethod.PUT)
	@ResponseBody
	public JsonResult updateById(HttpServletRequest request,
			@PathVariable String taskId, @RequestBody DetectDatabase dd)
			throws CommonException {
//		ddService.updateById(m, mqId);
		return ResultRender.renderResult(modelName + "修改成功", dd);
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
			@ModelAttribute DetectDatabase dd) throws CommonException {
		
		return ResultRender.renderResult(modelName + "添加成功", dd);
	}

	/**
	 * 接口检测总开关开启状态查询
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
		if(DatabaseConsts.MASTER_SWITCH_OPEN){
			flagName = "已开启";
		}else{
			flagName = "已关闭";
		}
		masterSwitchResult = new HashMap<String, Object>();
		masterSwitchResult.put("flag", DatabaseConsts.MASTER_SWITCH_OPEN);
		masterSwitchResult.put("flagName", flagName);
		
		return ResultRender.renderResult("数据库检测总开关状态查询成功", masterSwitchResult);
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
		if(flag){
			flagName = "已开启";
		}else{
			flagName = "已关闭";
		}
		if(flag!=DatabaseConsts.MASTER_SWITCH_OPEN)
			DatabaseConsts.MASTER_SWITCH_OPEN = flag;
		masterSwitchResult = new HashMap<String, Object>();
		masterSwitchResult.put("flag", DatabaseConsts.MASTER_SWITCH_OPEN);
		masterSwitchResult.put("flagName", flagName);
		
		return ResultRender.renderResult("数据库检测总开关"+flagName, masterSwitchResult);
	}

}
