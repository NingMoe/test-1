package com.sharefree.biz.itf;

import java.util.List;

import com.sharefree.common.CommonException;
import com.sharefree.model.BaseModel;

/**
 * Title: IBaseBiz
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 17, 2016
 *
 */
public interface IBaseBiz<Model extends BaseModel, Id> {

	/**
	 * 按ID查询
	 * 
	 * @param id
	 * @return
	 * @throws CommonException
	 */
	Model selectById(Id id) throws CommonException;

	/**
	 * 根据条件，获取多条记录
	 * 
	 * @param model
	 * @return
	 */
	List<Model> query(Model model) throws CommonException;

	/**
	 * 根据条件，查询数量
	 * 
	 * @param model
	 * @return
	 */
	int count(Model model) throws CommonException;

	/**
	 * 添加
	 * 
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	Model save(Model model) throws CommonException;

	/**
	 * 按id删除
	 * 
	 * @param id
	 * @throws CommonException
	 */
	int deleteById(Id id) throws CommonException;

	/**
	 * 按ID修改
	 * 
	 * @param m
	 * @return
	 * @throws CommonException
	 */
	int update(Model model) throws CommonException;
	
}
