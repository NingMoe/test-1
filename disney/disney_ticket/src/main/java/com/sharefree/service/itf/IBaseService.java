package com.sharefree.service.itf;

import java.util.List;

import com.sharefree.model.BaseModel;

/**
 * 
 * Title: IBaseService
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
public interface IBaseService<Model extends BaseModel, Id> {

	/**
	 * 根据主键，获取一条记录
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	Model fetch(Id id);

	/**
	 * 根据条件，获取多条记录
	 * 
	 * @param cnd
	 *            查询条件（Model内部包含分页信息）
	 * @return
	 */
	List<Model> query(Model cnd);

	/**
	 * 根据条件，获取多条记录
	 * 
	 * @param cnd
	 *            查询条件（Model内部包含分页信息）
	 * @return
	 */
	List<Model> queryByCustomSQL(Model cnd);

	/**
	 * 根据条件，查询数量
	 * 
	 * @param cnd
	 *            查询条件
	 * @return
	 */
	int count(Model cnd);

	/**
	 * 根据条件，查询数量
	 * 
	 * @param cnd
	 *            查询条件
	 * @return
	 */
	int countByCustomSQL(Model cnd);

	/**
	 * 插入一条记录
	 * 
	 * @param model
	 *            更新记录
	 * @return
	 */
	Model insert(Model model);

	/**
	 * 插入多条记录
	 * 
	 * @param models
	 *            更新记录
	 * @return
	 */
	List<Model> insert(List<Model> models);

	/**
	 * 根据主键，删除一条记录
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	int delete(Id id);

	/**
	 * 根据条件，删除多条记录
	 * 
	 * @param cnd
	 *            删除条件
	 * @return
	 */
	int clear(Model cnd);

	/**
	 * 根据主键更新一条记录
	 * 
	 * @param models
	 *            记录
	 * @param ignoreNull
	 *            是否忽略空值
	 * @return
	 */
	int updateById(Model model, Boolean ignoreNull);

	/**
	 * 根据主键更新多条记录
	 * 
	 * @param models
	 *            记录
	 * @param ignoreNull
	 *            是否忽略空值
	 * @return
	 */
	int updateById(List<Model> models, Boolean ignoreNull);

	/**
	 * 根据条件，更新一条或者多条记录
	 * 
	 * @param chain
	 *            更新字段
	 * @param cnd
	 *            更新条件
	 * @return
	 */
	int update(Model chain, Model cnd);

}
