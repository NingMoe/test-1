package com.sharefree.biz.itf.system;

import com.sharefree.common.CommonException;
import com.sharefree.model.system.OperatorModel;

public interface ILoginBiz {
	
	/**
	 * 操作员号登录
	 * 
	 * @param model
	 * @throws CommonException
	 */
	OperatorModel loginInByOptNo(OperatorModel model) throws CommonException;

	/**
	 * 手机号登陆
	 * 
	 * @param model
	 * @throws CommonException
	 */
	OperatorModel loginInByTelephoneNo(OperatorModel model) throws CommonException;

	/**
	 * 用户号登陆
	 * 
	 * 操作员号/手机号
	 * 
	 * @param model
	 * @throws CommonException
	 */
	OperatorModel loginInByUserNo(OperatorModel model) throws CommonException;
	
	/**
	 * 操作员注销
	 * 
	 * @throws CommonException
	 */
	void logout() throws CommonException;

}
