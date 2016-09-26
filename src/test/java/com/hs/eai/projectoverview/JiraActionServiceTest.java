package com.hs.eai.projectoverview;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hs.eai.projectoverview.service.JiraActionService;
import com.hs.eai.projectoverview.spring.HibernateConfiguration;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class JiraActionServiceTest {

	@Autowired
	JiraActionService jiraActionService;

	@Before
	public void init(){
	
	}
	
	@Test
	public void findAll(){
		
		Assert.assertEquals(1470,jiraActionService.findAll().size());
	}
	
	@Test
	public void findByProjectId(){
		
		int total = jiraActionService.findByProjectId(11406).size();
		Assert.assertEquals(25,total);
		
	}
	
}
