package com.hs.eai.projectoverview.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hs.eai.projectoverview.dao.WorklogDtoDao;
import com.hs.eai.projectoverview.model.WorklogDto;


@Service
public class WorklogDtoServiceImpl implements WorklogDtoService {

	@Autowired
	WorklogDtoDao worklogDtoDao;

	@Transactional
	public List<WorklogDto> findByAuthor(String author) {
		
		return worklogDtoDao.findByAuthor(author);
	}

	@Transactional
	public List<WorklogDto> findByAuthorAndDateBetween(String author, String dateFrom, String dateTo) {
		
		return worklogDtoDao.findByAuthorAndDateBetween(author,dateFrom,dateTo);
	}


	@Transactional
	public List<WorklogDto> findAllByDateBetween(String dateFrom, String dateTo) {
		// TODO Auto-generated method stub
		return worklogDtoDao.findAllByDateBetween(dateFrom, dateTo);
	}


}
