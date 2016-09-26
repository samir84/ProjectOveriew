package com.hs.eai.projectoverview.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.eai.projectoverview.model.WorklogDto;
import com.hs.eai.projectoverview.utils.AppUtils;

@Repository
public class WorklogDtoDaoImpl implements WorklogDtoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	public List<WorklogDto> findByAuthor(String author) {
		List<WorklogDto> list = new ArrayList<WorklogDto>();
		try {

			Query query = getSession().getNamedQuery("CreateWorklogDtoByAuthor");
			query.setParameter("author", author);
			list = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;

	}

	public List<WorklogDto> findByAuthorAndDateBetween(String author, String dateFrom, String dateTo) {
		List<WorklogDto> list = new ArrayList<WorklogDto>();
		try {

			Query query = getSession().getNamedQuery("CreateWorklogDtoByAuthorAndDateBetween");
			query.setParameter("author", author);
			query.setParameter("dateFrom", AppUtils.getTimeStampFromString(dateFrom));
			query.setParameter("dateTo", AppUtils.getTimeStampFromString(dateTo));

			list = query.list();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List<WorklogDto> findAllByDateBetween(String dateFrom, String dateTo) {
		List<WorklogDto> list = null;
		try {
			Query query = getSession().getNamedQuery("calluspWorklogDtoByDateBetween");
			query.setParameter("fromDate", AppUtils.getTimeStampFromString(dateFrom));
			query.setParameter("toDate", AppUtils.getTimeStampFromString(dateTo));
			list = query.list();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
