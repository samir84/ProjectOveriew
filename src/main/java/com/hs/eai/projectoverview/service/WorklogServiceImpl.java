package com.hs.eai.projectoverview.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.eai.projectoverview.dao.WorklogDao;
import com.hs.eai.projectoverview.model.Worklog;

@Service
public class WorklogServiceImpl implements WorklogService{

	@Autowired
	private WorklogDao worklogDAO;
	
	
	public List<Worklog> findByCreatedDate(Timestamp CREATED) {
		// TODO Auto-generated method stub
		return worklogDAO.findByCreatedDate(CREATED);
	}
	
	public List<Worklog> findAll() {
		
		return worklogDAO.findAll();
	}
	
	public List<Worklog> findByAuthor(String author) {

		return worklogDAO.findByAuthor(author);
	}
	
	public List<Worklog> findByFromDateToDate(Timestamp dateFrom, Timestamp dateTo) {
		// TODO Auto-generated method stub
		return worklogDAO.findByFromDateToDate( dateFrom,  dateTo);
	}
	
	public List<Worklog> findByAuthorAndFromDateToDate(String author, Timestamp dateFrom, Timestamp dateTo) {
		// TODO Auto-generated method stub
		return worklogDAO.findByAuthorAndFromDateToDate(author, dateFrom,  dateTo);
	}

}
