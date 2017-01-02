package tron.rmi;

import java.rmi.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import tron.Joueur;
import tron.Partie;


public interface TronRMIServeur extends Remote {

	public DefaultListModel<String> getListeJoueurs(int unNumeroDePartie)throws RemoteException;
	public DefaultListModel<String> getListeParties()throws RemoteException;
	public void ajouterPartie(Partie unePartie, Joueur unCreateur)throws RemoteException;
	public void ajouterJoueur(int unNumeroDePartie, Joueur unJoueur)throws RemoteException;
	public void creePartie(int nbJoueurMax, int vitesse) throws RemoteException;
	public ArrayList<Partie> getM_listeDeParties()throws RemoteException;
}

