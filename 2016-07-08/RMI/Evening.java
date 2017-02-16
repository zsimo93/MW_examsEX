package RMI1;

import java.util.Date;
import java.util.List;

public class Evening {

	private Date date;
	private List<String> tables;
	private int remSeats;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<String> getTables() {
		return tables;
	}
	public void setTables(List<String> tables) {
		this.tables = tables;
	}
	public int getRemSeats() {
		return remSeats;
	}
	public void decrRem() {
		this.remSeats = remSeats-2;
	}
	
	
	
	
}
