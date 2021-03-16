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
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
					.setProperty("hibernate.connection.password", System.getenv("postgresPassword"))
					.setProperty("hibernate.connection.username", System.getenv("postgresUsername"))
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
