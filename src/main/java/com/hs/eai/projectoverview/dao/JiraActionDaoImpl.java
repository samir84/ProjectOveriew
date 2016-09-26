package com.hs.eai.projectoverview.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.eai.projectoverview.model.JiraAction;

@Repository
public class JiraActionDaoImpl implements JiraActionDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	public List<JiraAction> findAll() {
		
		Query query = getSession().getNamedQuery("jiraaction.findAll");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	
	public List<JiraAction> findByProjectId(Integer id) {
		
		Query query = getSession().getNamedQuery("jiraaction.findByProjectId");
		query.setParameter("id", id);
		return query.list();
	}

}
