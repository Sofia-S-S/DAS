package com.revature.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Role;
import com.revature.model.RoleEnum;
import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.RoleRepository;



@Service(value="userSrvice")
public class UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	public void createNewUser(User user) {
		this.userRepository.save(user);
	}
	public void createNewDoctor(User user){
		
//		user.setRole("admin");
//		
//		String strRole = user.getRole();
		String strRole = "admin";
		Set<Role> roles = new HashSet<>();		
		if (strRole == null || strRole.isEmpty() ) {
			Role userRole = roleRepository.findByRole(RoleEnum.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			switch (strRole) {
				case "admin":
					Role patient = roleRepository.findByRole(RoleEnum.ROLE_ADMIN).orElseThrow(()->new RuntimeException("Error: Role is not found."));
					roles.add(patient);

					break;
				case "doctor":
					Role doctor = roleRepository.findByRole(RoleEnum.ROLE_DOCTOR)
							.orElseThrow(()->new RuntimeException("Error: Role is not found."));
					roles.add(doctor);

					break;
				default:
					Role adminRole = roleRepository.findByRole(RoleEnum.ROLE_PATIENT)
							.orElseThrow(()->new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
			}
		}
		user.setRoles(roles);
			//For our field role
		
			//For join table
//			Role role = new Role();
//			role.setRoleId(2);
//			Set<Role> roles = new HashSet<>();
//			roles.add(role);
//			user.setRoles(roles);
	
			this.userRepository.save(user);
		
	}
	
public void createNewPatient(User user){
		
		String strRole = user.getRole();
		Set<Role> roles = new HashSet<>();		
		if (strRole == null || strRole.isEmpty() ) {
			Role userRole = roleRepository.findByRole(RoleEnum.ROLE_PATIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			switch (strRole) {
				case "admin":
					Role patient = roleRepository.findByRole(RoleEnum.ROLE_ADMIN).orElseThrow(()->new RuntimeException("Error: Role is not found."));
					roles.add(patient);

					break;
				case "doctor":
					Role doctor = roleRepository.findByRole(RoleEnum.ROLE_DOCTOR)
							.orElseThrow(()->new RuntimeException("Error: Role is not found."));
					roles.add(doctor);

					break;
				default:
					Role adminRole = roleRepository.findByRole(RoleEnum.ROLE_PATIENT)
							.orElseThrow(()->new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
			}
		}
		user.setRoles(roles);
			//For our field role
			user.setRole("Patient");
	
			this.userRepository.save(user);
		
	}
//Get all doctors
//	public List<Users> findAllDoctors(){
//		
//		Role role = new Role(2, RoleEnum.ROLE_DOCTOR);
//		
//		return this.userRepository.findAllByRoles(role.getUserRole());
//	}
	
	// Grab user info
	public User viewUser(int userId) {
		return userRepository.findByUserId(userId);
	}
	
}