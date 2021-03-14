package com.revature.service;

import com.revature.model.Address;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;

public interface PatientService {

	// A new patient can register for a new account
	void registerNewPatient(User user, Address address, Login login, Role role);
	
	// Patients can login
	boolean userLogin(String email, String password);
	
}
