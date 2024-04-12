package com.Auth.Exception;

import com.Auth.Model.ResponseModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(DatabaseConnectionException.class)
	public ResponseEntity<ResponseModel> databaseConnectionException(DatabaseConnectionException e) {
		ResponseModel response=  new ResponseModel();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
