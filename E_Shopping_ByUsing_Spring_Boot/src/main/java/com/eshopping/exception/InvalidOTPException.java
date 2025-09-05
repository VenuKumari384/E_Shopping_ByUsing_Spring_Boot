package com.eshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidOTPException extends RuntimeException{
	private String exceptionMsg;

//	public InvalidOTPException(String exceptionMsg) {
//		super(exceptionMsg);
//		//this.exceptionMsg = exceptionMsg;
//	}
	
}