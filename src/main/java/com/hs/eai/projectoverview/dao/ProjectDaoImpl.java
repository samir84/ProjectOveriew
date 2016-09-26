package com.hs.eai.projectoverview.dao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.eai.projectoverview.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public List<Project> findAll() {
		logger.debug("Find all projects .");
		Query query = getSession().getNamedQuery("Project.findAll");
		@SuppressWarnings("unchecked")
		List<Project> list = query.list();
		logger.debug("total projects found {} ", list.size(), " .");
		return list;
	}

	@Transactional
	public List<Project> findByAssignee(String assignee) {
		// TODO Auto-generated method stub
		logger.debug("Find projects By Assignee {} ", assignee, "..");
		Query query = getSession().getNamedQuery("Project.findProjectsByAssignee");
		query.setParameter("assignee", assignee);
		logger.debug("query {} ", query.toString(), "..");
		@SuppressWarnings("unchecked")
		List<Project> list = query.list();
		logger.debug("total projects found {} ", list.size(), " .");
		return list;
	}

	@Transactional
	public Project findById(Integer id) {
		logger.debug("Find project By id {} ", id, "..");
		return (Project) getSession().get(Project.class, id);
	}

	public Project findByName(String name) {
		logger.debug("Find project by name.");
		Query query = getSession().getNamedQuery("Project.findByName");
		query.setParameter("pname", name);
		return (Project) query.list();
	}

	public Project findByKey(String key) {
		logger.debug("Find project by key.");
		Query query = getSession().getNamedQuery("Project.findByKey");
		query.setParameter("pkey", key);
		return (Project) query.list();
	}

	public Project findByDescription(String description) {
		logger.debug("Find project by description.");
		Query query = getSession().getNamedQuery("Project.findByDescription");
		query.setParameter("description", description);
		return (Project) query.list();
	}

	public List<Project> loadLazyProjects(Integer startIndex, Integer maxResult) {
		// return super.Pagination(startIndex, maxResult);
		return null;
	}

	public List<Project> fullTextProjectSearchWildcard(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer countAlle() {
		// TODO Auto-generated method stub
		return null;
	}


}
