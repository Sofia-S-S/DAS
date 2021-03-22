package com.revature.repository.impl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.exception.NothingFoundException;
import com.revature.model.Appointment;
import com.revature.model.PatientDoctor;
import com.revature.repository.DoctorViewRepository;
import com.revature.util.HibernateSessionFactory;

/*@Repository
public class DoctorViewRepositoryImpl implements DoctorViewRepository{

	@Override
	public List<PatientDoctor> viewSelfPatients(int doctorId) throws NothingFoundException{
		List<PatientDoctor> viewSelfPatients = new ArrayList<>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			viewSelfPatients = session.createQuery("FROM PatientDoctor WHERE doctor.userId = :doctorId", PatientDoctor.class)
					.setParameter("doctorId", doctorId).getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
				
		return viewSelfPatients;
	}

	@Override
	public List<Appointment> viewBookedAppointments(int doctorId) throws NothingFoundException{
		List<Appointment> viewBookedAppointments = new ArrayList<>();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			viewBookedAppointments = session.createQuery("FROM Appointment WHERE doctor.userId = :doctorId AND "
					+ "status = :status", Appointment.class).setParameter("doctorId", doctorId).setParameter("status", "booked")
					.getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		return viewBookedAppointments;
	}

}*/
