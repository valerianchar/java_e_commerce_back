package com.doranco.Dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.doranco.Dao.Interface.IComment;
import com.doranco.Dao.Interface.ICrud;
import com.doranco.entity.Commentaire;
import com.doranco.hibernateConnector.HibernateConnector;
import com.doranco.utils.SessionUtils;

public class CommentaireDAO implements ICrud<Commentaire>, IComment{

	



	@Override
	public void add(Commentaire c) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        session.save(c);
	        transaction.commit();
		}catch (RollbackException e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}


	@Override
	public void update(Commentaire c) throws Exception {
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
	        Commentaire a = session.find(Commentaire.class, id);
	        session.delete(a);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}


	@Override
	public Commentaire getById(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Commentaire> query = session.createNamedQuery("Commentaire:FindById", Commentaire.class);
	         query.setParameter("id", id);
	         return query.uniqueResult();
		} finally {
			SessionUtils.closeSession(session);
		}
	}


	@Override
	public List<Commentaire> getAll() throws Exception {
		Session session = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Commentaire> query = session.createNamedQuery("Commentaire:findAll", Commentaire.class);
	         List<Commentaire> list = query.getResultList();
	         return list;
		} finally {
			SessionUtils.closeSession(session);
		}
	}
}
