package com.revature.service;

import java.util.List;

import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Login;
import com.revature.model.User;

public interface PatientService {

	// A new patient can register for a new account
	void registerNewPatient(User user, Address address, Login login);
	
	// Patients can login
	boolean userLogin(String email, String password);
	
	// Patients can update their info
	void updateInfo(User user, Address address, Login login);
	
	// Patients can view doctors and their availability
	List<Appointment> viewAvailability();
	
}
