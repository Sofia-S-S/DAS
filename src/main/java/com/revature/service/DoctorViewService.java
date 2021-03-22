package com.revature.service;

import java.util.List;

import com.revature.exception.NothingFoundException;
import com.revature.model.Appointment;
import com.revature.model.PatientDoctor;
import com.revature.model.User;

public interface DoctorViewService {
	List<PatientDoctor> viewSelfPatients(String username) throws NothingFoundException;
	List<Appointment> viewBookedAppointments(String username) throws NothingFoundException;

}