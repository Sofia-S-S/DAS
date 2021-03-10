package com.revature.repository;

import com.revature.model.User;

public interface UserRepository {

	// New patients can register for an account
	void registerNewPatient(User user);
	
	// Users (doctors and patients) can update their infor
	void updateInfo(User user);
	
}
