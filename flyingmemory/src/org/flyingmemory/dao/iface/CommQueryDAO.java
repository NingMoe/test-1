package org.flyingmemory.dao.iface;

import java.util.List;


/**
 * Title: 通用查询接口
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2010-3-8
 * 
 * 
 * 
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public interface CommQueryDAO {

	/**
	 * 通过 SQL 查询 无限制
	 * 
	 * @param sql
	 * @return
	 */
	public abstract List findBySQLQuery(final String sql);
	
	/**
	 * 通过 SQL 查询
	 * 
	 * @param sql
	 * @param begin
	 * @param count
	 * @return
	 */
	public abstract List findBySQLQuery(final String sql, final int begin, final int count);

	/**
	 * 通过 SQL 执行操作
	 * 
	 * @param sql
	 */
	public abstract void excute(final String sql);
	
	/**
	 * 通过 SQL 查询结果条数
	 * 
	 * @param sql
	 * @return
	 */
	public abstract String findCountBySQLQuery(final String countSql);
	
	/**
	 * 通过 HQL 查询 无限制
	 * 
	 * @param sql
	 * @return
	 */
	public List findByHQLQuery(final String hql);
	
	/**
	 * 通过 HQL 查询
	 * 
	 * @param sql
	 * @return
	 */
	public List findByHQLQuery(final String hql,final int begin, final int count);
	
	/**
	 * 刷新Hibernate缓存
	 * 
	 * @param sql
	 * @return
	 */
	public abstract void flush();
	
}
