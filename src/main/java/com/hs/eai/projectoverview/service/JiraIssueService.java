package com.hs.eai.projectoverview.service;

import java.sql.Timestamp;
import java.util.List;

import com.hs.eai.projectoverview.model.ProjectIssueStatistics;

public interface JiraIssueService {

	Integer findTotalIssuesByProjectId(Integer id);

	List<String> findAssigneesByProject(Integer id);

	Long findTotalCompletedIssuesByProject(Integer id);
	
	Long findTotalClosedIssuesByProject(Integer id);

	Long findTotalResolvedIssuesByProject(Integer id);

	Long findTotalOpenIssuesByProject(Integer id);

	Long findTotalReopenedIssuesByProject(Integer id);

	Long findTotalInprogressIssuesByProject(Integer id);
	List<Integer> findTimeoriginalestimateByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,Timestamp toDateCreated);
	List<Integer> findTimespentByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,Timestamp toDateCreated);
	List<ProjectIssueStatistics> findTimeoriginalestimatedAndTimespentByProjectAndYear(Integer projectId, String year);


}
