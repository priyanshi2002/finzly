package com.finzly.fxTrading.CcyEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ccy {
	private int id;
	private String ccy;
	private double amount;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", ccy=" + ccy + ", amount=" + amount + "]";
	}
}
