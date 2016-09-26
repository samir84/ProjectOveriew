package com.hs.eai.projectoverview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hs.eai.projectoverview.model.Project;
import com.hs.eai.projectoverview.service.ProjectService;
import com.hs.eai.projectoverview.spring.HibernateConfiguration;
import com.hs.eai.projectoverview.web.controller.ProjectController;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class ProjectServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectService;

	@Before
	public void init() {

	}

	@Test
	public void findAll() {

		Assert.assertEquals(projectService.findAll().size(), 96);
	}

	@Test
	public void findByAssignee() {
		List<Project> projects = projectService.findByAssignee("samir.elazzouzi");
	}

	@Test
	public void findById() {
		Project project = projectService.findById(11406);
		Assert.assertEquals("6410 - Migrate JCAPS to ECLIPS", project.getPname());
	}

	@Test
	public void findByName() {
		Project project = projectService.findByName("6410 - Migrate JCAPS to ECLIPS");
		Assert.assertEquals(new Integer(11406), project.getId());
	}

	@Test
	public void findByKey() {
		Project project = projectService.findByKey("MJTE");
		Assert.assertEquals("6410 - Migrate JCAPS to ECLIPS", project.getPname());
	}

	@Test
	public void findByDescription() {
		Project project = projectService.findByDescription(null);
		Assert.assertEquals("6410 - Migrate JCAPS to ECLIPS", project.getPname());
	}



	@Test
	public void searchProjects() {
//Wildcards are only provided for a single field.
		String searchString = "6410";
		String fields[] = { "description", "lead","pkey","pname","projecttype"};
		List<Project> projects = projectService.fullTextProjectSearchWildcard(searchString);

		System.out.println("total projects: " + projects.size());
		for (Project p : projects) {
			System.out.println(p.toString());
		}

	}
	@Test
	public void loadLazyProjects(){
		List<Project> projects = projectService.loadLazyProjects(1,10);
		System.out.println("total projects: " + projects.size());
		for (Project p : projects) {
			System.out.println(p.toString());
		}

	}

}
