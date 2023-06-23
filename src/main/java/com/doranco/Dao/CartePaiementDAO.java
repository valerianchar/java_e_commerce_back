package com.doranco.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.doranco.Dao.Interface.ICrud;
import com.doranco.entity.CartePaiement;
import com.doranco.hibernateConnector.HibernateConnector;
import com.doranco.utils.SessionUtils;

public class CartePaiementDAO implements ICrud<CartePaiement>{
	


	@Override
	public void add(CartePaiement cp) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        transaction.begin();
	        session.save(cp);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}


	@Override
	public void update(CartePaiement cp) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        transaction.begin();
	        session.update(cp);
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
	        CartePaiement a = session.find(CartePaiement.class, id);
	        session.delete(a);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}


	@Override
	public CartePaiement getById(int id) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	         Query<CartePaiement> query = session.createNamedQuery("CartePaiement:FindById", CartePaiement.class);
	         query.setParameter("id", id);
	         return query.uniqueResult();
		} finally {
			SessionUtils.closeSession(session);
		}
	}
}
