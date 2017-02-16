package RMI2;

import java.io.Serializable;
import java.util.Date;

public class Forecast implements Serializable {
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getLowT() {
		return lowT;
	}
	public void setLowT(double lowT) {
		this.lowT = lowT;
	}
	public double getHighT() {
		return highT;
	}
	public void setHighT(double highT) {
		this.highT = highT;
	}
	public double getRainProb() {
		return rainProb;
	}
	public void setRainProb(double rainProb) {
		this.rainProb = rainProb;
	}
	private double lowT;
	private double highT;
	private double rainProb;
}
