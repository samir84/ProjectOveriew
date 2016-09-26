package com.hs.eai.projectoverview.utils;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hs.eai.projectoverview.spring.HibernateConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = WebAppConfig.class, loader = AnnotationConfigContextLoader.class)
//@WebAppConfiguration
public class AppUtilsTest {

	@Test
	public void calculateProgres(){
		Float progress = AppUtils.CalculatePorjectProgress(0, 1);
		System.out.println(progress);
	}
	
	@Test 
	public static java.sql.Timestamp getTimeStampFromString(){
		java.sql.Timestamp timestamp = null ;
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		    java.util.Date parsedDate = dateFormat.parse("2016-08-05 15:29:00.453");
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    System.out.println("Date:"+timestamp);
		}catch(Exception e){//this generic but you can control another types of exception
		 e.printStackTrace();
		}
		return timestamp;
	}
	
	
}
