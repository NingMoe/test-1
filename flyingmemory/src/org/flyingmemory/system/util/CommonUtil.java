package org.flyingmemory.system.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.flyingmemory.base.util.ContextUtil;
import org.flyingmemory.dao.iface.CommQueryDAO;

/**
 * Title:通用方法工具类
 * 
 * Description:
 * 
 * @version 1.0
 */
public class CommonUtil {
	
	private static SimpleDateFormat DateFormat = new SimpleDateFormat("yyyyMMdd");
	
	private static SimpleDateFormat TimeFormat = new SimpleDateFormat("HHmmss");
	
	private static SimpleDateFormat DateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static SimpleDateFormat DateTimeFormat_Show = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static SimpleDateFormat DateFormat_ShowCN = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	
	private static CommQueryDAO commQueryDAO = null;
		
	/**
	 * 获得系统当前日期
	 * @return
	 */
	public static String getCurrentDate() {
		return DateFormat.format(new Date());
	}
	
	/**
	 * 获得系统当前时间
	 * @return
	 */
	public static String getCurrentTime() {
		return TimeFormat.format(new Date());
	}
	
	/**
	 * 获得系统当前日期时间
	 * @return
	 */
	public static String getCurrentDateTime() {
		return DateTimeFormat.format(new Date());
	}
	
	/**
	 * 获得系统当前时间用于显示
	 * @return
	 */
	public static String getCurrentDateTimeForShow() {
		return DateTimeFormat_Show.format(new Date());
	}
	
	/**
	 * 获得系统中文时间用于显示
	 * @return
	 */
	public static String getCurrentDateTimeZHCN() {
		return DateFormat_ShowCN.format(new Date());
	}

	/**
	 * 获得通用查询接口
	 * @return
	 */
	public static CommQueryDAO getCommQueryDAO() {
		if(commQueryDAO == null) {
			commQueryDAO = (CommQueryDAO) ContextUtil.getBean("CommQueryDAO");
		}
		return commQueryDAO;
	}
	
	/** 
	 * 将微信消息中的CreateTime转换成数据库14位存储格式的时间（yyyyMMddHHmmss） 
	 *  
	 * @param createTime 消息创建时间，它表示1970年1月1日0时0分0秒至消息创建时所间隔的秒数
	 * @return 
	 */  
	public static String formatTime(String createTime) {
	    // 将微信传入的CreateTime转换成long类型，再乘以1000  
	    long msgCreateTime = Long.parseLong(createTime) * 1000L;
	    return DateTimeFormat.format(new Date(msgCreateTime));  
	}
	
	/**
	 * 填补字符串
	 * @param str
	 * @param fill
	 * @param len
	 * @param isEnd
	 * @return
	 */
	public static String fillString(String str,char fill,int len,boolean isEnd) {
		int fillLen = len - str.getBytes().length;
		if(len <= 0) {
			return str;
		}
		for(int i = 0; i < fillLen; i++) {
			if(isEnd) {
				str += fill;
			} else {
				str = fill + str;
			}
		}
		return str;
	}

	/**
	 * 获得指定日期的偏移日期
	 * @param refDate 参照日期
	 * @param offSize 偏移日期
	 * @return
	 */
	public static String getOffSizeDate(String refDate,String offSize) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(refDate.substring(0, 4)), 
							  Integer.parseInt(refDate.substring(4, 6)) - 1, 
							  Integer.parseInt(refDate.substring(6, 8)));
		calendar.add(Calendar.DATE, Integer.parseInt(offSize));
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String retDate = String.valueOf(calendar.get(Calendar.DATE));
		if(Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		if(Integer.parseInt(retDate) < 10) {
			retDate = "0" + retDate;
		}
		return year + month + retDate;
	}
	

	/**
	 * 获得指定个数的随机数组合
	 * @param len
	 * @return
	 * 2010-8-19上午10:51:15
	 */
	public static String getRandomNum(int len) {
		String ran = "";
		Random random = new Random();
		for(int i = 0; i < len; i++) {
			ran += String.valueOf(random.nextInt(10));
		}
		return ran;
	}
	

	/**
	 * 获得指定范围内的随机数
	 * @param num1
	 * @param num2
	 * @return
	 * 2010-8-19上午10:51:15
	 */
	public static String getRangeRandomNum(int num1, int num2) {
		try{
			if(num1 == num2){
				return "该范围无随机数";
			} else if(num1 > num2){
				int numTmp = num2;
				num2 = num1;
				num1 = numTmp;
			}
			Random random = new Random();
			int s = random.nextInt(num2 - num1) + num1;
			return String.valueOf(s);
		} catch (Exception e) {
			e.printStackTrace();
			return "参数错误";
		}
	}
	
	/**
	 * 判断字符串是否全部由数字组成
	 * @param str
	 * @return
	 * 2010-8-26下午02:20:28
	 */
	public static boolean isAllDigit(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}
	
	/**
	 * 计算采用utf-8编码方式时字符串所占字节数
	 * 
	 * @param content
	 * @return
	 */
	public static int getByteSize(String content) {
		int size = 0;
		if (null != content) {
			try {
				// 汉字采用utf-8编码时占3个字节
				size = content.getBytes("utf-8").length;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return size;
	}
}