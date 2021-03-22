package com.revature.service.impl.test;
import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.exception.NothingFoundException;
import com.revature.model.Appointment;
import com.revature.model.PatientDoctor;
import com.revature.model.User;
import com.revature.repository.AppointmentRepository;
import com.revature.repository.PatientDoctorRepository;
import com.revature.service.impl.DoctorViewServiceImpl;

/*public class DoctorViewServiceImplTest {
	@InjectMocks
	private static DoctorViewServiceImpl doctorViewServiceImpl;
	
	@Mock
	private AppointmentRepository appointmentRepository;
	@Mock
	private PatientDoctorRepository patientDoctorRepository;
	
	@BeforeClass
	public static void setup() {
		doctorViewServiceImpl = new DoctorViewServiceImpl();
	}
	
	@Before
	public void beforeSetup() {
		MockitoAnnotations.initMocks(this);
		User user = null;
		List<PatientDoctor> testPatients = new ArrayList<>();
		List<Appointment> testAppointments = new ArrayList<>();
	}
	@Test
	public void testViewSelfPatientsForNothingFoundException() {
		List<PatientDoctor> testPatients = new ArrayList<>();
		User doctor = new User();
		try {
			Mockito.when(patientDoctorRepository.findAllByDoctor(doctor)).thenReturn(testPatients);
			Assert.assertThrows(NothingFoundException.class, () -> doctorViewServiceImpl.viewSelfPatients(doctor));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testViewSelfPatientsForInvalidSession() {
		fail("Not yet implemented");
	}
	@Test
	public void testViewBookedAppointmentsForNothingFoundException() {
		List<Appointment> testAppointments = new ArrayList<>();
		User doctor = new User();
		try {
			Mockito.when(appointmentRepository.findAllByDoctorAndStatus(doctor, "booked")).thenReturn(testAppointments);
			Assert.assertThrows(NothingFoundException.class, () -> doctorViewServiceImpl.viewSelfPatients(doctor));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testViewBookedAppointmentsForInvalidSession() {
		fail("Not yet implemented");
	}
}*/
