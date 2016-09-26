package com.hs.eai.projectoverview.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@Service
public class AppUtilsService {

	private static final Logger logger = LoggerFactory.getLogger(AppUtilsService.class);
	
	private static final String SQL_SERVER_TIME_STAMP_PATTERN ="SqlServerTimeStampPattern";
	
	@Autowired
	private Environment env;

	public java.sql.Timestamp stringToTimeStamp(String dateString) {

		java.sql.Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(env.getRequiredProperty(SQL_SERVER_TIME_STAMP_PATTERN));// '2015-11-01
																							// 23:59:59.999'
			Date parsedDate = dateFormat.parse(dateString);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (Exception e) {// this generic but you can control another types
								// of exception
			e.printStackTrace();
		}
		return timestamp;
	}
}
