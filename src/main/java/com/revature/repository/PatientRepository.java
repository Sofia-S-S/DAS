package com.revature.repository;

import java.util.List;

import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;

public interface PatientRepository {

	// New patients can register for an account
	void registerNewPatient(User user, Address address, Login login, Role role);
	
	// Patients can log in
	String getPassword(String email);
	
	// Patients can update their info
	void updateInfo(User user, Address address, Login login, Role role);
	
	// Patients can view doctors and their availability
	List<Appointment> viewAvailability();
	
	// Patients can book an appointment
	void bookAppointment(Appointment appointment);
	
	// Patients can view their appointments
	List<Appointment> getMyAppointments(int patient);
	
	// Patients can cancel appointments
	void cancelAppointment(int appointmentId);
	
	// Patients can view their bills
	List<Bill> viewMyBills(int patient);
	
	// Patients can pay their bills
	void payBill(int invoiceId);
	
}
