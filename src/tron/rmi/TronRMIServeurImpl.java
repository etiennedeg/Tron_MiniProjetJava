
package tron.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tron.*;

public class TronRMIServeurImpl extends UnicastRemoteObject implements TronRMIServeur {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Partie partie;
	
	//Create the game
	public TronRMIServeurImpl() throws RemoteException{
		super();
	}

	//Waiting players to lunch the game
	public void creePartie(int nbJoueurMax, int vitesse ) throws RemoteException{
		partie = new Partie(nbJoueurMax,vitesse);
	}
	
	//Main
	public static void main(String[] args) {
		try {
			TronRMIServeurImpl p = new TronRMIServeurImpl();
			Registry registry = LocateRegistry.createRegistry(1099);
			if (args.length > 0) registry = LocateRegistry.getRegistry(1099);
			else registry = LocateRegistry.getRegistry(1099);
			registry.rebind("Partie", p);
			System.out.println("La partie est bien enregistree");
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
	
	
}

