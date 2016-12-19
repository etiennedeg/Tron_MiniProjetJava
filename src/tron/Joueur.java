package tron;

import java.awt.Color;
import java.util.ArrayList;

public class Joueur {

	private String m_nom;
	private int m_record;
	private Serpent m_serpent;
	public ArrayList<Color> m_colorList;
	private int m_numero;

	public Joueur(String unNom, int unNumero){
		m_nom=unNom;
		m_numero=unNumero;
		m_record=0;
		m_colorList.add(Color.BLUE);
		m_colorList.add(Color.green);
		m_colorList.add(Color.magenta);
		m_colorList.add(Color.YELLOW);
		m_colorList.add(Color.RED);
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
		Serpent m_serpent=new Serpent(m_numero,m_colorList.get(m_numero));
		//m_serpent.setControle();;
		m_serpent.setJoueur(this);
		m_serpent.setPartie(unePartie);
	}
}