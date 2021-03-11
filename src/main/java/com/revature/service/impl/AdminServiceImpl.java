package com.revature.service.impl;

import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.AdminRepository;
import com.revature.repository.impl.AdminRepositoryImpl;
import com.revature.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	AdminRepository repo = new AdminRepositoryImpl();

	//Creating new doctor by passing Role #2 to createUser method
	@Override
	public void createDoctor(Address address, User doctor, Login login) {
		
		Role role = new Role(2, "doctor");

		repo.createDoctor(address, role, doctor, login);
		
	}

	// Creating appointment with status "available" and user = null
	@Override
	public void createSpot(Appointment spot) {

		repo.createSpot(spot);
		
	}

	@Override
	public void createBill(Bill bill) {

		repo.createBill(bill);
		
	}

}
