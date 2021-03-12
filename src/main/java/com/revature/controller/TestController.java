/**
 * 
 */
package com.revature.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jinwei Xiong
 *
 */

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/patient")
	@PreAuthorize("hasRole('Patient') or hasRole('Doctor') or hasRole('Admin')")
	public String patientAccess() {
		return "patient Content.";
	}
	
	@GetMapping("/doctor")
	@PreAuthorize("hasRole('doctor')")
	public String doctorAccess() {
		return "doctor content.";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin content.";
	}
}
