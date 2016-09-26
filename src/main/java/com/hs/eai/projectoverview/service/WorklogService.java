package com.hs.eai.projectoverview.service;

import java.sql.Timestamp;
import java.util.List;

import com.hs.eai.projectoverview.model.Worklog;

public interface WorklogService {

	List<Worklog> findAll();
	List<Worklog> findByCreatedDate(Timestamp CREATED);
	List<Worklog> findByAuthor(String author);
	List<Worklog> findByFromDateToDate(Timestamp dateFrom, Timestamp dateTo);
	List<Worklog> findByAuthorAndFromDateToDate(String author, Timestamp dateFrom, Timestamp dateTo);
}
