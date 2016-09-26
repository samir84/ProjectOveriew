package com.hs.eai.projectoverview;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hs.eai.projectoverview.model.Worklog;
import com.hs.eai.projectoverview.model.WorklogDto;
import com.hs.eai.projectoverview.service.WorklogDtoService;
import com.hs.eai.projectoverview.service.WorklogService;
import com.hs.eai.projectoverview.spring.HibernateConfiguration;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class WorklogServiceTest {

	@Autowired
	WorklogService worklogService;
	
	@Before
	public void init() {

	}

	@Test
	public void findAll() {
		List<Worklog> worklogs = worklogService.findAll();

	}

	@Test
	public void findByAuthor() {
		List<Worklog> worklogs = worklogService.findByAuthor("samir.elazzouzi");
		
	}

	@Test
	public void findByCreated() {
		String text = "2016-06-08 16:04:46.257";
		Timestamp ts = Timestamp.valueOf(text);

		List<Worklog> worklogs = worklogService.findByCreatedDate(ts);
		
	}

	@Test
	public void findByFromDateToDate() {

		Timestamp dateFrom = Timestamp.valueOf("2016-06-01 00:00:00.000");
		Timestamp dateTo = Timestamp.valueOf("2016-06-08 23:59:59.999");

		List<Worklog> worklogs = worklogService.findByFromDateToDate(dateFrom, dateTo);
		Assert.assertEquals(worklogs.size(), 130);;
		
	}

	
	@Test
	public void findByAuthorAndFromDateToDate() {

		String author = "samir.elazzouzi";

		Timestamp dateFrom = Timestamp.valueOf("2016-06-01 00:00:00.000");
		Timestamp dateTo = Timestamp.valueOf("2016-06-08 23:59:59.999");

		List<Worklog> worklogs = worklogService.findByAuthorAndFromDateToDate(author, dateFrom, dateTo);
		
		for (int i=0 ; i< worklogs.size(); i++){
			
			System.out.println("worklog: "+worklogs.get(i));
		}
		
		
	}

}
