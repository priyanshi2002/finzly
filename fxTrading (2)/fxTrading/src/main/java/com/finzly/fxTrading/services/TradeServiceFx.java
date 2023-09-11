package com.finzly.fxTrading.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;
import java.util.InputMismatchException;

import org.springframework.stereotype.Service;

import model.Trade;

@Service
public class TradeServiceFx {

	// to print list of all trade
	public static List<Trade> book = new ArrayList<>();

	// method for validation
	public static Map<String, String> Validation(Trade trade) {
		Map<String, String> errorResp = new TreeMap<>();
               try {
		if (trade.getName() == null) {
			errorResp.put("Name", "Customer name can't be null");
		}
		if (trade.getName().isBlank()) {
			errorResp.put("Name", "Customer name can't be empty");
		}
		if (trade.getAmount() < 0) {
			errorResp.put("USD Amount", "Amount cannot be negative , Please enter a valid amount");
		}
	       }
	       catch (ClassCastException e) {
			return Collections.singletonMap("Invalid entry please read exception and submit " , "Thank you!!");
		}
		
		try {
		if (!trade.getCurrencyPair().equals("USDINR")) {
			errorResp.put("Currency Pair", "Invalid currency pair. only USDINR is supported");
		}
		} 
			catch (InputMismatchException im) {
			return Collections.singletonMap("Invalid entry please read exception and submit " , "Thank you!!");
		}
		return errorResp;
	}

	// method for booking trades
	public static Map<String, String> bookTrade(Trade trade) {
		Map<String, String> responses = new LinkedHashMap<>();
		responses = Validation(trade);
		try {
		if (!responses.isEmpty()) {
			responses.put("Message", "Trade not booked");
		}
		if (responses.isEmpty()) {
			double amount = trade.getAmount();
			double finlAmount = amount * 66.6;

			trade.setAmount(finlAmount);
			trade.setCurrencyPair(trade.getCurrencyPair().toUpperCase());

			Trade tbook = new Trade(trade.getName(), trade.getAmount(), trade.getCurrencyPair());
			responses.put("Message", "Trade for " + trade.getCurrencyPair() + "has been booked with rate"
					+ trade.getAmount() + "will be transferred in 2 working days to " + trade.getCurrencyPair());

			book.add(tbook);
			return responses;
		}
		}
		catch (NullPointerException np){
			return Collections.singletonMap("Invalid entry please read exception and submit " , "Thank you!!");
		}
		return null;
	}

	public List<Trade> getTradeList() {
		return this.book;
	}
}
}
