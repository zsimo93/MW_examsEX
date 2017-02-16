package RMI3;

import java.rmi.Remote;

public interface StockInt extends Remote {

	public StockQuote getQuote(String symbol);
}
