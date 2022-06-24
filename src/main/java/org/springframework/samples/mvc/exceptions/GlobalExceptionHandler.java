package org.springframework.samples.mvc.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SuppressWarnings("ALL")
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public String handleBusinessException(BusinessException ex) {
		return "Handled BusinessException";
	}

}
