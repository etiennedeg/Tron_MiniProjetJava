package tron.rmi;

import java.rmi.*;

public interface TronRMIServeur extends Remote {

	public void rejoindrePartie() throws RemoteException;
}
