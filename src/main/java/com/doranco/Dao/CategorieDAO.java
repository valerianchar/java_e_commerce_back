package com.doranco.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.doranco.Dao.Interface.ICategorie;
import com.doranco.Dao.Interface.ICrud;
import com.doranco.entity.Article;
import com.doranco.entity.Categorie;
import com.doranco.hibernateConnector.HibernateConnector;
import com.doranco.utils.SessionUtils;

public class CategorieDAO implements ICrud<Categorie>, ICategorie{

	
	


	@Override
	public void add(Categorie c) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        transaction.begin();
	        session.save(c);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}


	@Override
	public void update(Categorie c) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        transaction.begin();
	        session.update(c);
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
	        transaction.begin();
	        Categorie a = session.find(Categorie.class, id);
	        session.delete(a);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}


	@Override
	public Categorie getById(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Categorie> query = session.createNamedQuery("Categorie:FindById", Categorie.class);
	         query.setParameter("id", id);
	         return query.uniqueResult();
		} finally {
			SessionUtils.closeSession(session);
		}
	}


	@Override
	public List<Categorie> getAll() throws Exception {
		Session session = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Categorie> query = session.createNamedQuery("Categorie:findAll", Categorie.class);
	         List<Categorie> list = query.list();
	         return list;
		} finally {
			SessionUtils.closeSession(session);
		}
	}
}
