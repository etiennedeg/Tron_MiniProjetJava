package tron;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serpent {

	/**Pour definir un Serpent, et d��placer le serpent.
	 * @author 
	*/
	 
	private static List<Color> ColorList = Arrays.asList(Color.red,Color.blue,Color.green,Color.orange);
	private Color m_couleur;
	private int m_numero;
	private int m_orientation=0;
	private int m_teteX=0;
	private int m_score=0;
	private int m_teteY=0;
	private boolean m_isDead=false;
	private Joueur m_joueur;
	private Partie m_partie;
	private ControleKEY m_controle;


	/**
	 * Creer un Serpent liee a un joueur et une partie.
	 * @param unJoueur
	 * @param unePartie
	 */
	public Serpent(Joueur unJoueur, Partie unePartie){
		m_joueur=unJoueur;
		setPartie(unePartie);
		//m_numero=m_partie.getNombresJoueurs();
		m_numero = unJoueur.getNumero();
		m_couleur=ColorList.get(m_numero-1);
		m_controle = new ControleKEY(this);
		m_partie.getEcran().addKeyListener(m_controle);
	}

	public int getTeteX(){
		return m_teteX;
	}

	public int getTeteY(){
		return m_teteY;
	}

	/**
	 * Pour changer la position de la tete du serpent
	 * @param x :L'abscisse de la tete du serpent.
	 * @param y :L'ordonnee de la tete du serpent.
	 */
	public boolean changerTete(int x,int y){
		System.out.println(x);
		System.out.println(y);
		m_teteX = x;
		m_teteY = y;
		if ( (x < 0) || (x > Partie.TAILLE_X - 1) || (y < 0) || (y > Partie.TAILLE_Y - 1) ){
			return false;
		}
		if (m_partie.getGrille(x,y) == 0)
		{
			m_partie.setGrille(x,y,m_numero);
			//m_partie.getEcran().editerBuff(m_numero, x, y);
			return true;
		}
		else{
			return false;
		}

	}

	/**
	 * Deplacer le serpent (si possible) par changer sa tete.
	 * @return true si on peut deplacer le serpent (c'est pas mort);
	 * false sinon
	 */
	public boolean deplacerSerpent(){
		if(Math.abs(m_orientation) == 1 ){              //deplacement selon x
			int x = m_teteX + m_orientation;
			int y = m_teteY;
			m_isDead = !changerTete(x,y);
		}
		else if(Math.abs(m_orientation) == 2){              //deplacement selon y
			int x = m_teteX;
			int y = (int) (m_teteY + 0.5 * m_orientation);
			m_isDead = !changerTete(x,y);
		}
		return !m_isDead;
	}

	/**Setters et getters
	 */
	public void setPartie(Partie unePartie){
		m_partie=unePartie;
		unePartie.ajouterSerpent(this);
		//m_couleur=ColorList.get(m_joueur.getNumero());
	}

	public int getOrientation(){
		return m_orientation;
	}

	public void changerOrientation(int uneOrientation){
		if (java.lang.Math.abs(m_orientation)!=Math.abs(uneOrientation)){
			m_orientation=uneOrientation;
		}
	}


	public boolean getRes(){
		return m_isDead;
	}

	public Color getCouleur(){
		return m_couleur;
	}

	public void setCouleur(Color uneCouleur){
		m_couleur=uneCouleur;
	}

	public Joueur getJoueur(){
		return m_joueur;
	}

	public void setControle(ControleKEY uneControle){
		m_controle=uneControle;
	}
	
	public void setNumero(int unNumero){
		m_numero=unNumero;
	}
	/*public void changerScore(){
		if (getRes()==true){
			m_score=m_score+1;
		}
	}*/

	public void setJoueur(Joueur unJoueur) {
		m_joueur=unJoueur;
	}
}
