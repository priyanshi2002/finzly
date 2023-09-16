package com.finzly.fxTrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.finzly.fxTrading.CcyEntity.Ccy;
import com.finzly.fxTrading.CustomerEntity.Customer;
import com.finzly.fxTrading.Dao.Dao;
import com.finzly.fxTrading.Exception.GlobalExceptionsHandler;

public class Services {

	
	@Autowired
	Dao fxdao;
	
	// This is beyond which the user won't be allowed to trade the amount
	private static final double maxTradingAmt = Double.MAX_VALUE;
	
	public static String addingCcy(Ccy ccy) {
		if (ccy.getCcy().isEmpty() || ccy.getAmount() == 0 || ccy.getCcy() == " "
				|| Double.isNaN(ccy.getAmount())) {
			return "Please enter proper currency pair. ";
		} else {
			return fxdao.addingCcy(ccy);
		}
	}

	public List<Ccy> getAllCcyPairs() {
		if (fxdao.getAllCcyPairs().isEmpty()) {
			GlobalExceptionsHandler.getCcyListNotPresentException("Ccy List is Empty");
		}
		return fxdao.getAllCcyPairs();
	}
	
	
	public String addExchanges(Customer customer) {
		// Validation for from and to

				boolean fromToValidation = false;
				if (Services.isValidName(customer.getFrom())
						&& Services.isValidName(customer.getTo())) {
					fromToValidation = true;
				} else {
					return "Kindly enter proper From and to";
				}

				// Validation for rate

				boolean rateValidation = true;
				if (customer.getAmount() == 0 || Double.isNaN(customer.getAmount())) {
					rateValidation = false;
					return "Kindly Enter Proper amount to trade";
				}

				// Checks to see if the trade already exists
				if (!(fxdao.getAllExchanges().isEmpty())) {
					List<Customer> exchanges = getAllExchanges();
					for (Customer exchangedata2 : exchanges) {
						if (exchangedata2.getFrom().equalsIgnoreCase(customer.getFrom())
								&& exchangedata2.getTo().equalsIgnoreCase(customer.getTo())) {
							GlobalExceptionsHandler.getTradeAlreadyPresentException("The Trade Already Exists !!");
						}
					}
				}

				// Validation for Currency pair
				 List<Ccy> currencypairs = getAllCcyPairs();
				int count = 0; // Count is set so that if currency pair exists it proceeds with adding the
								// exchanges else it will print currency pair not available
				double ccyAmount = 0;
				for (Ccy ccydata : currencypairs) { // to iterate the ccydata to check for currency pair
					if (ccydata.getCcy().equalsIgnoreCase(customer.getCcy().trim())) {
						ccyAmount = ccydata.getAmount();
						double exchangeAmount = customer.getAmount();
						double convertedAmount = exchangeAmount * ccyAmount;
						if (convertedAmount < maxTradingAmt) {
							customer.setConvertedamount(convertedAmount);
							count++;
						} else {
							return "The trading amount exceeded the trading limit. Kindly enter amount within Trading limit";
						}

					}
				}
				if (count > 0 && fromToValidation && rateValidation) {
					return fxdao.addExchanges(customer);

				} else {
					return "Currency pair not available";
				}
	}

	

	public List<Customer> getAllExchanges() {
		if (fxdao.getAllExchanges().isEmpty()) {
			GlobalExceptionsHandler.getTradeListNotPresentException("No trade available till now!");
		}
		return fxdao.getAllExchanges();
	}
	

	private static boolean isValidName(String name) {
		return name.matches("^[a-zA-Z. ]+$") && !(name.isEmpty()) && !(name.equals(" ") && !(name == null));
	}

	
}
