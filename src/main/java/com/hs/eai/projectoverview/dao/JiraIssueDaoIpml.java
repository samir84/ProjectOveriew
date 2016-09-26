package com.hs.eai.projectoverview.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.eai.projectoverview.model.ProjectIssueStatistics;


@Repository
public class JiraIssueDaoIpml implements JiraIssueDao {

	private static final Logger logger = LoggerFactory.getLogger(JiraIssueDaoIpml.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	
	@Transactional
	public Long findTotalIssuesByProjectId(Integer id) {

		logger.debug("findTotalIssues..");
		Query query = getSession().getNamedQuery("Jiraissue.findTotalIssuesByProjectId");
		query.setParameter("id", id);
		Long count = (Long) query.uniqueResult();
		// logger.debug("Total issues found for project id {}.", id);
		return count;
	}

	
	@Transactional
	public Long findTotalIssuesByProjectAndStatus(Integer id, Long status){
		
		logger.debug("Find total issues by project id {}",id,"and status{} ",status);
		Long count = null;
		try{
			Query query = getSession().getNamedQuery("Jiraissue.findTotalIssuesByProjectAndStatus");
			query.setParameter("id", id);
			query.setParameter("issuestatus", status);
			 count = (Long) query.uniqueResult();
			// logger.debug("Total issues found for project id {}.", id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return count;
	}
	
	
	@Transactional
	public Long findTotalIssuesByProjectAndStatussen(Integer id, Long[] statussen) {

		Long count = null ;
		logger.debug("findTotalIssuesByProjectAndStatus..");
		try{
			Query query = getSession().getNamedQuery("Jiraissue.findTotalIssuesByProjectAndStatussen");
			query.setParameter("id", id);
			query.setParameter("ids", Arrays.asList(statussen));
			count = (Long) query.uniqueResult();
			return (Long) query.uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return count;
		
	}

	
	public List<String> findAssigneesByProject(Integer id) {

		logger.debug("find Assignees By Project id ...");
		Query query = getSession().getNamedQuery("Jiraissue.findAssigneesByProject");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<String> assignees = query.list();
		
		return assignees;
	}

	
	public List<Integer> findTimeoriginalestimateByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,Timestamp toDateCreated) {
		
		List<Integer> timeoriginalestimate  = null;
		logger.debug("find Timeoriginalestimate By Project {},",projectId, " And Createtd {} ,Between",fromDateCreated , " and {} ",toDateCreated ," .");
		
		try{
			
			Query query = getSession().getNamedQuery("Jiraissue.findTimeoriginalestimateByProjectAndCreatetdBetween");
			query.setParameter("id", projectId);
			query.setParameter("fromDateCreated", fromDateCreated);
			query.setParameter("toDateCreated", toDateCreated);
			timeoriginalestimate = query.list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return timeoriginalestimate;
	}

	
	public List<Integer> findTimespentByProjectAndCreatetdBetween(Integer projectId, Timestamp fromDateCreated,
			Timestamp toDateCreated) {
		
		List<Integer> timeSpent  = null;
		logger.debug("find time spent By Project {},",projectId, " And Createtd {} ,Between",fromDateCreated , " and {} ",toDateCreated ," .");
		
		try{
			
			Query query = getSession().getNamedQuery("Jiraissue.findTimespentByProjectAndCreatetdBetween");
			query.setParameter("id", projectId);
			query.setParameter("fromDateCreated", fromDateCreated);
			query.setParameter("toDateCreated", toDateCreated);
			timeSpent = query.list();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return timeSpent;
		//findTimespentByProjectAndCreatetdBetween
	}

	
	public List<ProjectIssueStatistics> findTimeoriginalestimatedAndTimespentByProjectAndYear(Integer projectId,
			String year) {
		
		List<ProjectIssueStatistics> timeoriginalestimateVSTimeSpent  = new ArrayList<ProjectIssueStatistics>();
		logger.debug("find Timeoriginalestimated And Timespent  By Project {},",projectId, " And year {} ",year , " .");
		
		try{
			
			Query query = getSession().getNamedQuery("callUspSelectLast12MonthsTimeOrgEstimatedVsTimeSpent")
				.setParameter(1, projectId)
				.setParameter(2, year);
			List<Object[]> results = query.list();
			for(Object[] elements: results){
				ProjectIssueStatistics projectStatistics = new ProjectIssueStatistics();
				projectStatistics.setYear(String.valueOf(elements[0]));
				projectStatistics.setMonth(String.valueOf(elements[1]));
				projectStatistics.setTotalTimeOrgEstimate(Integer.valueOf(String.valueOf(elements[2])));
				projectStatistics.setTotalTimeSpent(Integer.valueOf(String.valueOf(elements[3])));
				timeoriginalestimateVSTimeSpent.add(projectStatistics);
			}   
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return timeoriginalestimateVSTimeSpent;
	}





}
