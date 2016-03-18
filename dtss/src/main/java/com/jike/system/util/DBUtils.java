package com.jike.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** 
 * 连接数据库的工具类,被定义成不可继承且是私有访问 
 * @author lanp 
 * @since 2012-2-29 22:27 
 */  
public class DBUtils {

	// 设置默认连接超时时间
	public static int TIME_OUT = 2;
      
    /** 
     * 获取数据库的连接 
     * @return conn 
     */  
	public static Connection getConnection(String driver, String url, String user, String psw) {
		try {
            Class.forName(driver);  
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }
    	Connection conn = null;
        try {
    		// 设置连接超时
    		DriverManager.setLoginTimeout(TIME_OUT);
        	// 获取连接
            conn = DriverManager.getConnection(url, user, psw);  
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);  
        }
        return conn;  
    }  
      
    /** 
     * 释放资源 
     * @param conn 
     * @param pstmt 
     * @param rs 
     */  
    public static void closeResources(Connection conn,Statement stmt,ResultSet rs) {  
        if(null != rs) {  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            } finally {  
                if(null != stmt) {  
                    try {
                    	stmt.close();  
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);  
                    } finally {  
                        if(null != conn) {
                            try {  
                                conn.close();  
                            } catch (SQLException e) {  
                                e.printStackTrace();  
                                throw new RuntimeException(e);  
                            }  
                        }  
                    }  
                }  
            }  
        }  
    }
    
    /**
     * 执行查询操作
     * 
     * @param conn
     * @param sql
     */
    public static List<Object[]> query(Connection conn, String sql) {
    	// 定义结果集
    	List<Object[]> result = new ArrayList<Object[]>();
    	//创建该连接下的Statement对象
    	Statement stmt = null;
    	//执行查询语句，将数据保存到ResultSet对象中
        ResultSet rs = null;
    	try {
	    	// 准备查询对象
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// 执行查询并返回结果
	    	rs = stmt.executeQuery(sql);
	    	ResultSetMetaData m=rs.getMetaData();
	    	int columns=m.getColumnCount();
            rs.beforeFirst();//将结果集指针指回到开始位置
            while(rs.next()){
            	Object[] obj = new Object[columns];
//        		System.out.print("|");
            	for(int i=1;i<=columns;i++){
//            		System.out.print(" " + rs.getString(i) + " |");
            		obj[i-1] = rs.getString(i);
            	}
//        		System.out.println("");
            	result.add(obj);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeResources(conn, stmt, rs);
        }
        // 返回结果集
        return result;
    }
    
	public static void main(String[] args){
//		String driver="oracle.jdbc.OracleDriver";  
//        String url="jdbc:oracle:thin:@180.97.80.177:1621:traveldb";  
//        String user="jike";  
//        String psw="jike17712613261";
//        
//        
//        
//		Connection conn = DBUtils.getConnection(driver, url, user, psw);
//		String sql = "select * FROM T_API_DETECT WHERE TASK_ID > '20151127110500'";
//		DBUtils.query(conn, sql);
		
		System.out.println(" ".length());
	}
    
} 