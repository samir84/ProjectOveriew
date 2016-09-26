package com.hs.eai.projectoverview;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hs.eai.projectoverview.model.ProjectIssueStatistics;
import com.hs.eai.projectoverview.service.JiraIssueService;
import com.hs.eai.projectoverview.spring.HibernateConfiguration;
import com.sun.jmx.snmp.Timestamp;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class JiraIssueServiceTest {

	@Autowired
	JiraIssueService jiraIssueService;


	@Before
	public void init(){
	
	}
	
	
	@Test
	public void findTotalIssuesByProjectId(){
		Integer inprogress = jiraIssueService.findTotalInprogressIssuesByProject(11406).intValue();
		Integer completed = jiraIssueService.findTotalCompletedIssuesByProject(11406).intValue();
		Integer open = jiraIssueService.findTotalOpenIssuesByProject(11406).intValue();
		int reopend = jiraIssueService.findTotalReopenedIssuesByProject(11406).intValue();
		Assert.assertEquals((inprogress+completed+open+reopend), 148);
		//Assert.assertEquals(new Integer(148), jiraIssueService.findTotalIssuesByProjectId(11406));
		
	}
	@Test
	public void findAssigneesByProject(){
		
	}
	@Test
	public void findTotalClosedIssuesByProject(){
		
		int total = jiraIssueService.findTotalClosedIssuesByProject(11406).intValue();
		Assert.assertEquals(27, total);
	}
	@Test
	public void findTotalCompletedIssuesByProject(){
		
		int resolved = jiraIssueService.findTotalResolvedIssuesByProject(11406).intValue();
		int closed = jiraIssueService.findTotalClosedIssuesByProject(11406).intValue();
		
		int total = jiraIssueService.findTotalCompletedIssuesByProject(11406).intValue();
		System.out.println(total);
		Assert.assertEquals(resolved+closed, total);
	}
	@Test
	public void findTotalResolvedIssuesByProject(){
		
		int total = jiraIssueService.findTotalResolvedIssuesByProject(11406).intValue();
		Assert.assertEquals(52, total);
	}
	
	@Test
	public void findTotalOpenIssuesByProject(){
		int total = jiraIssueService.findTotalOpenIssuesByProject(11406).intValue();
		Assert.assertEquals(60, total);
	}
	@Test
	public void findTotalReopenedIssuesByProject(){
		int total = jiraIssueService.findTotalReopenedIssuesByProject(11406).intValue();
		Assert.assertEquals(2, total);
	}
	@Test
	public void findTotalInprogressIssuesByProject(){
		int total = jiraIssueService.findTotalInprogressIssuesByProject(11406).intValue();
		Assert.assertEquals(7, total);
	}
	@Test
	public void findTimeoriginalestimateByProjectAndCreatetdBetween(){
		Integer projectId = 11406 ;
		String fromdateString ="2015-11-01 00:00:00.000";
		String todateString ="2015-11-30 11:59:59.999";
		java.sql.Timestamp fromdate = stringToTimeStamp(fromdateString);
		java.sql.Timestamp todate = stringToTimeStamp(todateString);
		List<Integer> test = jiraIssueService.findTimeoriginalestimateByProjectAndCreatetdBetween(projectId, fromdate,todate);
		Assert.assertEquals(2,test.size());
	}
	@Test
	public void findTimespentByProjectAndCreatetdBetween(){
		Integer projectId = 11406 ;
		String fromdateString ="2015-11-01 00:00:00.000";
		String todateString ="2015-11-30 11:59:59.999";
		java.sql.Timestamp fromdate = stringToTimeStamp(fromdateString);
		java.sql.Timestamp todate = stringToTimeStamp(todateString);
		List<Integer> test = jiraIssueService.findTimespentByProjectAndCreatetdBetween(projectId, fromdate,todate);
		Assert.assertEquals(2,test.size());
	}//findTimespentByProjectAndCreatetdBetween
	
	public java.sql.Timestamp stringToTimeStamp(String dateString){
		
		java.sql.Timestamp timestamp = null;
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");//'2015-11-01 23:59:59.999' 
		    Date parsedDate = dateFormat.parse(dateString);
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		}catch(Exception e){//this generic but you can control another types of exception
		  e.printStackTrace(); 
		}
		return timestamp;
	}
	
	@Test
	public void findTimeoriginalestimatedAndTimespentByProjectAndYear(){
		
		List<ProjectIssueStatistics> prjsStatistics = jiraIssueService.findTimeoriginalestimatedAndTimespentByProjectAndYear(11406, "2016");
		System.out.println(prjsStatistics.get(0).getTotalTimeSpent());
		Assert.assertEquals(4, prjsStatistics.size());
	}
	
}
