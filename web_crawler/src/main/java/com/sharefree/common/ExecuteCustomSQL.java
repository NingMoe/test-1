package com.sharefree.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;

import com.sharefree.utils.StringUtil;

/**
 * 
 * Title: ExecuteCustomSQL
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Mar 18, 2016
 *
 */
public class ExecuteCustomSQL {

	/**
	 * 自定义查询SQL语句，执行回调函数，返回对象数组
	 * 
	 * @param dao
	 * @param sql
	 * @return
	 */
	public static Object[] executeQuery(Dao dao, Sql[] sqls) {
		// 定义返回结果集
        Object[] result = new Object[2];
        // query sql
        Sql querySql = sqls[0];
        // count sql
        Sql countSql = sqls[1];
        // 先查询数据总量
        if(StringUtil.isNotEmpty(countSql.getSourceSql())){
        	countSql.setCallback(new SqlCallback() {
    			public Object invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException {
        			rs.next();
                    return rs.getInt(1);
    	        }
    	    });
    	    dao.execute(countSql);
    	    result[1] = countSql.getResult();
        }
        // 如果数据总量为空或者大于0，执行查询语句
        if(result[1] == null || ((Integer) result[1]) > 0){
        	querySql.setCallback(new SqlCallback() {
        		public List<Object[]> invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException {
        			List<Object[]> list = new LinkedList<Object[]>();
    				ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
    				int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
    				while(rs.next()){
    					Object[] obj = new Object[columnCount];
    					for (int i = 0; i < columnCount; i++) {
    						// 结果集中第一列的index为1
    						obj[i] = rs.getObject(i + 1);
    					}
    					list.add(obj);
    				}
        			return list;
        		}
        	});
        	dao.execute(querySql);
        	List<Object[]> dataList = querySql.getList(Object[].class);
        	result[0] = dataList;
        	// 如果数据总量为空，默认为查询数据量
        	if(result[1] == null)
        		result[1] = dataList.size();
        }else{
        	result[0] = new ArrayList<Object[]>();
        }
        // 返回结果集
        return result;
	}
	
	/**
	 * 自定义其他执行语句
	 * 
	 * @param dao
	 * @param sql
	 */
	
	public static void execute(Dao dao, Sql sql){
		dao.execute(sql);
	}
	
}
