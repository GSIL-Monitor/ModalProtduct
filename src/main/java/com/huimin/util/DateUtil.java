package com.huimin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String BASE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat BASE_DATE_FORMATER = new SimpleDateFormat(BASE_DATE_FORMAT);
	
	public static String format(Date date){
		return BASE_DATE_FORMATER.format(date);
	}
	
	public static String format(Date date, String pattern){
		return new SimpleDateFormat(pattern).format(date);
	}
	
}
