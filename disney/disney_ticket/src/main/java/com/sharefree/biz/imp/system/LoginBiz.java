package com.sharefree.biz.imp.system;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.sharefree.biz.imp.BaseBiz;
import com.sharefree.biz.itf.system.ILoginBiz;
import com.sharefree.common.CommonException;
import com.sharefree.model.system.OperatorModel;
import com.sharefree.service.itf.system.IOperatorService;
import com.sharefree.utils.WebSystemUtils;

@IocBean
public class LoginBiz extends BaseBiz<OperatorModel, Long> implements ILoginBiz {

	@Inject
	private IOperatorService operatorService;

	@Override
	public OperatorModel loginInByOptNo(OperatorModel model) throws CommonException {
		if (model == null)
			throw new CommonException("缺少参数");
		String optNo = model.getOptNo();
		if (optNo == null)
			throw new CommonException("操作员号不为空");
		String password = model.getPassword();
		if (password == null)
			throw new CommonException("密码不为空");
		// 登陆验证
		model = new OperatorModel();
		model.setOptNo(optNo);
		List<OperatorModel> models = operatorService.query(model);
		if (models != null) {
			model = models.get(0);
			// 密码验证
			if (!password.equals(model.getPassword()))
				throw new CommonException("密码错误");
		} else {
			throw new CommonException("操作员号不存在");
		}
		return model;
	}

	@Override
	public OperatorModel loginInByTelephoneNo(OperatorModel model)
			throws CommonException {
		if (model == null)
			throw new CommonException("缺少参数");
		String tel = model.getTel();
		if (tel == null)
			throw new CommonException("手机号不为空");
		String password = model.getPassword();
		if (password == null)
			throw new CommonException("密码不为空");
		// 登陆验证
		model = new OperatorModel();
		model.setTel(tel);
		List<OperatorModel> models = operatorService.query(model);
		if (models != null) {
			model = models.get(0);
			// 密码验证
			if (!password.equals(model.getPassword()))
				throw new CommonException("密码错误");
		} else {
			throw new CommonException("手机号不存在");
		}
		return model;
	}

	@Override
	public OperatorModel loginInByUserNo(OperatorModel model) throws CommonException {
		if (model == null)
			throw new CommonException("缺少参数");
		String userNo = model.getUserNo();
		if (userNo == null)
			throw new CommonException("用户号不为空");
		String password = model.getPassword();
		if (password == null)
			throw new CommonException("密码不为空");
		// 登陆验证
		model = new OperatorModel();
		model.setUserNo(userNo);
		List<OperatorModel> models = operatorService.query(model);
		if (models != null && models.size() > 0) {
			model = models.get(0);
			// 密码验证
			if (!password.equals(model.getPassword()))
				throw new CommonException("密码错误");
		} else {
			throw new CommonException("用户号不存在");
		}
		return model;
	}

	@Override
	public void logout() throws CommonException {
		String token = WebSystemUtils.getToken(getRequest());
		// 删除登陆token
		WebSystemUtils.deleteToken(token);
	}
	
}
