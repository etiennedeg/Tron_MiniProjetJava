import java.util.ArrayList;


public class Partie {

	public static final int TAILLE_X = 50;
	public static final int TAILLE_Y = 20;
	private int m_nombresDeManches;
	private int[] m_scores;
	private int[][] m_grille;
	private int[] m_serpents;
	//private Joueur[] m_joueurs;
	private boolean m_isPartieEnCours;  //true si la partie est déjà lancée
	//private Ecran m_ecran;

	public Partie()
	{
		m_nombresDeManches = 0;
		for(int i = 0; i < TAILLE_X; ++i)
		{
			for(int j = 0; j < TAILLE_Y; ++j)
			{
				m_grille[i][j] = 0;
			}
		}
		m_isPartieEnCours = false;
	}


}
