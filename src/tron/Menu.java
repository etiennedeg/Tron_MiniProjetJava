package tron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Menu du jeu
 * 
 * @author JIANG Shangwei , MACE DE GASTINES Etienne
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public class Menu extends JFrame{

	/**
	 * Le panel principal du menu 
	 */
	private JPanel m_panelStart;
	
	/**
	 * Contrôle de boutons
	 */
	private Controle m_controle;
	
	/**
	 * Le joueur actif 
	 */
	private Joueur m_joueur;
	
	/**
	 * L'objet contenant les informations d'une partie du jeu
	 */
	private Partie m_partie;
	
	/**
	 * Une liste des joueurs qui ont connecté au jeu   
	 */
	private DefaultListModel<String> m_joueursConnectes;
	
	/**
	 * Une liste pour afficher les joueurs connectés 
	 */
	private JList<String> m_listeJoueurs;
	
	/**
	 * Une liste de nom de partie créé  
	 */
	private DefaultListModel<String> m_nomsPartiesCrees;
	
	/**
	 * Une liste de parties créés
	 */
	private ArrayList<Partie> m_partiesCrees;
	
	/**
	 * Une liste pour afficher les parties créés 
	 */
	private JList<String> m_listeParties;
	
	/**
	 * Un bouton pour lancer une partie du jeu  
	 */
	private JButton m_buttonStart;
	
	/**
	 * Un bouton pour créer une partie du jeu  
	 */
	private JButton m_boutonCreerPartie;
	
	/**
	 * Un bouton pour rejoindre une partie du jeu  
	 */
	private JButton m_boutonRejoindrePartie;

	/**
	 * Constructeur
	 */

	public Menu(){
		super("Tron");
		
		/** créer le joueur actif  */		
		m_joueur = new Joueur(JOptionPane.showInputDialog("Nom du joueur"));
		
		m_controle = new Controle(this, m_joueur);

		/** construction d'image du fond  */
		ImageIcon imgBack = new ImageIcon("serpent.png");
		JLabel backGround = new JLabel(imgBack);
		backGround.setBounds(0,0, imgBack.getIconWidth(), imgBack.getIconHeight());
		getLayeredPane().add(backGround , new Integer(Integer.MIN_VALUE));

		/** Construction du panel principal */
		m_panelStart = new JPanel();
		m_panelStart.setLayout(null);
		m_panelStart.setOpaque(false);
		setContentPane(m_panelStart);

		/** Configuration de l'ecran */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(imgBack.getIconWidth(), imgBack.getIconHeight());
		setVisible(true);

		afficherListePartie();
	}

	
	/**
	 * affichage de la liste de partie et affichage des boutons associes
	 */
	void afficherListePartie(){
		
		//affichage de la liste de partie
		m_nomsPartiesCrees = new DefaultListModel<String>();
		m_partiesCrees = new ArrayList<Partie>();
		m_listeParties = new JList<String>();
		m_listeParties.setModel(m_nomsPartiesCrees);
		//m_listeParties.setSize(210,210);
		//m_listeParties.setLocation(30,450);
		m_panelStart.add(m_listeParties);

		//affichage des boutons associes
		m_boutonCreerPartie = new JButton("Creer une nouvelle partie");
		m_boutonCreerPartie.setLocation(400,500);
		m_boutonCreerPartie.setSize(300,30);
		m_panelStart.add(m_boutonCreerPartie);
		m_boutonCreerPartie.addActionListener(m_controle);


		m_boutonRejoindrePartie = new JButton("Rejoindre une partie");
		m_boutonRejoindrePartie.setSize(300,30);
		m_boutonRejoindrePartie.setLocation(400,580);
		m_panelStart.add(m_boutonRejoindrePartie);
		m_boutonRejoindrePartie.addActionListener(m_controle);

		// chercher les parties cr�es dans le serveur
		
		repaint();
	}

	
	/**
	 * affichage de la liste des joueurs
	 */
	void afficherListeJoueur(){
		//affichage de la liste des joueurs
		m_joueursConnectes = new DefaultListModel<String>();
		m_listeJoueurs = new JList<String>();
		m_listeJoueurs.setModel(m_joueursConnectes);
		m_listeJoueurs.setSize(210,210);
		m_listeJoueurs.setLocation(30,450);

		m_joueursConnectes.addElement(m_joueur.getNom()); //a la place, l'ajouter au serveur
		
		m_panelStart.remove(m_listeParties);
		m_panelStart.remove(m_boutonCreerPartie);
		m_panelStart.remove(m_boutonRejoindrePartie);
		m_panelStart.add(m_listeJoueurs);

		repaint();

	}

	
	/**
	 * affichage du bouton "start"
	 */
	void afficherBoutonStart(){
		m_buttonStart = new JButton();
		m_buttonStart.setIcon(new ImageIcon("start.png"));
		m_buttonStart.setSize(210,210);
		m_buttonStart.setLocation(410,410);
		m_buttonStart.setOpaque(false);
		m_buttonStart.setContentAreaFilled(false);
		m_panelStart.add(m_buttonStart);
		m_buttonStart.addActionListener(m_controle);
	}

	/**
	 * créer une nouvelle partie 
	 */
	public void creerNouvellePartie(){
		int nombreJoueursMax = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs ? (2-4)"));
		String[] choixVitesse = {"lent" , "modere", "rapide"};
		int vitesse = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,  choixVitesse, choixVitesse[1]);
		m_partie = new Partie(nombreJoueursMax, vitesse*5000, m_joueur); //ajout Partie au serveur
		
		afficherListeJoueur();
		afficherBoutonStart();
	}

	/**
	 * rejoindre une partie 
	 */
	public void rejoindrePartie(){
		m_partie = m_partiesCrees.get( m_listeParties.getAnchorSelectionIndex() );
		afficherListeJoueur();
	}
	
	public void lancerPartie(){
		
	}

	public static void main (String[] args){
		Menu menu = new Menu();
		menu.setVisible(true);
	}

	
	/**
	 * classe privee pour reagir aux boutons
	 * 
	 * @author MACE DE GASTINES Etienne
	 * @version 1.0
	 * @since 1.0
	 */
	private class Controle implements ActionListener{

		private Menu m_menu;
		private Joueur m_joueur;

		public Controle(Menu unMenu, Joueur unJoueur){
			m_menu = unMenu;
			m_joueur = unJoueur;
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getActionCommand() == "Creer une nouvelle partie"){
				creerNouvellePartie();
			}

			else if (e.getActionCommand() == "Rejoindre une partie"){
				rejoindrePartie(); // gerer exception si aucune partie selectionée ou si partie remplie
			}
			
			else {
				lancerPartie();
			}
		}

	}

}

