package com.revature.service;

import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.Login;
import com.revature.model.User;

public interface AdminService {

	void createDoctor(Address address, User doctor, Login login);
	void createSpot(Appointment spot);
	void createBill(Bill bill);
}
