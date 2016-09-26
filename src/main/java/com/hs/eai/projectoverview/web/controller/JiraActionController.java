package com.hs.eai.projectoverview.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hs.eai.projectoverview.model.JiraAction;
import com.hs.eai.projectoverview.service.JiraActionService;



@RestController
public class JiraActionController {

	@Autowired
	JiraActionService jiraActionService;
	
	 /**
     * Retrieve All JiraActions
     * @return
     */
    @RequestMapping(value = "/JiraAction/", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JiraAction>> listAllJiraActions() {
        List<JiraAction> JiraActions = jiraActionService.findAll();
        if(JiraActions.isEmpty()){
            return new ResponseEntity<List<JiraAction>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<JiraAction>>(JiraActions, HttpStatus.OK);
    }
    /**
     * Retrieve All Jira Actions By Project Id
     * @return
     */
    @RequestMapping(value = "/JiraAction/project/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JiraAction>> listJiraActionsByProjectId(@PathVariable("id") String projectId) {
        
    	//Integer id = AppUtils.getInstance().StringToInteger(projectId);
    	Integer id = Integer.valueOf(projectId);
    	List<JiraAction> JiraActions = jiraActionService.findByProjectId(id);
        if(JiraActions.isEmpty()){
            return new ResponseEntity<List<JiraAction>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<JiraAction>>(JiraActions, HttpStatus.OK);
    }
 
}
