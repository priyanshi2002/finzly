package com.finzly.fxTrading.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.fxTrading.services.TradeServiceFx;

import model.Trade;

@RestController
public class FxController {
   
	//to make objects automatically
	@Autowired
	private TradeServiceFx tradeServiceFx;

	
	@PostMapping("doTrade")
	public Map<String, String> doTrade(@RequestBody Trade trade) {
		return TradeServiceFx.bookTrade(trade);
	}

	@GetMapping("getALLTrade")
	public Object getAllTrade() {
		List<Trade> tradeList = this.tradeServiceFx.getTradeList();
		if (tradeList.isEmpty()) {
			return "Your trade list is empty";
		} else {
			return tradeList;
		}
	}

}
