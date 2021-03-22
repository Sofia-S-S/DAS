package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Appointment;
import com.revature.repository.AppointmentRepository;

@Service(value = "appointmentService")
public class AppointmentService {

	private AppointmentRepository appointmentRepository;
	
	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	// PAdmin can view all appointments
	public List<Appointment> getAll(){
		return this.appointmentRepository.findAll();
		}

	// Admin creates a new appointment spot
	public void createAppointment(Appointment appointment) {
		// Set the status to available
		appointment.setStatus("available");
		appointment.setPatient(null);
		this.appointmentRepository.save(appointment);
	}
	
	// Patients book an appointment
	public void bookAppointment(Appointment appointment) {
		
		System.out.println(appointment);
		
		// Get the appointment that will be updated
		Appointment updatedAppointment = this.appointmentRepository.findByAppointmentId(appointment.getAppointmentId());
		System.out.println(updatedAppointment);
		// Set the status to booked
		updatedAppointment.setStatus("booked");
		
		this.appointmentRepository.save(updatedAppointment);
	}
	
	// Patients can cancel appointments
	public void cancelAppointment(Appointment appointment) {
		
		// Get the appointment that will be canceled
		Appointment canceledAppointment = this.appointmentRepository.findByAppointmentId(appointment.getAppointmentId());
		
		// Set the status to canceled
		canceledAppointment.setStatus("available");
		canceledAppointment.setPatient(null);

		this.appointmentRepository.save(canceledAppointment);
	}
	// PAdmin can view all appointments
	public List<Appointment> getAll(){
		return this.appointmentRepository.findAll();
	}
	
	// Patients can view available appointments
	public List<Appointment> viewAllAvailableAppointments(){
		return this.appointmentRepository.findAllByStatus();
	}
	
	// Patients can view their appointments
	public List<Appointment> viewMyAppointments(int patientId){
		return this.appointmentRepository.findAllByPatient(patientId);
	}
	
	// Doctor can view their scheduled appointments
	public List<Appointment> viewMyScheduledAppointments(int doctorId){
		return this.appointmentRepository.findAllByDoctorAndStatus(doctorId);
	}
	
}
