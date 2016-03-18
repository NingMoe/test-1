package com.sharefree.biz.itf;

import java.util.List;

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
public interface IBaseBiz<Model, Id> {

	/**
	 * 按ID查询
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Model selectById(Id id) throws Exception;

	/**
	 * 查询所有
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Model> selectAll() throws Exception;

	/**
	 * 查询所有数量
	 * 
	 * @return
	 * @throws Exception
	 */
	int countAll() throws Exception;

	/**
	 * 添加
	 * 
	 * @param m
	 * @return
	 * @throws Exception
	 */
	Model save(Model m) throws Exception;

	/**
	 * 按id删除
	 * 
	 * @param id
	 * @throws Exception
	 */
	int deleteById(Id id) throws Exception;

	/**
	 * 按ID修改
	 * 
	 * @param m
	 * @return
	 * @throws Exception
	 */
	int update(Model m) throws Exception;
	
}
