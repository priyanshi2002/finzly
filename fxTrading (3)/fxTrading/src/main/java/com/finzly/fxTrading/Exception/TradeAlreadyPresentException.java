package com.finzly.fxTrading.Exception;

public class TradeAlreadyPresentException extends RuntimeException{
	TradeAlreadyPresentException(String message){
		super(message);
	}
	
	TradeAlreadyPresentException(){
		super();
	}
}
