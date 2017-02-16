package RMI3;

import java.io.Serializable;

public class StockQuote implements Serializable{

	private static final long serialVersionUID = 1L;
	
	double current;
	double opening;
	double max;
	double min;
	public StockQuote(double current, double opening, double max, double min) {
		super();
		this.current = current;
		this.opening = opening;
		this.max = max;
		this.min = min;
	}
	
	

}
