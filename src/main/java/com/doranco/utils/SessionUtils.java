package com.doranco.utils;

import org.hibernate.Session;

public final class SessionUtils {
	
	private SessionUtils() {
		
	}

	
	public final static void closeSession(Session session) {
		if(session != null && session.isOpen()) {
			session.close();
		}
	}

}
