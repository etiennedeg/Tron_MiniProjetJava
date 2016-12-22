package tron;

import java.awt.Color;
import java.util.ArrayList;

public class Joueur {

	public static int NOMBREJOUEURSCREES = 0;

	private String m_nom;
	private int m_record;
	private Serpent m_serpent;
	private int m_numero;

	public Joueur(String unNom){
		m_nom = unNom;
		m_record = 0;
		NOMBREJOUEURSCREES++;
		m_numero = NOMBREJOUEURSCREES;
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

	public int getNumero(){
		return m_numero;
	}

	public String getNom(){
		return m_nom;
	}

	public void rejoindrePartie(Partie unePartie){
		Serpent m_serpent = new Serpent(this, unePartie);
		setSerpent(m_serpent);
	}
}
