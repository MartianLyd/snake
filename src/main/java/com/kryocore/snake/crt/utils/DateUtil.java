package com.kryocore.snake.crt.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <code>{@link DateUtil}</code>
 * 
 * 日期工具类
 * 
 */
public class DateUtil {
	/**
	 * 字符串转换时间 yyyy-MM-dd
	 */
	public static Date getStringDate(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		java.sql.Timestamp sqlDate = null;
		try {
			date = format.parse(dateStr);
			sqlDate = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
//			e.printStackTrace();
			return null;
		}
		return sqlDate;
	}
	
	/**
	 * 字符串转换时间 yyyyMMdd
	 */
	public static Date getShortDate(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHH");
		Date date = null;
		java.sql.Timestamp sqlDate = null;
		try {
			date = format.parse(dateStr);
			sqlDate = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
//			e.printStackTrace();
			return null;
		}
		return sqlDate;
	}

	/**
	 * 获取当前时间 yyyy/MM/dd
	 */
	public static String getNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
		Date curDate = new Date();// 获取当前时间
		String dateStr = formatter.format(curDate);
		return dateStr;
	}
	
	/**
	 * 将时间转换为文本格式
	 */
	public static String getDateStr(Date d) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = formatter.format(d);
		return dateStr;
	}
	
	/**
	 * 获取当前时间 yyyy/MM/dd
	 */
	public static String getNowDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date curDate = new Date();// 获取当前时间
		String dateStr = formatter.format(curDate);
		return dateStr;
	}
	
	/**
	 * 获取下一个月的同一时间
	 */
	public static Date getNextMonthDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化对象
		Calendar calendar = Calendar.getInstance();//日历对象
		calendar.setTime(d);//设置当前日期
		calendar.add(Calendar.MONTH, +1);//月份减一
		System.out.println(sdf.format(calendar.getTime()));//输出格式化的日期
		Date nextMonth = DateUtil.getStringDate(sdf.format(calendar.getTime()));
		
		return nextMonth;
	}
	
	public static void main(String[] args){
		System.out.println(getNowDay());
	}
}