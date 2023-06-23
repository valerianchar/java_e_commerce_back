package com.doranco.main;

import org.hibernate.Session;

import com.doranco.hibernateConnector.HibernateConnector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Session sesion = HibernateConnector.getSession();
			System.out.println(sesion);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
