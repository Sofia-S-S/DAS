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

import com.revature.exception.NothingFoundException;
import com.revature.model.User;
import com.revature.service.UserService;

@RestController(value="userController")
@RequestMapping(path="/user")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(path ="/all")
	public List<User> getAllUsers(){
		return this.userService.getAllUsers();
		}
	
	@GetMapping(path = "/id")
	public User getUserById(@RequestParam int userId) throws NothingFoundException {
	
		return this.userService.viewUser(userId);
	
	}
	
	@PostMapping(path = "/new", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void createNewUser(@RequestBody User user) {
		
		this.userService.createNewUser(user);
	}
	@PostMapping(path = "/new-doctor", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void createNewDoctor(@RequestBody User user) {
		
		this.userService.createNewDoctor(user);
	}
	
	// Getting user info
	@GetMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
	public User viewUser(@RequestParam String username) {
		return userService.getUser(username);

	}
}