package com.hs.eai.projectoverview.dao;

import java.sql.Timestamp;
import java.util.List;

import com.hs.eai.projectoverview.model.Worklog;

public interface WorklogDao {

	//List<Worklog> findByFromDateToDate(Timestamp from, Timestamp to);
	List<Worklog> findAll();
	List<Worklog> findByAuthor(String author);
	List<Worklog> findByCreatedDate(Timestamp CREATED);
	
	List<Worklog> findByAuthorAndFromDateToDate(String author,Timestamp dateFrom, Timestamp dateTo);
	List<Worklog> findByFromDateToDate(Timestamp dateFrom, Timestamp dateTo);
}
