package com.hs.eai.projectoverview.dao;

import java.sql.Timestamp;
import java.util.List;

import com.hs.eai.projectoverview.model.ProjectIssueStatistics;

public interface JiraIssueDao {

	Long findTotalIssuesByProjectId(Integer id);
	List<String> findAssigneesByProject(Integer id );
	
	Long findTotalIssuesByProjectAndStatussen(Integer id, Long[] statussen);
	
	Long findTotalIssuesByProjectAndStatus(Integer id, Long status);
	
	List<Integer> findTimeoriginalestimateByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,Timestamp toDateCreated);

	//findTimespentByProjectAndCreatetdBetween
	List<Integer> findTimespentByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,Timestamp toDateCreated);
	List<ProjectIssueStatistics> findTimeoriginalestimatedAndTimespentByProjectAndYear(Integer projectId, String year);
}
