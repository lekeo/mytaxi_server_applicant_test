package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are violated ...")
public class CarAlreadyInUseException extends Exception {

	private static final long serialVersionUID = -8286002109063841731L;
	
	public CarAlreadyInUseException(String message) {
		super(message);
	}
	
}
