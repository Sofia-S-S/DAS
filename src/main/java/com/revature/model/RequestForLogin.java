/**
 * 
 */
package com.revature.model;

import javax.validation.constraints.*;


/**
 * @author Jinwei Xiong
 *
 */
public class RequestForLogin {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	public RequestForLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestForLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	
	
}
