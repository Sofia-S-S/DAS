
package com.revature;

import com.revature.model.Address;
import com.revature.model.User;
import com.revature.repository.AdminRepository;
import com.revature.repository.impl.AdminRepositoryImpl;

public class Driver {
	


	public static void main(String[] args) {
	
		AdminRepository admin = new AdminRepositoryImpl();
//		Bill bill = new Bill();
//		bill.setTotal(4000d);
//		admin.createBill(bill);
//		System.out.print("helllo");
		Address address = new Address();
		User doctor = new User();
		doctor.setEmail("rrr.com");
		doctor.setRole("Doctor");
//		Login login = new Login();
//		admin.createDoctor(address, doctor, login);
//		
		admin.createDoctor(address, doctor);
		
	}

}
