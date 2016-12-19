package tron.rmi;

import java.rmi.*;



public interface TronRMIServeur extends Remote {

	public void creePartie(int nbJoueurMax, int vitesse) throws RemoteException;
}

