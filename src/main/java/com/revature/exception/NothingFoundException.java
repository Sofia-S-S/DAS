package com.revature.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Sorry. Nothing was found!")
public class NothingFoundException extends Exception{

	/**
	 * @author sofka
	 */
	private static final long serialVersionUID = 1L;

	public NothingFoundException() {
		super();
	}

	public NothingFoundException(String message) {
		super(message);
	}


	
	

}
