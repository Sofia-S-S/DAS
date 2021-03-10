package com.revature.repository;

import com.revature.model.User;

public interface UserRepository {

	// New patients can create an account
	void registerNewPatient(User user);
	
	// Users (patients and doctors) can update their info
	void updateInfo(User user);
	
}
