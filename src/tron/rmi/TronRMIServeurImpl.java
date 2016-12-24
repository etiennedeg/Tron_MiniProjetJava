
package tron.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import tron.*;

public class TronRMIServeurImpl extends UnicastRemoteObject implements TronRMIServeur {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Partie m_partie;
	ArrayList<Partie> m_listeDeParties;
	ArrayList<ArrayList<Joueur>> m_listeDeJoueurs;
	
	//Create the game
	public TronRMIServeurImpl() throws RemoteException{
		super();
		m_listeDeParties = new ArrayList<Partie>();
		m_listeDeJoueurs = new ArrayList<ArrayList<Joueur>>();
	}

	
	public DefaultListModel<String> getListeJoueurs(int unNumeroDePartie){
		DefaultListModel<String> modele = new DefaultListModel<String>();
		for (int i=0; i<m_listeDeJoueurs.get(unNumeroDePartie).size(); ++i){
			modele.addElement(m_listeDeJoueurs.get(unNumeroDePartie).get(i).getNom());
		}
		return modele;
	}
	
	public DefaultListModel<String> getListeParties(){
		DefaultListModel<String> modele = new DefaultListModel<String>();
		for (int i=0; i<m_listeDeParties.size(); ++i){
			modele.addElement(m_listeDeParties.get(i).getCreateur().getNom());
		}
		return modele;
	}
	
	public void ajouterPartie(Partie unePartie, Joueur unCreateur){
		m_listeDeParties.add(unePartie);
		m_listeDeJoueurs.add(new ArrayList<Joueur>());
		m_listeDeJoueurs.get(m_listeDeJoueurs.size()-1).add(unCreateur);
	}

	public void ajouterJoueur(int unNumeroDePartie, Joueur unJoueur){
		m_listeDeJoueurs.get(unNumeroDePartie).add(unJoueur);
		for (int i=0; i<m_listeDeJoueurs.get(unNumeroDePartie).size(); ++i){
			//repaintEcran
		}
	}


	//ecrire quitter Partie et finir le menu
	
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

