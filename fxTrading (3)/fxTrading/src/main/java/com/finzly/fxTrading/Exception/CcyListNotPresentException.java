package com.finzly.fxTrading.Exception;

public class CcyListNotPresentException extends RuntimeException {
	CcyListNotPresentException(String message){
		super(message);
	}
	CcyListNotPresentException(){
		super();
	}
}
