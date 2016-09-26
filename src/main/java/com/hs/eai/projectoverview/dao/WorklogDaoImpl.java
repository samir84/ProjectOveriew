package com.hs.eai.projectoverview.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hs.eai.projectoverview.model.Worklog;

@Repository
public class WorklogDaoImpl implements WorklogDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public List<Worklog> findAll() {

		Query query = getSession().getNamedQuery("Worklog.findAll");
		@SuppressWarnings("unchecked")
		List<Worklog> list = query.list();
		return list;
	}

	@Transactional
	public List<Worklog> findByAuthor(String author) {

		Query query = getSession().getNamedQuery("Worklog.findByAuthor");
		query.setParameter("author", author);
		List<Worklog> list = query.list();
		return list;
	}

	@Transactional
	public List<Worklog> findByCreatedDate(Timestamp created) {
		Query query = getSession().getNamedQuery("Worklog.findByCreatedDate");
		query.setParameter("created", created);
		List<Worklog> list = query.list();
		return list;
	}

	@Transactional
	public List<Worklog> findByFromDateToDate(Timestamp fromDate, Timestamp toDate) {

		Query query = getSession().getNamedQuery("Worklog.findByFromDateToDate");
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		List<Worklog> list = query.list();
		return list;
	}

	@Transactional
	public List<Worklog> findByAuthorAndFromDateToDate(String author, Timestamp fromDate, Timestamp toDate) {

		Query query = getSession().getNamedQuery("Worklog.findByAuthorAndFromDateToDate");
		query.setParameter("author", author);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		List<Worklog> list = query.list();
		return list;
	}

}
