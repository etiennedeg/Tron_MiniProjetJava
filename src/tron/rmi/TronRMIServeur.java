package tron.rmi;

import java.rmi.*;

public interface TronRMIServeur extends Remote {

	public void getInformation() throws RemoteException;
}
