package com.hs.eai.projectoverview.service;

import java.util.List;
import java.util.Map;

import com.hs.eai.projectoverview.dao.ProjectDao;
import com.hs.eai.projectoverview.model.Project;

public interface ProjectService {

	List<Project> findAll();
	List<Project> findByAssignee(String assignee);
	
	Project findById(Integer id);
	Project findByName(String name);
	Project findByKey(String key);
	Project findByDescription(String description);

	List<Project> fullTextProjectSearchWildcard(String searchText);
	List<Project> loadLazyProjects(Integer startIndex, Integer maxResult);
	Integer countAlle();
	


	
}
