package com.revature.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.revature.exception.NothingFoundException;
import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.MessageResponse;
import com.revature.model.User;

public interface PatientService {

	// A new patient can register for a new account
	ResponseEntity<MessageResponse> registerNewPatient(User user, MultipartFile image) throws IOException;
	
	// Patients can login
	boolean userLogin(String email, String password);
	
	// Patients can update their info
	void updateInfo(User user, Address address);
	
	// Patients can view doctors and their availability
	List<Appointment> viewAvailability();
	
	// Patients can book an appointment
	void bookAppointment(Appointment appointment);
	
	// Patients can view their appointments
	List<Appointment> getMyAppointments(String username) throws NothingFoundException;
	
	// Patients can cancel appointments
	void cancelAppointment(Appointment appointment);
	
	// Patients can view their bills
	List<Bill> viewMyBills(String username) throws NothingFoundException;
	
	// Patients can pay their bills
	void payBill(Bill bill);
	
	User viewMyInfo(String username) throws NothingFoundException;
	
	ResponseEntity<MessageResponse> updatePatient(User user, MultipartFile image) throws IOException;
}