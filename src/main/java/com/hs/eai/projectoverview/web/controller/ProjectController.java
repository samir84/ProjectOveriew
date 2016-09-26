package com.hs.eai.projectoverview.web.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hs.eai.projectoverview.model.Project;
import com.hs.eai.projectoverview.model.ProjectDetails;
import com.hs.eai.projectoverview.model.ProjectIssueStatistics;
import com.hs.eai.projectoverview.service.AppUtilsService;
import com.hs.eai.projectoverview.service.JiraActionService;
import com.hs.eai.projectoverview.service.JiraIssueService;
import com.hs.eai.projectoverview.service.ProjectDetailsService;
import com.hs.eai.projectoverview.service.ProjectService;

@RestController
@RequestMapping("projects")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectgService;
	@Autowired
	JiraIssueService jiraIssueService;
	@Autowired
	JiraActionService jiraActionService;
	@Autowired
	ProjectDetailsService projectDetailsService;
	@Autowired
	AppUtilsService appUtilsService;
	/**
	 * Retrieve All Projects
	 * 
	 * @param
	 * @return list projects
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> listAllProjects() {
		List<Project> Projects = projectgService.findAll();
		if (Projects.isEmpty()) {
			return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Project>>(Projects, HttpStatus.OK);
	}

	/**
	 * Retrieve Lazy loading Projects
	 * 
	 * @param
	 * @return list projects
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProjectDetails>> lazyLoadProjectsDetials(
			@RequestParam(required = true, value = "startIndex") Integer startIndex,
			@RequestParam(required = true, value = "maxResult") Integer maxResult) {
		List<ProjectDetails> projectsDetails = projectDetailsService.lazyLoadProjectDetails(startIndex, maxResult);

		if (projectsDetails.isEmpty()) {
			return new ResponseEntity<List<ProjectDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProjectDetails>>(projectsDetails, HttpStatus.OK);
	}

	/**
	 * Retrieve All Projects by user
	 * 
	 * @param assignee
	 *            name
	 * @return list projects
	 */
	@RequestMapping(value = "/assignee/{assignee}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Project>> listProjectsByAssignee(@PathVariable("assignee") String assignee) {
		List<Project> Projects = projectgService.findByAssignee(assignee);
		if (Projects.isEmpty()) {
			return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Project>>(Projects, HttpStatus.OK);
	}

	/**
	 * Retrive Project details
	 * 
	 * @param project
	 *            id
	 * @return ProjectDetails object
	 */
	@RequestMapping(value = "/details/{projectId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectDetails> getProjectDetails(@PathVariable("projectId") Integer projectId) {

		ProjectDetails projectdetails = null;
		try {
			projectdetails = projectDetailsService.findProjectDetails(projectId);

			return new ResponseEntity<ProjectDetails>(projectdetails, HttpStatus.OK);

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
			return new ResponseEntity<ProjectDetails>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Retrive Project by pname
	 * 
	 * @param project
	 *            name pname , pkey , lead , description , project type
	 * @return project object
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProjectDetails>> fullTextProjectSearchWildcard(@RequestParam(required = true, value = "q") String searchTerm) {

		logger.debug("Search Projects with searchTerm " + searchTerm);
		
		List<ProjectDetails> projects = projectDetailsService.fullTextProjectSearchWildcard(searchTerm.toLowerCase());
		if (projects.isEmpty()) {
			logger.debug("No projects found with search phrase " + searchTerm + " .");
			return new ResponseEntity<List<ProjectDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProjectDetails>>(projects, HttpStatus.OK);
	}
	 @RequestMapping(value = "/statistics/{projectId}/TimeoriginalestimatedAndTimespent/{fromDate}/{toDate}/", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Integer>> TimeoriginalestimatedAndTimespent(@PathVariable("projectId") Integer projectId,
	    														   @PathVariable("fromDate") String fromDate,@PathVariable("toDate") String toDate) {
	        
	    	Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
	    	
	    	Timestamp fromDateCreated = appUtilsService.stringToTimeStamp(fromDate);
	    	Timestamp toDateCreated = appUtilsService.stringToTimeStamp(toDate);
	    	
	    	map.put("timeoriginalestimated", jiraIssueService.findTimeoriginalestimateByProjectAndCreatetdBetween(projectId, fromDateCreated, toDateCreated));
	    	map.put("timespent", jiraIssueService.findTimespentByProjectAndCreatetdBetween(projectId, fromDateCreated, toDateCreated));
	    	
	    	List<Integer> timeOrgEestimatedAndTimeSpent = jiraIssueService.findTimeoriginalestimateByProjectAndCreatetdBetween(projectId, fromDateCreated, toDateCreated);
	        
	    	if(timeOrgEestimatedAndTimeSpent.isEmpty()){
	            return new ResponseEntity<List<Integer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Integer>>(timeOrgEestimatedAndTimeSpent,HttpStatus.OK);
	    }
//
	 @RequestMapping(value = "/statistics/{projectId}/TimeoriginalestimatedAndTimespentByProjectAndYear/{year}/", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<ProjectIssueStatistics>> findTimeoriginalestimatedAndTimespentByProjectAndYear(@PathVariable("projectId") Integer projectId,
	    														   @PathVariable("year") String year) {
	        
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("projectId", projectId);
	    	map.put("year", year);
	    	
	        List<ProjectIssueStatistics> TimeOrgEestimatedAndTimeSpent = jiraIssueService.findTimeoriginalestimatedAndTimespentByProjectAndYear(projectId, year);
	    	if(TimeOrgEestimatedAndTimeSpent.isEmpty()){
	            return new ResponseEntity<List<ProjectIssueStatistics>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<ProjectIssueStatistics>>(TimeOrgEestimatedAndTimeSpent,HttpStatus.OK);
	    }
	/**
	 * Count All
	 */
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> countProjects() {
		Integer count = projectgService.countAlle();
		if (count.equals(null)) {
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}
	

}
