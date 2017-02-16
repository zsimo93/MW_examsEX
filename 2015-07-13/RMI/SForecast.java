package RMI2;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class SForecast implements Serializable{
	
	private HashMap<Date, Forecast> data;

	public HashMap<Date, Forecast> getData() {
		return data;
	}

	public void setData(HashMap<Date, Forecast> data) {
		this.data = data;
	}
	
}
