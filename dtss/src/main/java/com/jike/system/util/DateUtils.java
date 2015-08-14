package com.jike.system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Title: DateUtils
 *
 * Description: 日期时间工具
 *
 * Company: LuoPan
 *
 * @author pfxu
 *
 * @date Aug 14, 2015
 *
 */
public class DateUtils {

	private static SimpleDateFormat sdfMsFull = new SimpleDateFormat(
			"yyyyMMddHHmmssms");
	private static SimpleDateFormat sdfSFull = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private static SimpleDateFormat sdfDayFull = new SimpleDateFormat(
			"yyyyMMdd");
	private static SimpleDateFormat sdfFull = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	private static SimpleDateFormat sdfSlashDay = new SimpleDateFormat(
			"yyyy/MM/dd");
	private static SimpleDateFormat sdfSlashFull = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	private static SimpleDateFormat sdfHHMM = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	private static SimpleDateFormat sdfOnlyHHMM = new SimpleDateFormat("HH:mm");

	/**
	 * 转换日期 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseFullDate(String dateStr) throws ParseException {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		Date date = sdfFull.parse(dateStr);
		return date;
	}

	public static String formatFullDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfFull.format(date);
		return dateStr;
	}

	public static String formatMsFullDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfMsFull.format(date);
		return dateStr;
	}

	public static String formatSFullDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfSFull.format(date);
		return dateStr;
	}

	public static String formatDayFullDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfDayFull.format(date);
		return dateStr;
	}

	public static String formatZeroFullDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfDayFull.format(date);
		return dateStr+" 00:00:00";
	}

	/**
	 * 转换日期
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDayDate(String dateStr) throws ParseException {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		Date date = sdfDay.parse(dateStr);
		return date;
	}

	public static String formatDayDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfDay.format(date);
		return dateStr;
	}

	public static Date parseSlashDayDate(String dateStr) throws ParseException {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		Date date = sdfSlashDay.parse(dateStr);
		return date;
	}

	public static String formatSlashDayDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfSlashDay.format(date);
		return dateStr;
	}

	public static Date parseSlashFullDate(String dateStr) throws ParseException {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		Date date = sdfSlashFull.parse(dateStr);
		return date;
	}

	public static String formatSlashFullDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfSlashFull.format(date);
		return dateStr;
	}

	/**
	 * 转换日期
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseHHMMDate(String dateStr) throws ParseException {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		Date date = sdfHHMM.parse(dateStr);
		return date;
	}

	public static String formatHHMMDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfHHMM.format(date);
		return dateStr;
	}

	public static Date parseOnlyHHMMDate(String dateStr) throws ParseException {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		Date date = sdfOnlyHHMM.parse(dateStr);
		return date;
	}

	public static String formatOnlyHHMMDate(Date date) {
		if (date == null || "".equals(date)) {
			return null;
		}
		String dateStr = sdfOnlyHHMM.format(date);
		return dateStr;
	}

	/**
	 * 间隔天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static int getDaysBetweenDates(Date startDate, Date endDate)
			throws ParseException {
		Long startTime = parseDayDate(formatDayDate(startDate)).getTime();
		Long endTime = parseDayDate(formatDayDate(endDate)).getTime();
		int betweenDays = (int) ((endTime - startTime) / (1000 * 60 * 60 * 24));
		return betweenDays;
	}

	public static String getTimeBetweenDates(Date start, Date end) {
		if (start == null || end == null) {
			return "";
		}
		long diff = end.getTime() - start.getTime();// 这样得到的差值是微秒级别
		if (diff < 0) {
			return "";
		}
		long days = diff / (1000 * 60 * 60 * 24);
		long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
				* (1000 * 60 * 60))
				/ (1000 * 60);
		long second = (diff - days * (1000 * 60 * 60 * 24) - hours
				* (1000 * 60 * 60) - minutes * (1000 * 60)) / 1000;
		StringBuilder builder = new StringBuilder();
		if (days != 0) {
			builder.append(days + "天");
		}
		if (hours != 0) {
			builder.append(hours + "小时");
		}
		if (minutes != 0) {
			builder.append(minutes + "分");
		}
		if (second != 0) {
			builder.append(second + "秒");
		}

		return builder.toString();
	}

	/**
	 * @Title: getSpecifiedDayAfter
	 * @Description: 获得指定日期的后一天
	 * @param specifiedDay
	 * @return String
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}
	
	/**
	 * @Title: getSpecifiedDayAfter
	 * @Description: 获得指定日期的后一天
	 * @param specifiedDay
	 * @return String
	 */
	public static Date getDateAfter(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date dateAfter = new Date(calendar.getTimeInMillis());
		return dateAfter;
	} 

	/**
	 * Adds a number of days to a date returning a new object. The original date
	 * object is unchanged.
	 * 
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 */
	public static Date addDays(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}

	/**
	 * Adds to a date returning a new object. The original date object is
	 * unchanged.
	 * 
	 * @param date
	 *            the date, not null
	 * @param calendarField
	 *            the calendar field to add to
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 * @deprecated Will become privately scoped in 3.0
	 */
	public static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	/**
	 * Adds a number of seconds to a date returning a new object. The original
	 * date object is unchanged.
	 * 
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 */
	public static Date addSeconds(Date date, int amount) {
		return add(date, Calendar.SECOND, amount);
	}

	/**
	 * 去掉日期的时间
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDayDate(Date date) throws ParseException {
		String dayDate = formatDayDate(date);
		Date day = parseDayDate(dayDate);
		return day;
	}
	
	/**
	 * 计算两个时间相差分钟数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Long compareDifferMin(Date date1,Date date2)
	{
		Long time1 = date1.getTime();
		Long time2 = date2.getTime();
		Long diff;
		Long diffMin;
		if(time1>time2)
		{
			diff = time1-time2;
		}else
		{
			diff = time2-time1;
		}
		
		diffMin=diff/(60*1000);
		return diffMin;
	}


	public static void main(String[] args) throws ParseException {
		Date parseDayDate = DateUtils.parseDayDate("2014-09-09");
		System.out.println(parseDayDate.getTime());
	}
}