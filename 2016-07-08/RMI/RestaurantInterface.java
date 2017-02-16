package RMI1;

import java.util.Date;

public interface RestaurantInterface {
	
	boolean makeReservation(Date date, String name, int numPeople);

}
