package com.revature.service;

import com.revature.model.Address;
import com.revature.model.Login;
import com.revature.model.User;

public interface AdminService {

	void createDoctor(Address address, User doctor, Login login);
}
