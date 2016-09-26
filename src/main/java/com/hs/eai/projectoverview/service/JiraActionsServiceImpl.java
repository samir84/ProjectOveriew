package com.hs.eai.projectoverview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.eai.projectoverview.dao.JiraActionDao;
import com.hs.eai.projectoverview.model.JiraAction;

@Service
public class JiraActionsServiceImpl implements JiraActionService {

	@Autowired
	JiraActionDao jiraActionDao;
	
	
	public List<JiraAction> findAll() {
		// TODO Auto-generated method stub
		return jiraActionDao.findAll();
	}

	
	public List<JiraAction> findByProjectId(Integer id) {
		// TODO Auto-generated method stub
		return jiraActionDao.findByProjectId(id);
	}

	

}
