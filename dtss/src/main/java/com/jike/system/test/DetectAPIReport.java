package com.jike.system.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jike.system.util.DBUtils;
import com.jike.system.util.DateUtils;

/**
 * Title: DetectAPIReport
 *
 * Description:
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Nov 27, 2015
 *
 */
public class DetectAPIReport {
	
	private static final String driver="oracle.jdbc.OracleDriver";  
	private static final String url="jdbc:oracle:thin:@180.97.80.177:1621:traveldb";  
	private static final String user="jike";  
	private static final String psw="jike17712613261";
	
	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	private Connection getConn(){
		Connection conn = DBUtils.getConnection(driver, url, user, psw);
		return conn;
	}
	
	/**
	 * 计算字符串长度
	 * 
	 * @param value
	 * @return
	 */
	public int length(String value) {
        int valueLength = 0;
        int chineseNum = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为16/9 */
            	chineseNum ++;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength + new BigDecimal(chineseNum * 16).divide(new BigDecimal(9),0,BigDecimal.ROUND_HALF_EVEN).intValue();
    }
	
	/**
	 * 统计基本数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Object[]> baseData(String startTime, String endTime){
		Connection conn = getConn();
		String sql = "SELECT RESULT_TYPE AS 结果类型, ( CASE WHEN RESULT_TYPE='0' THEN '正常 有数据且完全返回' WHEN RESULT_TYPE='1' THEN '正常 完全返回却无数据' WHEN RESULT_TYPE='2' THEN '正常 采集失败原因超时' WHEN RESULT_TYPE='3' THEN '数据缺失 DATA ERROR!' WHEN RESULT_TYPE='4' THEN '没有数据 SYSTEM IS BUSY!' WHEN RESULT_TYPE='5' THEN 'SOCKET异常' ELSE '其它' END) AS 请求结果描述, MIN(TASK_RUN_TIME) AS 开始时间, MAX(TASK_RUN_TIME) AS 结束时间, COUNT(RESULT_TYPE) AS 次数, MIN(TASK_TIME_COST) AS 最少用时, MAX(TASK_TIME_COST) AS 最多用时, ROUND(AVG(TASK_TIME_COST), 0) AS 平均用时 FROM T_API_DETECT WHERE TASK_ID > '" + startTime + "' AND TASK_ID < '" + endTime + "' GROUP BY RESULT_TYPE ORDER BY RESULT_TYPE";
		List<Object[]> objs = DBUtils.query(conn, sql);
		return objs;
	}
	
	/**
	 * 统计响应时间 < timeCost 且完全返回的查询请求
	 * 
	 * @param startTime
	 * @param endTime
	 * @param timeCost
	 * @return
	 */
	public List<Object[]> respTime(String startTime, String endTime, String timeCost){
		Connection conn = getConn();
		String sql = "SELECT COUNT(*) FROM T_API_DETECT WHERE TASK_ID > '" + startTime + "' AND TASK_ID < '" + endTime + "' AND TASK_TIME_COST < '" + timeCost + "' AND RESULT_TYPE IN('0', '1')";
		List<Object[]> objs = DBUtils.query(conn, sql);
		return objs;
	}
	
	/**
	 * 统计响应超时的查询请求
	 * 
	 * @param startTime
	 * @param endTime
	 * @param timeCost
	 * @return
	 */
	public List<Object[]> timeout(String startTime, String endTime){
		Connection conn = getConn();
		String sql = "SELECT TASK_RUN_TIME FROM T_API_DETECT WHERE TASK_ID > '" + startTime + "' AND TASK_ID < '" + endTime + "' AND RESULT_TYPE = '2'";
		List<Object[]> objs = DBUtils.query(conn, sql);
		return objs;
	}
	
	public String getSpace(Integer count){
		String space = "";
		for(int i = 0; i < count; i++){
			space += " ";
		}
		return space;
	}
	
	
	public String formatData(String data, Integer maxlength, Integer format){
		Integer leftLength = maxlength - length(data);
		data = " " + data + " ";
		if(format == 1){ 			// 左对齐
			data = data + getSpace(leftLength);
		}else if(format == 2){		// 居中
			String space = getSpace(leftLength/2);
			if((leftLength&1) == 0){
				data = space + data + space;
			}else{
				data = space + data + space + " ";
			}
		}else if(format == 3){		// 右对齐
			data = getSpace(leftLength) + data;
		}
		return data;
	}
	
	
	/**
	 * 打印报表
	 * 
	 * @param startTime
	 * @param endTime
	 */
	public void reportFactory(String startTime, String endTime) {
// 统计条件
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println("—————————————————————————————————————————————————————————————");
		System.out.println("统计条件：");
		System.out.println();
		try {
			System.out.println("查询请求起始时间：" + DateUtils.formatFullDate(format.parse(startTime)));
			System.out.println();
			System.out.println("查询请求结束时间：" + DateUtils.formatFullDate(format.parse(endTime)));
			System.out.println();
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		
// 1. 统计基本数据
		List<Object[]> objs = baseData(startTime, endTime);
		System.out.println("—————————————————————————————————————————————————————————————");
		System.out.println("1. 统计基本数据");
		System.out.println();
		if(objs.size() > 0){
			// 添加列名称
			Object[] columnNames = {"结果类型","请求结果描述","开始时间","结束时间","查询次数","最少用时","最多用时","平均用时"};
//			Object[] columnNames = {"RESULT_TYPE","RESULR_DESCRIPE","START_TIME","END_TIME","COUNT","MIN_TIME_COST","MAX_TIME_COST","AVG_TIME_COST"};
			// 列格式(1:左对齐; 2:居中; 3:右对齐)
			Integer[] columnFormats = {2, 1, 1, 1, 3, 3, 3, 3};
			objs.add(0, columnNames);
			// 每一列的最大宽度
			Map<Integer, Integer> maxlength = new HashMap<Integer, Integer>();
			for (Object[] obj : objs) {
				for (int i = 0; i < obj.length; i++) {
					Integer newValue = length(obj[i].toString());
					if (maxlength.containsKey(i)) {
						Integer oldValue = maxlength.get(i);
						if(newValue > oldValue){
							maxlength.put(i, newValue);
						}
					} else {
						maxlength.put(i, newValue);
					}
				}
			}
			// 打印基本数据
			for (Object[] obj : objs) {
				System.out.print("|");
				for (int i = 0; i < obj.length; i++) {
            		System.out.print(formatData(obj[i].toString(), maxlength.get(i), columnFormats[i]) + "|");
				}
				System.out.println("");
			}
			System.out.println();
			System.out.println("—————————————————————————————————————————————————————————————");
		}else{
			// 没有数据
			System.out.println("没有查询到数据");
			return;
		}
		
// 统计响应时间 < timeCost 且完全返回的查询请求
		objs.remove(0);
		Integer sum = 1;
		String timeoutNum = "0";
		for (Object[] obj : objs) {
			Integer type = Integer.valueOf(obj[0].toString());
			if(type == 2){
				timeoutNum = obj[4].toString();
			}
			sum += Integer.valueOf(obj[4].toString());
		}
		objs = respTime(startTime, endTime, "10000");
		System.out.println("2. 统计查询请求的响应效率");
		System.out.println();
		System.out.println("响应时间 < 10s 且完全返回的查询请求："
				+ new BigDecimal(objs.get(0)[0].toString()).divide(
						new BigDecimal(sum), 4, BigDecimal.ROUND_HALF_EVEN)
						.multiply(new BigDecimal(100)).setScale(2) + "%");

		objs = respTime(startTime, endTime, "15000");
		System.out.println();
		System.out.println("响应时间 < 15s 且完全返回的查询请求："
				+ new BigDecimal(objs.get(0)[0].toString()).divide(
						new BigDecimal(sum), 4, BigDecimal.ROUND_HALF_EVEN)
						.multiply(new BigDecimal(100)).setScale(2) + "%");

		objs = respTime(startTime, endTime, "20000");
		System.out.println();
		System.out.println("响应时间 < 20s 且完全返回的查询请求："
				+ new BigDecimal(objs.get(0)[0].toString()).divide(
						new BigDecimal(sum), 4, BigDecimal.ROUND_HALF_EVEN)
						.multiply(new BigDecimal(100)).setScale(2) + "%");

		System.out.println();
		System.out.println("—————————————————————————————————————————————————————————————");
		System.out.println("3. 统计查询请求超时的响应");
		System.out.println();
		System.out.println("响应超时的查询请求："
				+ new BigDecimal(timeoutNum).divide(
						new BigDecimal(sum), 4, BigDecimal.ROUND_HALF_EVEN)
						.multiply(new BigDecimal(100)).setScale(2) + "%");
		System.out.println();

//		objs = timeout(startTime, endTime);
		
		System.out.println("—————————————————————————————————————————————————————————————");
		
	}
	
	
	
	public static void main(String[] args) {
		DetectAPIReport dapir = new DetectAPIReport();
		String startTime = "20151225090000";
		String endTime = "20151225100000";
		dapir.reportFactory(startTime ,endTime);
		
//		System.out.println(dapir.length("最少用时"));
//		System.out.println(dapir.length("953"));
//		System.out.println(dapir.length("1203"));
//		System.out.println(dapir.length("最多用"));
		
	}
	
	
	
	
	
	

}
