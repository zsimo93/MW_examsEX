package RMI2;

import java.util.HashMap;

public class ServerImpl implements ForecastInt {

	HashMap<String, SForecast> f;
	
	@Override
	public SForecast getForecast(String zip) {
		return f.get(zip);
	}

}
