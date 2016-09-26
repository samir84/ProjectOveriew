package com.hs.eai.projectoverview;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hs.eai.projectoverview.model.WorklogDto;
import com.hs.eai.projectoverview.service.WorklogDtoService;
import com.hs.eai.projectoverview.spring.HibernateConfiguration;
import org.hibernate.dialect.MySQLDialect;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class, loader = AnnotationConfigContextLoader.class)
@WebAppConfiguration
public class WorklogDtoServiceTest {

	@Autowired
	WorklogDtoService worklogDtoService;
	
	
	@Test
	public void findByAuthor(){
		String author = "samir.elazzouzi";
		List<WorklogDto> worklogs = worklogDtoService.findByAuthor(author);
	}
	@Test
	public void findAllByDateBetween() {

		String dateFrom = "2016-06-01";
		String dateTo = "2016-06-08";
		List<WorklogDto> worklogs = worklogDtoService.findAllByDateBetween(dateFrom, dateTo);
		System.out.println(worklogs.size());
		Assert.assertNotNull(worklogs);
		
	}
}
