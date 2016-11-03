package com.zzgproject.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
    /**
     * 根据默认的格式或者指定的格式返回当前时间带格式的时间字符串
     */
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	public static String getDatetime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public static String getDateFormat(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	
	/**
	 * ====================分割线==================
	 * 返回给定long值时间的格式
	 */
	public static String getDate(long timer){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(timer));
	}
	
	public static String getDatetime(long timer){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(timer));
	}
	
    public static String getDateFormat(long timer, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(timer));
    }
	
	
    /**
     * ====================分割线==================
     * 返回给定的date时间的格式
     */
	public static String getDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String getDatetime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
    public static String getDateFormat(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
	
	
}







