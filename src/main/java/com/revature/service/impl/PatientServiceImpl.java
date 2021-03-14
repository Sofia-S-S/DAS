package com.revature.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Address;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.impl.PatientRepositoryImpl;
import com.revature.service.PatientService;

@Service("patientService")
public class PatientServiceImpl implements PatientService {
	
	// Autowire to the patientRepository bean
	private PatientRepositoryImpl patientRepository;
	
	@Autowired
	public void setPatientRepository(PatientRepositoryImpl patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public void registerNewPatient(User user, Address address, Login login, Role role) {
		
		patientRepository.registerNewPatient(user, address, login, role);

	}

	@Override
	public boolean userLogin(String email, String password) {
		
		// Initial boolean value
		boolean b = false;
		
		// Get the password that is stored in the DB
		String savedPassword = patientRepository.getPassword(email);
		
		// Check to see if the passwords match
		if(password.equals(savedPassword)) {
			
			// Change the value of b to true
			b = true;
			
		}
		
		return b;
	}

}
