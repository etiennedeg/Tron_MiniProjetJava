package tron;

import java.awt.Color;
import tron.ihm.Menu;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import tron.rmi.TronRMIServeur;
import tron.rmi.TronRMIServeurImpl;


/**
 * Pour definir un joueur
 * @author 
 * 
 */
public class Joueur implements Serializable{

	public static int NOMBREJOUEURSCREES = 0;

	private TronRMIServeur m_objetDistant; 
	private String m_nom;
	private int m_record;
	private Serpent m_serpent;
	private int m_numero;
	
	/**
	 * Le constructeur de joueur
	 * @param unNom   le nom du joueur
	 */
	public Joueur(String unNom){
		m_nom = unNom;
		m_record = 0;
		NOMBREJOUEURSCREES++;
		m_numero = NOMBREJOUEURSCREES;
		try {
			m_objetDistant =(TronRMIServeur)LocateRegistry.getRegistry(1099).lookup("Partie");
		/*} catch (MalformedURLException e) {
			e.printStackTrace();*/
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Associer un serpent a un joueur
	 * @param uneSerpent
	 */
	public void setSerpent(Serpent uneSerpent){
		m_serpent=uneSerpent;
	}

	/**
	 * Get le serpent
	 * @return le serpent associe au joueur
	 */
	public Serpent getSerpent(){
		return m_serpent;
	}

	/**
	 * Obtenir le record
	 * @return le record 
	 */
	public int getRecord(){
		return m_record;
	}

	/**
	 * Changer le record d'un joueur
	 * @param uneRecord
	 */
	public void setRecord(int uneRecord){
		m_record=uneRecord;
	}
	
	/**
	 * Pour acceder a une partie antecedent, on cree un nouvel serpent
	 * et l'associe au joueur et la partie.
	 * @param unePartie la partie antecedent selectionne
	 */
	public void rejoindrePartie(Partie unePartie){
		Serpent m_serpent=new Serpent(this,unePartie);
		this.setSerpent(m_serpent);
	}

	/**
	 * Obtenir le numero du serpent associe au joueur
	 * @return le numero du serpent
	 */
	public int getNumero(){
		return m_numero;
	}

	/**
	 * Obtenir le nom du joueur
	 * @return le nom du joueur
	 */
	public String getNom(){
		return m_nom;
	}
	
	public TronRMIServeur getObjetDistant()throws RemoteException{
		return m_objetDistant;
	}

	public void setObjetDistant(TronRMIServeur unServeur) throws RemoteException{
		m_objetDistant = unServeur;
	}

}