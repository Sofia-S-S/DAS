package com.revature.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.AdminRepository;
import com.revature.util.HibernateSessionFactory;

public class AdminRepositoryImpl implements AdminRepository {

	//--------------------------ADD NEW DOCTOR TO THE SYSTEM

	@Override // Create Employee (with Address) // Create Login
	public void createDoctor(Address address,Role role, User doctor, Login login) {
		

			//All my work is done within the context of a Hibernate session
			Session s = null;
			// The Transaction interface gives me control over  DB transactions.
			Transaction tx = null;
			
			try {
				s = HibernateSessionFactory.getSession();
				tx = s.beginTransaction();
				// This method persists the doctor,address,role and login (i.e. creates a new record in four tables)
				s.save(address);
				s.save(role);
				s.save(doctor);
				s.save(login);
				tx.commit();

			}catch(HibernateException e) {
				e.printStackTrace();
				tx.rollback();

			}finally {
				//Always close your sessions!
				s.close();
			}

		}

	@Override
	public void createSpot(Appointment spot) {
		//All my work is done within the context of a Hibernate session
		Session s = null;
		// The Transaction interface gives me control over  DB transactions.
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			// This method persists appointment(i.e. creates a new record in Appointment table)
			s.save(spot);
			tx.commit();

		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}finally {
			//Always close your sessions!
			s.close();
		}
		
	}

	@Override
	public void createBill(Bill bill) {
		//All my work is done within the context of a Hibernate session
		Session s = null;
		// The Transaction interface gives me control over  DB transactions.
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			// This method persists bill(i.e. creates a new record in Bill table)
			s.save(bill);
			tx.commit();

		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();

		}finally {
			//Always close your sessions!
			s.close();
		}
	}
}
