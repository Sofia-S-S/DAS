package com.revature.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	
	public static Session getSession() throws HibernateException{
		
		if(sessionFactory == null) {
			
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", "localhost")
					.setProperty("hibernate.connection.password", "trxr4kidz")
					.setProperty("hibernate.connection.username", "postgres")
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
