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
<<<<<<< HEAD
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/postgres")
					.setProperty("hibernate.connection.password", "password")
=======
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
					.setProperty("hibernate.connection.password", "Heix#394")
>>>>>>> 067fa31 (Rewrote ontroller Cors Filters)
=======

					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
					.setProperty("hibernate.connection.password", "Heix#394")
>>>>>>> 4f7de85 (Resolved merge conflict, does compile)
					.setProperty("hibernate.connection.username", "postgres")
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
