package tron;

import java.awt.Color;
import java.util.ArrayList;

public class Joueur {

	public static int NOMBREJOUEURSCREES=0;

	private String m_nom;
	private int m_record;
	private Serpent m_serpent;
	private int m_numero;

	public Joueur(String unNom, int unNumero){
		NOMBREJOUEURSCREES++;
		m_nom=unNom;
		m_numero=NOMBREJOUEURSCREES;
		m_record=0;

	}
	public void setSerpent(Serpent uneSerpent){
		m_serpent=uneSerpent;
	}

	public Serpent getSerpent(){
		return m_serpent;
	}

	public int getRecord(){
		return m_record;
	}

	public void setRecord(int uneRecord){
		m_record=uneRecord;
	}
	public void rejoindrePartie(Partie unePartie){
		Serpent m_serpent=new Serpent(this,unePartie);
		this.setSerpent(m_serpent);
		m_numero=NOMBREJOUEURSCREES;
		m_serpent.setNumero(m_numero);
		m_serpent.setJoueur(this);
		m_serpent.setPartie(unePartie);
		NOMBREJOUEURSCREES++;

	public int getNumero(){
		return m_numero;
	}

	public String getNom(){
		return m_nom;
	}
}
