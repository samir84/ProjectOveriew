package com.hs.eai.projectoverview.dao;

import java.util.List;

import com.hs.eai.projectoverview.model.JiraAction;

public interface JiraActionDao {

	List<JiraAction> findAll();

	List<JiraAction> findByProjectId(Integer id);
}
