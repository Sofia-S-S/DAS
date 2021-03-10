package com.revature.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.util.HibernateSessionFactory;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
	
	// Transaction variable
	Transaction tx;

	@Override
	public void registerNewPatient(User user) {
		
		// Try block that will start and automatically close a session
		try (Session session = HibernateSessionFactory.getSession()) {
			
			// Begin a transaction
			tx = session.beginTransaction();
			
			// Save the new patient info
			session.save(user);
			
			// Commit the transaction
			tx.commit();
			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	@Override
	public void updateInfo(User user) {

		// Try block that will start and automatically close a session
		try (Session session = HibernateSessionFactory.getSession()) {
			
			// Begin a transaction
			tx = session.beginTransaction();
			
			// update the user info
			session.update(user);
			
			// Commit the transaction
			tx.commit();
			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
