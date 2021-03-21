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
<<<<<<< HEAD
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/postgres")
					.setProperty("hibernate.connection.password", "password")
=======
					.setProperty("hibernate.connection.url", "jdbc:postgresql://database-1.cb2owfxnvd4m.us-east-2.rds.amazonaws.com:5432/postgres")
					.setProperty("hibernate.connection.password", "Ne18mne!")
>>>>>>> 558882e62b61ad006ae1a9ab99217a3472cf9df9
					.setProperty("hibernate.connection.username", "postgres")
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
