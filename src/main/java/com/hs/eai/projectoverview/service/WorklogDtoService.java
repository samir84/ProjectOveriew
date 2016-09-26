package com.hs.eai.projectoverview.service;

import java.util.List;

import com.hs.eai.projectoverview.model.WorklogDto;

public interface WorklogDtoService {

	List<WorklogDto> findAllByDateBetween(String dateFrom, String dateTo);
	List<WorklogDto> findByAuthor(String author);
	List<WorklogDto> findByAuthorAndDateBetween(String author , String dateFrom, String dateTo);
}
