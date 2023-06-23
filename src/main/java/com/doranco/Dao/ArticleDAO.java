package com.doranco.Dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.doranco.Dao.Interface.IArticle;
import com.doranco.Dao.Interface.ICrud;
import com.doranco.entity.Article;
import com.doranco.hibernateConnector.HibernateConnector;
import com.doranco.utils.SessionUtils;

public class ArticleDAO implements IArticle{

	

	
	@Override
	public int add(Article art) throws Exception {
		Session session = null;
		 int id = 0;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        id = (int) session.save(art);
	        transaction.commit();
		}catch (RollbackException e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		return id;
		
	}

	@Override
	public void update(Article art) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        session.update(art);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
	}

	@Override
	public void delete(int id) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        Article a = session.find(Article.class, id);
	        session.delete(a);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
	}

	@Override
	public Article getById(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Article> query = session.createNamedQuery("Article:FindById", Article.class);
	         query.setParameter("id", id);
	         return query.uniqueResult();
		} finally {
			SessionUtils.closeSession(session);
		}
	}
	


	@Override
	public List<Article> getArticles() {
		Session session = null;
		List<Article> list = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Article> query = session.createNamedQuery("Article:findAll", Article.class);
	         list = query.list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			SessionUtils.closeSession(session);
		}
		return list;
	}

	
	
}
