package RMI2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SetupServer {
	
	public static void main(String[] args) {
		
		ForecastInt rmiInt = new ServerImpl();
		
		try {
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("forecast", rmiInt);
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
