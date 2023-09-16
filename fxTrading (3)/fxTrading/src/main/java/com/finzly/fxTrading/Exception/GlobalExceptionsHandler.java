package com.finzly.fxTrading.Exception;

import org.springframework.stereotype.Component;

@Component
public class GlobalExceptionsHandler {

	// This exception is thrown when we are trying to add already existing ccy data
		public static void getCcyAlreadyPresentException(String message) {
			throw new CcyAlreadyPresentException(message);
		}

		// This exception is thrown when we are trying to fetch ccy data when no ccy is
		// present
		public static void getCcyListNotPresentException(String message) {
			throw new CcyListNotPresentException(message);
		}

		// This exception is thrown when we are trying to insert id which is already
		// existing or trying to delete a id which is not existing
		public static void getIdNotPresentException(String message) {
			throw new IdNotPresentException(message);
		}

		// This exception is thrown when same trade is booked twice
		public static void getTradeAlreadyPresentException(String message) {
			throw new TradeAlreadyPresentException(message);
		}

		// This exception is thrown when we try to get all trades when there no trade is
		// already available.
		public static void getTradeListNotPresentException(String message) {
			throw new TradeListNotPresentException(message);
		}
}
