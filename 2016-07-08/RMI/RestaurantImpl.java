package RMI1;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class RestaurantImpl implements RestaurantInterface {

	HashMap<Date, Evening> reservations;
	
	@Override
	public boolean makeReservation(Date date, String name, int numPeople) {
		Evening ev = reservations.get(date);
		List<String> tables = ev.getTables();
		
		if(numPeople<=ev.getRemSeats()){
			int toAlloc = numPeople;
			for(int i=0; i<20 && toAlloc > 0; i++){
				if (tables.get(i) == null && toAlloc>0){
					tables.add(i, name);
					toAlloc = toAlloc-2;
					ev.decrRem();
				}
			}
			return true;
		}
		return false;
	}

}
