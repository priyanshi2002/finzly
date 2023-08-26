package finzly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Trades {
	private static int tradeCount = 0;
	private int tradeNo;
	private String currencyPair;
	private String name;
	private double amount;
	private double rate;

	public Trades(String name, String currencyPair, double amount, double rate) {
		this.tradeNo = ++tradeCount;
		// setAmount(amount);
		this.name = name;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.rate = rate;
	}

	public int getTradeNo() {
		return tradeNo;
	}

	public String getName() {
		return name;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public double getAmount() {
		return amount;
	}

	public double getRate() {
		return rate;
	}

	@Override
	public String toString() {

		double formattedAmount = amount * 66.0;
		return tradeNo + " " + name + " " + currencyPair + " " + formattedAmount + " " + rate;
		// return tradeNo + " " + currencyPair + " " + name +" "+formattedAmount+"
		// "+rate ;

	}
}

public class Trading {
	private static double usdToInrRate = 66.0;
	private static List<Trades> trade = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		String input;

		while (true) {
			System.out.println("Enter 1 to Book Trade: ");
			System.out.println("Enter 2 to Print Trade: ");
			System.out.println("Enter 3 to exit: ");
			System.out.println("Enter you choice: ");
			input = sc.nextLine();

			switch (input) {
			case "1":
				book();
				break;
			case "2":
				display();
				break;
			case "3":
				wantToExit();
				break;
			default:
				System.out.println("Invalid choice. Please select again.");
				break;
			}
		}

	}

	// method for for booking trade
	private static void book() {
		sc.nextLine();
		System.out.println("Enter name: ");
		String cus_name = sc.nextLine();
		while (!isValidName(cus_name)) {
			System.out.println("Enter Proper name: ");
			cus_name = sc.nextLine();
		}

		System.out.println("Enter currency pair of USDINR");
		String currency = sc.nextLine();
		if (currency.equalsIgnoreCase("USDINR")) {
			System.out.println("");
		} else {
			do {
				System.out.print("Enter currency again and it should be USDINR only: ");
				currency = sc.nextLine();
			} while (!isValidCurrency(currency));
		}
		System.out.println("Enter Amount");
		String cus_amount = sc.nextLine();
		while (cus_amount != null) {
			if ((cus_amount.trim()).matches("[0-9]+"))
				break;
			else {
				System.out.println("Amount should be number ");
				cus_amount = sc.nextLine();
			}
		}
		double amountInt = Double.parseDouble(cus_amount);
		while (!checkAmount(amountInt)) {
			System.out.println("Amount should be greater than zero/0. Enter Proper Amount");
			cus_amount = sc.nextLine();
		}
		System.out.println("Do you want to get rate (Yes or No): ");

		String getRate = sc.nextLine();

		double rate = usdToInrRate; // Hardcoded rate

		System.out.println("You are Transfering INR " + amountInt * 66.00 + " to " + cus_name
				+ "(assuming that rate was " + rate + ")");

		System.out.println("Book / cancel this trade? yes or no");
		String choice = sc.nextLine();

		if (choice.equalsIgnoreCase("Yes")) {
			System.out.println("Trade for USDINR has been booked with rate 66.0 . The amount of Rs." + amountInt * 66.00
					+ "will be transferred in 2 working days to " + cus_name);
			trade.add(new Trades(cus_name, currency, amountInt, rate));
			display();
		} else {
			System.out.println("Trade is canceled");
		}
	}

	// method for checking validation for amount
	public static boolean checkAmount(double amount) {
		if (amount < 0) {
			return false;
		} else if (amount == 0) {
			return false;
		} else {
			return true;
		}
	}

	// method for checking validation for Currency
	private static boolean isValidCurrency(String currency) {
		if (currency.equalsIgnoreCase("USDINR")) {
			return true;
		} else {
			return false;
		}
	}

	// method for checking validation for name
	private static boolean isValidName(String cus_name) {

		if (cus_name == null) {
			return false;
		}
		for (char c : cus_name.toCharArray()) {
			if (!Character.isLetter(c) && c != ' ') {
				return false;
			}
		}

		return true;
	}

	// method to display trade
	private static void display() {

		System.out.println("TradeNo --CurrencyPair--CustomerName--Amount--Rate");
		for (Trades trades : trade) {
			System.out.println(trades);
		}
	}

	// method for exist
	private static void wantToExit() {
		System.out.println("Do you really want to exist? type yes  ");
		String confirm = sc.nextLine();

		if (confirm.equalsIgnoreCase(confirm)) {
			System.out.println("Bye -- have a good day !! ");
			System.exit(0);
		}
	}
}
