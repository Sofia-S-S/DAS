package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Address;
import com.revature.model.User;
import com.revature.service.impl.PatientServiceImpl;

@RestController("patientController")
@RequestMapping(path = "/patient")
public class PatientController {

	// Autowire to the patientService bean
	private PatientServiceImpl patientService;
	
	@Autowired
	public void setPatientService(PatientServiceImpl patientService) {
		this.patientService = patientService;
	}
	
	// Endpoint for registering a new patient
	@PostMapping(path = "/new", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void registerNewPatient(@RequestBody User user, Address address) {
		this.patientService.registerNewPatient(user, address);
	}
	
}
