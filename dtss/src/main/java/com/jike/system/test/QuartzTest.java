package com.jike.system.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jike.system.util.DBUtils;

 
/** 
* 一个简单的测试quartz任务管理器测试类 
*/  
public class QuartzTest {  
 
   public static void main(String[] args) throws Exception {

	   String driver = "oracle.jdbc.OracleDriver"; 
	   String url = "jdbc:oracle:thin:@112.80.51.78:1621:traveldb";   
	   String user = "jike";  
	   String psw = "jike";  
	   Connection conn = DBUtils.getConnection(driver, url, user, psw);
	   if(conn != null){
		   System.out.println(conn);
		   String sql = "select * from T_SYSTEM_DETECT_INTERFACE_LOG where ITF_LOG_ID=?";
		   PreparedStatement pre = conn.prepareStatement(sql);
		   pre.setString(1, "1508181000000215");
		   ResultSet result = pre.executeQuery();
		   while (result.next())
			   System.out.println(result.getString("INPUT_PARAMS"));
		   DBUtils.closeResources(conn, pre, result);
	   }
   }  
 
}  