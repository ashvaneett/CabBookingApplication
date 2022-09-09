package com.cba.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler  extends RuntimeException{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex,WebRequest request){
		Errordetails errordetails=new Errordetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ResourceAlreadyExist.class)
	public ResponseEntity<?> ResourceAlreadyExist(ResourceAlreadyExist ex,WebRequest request){
		Errordetails errordetails=new Errordetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex,WebRequest request){
		Errordetails errordetails=new Errordetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
