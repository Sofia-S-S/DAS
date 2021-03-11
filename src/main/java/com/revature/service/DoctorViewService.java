package com.revature.service;

import java.util.List;

import com.revature.model.Appointment;
import com.revature.model.User;

public interface DoctorViewService {
	List<User> viewSelfPatients(int doctorId) /*throws BusinessException*/;
	List<Appointment> viewBookedAppointments(int doctorId) /*throws BusinessException*/;

}
