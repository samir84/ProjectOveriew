package com.hs.eai.projectoverview.dao;

import java.util.List;

import com.hs.eai.projectoverview.model.Worklog;
import com.hs.eai.projectoverview.model.WorklogDto;

public interface WorklogDtoDao {

	List<WorklogDto> findByAuthor(String author);
	List<WorklogDto> findByAuthorAndDateBetween(String author , String dateFrom, String dateTo);
	List<WorklogDto> findAllByDateBetween(String dateFrom, String dateTo);
}
