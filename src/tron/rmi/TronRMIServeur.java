package tron.rmi;

import java.rmi.*;

import javax.swing.DefaultListModel;

import tron.Joueur;
import tron.Partie;


public interface TronRMIServeur extends Remote {

	public DefaultListModel<String> getListeJoueurs(int unNumeroDePartie);
	public DefaultListModel<String> getListeParties();
	public void ajouterPartie(Partie unePartie, Joueur unCreateur);
	public void ajouterJoueur(int unNumeroDePartie, Joueur unJoueur);
	public void creePartie(int nbJoueurMax, int vitesse) throws RemoteException;
}

