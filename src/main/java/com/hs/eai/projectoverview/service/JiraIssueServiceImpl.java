package com.hs.eai.projectoverview.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hs.eai.projectoverview.dao.JiraIssueDao;
import com.hs.eai.projectoverview.model.ProjectIssueStatistics;
import com.hs.eai.projectoverview.utils.AppUtils;

@Service
public class JiraIssueServiceImpl implements JiraIssueService{

	@Autowired
	private JiraIssueDao jiraissueDao;
	
	
	@Value("${jiraCompletedStatus}")
	private String completedStatus;
	
	@Value("${jiraIssueDone}")
	private String doneIssues;
	
	@Value("${jiraIssueResolved}")
	private String resolvedIssues;
	
	@Value("${jiraIssueClosed}")
	private String closedIssues;
	
	@Value("${jiraIssueInprogress}")
	private String inprogressIssues;
	
	@Value("${jiraIssueOpen}")
	private String openIssues;
	
	@Value("${jiraIssueReopened}")
	private String ReopenedIssues;

	@Transactional
	public Integer findTotalIssuesByProjectId(Integer id) {
		// TODO Auto-generated method stub
		return jiraissueDao.findTotalIssuesByProjectId(id).intValue();
	}

	@Transactional
	public Long findTotalCompletedIssuesByProject(Integer id) {
		
		Long count = null ;
		try{
			Long[] ids = AppUtils.getInstance().StringArraysToInteger(completedStatus.split(","));
			count = jiraissueDao.findTotalIssuesByProjectAndStatussen( id, ids);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return count;
	}

	@Transactional
	public Long findTotalOpenIssuesByProject(Integer id) {
		
		return findTotalIssuesByProjectAndStatus( id, openIssues);
	}

	@Transactional
	public Long findTotalInprogressIssuesByProject(Integer id) {
		
		return findTotalIssuesByProjectAndStatus( id, inprogressIssues);
	}
	@Transactional
	public Long findTotalReopenedIssuesByProject(Integer id) {
		
		return findTotalIssuesByProjectAndStatus( id, ReopenedIssues);
	}
	@Transactional
	public List<String> findAssigneesByProject(Integer id) {
		
		return jiraissueDao.findAssigneesByProject(id );
	}

	@Transactional
	public Long findTotalResolvedIssuesByProject(Integer id) {
		
		
		return findTotalIssuesByProjectAndStatus( id, resolvedIssues);
	}

	@Transactional
	public Long findTotalClosedIssuesByProject(Integer id) {
		
		
		return findTotalIssuesByProjectAndStatus( id, closedIssues);
	}

	@Transactional
	private Long findTotalIssuesByProjectAndStatus(Integer id, String status){
		
		Long count = null ;
		try{
			Long statusId = Long.valueOf(status);
			count = jiraissueDao.findTotalIssuesByProjectAndStatus( id, statusId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return count;
	}

	@Transactional
	public List<Integer> findTimeoriginalestimateByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,Timestamp toDateCreated) {
		// TODO Auto-generated method stub
		return jiraissueDao.findTimeoriginalestimateByProjectAndCreatetdBetween(projectId, fromDateCreated,toDateCreated);
	}

	@Transactional
	public List<Integer> findTimespentByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,
			Timestamp toDateCreated) {
		// TODO Auto-generated method stub
		return jiraissueDao.findTimespentByProjectAndCreatetdBetween(projectId, fromDateCreated, toDateCreated);
	}

	@Transactional
	public List<ProjectIssueStatistics> findTimeoriginalestimatedAndTimespentByProjectAndYear(Integer projectId,
			String year) {
		// TODO Auto-generated method stub
		return jiraissueDao.findTimeoriginalestimatedAndTimespentByProjectAndYear(projectId, year);
	}

}
