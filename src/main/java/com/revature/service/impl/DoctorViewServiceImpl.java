package com.revature.service.impl;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.NothingFoundException;
import com.revature.model.Appointment;
import com.revature.model.PatientDoctor;
import com.revature.model.User;
import com.revature.repository.AppointmentRepository;
import com.revature.repository.PatientDoctorRepository;
import com.revature.service.DoctorViewService;


@Service(value = "doctorViewService")
public class DoctorViewServiceImpl implements DoctorViewService{
	private AppointmentRepository appointmentRepository;
	private PatientDoctorRepository patientDoctorRepository;
	
	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	@Autowired
	public void PatientDoctorRepository(PatientDoctorRepository patientDoctorRepository) {
		this.patientDoctorRepository = patientDoctorRepository;
	}

	@Override
	public List<PatientDoctor> viewSelfPatients(String username) throws NothingFoundException{
		List<PatientDoctor> viewSelfPatients = new ArrayList<>();
		viewSelfPatients = this.patientDoctorRepository.findAllByDoctor(username);
		if(viewSelfPatients.isEmpty()) throw new NothingFoundException();
		return viewSelfPatients;
	}

	@Override
	public List<Appointment> viewBookedAppointments(String username) throws NothingFoundException{
		List<Appointment> viewBookedAppointments = new ArrayList<>();
		viewBookedAppointments = this.appointmentRepository.findAllByDoctorAndStatus(username, "booked");
		if(viewBookedAppointments.isEmpty()) throw new NothingFoundException();
		return viewBookedAppointments;
	}

}
