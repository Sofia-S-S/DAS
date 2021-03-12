/**
 *
 */

package com.revature.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.JsonWebToken;
import com.revature.model.RequestForLogin;
import com.revature.model.RequestForRegister;
import com.revature.model.ResponseJsonWebToken;
import com.revature.model.ResponseMessage;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.RoleDAO;
import com.revature.repository.RoleDAOImpl;
import com.revature.repository.UserDAO;
import com.revature.repository.UserDAOImpl;
import com.revature.service.UserDetailsDAS;

/**
 * @author Jinwei Xiong
 *
 */
@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/auth")

public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserDAOImpl userDAO;
	@Autowired
	RoleDAOImpl roleDAO;
	@Autowired
	PasswordEncoder encoder;
	@Autowired 
	JsonWebToken jwts;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody RequestForLogin loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwts.generateJwtToken(authentication);
		
		UserDetailsDAS userDetails = (UserDetailsDAS)authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new ResponseJsonWebToken(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));				
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RequestForRegister registerRequest){
		if(userDAO.findUsersByUsername(registerRequest.getUsername())!=null) {
			return ResponseEntity
				.badRequest()
				.body(new ResponseMessage("Error:Username is already taken"));
					
		}	
		//Create new user's account
		User user = new User(registerRequest.getUsername(),
				registerRequest.getEmail(),
				encoder.encode(registerRequest.getPassword()));
		Set<String> strRoles = registerRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "patient":
				Role patentRole = roleDAO.findById(1);
				roles.add(patentRole);
				break;
			case "doctor":
				Role doctorRole = roleDAO.findById(2);
				roles.add(doctorRole);
				break;
			case "admin":
				Role adminRole = roleDAO.findById(3);
				roles.add(adminRole);
				break;
			default:
				Role userRole = roleDAO.findById(1);
				roles.add(userRole);
			}
		});		
		user.setRoles(roles);
		userDAO.addUser(user);
		return ResponseEntity.ok(new ResponseMessage("User registered successfully!"));
	}
}
