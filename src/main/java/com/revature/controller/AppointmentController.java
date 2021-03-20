package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Appointment;
import com.revature.service.AppointmentService;
@CrossOrigin(origins="*", maxAge=3600)
@RestController(value = "appointmentController")
@RequestMapping(path = "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	// Creating a new appointment spot
	@PostMapping(path = "/new-spot", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createAppointment(@RequestBody Appointment appointment) {
		this.appointmentService.createAppointment(appointment);
	}
	
	// Patients book an appointment
	@PostMapping(path = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void bookAppointment(@RequestBody Appointment appointment) {
		this.appointmentService.bookAppointment(appointment);
	}
	
	// Patients can cancel appointments
	@PostMapping(path = "/cancel", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cancelAppointment(@RequestBody Appointment appointment) {
		this.appointmentService.cancelAppointment(appointment);
	}
	
	// Patients can view available appointments
	@GetMapping(path = "/availability", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> viewAllAvailableAppointments(){
		return this.appointmentService.viewAllAvailableAppointments();
	}
	
	// Patients can view their appointments
	@GetMapping(path = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> viewMyAppointments(@RequestParam int patientId){
		return this.appointmentService.viewMyAppointments(patientId);
	}
	
	// Doctor can view their scheduled appointments
	@GetMapping(path = "/viewBookedAppointments", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> viewMyScheduledAppointments(@RequestParam int doctorId){
		return this.appointmentService.viewMyScheduledAppointments(doctorId);
	}

}
