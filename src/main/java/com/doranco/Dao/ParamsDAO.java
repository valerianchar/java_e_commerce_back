package com.doranco.Dao;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doranco.Dao.Interface.IParams;
import com.doranco.chiffrage.GenerateKey;
import com.doranco.entity.Params;
import com.doranco.hibernateConnector.HibernateConnector;
import com.doranco.utils.SessionUtils;

public class ParamsDAO implements IParams{

	
	
	Params params = null;
	
	@Override
	public Key getCleDeChiffrageCB() throws Exception {
		Transaction transaction = null;  
		Session session = null;
		try {
	            
	            session = HibernateConnector.getSession();
	            this.params = session.find(Params.class, 1);
	            
	            if(this.params == null) {
	            	this.params = new Params();
	            	Key keyCB = GenerateKey.getKey("AES", 128);
	                Key keyPWD = GenerateKey.getKey("AES", 128);
	                transaction = session.beginTransaction();
	                this.params.setCle_cryptage_pwd(keyPWD.getEncoded());
	                this.params.setCle_cryptage_cp(keyCB.getEncoded());
	                session.save(this.params);
	                transaction.commit();
	                return keyCB;
	            }
	            
	        } catch (RollbackException e) {
	            transaction.rollback();
	        } finally {
	        	SessionUtils.closeSession(session);
	        }
	        
	        Key newkey = new SecretKeySpec(this.params.getCle_cryptage_cp(), "AES");
	        return newkey;
	}

	@Override
	public Key getCleDeChiffrageUtilisat() throws Exception {
		Session session = null;
		Transaction transaction = null;
		try {
			
            session = HibernateConnector.getSession();
            this.params = session.find(Params.class, 1);
            
            if(this.params == null) {
            	this.params = new Params();
                Key keyCB = GenerateKey.getKey("AES", 128);
                Key keyPWD = GenerateKey.getKey("AES", 128);
                transaction = session.beginTransaction();
                this.params.setCle_cryptage_pwd(keyPWD.getEncoded());
                this.params.setCle_cryptage_cp(keyCB.getEncoded());
                session.save(this.params);
                transaction.commit();
                return keyPWD;
            }
            
        } catch (RollbackException e) {
            transaction.rollback();
        } finally {
        	SessionUtils.closeSession(session);
        }
        
        Key newkey = new SecretKeySpec(this.params.getCle_cryptage_pwd(), "AES");
        return newkey;
	}


}
