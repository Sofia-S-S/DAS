package com.revature;

import com.revature.model.Address;
import com.revature.model.Login;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.impl.AdminRepositoryImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		AdminRepositoryImpl admin = new AdminRepositoryImpl();
		Address address = new Address(1,"765 N Michigan Ave","Chicago","IL",60630,"Basement");
		Role role = new Role(1,"doctor");
		User doctor = new User(6,null,"Nick","Brown","gg", "brown@clinic.com", 676599, address, null, role);
		Login login = new Login(doctor,"kura","dura");
		admin.createDoctor(address,doctor,login);
		
		System.out.print(doctor);
	}
}
