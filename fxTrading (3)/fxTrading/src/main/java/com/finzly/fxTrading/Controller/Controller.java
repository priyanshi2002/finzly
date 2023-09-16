package com.finzly.fxTrading.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.finzly.fxTrading.CcyEntity.Ccy;
import com.finzly.fxTrading.CustomerEntity.Customer;
import com.finzly.fxTrading.service.Services;

public class Controller {

	@Autowired
	Services service;
	
	// @Author:Priyanshi Verma : Add ccy data in db
	@PostMapping("addCcyData")
	public String addingCcy(@RequestBody Ccy ccy) {
		return service.addingCcy(ccy);
	}
	//@Author:Priyanshi Verma :gets all currency pair from db if not exists then throws ccy list not available exception
	@GetMapping("getAllCurrencyPair")
	public List<Ccy> getAllCcyPairs() {
		return service.getAllCcyPairs();
	}
	
	//@Author:Priyanshi Verma :  gets all trades that happened if no trade exists throws trade list not available exception 
	@GetMapping("getAllExchanges")
	public List<Customer> getAllExchanges() {
		return service.getAllExchanges();
	}
	
	// @Author:Priyanshi Verma :adds exchange data into db.Validation is done in
	// Service layer
	@PostMapping("addExchangeData")
	public String addExchanges(@RequestBody Customer customer) {
		return service.addExchanges(customer);
	}
   
	
}
