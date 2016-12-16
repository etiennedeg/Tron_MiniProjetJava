package tron.rmi;

import java.rmi.*;

public interface TronRMIServeur extends Remote {

	public void lancerPartie(Integer nbjoueurs, Integer vitesse) throws RemoteException;
}

