package com.finzly.fxTrading.Exception;

public class TradeListNotPresentException  extends RuntimeException{
	TradeListNotPresentException(String message){
		super(message);
	}
	
	TradeListNotPresentException(){
		super();
	}
}
