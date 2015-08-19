package com.jike.system.util;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
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
    public static void closeResources(Connection conn,PreparedStatement pstmt,ResultSet rs) {  
        if(null != rs) {  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            } finally {  
                if(null != pstmt) {  
                    try {  
                        pstmt.close();  
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
} 