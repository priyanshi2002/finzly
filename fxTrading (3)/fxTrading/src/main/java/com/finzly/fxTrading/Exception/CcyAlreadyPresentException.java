package com.finzly.fxTrading.Exception;

public class CcyAlreadyPresentException  extends RuntimeException{
	CcyAlreadyPresentException (String message){
		super(message);
	}
	CcyAlreadyPresentException(){
		super();
	}
}
