package com.revature.repository;

import com.revature.model.Address;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;

public interface UserRepository {

	// New patients can register for an account
	void registerNewPatient(User user, Address address, Login login, Role role);
	
	// Users (doctors and patients) can update their info
	void updateInfo(User user);
	
}
