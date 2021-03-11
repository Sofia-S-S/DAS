package com.revature.repository;

import com.revature.model.Address;
import com.revature.model.Login;
import com.revature.model.User;

public interface AdminRepository {
	
	//1.Log in
	
	//2.Register new doctor (add login and an address for him as well)
	void createDoctor(Address address, User doctor, Login login);
	//3.Update doctor information
	//4.Add new availabilities to schedule
	//5.Send bill to client
	//6.Send reminder e-mail to the client on the day of Appointment(optional)

}
