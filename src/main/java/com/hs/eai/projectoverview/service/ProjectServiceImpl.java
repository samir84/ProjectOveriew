package com.hs.eai.projectoverview.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.eai.projectoverview.dao.ProjectDao;
import com.hs.eai.projectoverview.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDao projectDao;
	
	
	
	public List<Project> findAll() {

		return projectDao.findAll();
	}
	
	public List<Project> findByAssignee(String assignee) {
		// TODO Auto-generated method stub
		return projectDao.findByAssignee(assignee);
	}



	
	public Project findById(Integer id) {
		// TODO Auto-generated method stub
		return projectDao.findById(id);
	}

	
	public Project findByName(String name) {
		// TODO Auto-generated method stub
		return projectDao.findByName(name);
	}
	
	public Project findByKey(String key) {
		// TODO Auto-generated method stub
		return projectDao.findByKey(key);
	}
	
	public Project findByDescription(String description) {
		// TODO Auto-generated method stub
		return projectDao.findByDescription(description);
	}

	
	public List<Project> fullTextProjectSearchWildcard(String searchText) {
		// TODO Auto-generated method stub
		
		return projectDao.fullTextProjectSearchWildcard( searchText );
	}
	
	public List<Project> loadLazyProjects(Integer startIndex, Integer maxResult) {
		// TODO Auto-generated method stub
		return projectDao.loadLazyProjects( startIndex,  maxResult);
	}
	
	public Integer countAlle() {
		// TODO Auto-generated method stub
		return projectDao.countAlle();
	}
	
	
}
