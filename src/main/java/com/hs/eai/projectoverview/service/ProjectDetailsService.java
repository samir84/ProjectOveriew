package com.hs.eai.projectoverview.service;

import java.util.List;

import com.hs.eai.projectoverview.model.Project;
import com.hs.eai.projectoverview.model.ProjectDetails;

public interface ProjectDetailsService {

	public ProjectDetails findProjectDetails(Integer projectId);
	public List<ProjectDetails> lazyLoadProjectDetails(Integer startIndex, Integer maxResult);
	public List<ProjectDetails> fullTextProjectSearchWildcard(String searchText);
}
