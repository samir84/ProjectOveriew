package com.hs.eai.projectoverview.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hs.eai.projectoverview.model.WorklogDto;
import com.hs.eai.projectoverview.service.WorklogDtoService;




@RestController
@RequestMapping("worklog")
public class WorkLogController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);


	@Autowired
	WorklogDtoService WorklogDtoService;

	
	/**
	 * Retrieve All worklogs
	 * 
	 * @param author
	 * @return list worklogs of an author
	 */
	@RequestMapping(value = "/author/{author}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorklogDto>> listAllWorkLogsByUser(@PathVariable("author") String author) {
		
		List<WorklogDto> worklogsDto = WorklogDtoService.findByAuthor(author);
		if (worklogsDto.isEmpty()) {
			return new ResponseEntity<List<WorklogDto>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<WorklogDto>>(worklogsDto, HttpStatus.OK);
	}
	/**
	 * Retrieve All worklogs
	 * 
	 * @param author , date from , date to 
	 * @return list worklogs of an author
	 */
	@RequestMapping(value = "/author/{author}/fromDate/{fromDate}/toDate/{toDate}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorklogDto>> listWorkLogsByUserDateBetween(@PathVariable("author") String author , @PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
		
		List<WorklogDto> worklogsDto = WorklogDtoService.findByAuthorAndDateBetween(author, fromDate, toDate);
		if (worklogsDto.isEmpty()) {
			return new ResponseEntity<List<WorklogDto>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<WorklogDto>>(worklogsDto, HttpStatus.OK);
	}
	
	/**
	 * Retrieve All worklogs
	 * 
	 * @param author , date from , date to 
	 * @return list worklogs of an author
	 */
	@RequestMapping(value = "/fromDate/{fromDate}/toDate/{toDate}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorklogDto>> listAllWorkLogsByDateBetween(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
		
		List<WorklogDto> worklogsDto = WorklogDtoService.findAllByDateBetween(fromDate, toDate);
		if (worklogsDto.isEmpty()) {
			return new ResponseEntity<List<WorklogDto>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<WorklogDto>>(worklogsDto, HttpStatus.OK);
	}
	
	
	
}
