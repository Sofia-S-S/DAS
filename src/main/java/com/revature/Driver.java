
package com.revature;

import com.revature.model.Address;
import com.revature.model.Bill;
import com.revature.model.Login;
import com.revature.model.User;
import com.revature.service.AdminService;
import com.revature.service.impl.AdminServiceImpl;

public class Driver {
	


	public static void main(String[] args) {
	
		AdminService admin = new AdminServiceImpl();
//		Bill bill = new Bill();
//		bill.setTotal(4000d);
//		admin.createBill(bill);
		System.out.print("helllo");
		Address address = new Address();
		User doctor = new User();
		doctor.setEmail("777Lmnkgg");
		Login login = new Login();
		admin.createDoctor(address, doctor, login);
		
	}

}
