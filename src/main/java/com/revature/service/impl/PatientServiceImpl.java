package com.revature.service.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.revature.auth.model.RoleEnum;
import com.revature.exception.NothingFoundException;
import com.revature.model.Address;
import com.revature.model.Appointment;
import com.revature.model.Bill;
import com.revature.model.MessageResponse;
import com.revature.model.Role;
<<<<<<< HEAD
import com.revature.model.RoleEnum;
=======
>>>>>>> ab94d64 (Can update patient information)
import com.revature.model.User;
import com.revature.repository.AppointmentRepository;
import com.revature.repository.BillRepository;
import com.revature.repository.RoleRepository;
import com.revature.repository.UserRepository;
import com.revature.repository.impl.PatientRepositoryImpl;
import com.revature.service.PatientService;

@Service("patientService")
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	// Autowire to the patientRepository bean
	private PatientRepositoryImpl patientRepository;
	
	@Autowired
	public void setPatientRepository(PatientRepositoryImpl patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public ResponseEntity<MessageResponse> registerNewPatient(User user, MultipartFile image) throws IOException{
		
		// Assign the patient's role
//		Role role = new Role(3, "patient");
		
		// Send info to the repository layer
		//patientRepository.registerNewPatient(user);
		
		if(userRepository.existsByUsername(user.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if(userRepository.existsByEmail(user.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		Set<Role> roles = new HashSet<>();
		if(user.getRole() == null || user.getRole().isEmpty()) {
			Role userRole = roleRepository.findByRole(RoleEnum.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);		
			} else {
				switch(user.getRole()) {
				case "admin":
					Role patient = roleRepository.findByRole(RoleEnum.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(patient);
					break;
				case "doctor":
					Role doctor = roleRepository.findByRole(RoleEnum.ROLE_DOCTOR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(doctor);
					break;
				case "patient":
					Role newPatient = roleRepository.findByRole(RoleEnum.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(newPatient);
					break;
				default:
					Role adminRole = roleRepository.findByRole(RoleEnum.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				
				}
			}
		user.setRoles(roles);
		user.setProfilepicture(image.getBytes());
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User Registered Successfully!"));

	}

	@Override
	public boolean userLogin(String email, String password) {
		
		// Initial boolean value
		boolean b = false;
		
		// Get the password that is stored in the DB
		String savedPassword = patientRepository.getPassword(email);
		
		// Check to see if the passwords match
		if(password.equals(savedPassword)) {
			
			// Change the value of b to true
			b = true;
			
		}
		
		return b;
	}

	@Override
	public void updateInfo(User user, Address address) {
		
		// Send info to the repository layer
		patientRepository.updateInfo(user, address);
		
	}

	@Override
	public List<Appointment> viewAvailability() {
		
		// Grab the info from the Repository layer
		List<Appointment> doctorsAvailability = patientRepository.viewAvailability();
		
		return doctorsAvailability;
	}

	@Override
	public void bookAppointment(Appointment appointment) {
		
		// Send info to the repository layer
		patientRepository.bookAppointment(appointment);
		
	}

	@Override
	public List<Appointment> getMyAppointments(String username) throws NothingFoundException{
		List<Appointment> myAppointments = new ArrayList<>();
		// Grab the info from the Repository layer
		myAppointments = appointmentRepository.findAllByPatient(username, "booked");
		if(myAppointments.isEmpty()) throw new NothingFoundException();
		
		return myAppointments;
	}

	@Override
	public void cancelAppointment(Appointment appointment) {
		
		// Set the status to canceled
		appointment.setStatus("canceled");
		
		// Send data to the repository layer
		patientRepository.cancelAppointment(appointment);
		
	}

	@Override
	public List<Bill> viewMyBills(String username) throws NothingFoundException{
		List<Bill> myBills = new ArrayList<>();
		// Grab the info from the Repository layer
		myBills = billRepository.findAllByPatient(username);
		if(myBills.isEmpty()) throw new NothingFoundException();
		
		return myBills;
	}

	@Override
	public void payBill(Bill bill) {
		
		// Send info to the repository layer
		patientRepository.payBill(bill);
		
	}

	@Override
	public User viewMyInfo(String username) throws NothingFoundException {
		User patient = new User();
		patient = userRepository.findPatientByUsername(username);
		if(patient.getUserId() < 1) throw new NothingFoundException();
		return patient;
	}

	@Override
	public ResponseEntity<MessageResponse> updatePatient(User user, MultipartFile image) throws IOException {
		
		user.setProfilepicture(image.getBytes());
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User Registered Successfully!"));
	}

}
