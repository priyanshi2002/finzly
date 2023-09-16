package com.finzly.fxTrading.Exception;

public class IdNotPresentException extends RuntimeException{
	IdNotPresentException(String message){
		super(message);
	}
	
	IdNotPresentException(){
		super();
	}
	
}
