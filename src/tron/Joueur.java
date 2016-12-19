package tron;

import java.awt.Color;
import java.util.ArrayList;

public class Joueur {

	private String m_nom;
	private int m_record;
	private Serpent m_serpent;
	private int m_joueurCree;
	private int m_numero;

	public Joueur(String unNom, int unNumero){
		m_nom=unNom;
		m_numero=unNumero;
		m_record=0;
	}
	public void setSerpent(Serpent uneSerpent){
		m_serpent=uneSerpent;
	}
	public Serpent getSerpent(){
		return m_serpent;
	}
	public int getJoueurCree(){
		return m_joueurCree;
	}
	public int getRecord(){
		return m_record;
	}
	public void setRecord(int uneRecord){
		m_record=uneRecord;
	}
	public void rejoindrePartie(Partie unePartie){
		int i;
		for (i=1;i<unePartie.m_nombreJoueurs;i++){
			Serpent m_serpent=new Serpent(this);
			m_joueurCree++;
		}

		//m_serpent.m_controle.;
		m_serpent.setJoueur(this);
		m_serpent.setPartie(unePartie);
	}
}
