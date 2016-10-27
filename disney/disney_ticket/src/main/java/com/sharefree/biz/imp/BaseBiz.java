package com.sharefree.biz.imp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.Mvcs;

import com.sharefree.biz.itf.IBaseBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.BaseModel;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.service.itf.IBaseService;
import com.sharefree.service.itf.ISystemService;
import com.sharefree.utils.WebSystemUtils;

public class BaseBiz<Model extends BaseModel, Id> implements IBaseBiz<Model, Id> {

	@Inject
	protected ISystemService systemService;

	@Inject
	protected IBaseService<Model, Id> baseService;

	/**
	 * 获取当前系统时间
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected Date getSystemTime() throws CommonException {
		return systemService.getTime();
	}

	/**
	 * 获取当前HttpServletRequest信息
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected HttpServletRequest getRequest() throws CommonException {
		return Mvcs.getReq();
	}

	/**
	 * 获取当前登陆操作员信息
	 * 
	 * @return
	 * @throws CommonException
	 */
	protected OperatorModel currentOperator() throws CommonException {
		return WebSystemUtils.getLoginOpt(getRequest());
	}

	@Override
	public Model selectById(Id id) throws CommonException {
		return baseService.fetch(id);
	}

	@Override
	public List<Model> query(Model model) throws CommonException {
		return baseService.query(model);
	}

	@Override
	public int count(Model model) throws CommonException {
		return baseService.count(model);
	}

	@Override
	public Model save(Model model) throws CommonException {
		return baseService.insert(model);
	}

	@Override
	public int deleteById(Id id) throws CommonException {
		return baseService.delete(id);
	}

	@Override
	public int update(Model model) throws CommonException {
		return baseService.updateById(model, true);
	}

}
