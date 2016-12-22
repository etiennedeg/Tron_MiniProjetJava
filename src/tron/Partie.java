package tron;

import java.awt.Color;
import java.util.ArrayList;


public class Partie {

	public static final int TAILLE_X = 104;
	public static final int TAILLE_Y = 80;

	private int m_nombresDeManches;
	private Joueur m_createur;
	private PartieThread m_partieThread;
	private ArrayList<Integer> m_scores;
	private int[][] m_grille;
	private ArrayList<Serpent> m_serpents;
	private int m_vitesse;
	private int m_nombreJoueurs;
	private int m_nombreMaxJoueurs;
	private boolean m_isPartieEnCours;  //true si la partie est deja lancee
	private Ecran m_ecran;

	public Partie(int unNombreMaxJoueurs, int uneVitesse, Joueur unCreateur){
		m_nombresDeManches = 0;
		m_ecran = new Ecran(this);
		m_partieThread = new PartieThread(this);
		m_grille = new int[TAILLE_X][TAILLE_Y];
		reinitialiserGrille();
		m_isPartieEnCours = false;
		m_vitesse = uneVitesse;
		m_createur = unCreateur;
		m_nombreJoueurs = 0;
		m_nombreMaxJoueurs = unNombreMaxJoueurs; // exception a creer
		m_serpents = new ArrayList<Serpent>();
	}

	public void lancerPartie(){
		/*if (m_nombreJoueurs <=1){
			throw NombreJoueurInsuffisant; // exception a creer
		}*/
		//else{
			m_isPartieEnCours = true;
			switch (m_nombreJoueurs){
				case 2:
					m_serpents.get(0).changerTete( (int) TAILLE_X / 6, (int) TAILLE_Y / 2);
					m_serpents.get(0).changerOrientation(1);
					m_serpents.get(1).changerTete( (int) 5 * TAILLE_X / 6 + 1, (int) TAILLE_Y / 2);
					m_serpents.get(1).changerOrientation(-1);
					break;
				case 3:
					m_serpents.get(0).changerTete( (int) TAILLE_X / 2, (int) TAILLE_Y / 3);
					m_serpents.get(0).changerOrientation(2);
					m_serpents.get(1).changerTete( (int) TAILLE_X / 6, (int) 2 * TAILLE_Y / 3 + 1);
					m_serpents.get(1).changerOrientation(1);
					m_serpents.get(2).changerTete( (int) 5 * TAILLE_X / 6 + 1, (int) 2 * TAILLE_Y / 3);
					m_serpents.get(2).changerOrientation(-1);
					break;
				case 4:
					m_serpents.get(0).changerTete( (int) TAILLE_X / 3, (int) TAILLE_Y / 3);
					m_serpents.get(0).changerOrientation(1);
					m_serpents.get(1).changerTete( (int) TAILLE_X / 3, (int) 2 * TAILLE_Y / 3 + 1);
					m_serpents.get(1).changerOrientation(1);
					m_serpents.get(2).changerTete( (int) 2 * TAILLE_X / 3 + 1, (int)  TAILLE_Y / 3);
					m_serpents.get(2).changerOrientation(-1);
					m_serpents.get(3).changerTete( (int) 2 * TAILLE_X / 3 + 1, 2 * (int)  TAILLE_Y / 3);
					m_serpents.get(3).changerOrientation(-1);
					break;

			}

			jouerPartie();
		//}
	}

	public void stopperPartie(){
		reinitialiserGrille();

		m_isPartieEnCours = false;
	}

	public synchronized void jouerPartie(){
		while (m_isPartieEnCours){
			try {
				m_partieThread.run();
				Thread.sleep( m_vitesse );
			} catch (InterruptedException e){
				e.printStackTrace();
			}

		}
		System.out.println("finish");
	}

	public void designerGagnants(){

		stopperPartie();
	}


	public boolean deplacerSerpents(){
		boolean isDeplacementPossible = true;
		for (int i = 0; i < m_nombreJoueurs; ++i ){
			if ( !m_serpents.get(i).deplacerSerpent() ){
				isDeplacementPossible  = false;
			}
		}
		return isDeplacementPossible;

	}

	private void reinitialiserGrille(){
		for (int i = 1; i < TAILLE_X - 1; ++i ){
			for (int j = 1; j < TAILLE_Y - 1; ++j ){
				m_grille[i][j] = 0;
			}
		}

		for (int i = 0; i < TAILLE_X; ++i){
			m_grille[i][0] = -1;
			m_grille[i][TAILLE_Y-1] = -1;
		}

		for (int j = 1; j < TAILLE_Y - 1; ++j){
			m_grille[0][j] = -1;
			m_grille[TAILLE_X-1][j] = -1;
		}

	}

	// getters et setters

	public boolean isPartieEnCours(){
		return m_isPartieEnCours;
	}

	public int getVitesse(){

		return m_vitesse;
	}

	public int getNombresJoueurs(){
		return m_nombreJoueurs;
	}

	public int[][] getGrille(){
		return m_grille;
	}

	public int getGrille(int X, int Y){
		return m_grille[X][Y];
	}

	public void setGrille(int X, int Y, int uneValeur){
		m_grille[X][Y] = uneValeur;
	}

	public Ecran getEcran(){
		return m_ecran;
	}

	void ajouterSerpent(Serpent unSerpent){
		m_serpents.add(unSerpent);
		m_nombreJoueurs += 1;
	}
	public Serpent getSerpent(int i){
		return m_serpents.get(i);
	}


	public static void main (String[] args){
		Joueur joueur1 = new Joueur("Bernard");
		Joueur joueur2 = new Joueur("Jean-Guy");
		Partie partie = new Partie(2,100, joueur1);
		joueur1.rejoindrePartie(partie);
		joueur2.rejoindrePartie(partie);
		partie.m_ecran.setVisible(true);
		partie.lancerPartie();

	}
}


