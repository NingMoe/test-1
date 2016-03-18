package com.sharefree.utils;

import java.util.List;
import java.util.Map;

import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;

import com.sharefree.common.ExecuteCustomSQL;
import com.sharefree.model.CommonQueryModel;

/**
 * Title: SqlCreateUtil
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Feb 19, 2016
 *
 */
public class SqlCreateUtil {
	
	/**
	 * 复杂条件查询
	 * 
	 * @param cqm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CommonQueryModel complexQuery(Dao dao, CommonQueryModel cqm){
		// 获取待执行sql
		Sql[] sqls = cqm.getSqls();
		// 执行查询操作，获取查询结果
		Object[] results = ExecuteCustomSQL.executeQuery(dao, sqls);
		// 设置结果集
		cqm.setResults((List<Object[]>) results[0]);
		// 设置结果集
		Integer totalCount = (Integer) results[1];
		cqm.setTotalCount(totalCount);
		// 如果存在pageSize，计算页数
		if(cqm.getPageSize() != null){
			Integer pageSize = cqm.getPageSize();
			Integer totalPage = totalCount%pageSize == 0 ? (totalCount/pageSize) : (totalCount/pageSize)+1;
			cqm.setTotalPage(totalPage);
		}
		// 返回查询数据
		return cqm;
	}
	
	/**
	 * Map键值对查询
	 * 
	 * @param cqm
	 * @return
	 */
	public static Map<Object, Object> mapQuery(CommonQueryModel cqm){

		return null;
	}
	
}
