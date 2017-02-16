package RMI3;

import java.util.HashMap;

public class StockServiceImpl implements StockInt {

	HashMap<String, StockQuote> data;
	@Override
	public StockQuote getQuote(String symbol) {
		return data.get(symbol);
	}

}
