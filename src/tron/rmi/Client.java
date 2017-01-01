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
	
	private Menu m_menu;
	private TronRMIServeur m_Serveur;
	
	public Client(TronRMIServeur unServeur) throws RemoteException{
		m_Serveur = unServeur;
		m_menu = new Menu();
		m_menu.m_tronServeur = m_Serveur;
		//m_menu.m_joueursConnectes = tronServeur.getListeJoueurs(unNumeroDePartie)
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
