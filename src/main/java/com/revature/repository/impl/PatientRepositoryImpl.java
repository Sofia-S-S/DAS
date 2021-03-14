package com.revature.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.PatientRepository;
import com.revature.util.HibernateSessionFactory;

@Repository("patientRepository")
public class PatientRepositoryImpl implements PatientRepository {
	
	
	// Transaction variable
	Transaction tx;

	@Override
	public void registerNewPatient(User user, Address address, Login login, Role role) {

		// Try block that will start and automatically close a session
		try (Session session = HibernateSessionFactory.getSession()) {
			
			// Begin a transaction
			tx = session.beginTransaction();
			
			// Save the new patient info
			session.save(address);
			session.save(login);
			session.save(role);
			session.save(user);
			
			// Commit the transaction
			tx.commit();
			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

	@Override
	public String getPassword(String email) {
		
		// Password variable
		String password = null;
		
		// Try block that will start and automatically close a session
		try (Session session = HibernateSessionFactory.getSession()) {
			
			// Begin a transaction
			tx = session.beginTransaction();
			
			// create an initial login object
			Login login = new Login();
			
			// Query the DB and append it to the login object
			login = session.createQuery("FROM Login WHERE email = :email", Login.class)
					.setParameter("email", email)
					.getSingleResult();
			
			// Get the password
			password = login.getPassword();
			
			// Commit the transaction
			tx.commit();
			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		return password;
	}

	@Override
	public void updateInfo(User user, Address address, Login login, Role role) {

		// Try block that will start and automatically close a session
		try (Session session = HibernateSessionFactory.getSession()) {
			
			// Begin a transaction
			tx = session.beginTransaction();
			
			// Save the new patient info
			session.update(address);
			session.update(login);
			session.update(role);
			session.update(user);
			
			// Commit the transaction
			tx.commit();
			
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}


	}

	@Override
	public List<Appointment> viewAvailability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bookAppointment(Appointment appointment) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Appointment> getMyAppointments(int patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelAppointment(int appointmentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Bill> viewMyBills(int patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void payBill(int invoiceId) {
		// TODO Auto-generated method stub

	}

}
