package tron;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import org.omg.CORBA.SystemException;

import tron.ihm.Ecran;

/**
 * La classe poue definir une partie, contenant le damier ,les joueur, les serpents, et tous les autres parametres d'une partie
 *(score, les tetes des serpents, la vitesse) 
 * @author Etienne
 *
 */
public class Partie implements Serializable{

	public static final int TAILLE_X = 104;
	public static final int TAILLE_Y = 80;
	
	public static int NBPARTIESCREES = 0;
	private int m_numero;
	private int m_nombresDeManches;
	private Joueur m_createur;
	private PartieThread m_partieThread;
	private ArrayList<Integer> m_scores;
	private int[][] m_grille;
	private ArrayList<Serpent> m_serpents = new ArrayList<Serpent>();
	private int m_vitesse;
	private int m_nombreJoueurs = 0;
	private int m_nombreMaxJoueurs;
	private boolean m_isPartieEnCours;  //true si la partie est deja lancee
	private Ecran m_ecran;

	/**
	 * Le constructeur pour initialiser une partie
	 * @param unNombreMaxJoueurs 
	 * @param uneVitesse La vitesse de deplacement des serpents
	 * @param unCreateur Le createur du jeu 
	 */
	public Partie(int unNombreMaxJoueurs, int uneVitesse, Joueur unCreateur){
		m_numero = NBPARTIESCREES;
		NBPARTIESCREES++;
		m_nombresDeManches = 0;
		m_ecran = new Ecran(this);
		//new Ecran(this);
		m_partieThread = new PartieThread(this);
		m_grille = new int[TAILLE_X][TAILLE_Y];
		reinitialiserGrille();
		m_isPartieEnCours = false;
		m_vitesse = uneVitesse;
		m_createur = unCreateur;
		m_nombreJoueurs = 0;
		m_nombreMaxJoueurs = unNombreMaxJoueurs; // exception a creer
	}

	/**
	 * Pour commencer une partie, initialiser les tetes des serpents
	 */
	public void lancerPartie(){
		/*if (m_nombreJoueurs <=1){
			throw NombreJoueurInsuffisant; // exception a creer
		}*/
		//else{
			m_isPartieEnCours = true;
			switch (m_nombreJoueurs){
				case 1:
					m_serpents.get(0).changerTete( (int) TAILLE_X / 6, (int) TAILLE_Y / 2);
					m_serpents.get(0).changerOrientation(1);
					break;
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
				//default :System.exit(0);

			}
			m_ecran.setVisible(true);
			jouerPartie();
		//}
	}

	/**
	 * Reinitialiser les grille quand le jeu est termine
	 */
	public void stopperPartie(){
		reinitialiserGrille();

		m_isPartieEnCours = false;
	}

	/**
	 * 
	 */
	public void jouerPartie(){
		/*while (m_isPartieEnCours){
			try {
				m_partieThread.run();
				Thread.sleep( m_vitesse );
			} catch (InterruptedException e){
				e.printStackTrace();
			}

		}*/
		m_partieThread.start();
		System.out.println("finish");
	}

	
	public void designerGagnants(){

		stopperPartie();
	}


	/**
	 * Verifier si on peut deplacer le serpent par la methode deplacerSerpent dans la classe Serpent
	 * @return est-ce qu'il est possible de deplacer le serpent
	 */
	public boolean deplacerSerpents(){
		boolean isDeplacementPossible = true;
		for (int i = 0; i < m_nombreJoueurs; ++i ){
			if ( !m_serpents.get(i).deplacerSerpent() ){
				isDeplacementPossible  = false;
			}
		}
		return isDeplacementPossible;

	}

	/**
	 * Methode pour reinitialiser les grilles quand le jeu est termine
	 */
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

	/**
	 * Obtenir le numero de la partie
	 * @return le numero de la partie
	 */
	public int getm_numero(){
		return m_numero;
	}

	/**
	 * Verifier si une partie est en cours
	 * @return est-ce que une partie est en cours
	 */
	public boolean isPartieEnCours(){
		return m_isPartieEnCours;
	}

	/**
	 * Set le createur
	 * @param uncreateur
	 */
	public void setm_createur(Joueur uncreateur){
		m_createur = uncreateur;
	}
	
	/**
	 * Obtenir la vitesse
	 * @return la vitesse
	 */
	public int getVitesse(){
		return m_vitesse;
	}

	/**
	 * Obtenir le nombre de joueur
	 * @return le nombre de joueur
	 */
	public int getNombresJoueurs(){
		return m_nombreJoueurs;
	}

	/**
	 * Obtenir la grille
	 * @return la grille
	 */
	public int[][] getGrille(){
		return m_grille;
	}

	/**
	 * Obtenir le nombre d'un grille
	 * @param X L'abscisse de la grille
	 * @param Y l'ordonnee de la grille
	 * @return le nombre dans la grille
	 */
	public int getGrille(int X, int Y){
		return m_grille[X][Y];
	}

	/**
	 * Set le nombre d'un grille
	 * @param X L'abscisse de la grille
	 * @param Y l'ordonnee de la grille
	 * @param uneValeur
	 */
	public void setGrille(int X, int Y, int uneValeur){
		m_grille[X][Y] = uneValeur;
	}

	/**
	 * 
	 * @return l'ecran
	 */
	public Ecran getEcran(){
		return m_ecran;
	}

	/**
	 * Ajouter un serpent dans la partie
	 * @param unSerpent le nouveau serpent
	 */
	void ajouterSerpent(Serpent unSerpent){
		m_serpents.add(unSerpent);
		m_nombreJoueurs++;
	}

	/**
	 * Obtenir un serpent
	 * @param i le nombre du serpent
	 * @return le serpent
	 */
	public Serpent getSerpent(int i){
		return m_serpents.get(i-1);
	}

	/**
	 * Obtenir le createur
	 * @return le createur
	 */
	public Joueur getCreateur(){
		return m_createur;
	}

	/**
	 * La methode main
	 * @param args
	 */
	public static void main (String[] args){
		Joueur joueur1 = new Joueur("Bernard");
		Partie partie = new Partie(2,100, joueur1);
		joueur1.rejoindrePartie(partie);
		//Joueur joueur2 = new Joueur("Jean-Guy");
		//joueur2.rejoindrePartie(partie);
		//partie.m_ecran.setVisible(true);
		partie.lancerPartie(); 

	}
}


