package com.finzly.fxTrading.CustomerEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	private int id;
	private String from;
	private String to;
	private String ccy;
	private double amount;
	private double convertedamount;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getConvertedamount() {
		return convertedamount;
	}

	public void setConvertedamount(double convertedamount) {
		this.convertedamount = convertedamount;
	}

	@Override
	public String toString() {
		return "Ccy [id=" + id + ", from=" + from + ", to=" + to + ", ccy=" + ccy + ", amount=" + amount
				+ ", convertedamount=" + convertedamount + "]";
	}

}
