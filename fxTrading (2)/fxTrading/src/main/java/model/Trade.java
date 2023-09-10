package model;

public class Trade {
	private String name;
	private double amount;
	private String currencyPair;
	
     	public Trade(String name, double amount,String currencyPair) {
		super();
		this.name = name;
		this.amount = amount;
		this.currencyPair = currencyPair;
	}
     	public Trade() {
          super();
    	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	@Override
	public String toString() {
		return "Trade [name=" + name + ", amount=" + amount + ", currencyPair=" + currencyPair + "]";
	}
}
