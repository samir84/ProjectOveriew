package com.hs.eai.projectoverview.utils;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppUtils {

	private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);

	private static AppUtils appUtils = new AppUtils( );
	
	private AppUtils() {
	}

	/* Static 'instance' method */
	public static AppUtils getInstance() {
		return appUtils;
	}

	public static Long[] StringArraysToInteger(String[] array) {
		Long[] data = new Long[array.length];
		for (int i = 0; i < array.length; i++) {
			data[i] = Long.valueOf(array[i]);
		}
		return data;

	}

	public static Integer StringToInteger(String number) {

		Integer numberId = null;

		try {
			numberId = Integer.parseInt(number);
		} catch (NumberFormatException ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
		return numberId;
	}

	
	public static java.sql.Date getDateFromString(String date) {

		java.util.Date today;
		java.sql.Date rv = null;
		try {

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			today = format.parse(date);
			rv = new java.sql.Date(today.getTime());

		} catch (Exception e) {
			logger.error("Exception: " + e.getMessage());
		} finally {
			return rv;
		}

	}
	public static java.util.Date getDateString(String date){
		java.util.Date javaDate = null ;
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    javaDate = dateFormat.parse(date);
		}catch(Exception e){//this generic but you can control another types of exception
		 e.printStackTrace();
		}
		return javaDate;
	}
	public static java.sql.Timestamp getTimeStampFromString(String date){
		java.sql.Timestamp timestamp = null ;
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date parsedDate = dateFormat.parse(date);
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		}catch(Exception e){//this generic but you can control another types of exception
		 e.printStackTrace();
		}
		return timestamp;
	}
	public static Float CalculatePorjectProgress(Integer totalIssues , Integer completedIssues){
		
		try {
			return  ((totalIssues.floatValue()- completedIssues.floatValue() ) / totalIssues.floatValue()) ;
		}catch (Exception ex){
			logger.error(ex.getMessage());
			return null;
		}
	}
	public static String toPercentage(float n){
	    return String.format("%.0f",n*100)+"%";
	}
	public static float calculatePercentage(int a , int total){
		
		return ((total-a)/total);
	}

}
