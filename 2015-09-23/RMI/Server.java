package RMI3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1010);
			
			StockServiceImpl data = new StockServiceImpl();
			
			reg.rebind("stockint", data );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
