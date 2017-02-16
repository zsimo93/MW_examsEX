package RMI2;

import java.rmi.Remote;

public interface ForecastInt extends Remote{

	public SForecast getForecast(String zip);
}
