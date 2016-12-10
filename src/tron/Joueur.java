package tron;

public class Joueur {

	private String m_nom;
	private int m_record;
	private Serpent m_serpent;
	

	public Joueur(String unNom){
		m_nom=unNom;
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
		m_serpent.setPartie(unePartie);
	}
}