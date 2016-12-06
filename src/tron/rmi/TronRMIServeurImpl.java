package tron.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import insar.gm.marketTP.rmi.MarcheRMIServeurImpl;
import tron.Partie;

public class TronRMIServeurImpl extends UnicastRemoteObject implements TronRMIServeur {
	
	private Partie partie;
	
	//Create the game
	public TronRMIServeurImpl() throws RemoteException{
		super();
		partie = new Partie();
	}

	//Add a player to the game
	public void rejoindrePartie() throws RemoteException {
		
	}
	
	//Main
	public static void main(String[] args) {
		try {
			TronRMIServeurImpl p = new TronRMIServeurImpl();
			Registry registry;
			if (args.length > 0) registry = LocateRegistry.getRegistry(args[0]);
			else registry = LocateRegistry.getRegistry();
			registry.rebind("Partie", p);
			System.out.println("La partie est bien enregistree");
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}
	
	
}
