package com.cg.go.greatoutdoor.wishlist.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(WishlistNotFoundException.class)
	public String handleCustomerNotFound(WishlistNotFoundException e)
	{
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(WishlistException.class)
	public String handleCustomerAlreadyExists(WishlistException e)
	{
		return e.getMessage();
	}

}
