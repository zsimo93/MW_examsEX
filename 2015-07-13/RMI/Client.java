package RMI2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry();
		
		ForecastInt inter = (ForecastInt)registry.lookup("forecast");
		
		inter.getForecast("21052");
		
	}

}
