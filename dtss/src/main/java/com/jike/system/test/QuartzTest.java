package com.jike.system.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

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
	   Long start = new Date().getTime();
	   Connection conn = DBUtils.getConnection(driver, url, user, psw);
	   System.out.println((new Date().getTime()-start)/1000);
	   if(conn != null){
		   System.out.println(conn);
		   String sql = "select * from T_SYSTEM_DETECT_LOG where LOG_ID=?";
		   PreparedStatement pre = conn.prepareStatement(sql);
		   pre.setString(1, "1508181000001720");
		   ResultSet result = pre.executeQuery();
		   while (result.next())
			   System.out.println(result.getString("INPUT_PARAMS"));
		   DBUtils.closeResources(conn, pre, result);
	   }
   }  
 
}  