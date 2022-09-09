package com.cba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExist extends Exception{
	private static final long serialVersionUID=1;
	
	public ResourceAlreadyExist(String message) {
		super(message);
		
	}

}
