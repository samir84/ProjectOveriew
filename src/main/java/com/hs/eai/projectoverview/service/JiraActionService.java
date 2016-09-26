package com.hs.eai.projectoverview.service;

import java.util.List;

import com.hs.eai.projectoverview.model.JiraAction;

public interface JiraActionService {

	 List<JiraAction> findAll();
	 List<JiraAction> findByProjectId(Integer id);
}
