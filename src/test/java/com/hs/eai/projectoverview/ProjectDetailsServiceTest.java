package com.hs.eai.projectoverview;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hs.eai.projectoverview.model.ProjectDetails;
import com.hs.eai.projectoverview.service.ProjectDetailsService;
import com.hs.eai.projectoverview.spring.HibernateConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class ProjectDetailsServiceTest {

	@Autowired
	ProjectDetailsService projectDetailsService;
	
	@Test
	public void findProjectDetails(){
		
		ProjectDetails projectDetails = projectDetailsService.findProjectDetails(10103);
	
	}
	@Test
	public void lazyLoadProjectDetails(){
		List<ProjectDetails> projectDetailsList = projectDetailsService.lazyLoadProjectDetails(0,1);
		System.out.println(projectDetailsList);
	}
}
