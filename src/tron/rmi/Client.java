package tron.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import javax.swing.JOptionPane;

import tron.*;
import tron.ihm.Menu;

//Permet a un utilisateur humain de passer des ordres par le réseau
public class Client {
	
/* 	private Joueur joueur;
	
	private TronRMIServeur tronServeur;

		public Client(Joueur j, TronRMIServeur t) {
			joueur = j;
			tronServeur = t;
		}*/
	private Menu m_menu;
	private TronRMIServeur tronServeur;
	
	public Client(TronRMIServeur unServeur) throws RemoteException{
		tronServeur = unServeur;
		m_menu = new Menu();
	}

		public static void main(String[] args) {			
			TronRMIServeur t;
			try {
				if (args.length == 0) t = (TronRMIServeur)LocateRegistry.getRegistry(1099).lookup("Partie");
				else t = (TronRMIServeur)LocateRegistry.getRegistry(1099).lookup("Partie");
				
				Client client = new Client(t);
				
			} catch (RemoteException ex) {
				ex.printStackTrace();
			} catch (NotBoundException ex) {
				ex.printStackTrace();
			}
		}
	
	

}
