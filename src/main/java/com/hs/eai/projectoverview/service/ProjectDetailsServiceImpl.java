package com.hs.eai.projectoverview.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.hs.eai.projectoverview.dao.ProjectDao;
import com.hs.eai.projectoverview.model.JiraAction;
import com.hs.eai.projectoverview.model.Project;
import com.hs.eai.projectoverview.model.ProjectDetails;
import com.hs.eai.projectoverview.utils.AppUtils;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(ProjectDetailsServiceImpl.class);

	@Autowired
	ProjectService projectgService;
	@Autowired
	JiraIssueService jiraIssueService;
	@Autowired
	JiraActionService jiraActionService;

    
	public ProjectDetails findProjectDetails(Integer projectId) {

		ProjectDetails projectdetails = null;
		try {

			Integer id = Integer.valueOf(projectId);
			Project project = projectgService.findById(id);
			projectdetails = new ProjectDetails();
			projectdetails.setProject(project);
			Integer totalIssues = jiraIssueService.findTotalIssuesByProjectId(id);
			Integer completedIssues = jiraIssueService.findTotalCompletedIssuesByProject(id).intValue();
			Integer openIssues = jiraIssueService.findTotalOpenIssuesByProject(id).intValue();
			Integer reopenedIssues = jiraIssueService.findTotalReopenedIssuesByProject(id).intValue();
			Integer resolvedIssues = jiraIssueService.findTotalResolvedIssuesByProject(id).intValue();
			Integer closedIssues = jiraIssueService.findTotalClosedIssuesByProject(id).intValue();
			Integer inprogressIssues = jiraIssueService.findTotalInprogressIssuesByProject(id).intValue();

			
			// activities
			List<JiraAction> jiraActivities = jiraActionService.findByProjectId(id);
			
			projectdetails.setAssignees(jiraIssueService.findAssigneesByProject(id));
			
			projectdetails.setCompletedIssues(completedIssues);
			projectdetails.setResolvedIssues(resolvedIssues);
			projectdetails.setClosedIssues(closedIssues);
			
			projectdetails.setInprogressIssues(inprogressIssues);
			
			projectdetails.setOpenIssues(openIssues);
			projectdetails.setReopenIssues(reopenedIssues);
			
			projectdetails.setTotalIssues(totalIssues);

			Float progress = AppUtils.CalculatePorjectProgress(totalIssues, completedIssues);

			projectdetails.setProgress(AppUtils.toPercentage(progress));
			projectdetails.setActivities(jiraActionService.findByProjectId(id));

			return projectdetails;

		} catch (Exception ex) {
			// logger.error(ex.getMessage());
			ex.printStackTrace();

		}
		return projectdetails;
	}

	
	@Transactional
	public List<ProjectDetails> lazyLoadProjectDetails(Integer startIndex, Integer maxResult) {

		List<ProjectDetails> projectDetailsList = new ArrayList<ProjectDetails>();
        
		try {
			
			List<Project> projects = projectgService.loadLazyProjects(startIndex, maxResult);

			for (Project p : projects) {

				ProjectDetails projectDetail = new ProjectDetails();
				projectDetail.setProject(p);

				Integer totalIssues = jiraIssueService.findTotalIssuesByProjectId(p.getId());
				Integer completedIssues = jiraIssueService.findTotalCompletedIssuesByProject(p.getId()).intValue();
				Integer openIssues = jiraIssueService.findTotalOpenIssuesByProject(p.getId()).intValue();
				Integer reopenedIssues = jiraIssueService.findTotalReopenedIssuesByProject(p.getId()).intValue();
				Integer resolvedIssues = jiraIssueService.findTotalResolvedIssuesByProject(p.getId()).intValue();
				Integer closedIssues = jiraIssueService.findTotalClosedIssuesByProject(p.getId()).intValue();
				Integer inprogressIssues = jiraIssueService.findTotalInprogressIssuesByProject(p.getId()).intValue();

				projectDetail.setAssignees(jiraIssueService.findAssigneesByProject(p.getId()));
				
				projectDetail.setCompletedIssues(completedIssues);
				projectDetail.setResolvedIssues(resolvedIssues);
				projectDetail.setClosedIssues(closedIssues);
				
				projectDetail.setInprogressIssues(inprogressIssues);
				
				projectDetail.setOpenIssues(openIssues);
				projectDetail.setReopenIssues(reopenedIssues);
				
				projectDetail.setTotalIssues(totalIssues);

				Float progress = AppUtils.CalculatePorjectProgress(totalIssues, completedIssues);

				projectDetail.setProgress(AppUtils.toPercentage(progress));
				projectDetail.setActivities(jiraActionService.findByProjectId(p.getId()));
				
				projectDetailsList.add(projectDetail);
			}
		}catch(Exception ex){
		
			ex.printStackTrace();
		}
		
		return projectDetailsList;
	}

	
	public List<ProjectDetails> fullTextProjectSearchWildcard(String searchText) {

		List<ProjectDetails> projectDetailsList = new ArrayList<ProjectDetails>();
		List<Project> projects = projectgService.fullTextProjectSearchWildcard(searchText);

		for (Project p : projects) {

			ProjectDetails projectDetail = new ProjectDetails();
			projectDetail.setProject(p);

			Integer totalIssues = jiraIssueService.findTotalIssuesByProjectId(p.getId());
			Integer completedIssues = jiraIssueService.findTotalCompletedIssuesByProject(p.getId()).intValue();
			Integer openIssues = jiraIssueService.findTotalOpenIssuesByProject(p.getId()).intValue();
			Integer reopenedIssues = jiraIssueService.findTotalReopenedIssuesByProject(p.getId()).intValue();
			Integer resolvedIssues = jiraIssueService.findTotalResolvedIssuesByProject(p.getId()).intValue();
			Integer closedIssues = jiraIssueService.findTotalClosedIssuesByProject(p.getId()).intValue();
			Integer inprogressIssues = jiraIssueService.findTotalInprogressIssuesByProject(p.getId()).intValue();

			projectDetail.setAssignees(jiraIssueService.findAssigneesByProject(p.getId()));
			projectDetail.setCompletedIssues(completedIssues);
			projectDetail.setResolvedIssues(resolvedIssues);
			projectDetail.setClosedIssues(closedIssues);
			
			projectDetail.setInprogressIssues(inprogressIssues);
			
			projectDetail.setOpenIssues(openIssues);
			projectDetail.setReopenIssues(reopenedIssues);
			
			projectDetail.setTotalIssues(totalIssues);

			Float progress = AppUtils.CalculatePorjectProgress(totalIssues, completedIssues);

			projectDetail.setProgress(AppUtils.toPercentage(progress));
			projectDetail.setActivities(jiraActionService.findByProjectId(p.getId()));
			projectDetailsList.add(projectDetail);
		}
		return projectDetailsList;
	}
}
