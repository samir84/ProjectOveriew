package com.hs.eai.projectoverview.web.controller;



import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hs.eai.projectoverview.service.AppUtilsService;
import com.hs.eai.projectoverview.service.JiraIssueService;



@RestController
public class JiraIssueController {

	@Autowired
	JiraIssueService jiraIssueService;
	@Autowired
	AppUtilsService appUtilsService;
	 /**
     * Retrieve find Total Issues By Project Id
     * @param Project id
     * @return total issues
     */
    @RequestMapping(value = "/JiraIssue/TotalIssues/{projectId}", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> findTotalIssuesByProjectId(@PathVariable("projectId") Integer projectId) {

    	Integer  TotalJiraIssues = jiraIssueService.findTotalIssuesByProjectId(projectId);
        if(TotalJiraIssues.equals(0)){
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Integer>(TotalJiraIssues,HttpStatus.OK);
    }
    /**
     * find Total Issues By Project And Status
     * @param Project id , list Statussen
     * @return total issues
     */
    /*@RequestMapping(value = "/JiraIssue/TotalIssues/{projectId}/status/{statussen}", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> findTotalIssuesByProjectAndStatus(@PathVariable("projectId") String projectId,@PathVariable("statussen") String[] status) {
        
    	Integer id = Integer.valueOf(projectId);
    	Integer  TotalJiraIssues = jiraIssueService.findTotalIssuesByProjectAndStatussen(id, status);
        
    	if(TotalJiraIssues.equals(0)){
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Integer>(TotalJiraIssues,HttpStatus.OK);
    }*/
   
    /**
     *  find Total Completed Issues By Project id
     * @param Project id
     * @return total completed issue
     */
    @RequestMapping(value = "/JiraIssue/TotalCompletedIssues/{projectId}", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> findTotalCompletedIssuesByProject(@PathVariable("projectId") Integer projectId) {
        
    	Integer  TotalJiraIssues = jiraIssueService.findTotalCompletedIssuesByProject(projectId).intValue();

    	if(TotalJiraIssues.equals(0)){
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Integer>(TotalJiraIssues,HttpStatus.OK);
    }
    /**
     *     find Assignees By Project id
     * @param project id
     * @return Assignees
     */
    @RequestMapping(value = "/JiraIssue/Assignees/{projectId}", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findAssigneesByProject(@PathVariable("projectId") Integer projectId) {
        
    	List<String> assignees = jiraIssueService.findAssigneesByProject(projectId);
        
    	if(assignees.isEmpty()){
            return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<String>>(assignees,HttpStatus.OK);
    }
    /**
     *     find Assignees By Project id
     * @param project id
     * @return Assignees
     */
   
 
}
