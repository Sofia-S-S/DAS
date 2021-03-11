package com.revature.service.impl;

import com.revature.model.Address;
import com.revature.model.Login;
import com.revature.model.User;
import com.revature.repository.AdminRepository;
import com.revature.repository.impl.AdminRepositoryImpl;
import com.revature.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	AdminRepository repo = new AdminRepositoryImpl();

	@Override
	public void createDoctor(Address address, User doctor, Login login) {

		repo.createDoctor(address, doctor, login);
		
	}

}
