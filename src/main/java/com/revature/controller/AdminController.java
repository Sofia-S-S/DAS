package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.Login;
import com.revature.model.User;
import com.revature.service.AdminService;

@RestController(value = "adminController")
@RequestMapping(path = "/admin")
public class AdminController {

	private AdminService adminService;
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@PostMapping(path = "/new-doctor", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public void createDoctor(@RequestBody Address address, User doctor, Login login) {
		this.adminService.createDoctor(address, doctor, login);
	}
	
	@PostMapping(path = "/new-bill", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public void createBill(@RequestBody Bill bill) {
		this.adminService.createBill(bill);
	}
	
	@PostMapping(path = "/new-spot", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public void createSpot(@RequestBody Appointment spot) {
		this.adminService.createSpot(spot);
	}

	
	
	
}
