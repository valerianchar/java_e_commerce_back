package com.doranco.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.doranco.Dao.Interface.ICrud;
import com.doranco.Dao.Interface.IUtilisateur;
import com.doranco.DtoEntity.UtilisateurDTO;
import com.doranco.entity.Utilisateur;
import com.doranco.hibernateConnector.HibernateConnector;
import com.doranco.utils.SessionUtils;
import com.doranco.dtoService.DTOSercice;

public class UtilisateurDAO implements ICrud<Utilisateur>, IUtilisateur{
	
	
	
	


	@Override
	public void add(Utilisateur u) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        session.save(u);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}
	
	



	@Override
	public void update(Utilisateur u) throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateConnector.getSession();
	        transaction = session.beginTransaction();
	        session.update(u);
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
	        Utilisateur a = session.find(Utilisateur.class, id);
	        session.delete(a);
	        transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}


	@Override
	public Utilisateur getById(int id) throws Exception {
		Session session = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Utilisateur> query = session.createNamedQuery("Utilisateur:findByID", Utilisateur.class);
	         query.setParameter("id", id);
	         return query.uniqueResult();
		} finally {
			SessionUtils.closeSession(session);
		}
	}


	@Override
	public List<Utilisateur> getAll() throws Exception {
		Session session = null;
		try {
			session = HibernateConnector.getSession();
	         Query<Utilisateur> query = session.createNamedQuery("Utilisateur:findAll", Utilisateur.class);
	         List<Utilisateur> list = query.getResultList();
	         return list;
		} finally {
			SessionUtils.closeSession(session);
		}
	}





	@Override
	public UtilisateurDTO getByEmail(String email) throws Exception {
		
		Session session = null;
		UtilisateurDTO utilisatDTO = null;
		try {
			session = HibernateConnector.getSession();
	        Query<Utilisateur> query = session.createNamedQuery("Utilisateur:findByEmail", Utilisateur.class);
	        query.setParameter("email", email);
	        Utilisateur u = query.uniqueResult();
	        if(u != null) {
	        	utilisatDTO = DTOSercice.convertToUtilisateurDTO(u);
	        }
	        return utilisatDTO;
		} finally {
			SessionUtils.closeSession(session);
		}
		
	}
}
