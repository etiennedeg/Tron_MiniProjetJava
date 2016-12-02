import java.util.ArrayList;


public class Partie {

	public static final int TAILLE_X = 50;
	public static final int TAILLE_Y = 20;
	private int m_nombresDeManches;
	private PartieThread m_partieThread;
	private int[] m_scores;
	private int[][] m_grille;
	private int[] m_serpents;
	private int m_vitesse;
	private Joueur[] m_joueurs;
	private int m_nombreJoueurs;
	private boolean m_isPartieEnCours;  //true si la partie est déjà lancée
	private Ecran m_ecran;

	public Partie(int uneVitesse)
	{
		m_nombresDeManches = 0;
		m_partieThread = new PartieThread(this);
		for(int i = 0; i < TAILLE_X; ++i)
		{
			for(int j = 0; j < TAILLE_Y; ++j)
			{
				m_grille[i][j] = 0;
			}
		}
		m_isPartieEnCours = false;
		m_vitesse = uneVitesse;
		m_nombresJoueurs = 0;
	}

	public void lancerPartie()
	{

	}

	public void stopperPartie(){

	}

	public void stopperPartie(Joueur unJoueur){

	}

	public void jouerPartie()
	{

	}

	private void designerGagnant(){

	}

	private void detruireJoueurs(){

	}

	private Boolean deplacerSerpent(){

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
}
