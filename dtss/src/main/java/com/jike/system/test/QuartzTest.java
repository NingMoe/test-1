package com.jike.system.test;

import java.util.Date;

import com.jike.system.core.QuartzManager;



 
/** 
* 一个简单的测试quartz任务管理器测试类 
*/  
public class QuartzTest {  
 
   public static void main(String[] args) throws Exception {
/*
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
	   }*/
	   
	   System.out.println("start time:"+new Date());
	   QuartzManager.addCalendar("testTrigger", "16:07", "16:08");
	   QuartzManager.addSimpleJob("testJob", "testJobGroup", "testTrigger", "testTriggerGroup", QuartzJob.class, null, null, -1, 5, "123");
//	   QuartzManager.addCronJob("testJob", "testJobGroup", "testTrigger", "testTriggerGroup", QuartzJob.class, null, null, "0/5 * * * * ?");
	   QuartzManager.start();
	   System.out.println("sleep: 90 second");
	   Thread.sleep(90000);
//	   QuartzManager.addCalendar("testTrigger", "15:58", "15:59");
//	   QuartzManager.updateSimpleJob("testTrigger", "testTriggerGroup", 6000);
//	   QuartzManager.updateCronJob("testTrigger", "testTriggerGroup", "0/10 * * * * ?");
//	   System.out.println("sleep: 35 second");
//	   Thread.sleep(35000);
	   Thread.sleep(180000);
	   System.out.println("no stop time:"+new Date());
	   QuartzManager.shutdown();
   }  
 
}  