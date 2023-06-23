package com.doranco.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.doranco.Dao.Interface.IArticle;
import com.doranco.Dao.Interface.ICrud;
import com.doranco.entity.Adresse;
import com.doranco.entity.Article;
import com.doranco.hibernateConnector.HibernateConnector;
import com.doranco.utils.SessionUtils;

public class AdresseDAO implements ICrud<Adresse> {

	

	@Override
	public void add(Adresse t) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
			transaction = session.beginTransaction();
			transaction.begin();
			session.save(t);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}

	}

	@Override
	public void update(Adresse adresse) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
			transaction = session.beginTransaction();
			transaction.begin();
			session.update(adresse);
			transaction.commit();
		} catch (Exception e) {
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
			Adresse a = session.find(Adresse.class, id);
			session.delete(a);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
	}

	@Override
	public Adresse getById(int id) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
			Query<Adresse> query = session.createNamedQuery("Adresse:FindById", Adresse.class);
			query.setParameter("id", id);
			return query.uniqueResult();
		} finally {
			SessionUtils.closeSession(session);
		}

	}


}
