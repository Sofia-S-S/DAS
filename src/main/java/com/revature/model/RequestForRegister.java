/**
 * 
 */
package com.revature.model;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Jinwei Xiong
 *
 */
public class RequestForRegister {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	@NotBlank
	@Email
	private String email;
	
	private Set<String> role;

	public RequestForRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestForRegister(@NotBlank String username, @NotBlank String password, @NotBlank @Email String email,
			Set<String> role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
	
	
}
