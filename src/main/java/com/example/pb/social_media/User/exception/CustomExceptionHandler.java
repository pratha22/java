package com.example.pb.social_media.User.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.pb.social_media.User.Controller.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<CustomErrorDetails> handUserNotFoundException(Exception ex, WebRequest request) throws Exception {
	
	    CustomErrorDetails errorDetails = new CustomErrorDetails
	    		(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	    
		return new ResponseEntity<CustomErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		
	}


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomErrorDetails> handAllException(Exception ex, WebRequest request) throws Exception {
	
	    CustomErrorDetails errorDetails = new CustomErrorDetails
	    		(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	    
		return new ResponseEntity<CustomErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		CustomErrorDetails errorDetails = new CustomErrorDetails
	    		(LocalDateTime.now(), 
	    				"Total Errors "+ ex.getErrorCount() + ": " +ex.getFieldError().getDefaultMessage(), 
	    				request.getDescription(false));
		
		//"Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));

	    
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		
	}


}
