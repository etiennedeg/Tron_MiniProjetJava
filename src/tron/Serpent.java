package tron;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serpent {


	private static List<Color> ColorList = Arrays.asList(Color.cyan,Color.RED,Color.green,Color.orange,Color.YELLOW);
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



	public Serpent(Joueur unJoueur){
		m_numero=unJoueur.getJoueurCree();
		m_joueur=unJoueur;
	}

	public int getTeteX(){
		return m_teteX;
	}

	public int getTeteY(){
		return m_teteY;
	}

	public boolean changerTete(int x,int y){
		m_teteX=x;
		m_teteY=y;
		int[][] uneGrille=m_partie.getGrille();
		if (uneGrille[x][y]==0)
		{
			m_partie.setGrille(x,y,m_numero);
			return true;
		}else{
			return false;
		}
		m_partie.getEcran().changerTete(m_numero, x, y);
	}

	public boolean deplacerSerpent(){
			if(m_orientation==-1){              //gauch
				int x=m_teteX+m_orientation;
				int y=m_teteY;
				m_isDead=changerTete(x,y);
			}
			else if(m_orientation==-2){              //haut
				int x=m_teteX;
				int y=(int) (m_teteY+0.5*m_orientation);
				m_isDead=changerTete(x,y);
			}
			else if(m_orientation==1){              //droite
				int x=m_teteX+m_orientation;
				int y=m_teteY;
				m_isDead=changerTete(x,y);
			}
			else if(m_orientation==2){              //bas
				int x=m_teteX;
				int y=(int) (m_teteY+0.5*m_orientation);
				m_isDead=changerTete(x,y);

		}
		//changerScore();
		return m_isDead;
	}

	public void setPartie(Partie unePartie){
		m_partie=unePartie;
		unePartie.ajouterSerpent(this);
		m_couleur=ColorList.get(m_joueur.getJoueurCree());
	}

	public int getOrientation(){
		return m_orientation;
	}

	public void changerOrientation(int uneOrientation){
		if (java.lang.Math.abs(m_orientation)!=Math.abs(uneOrientation)){
			m_orientation=uneOrientation;
		}
	}

	public void setNumero(int unNumero){
		m_numero=unNumero;
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
	public void setJoueur(Joueur uneJoueur){
		m_joueur=uneJoueur;
	}
	public void setControle(ControleKEY uneControle){
		m_controle=uneControle;
	}
	/*public void changerScore(){
		if (getRes()==true){
			m_score=m_score+1;
		}
	}*/
}
