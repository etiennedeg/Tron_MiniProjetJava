package tron.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tron.Joueur;
import tron.Partie;
import tron.rmi.TronRMIServeur;
import tron.rmi.TronRMIServeurImpl;

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
	 * Controle de boutons
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
	 * Une liste des joueurs qui sont connecte au jeu   
	 */
	public DefaultListModel<String> m_joueursConnectes;
	
	/**
	 * Une liste pour afficher les joueurs connectés 
	 */
	private JList<String> m_listeJoueurs;
	
	/**
	 * Une liste de nom de partie creees  
	 */
	private DefaultListModel<String> m_nomsPartiesCrees;
	
	/**
	 * Une liste de parties creees
	 */
	private static ArrayList<Partie> m_partiesCrees;
	
	/**
	 * Une liste pour afficher les parties creees 
	 */
	private JList<String> m_listeParties;
	
	/**
	 * Un bouton pour lancer une partie du jeu  
	 */
	private JButton m_buttonStart;
	
	/**
	 * Un bouton pour creer une partie du jeu  
	 */
	private JButton m_boutonCreerPartie;
	
	/**
	 * Un bouton pour rejoindre une partie du jeu  
	 */
	private JButton m_boutonRejoindrePartie;
	
	/**
	 * Un bouton pour terminer une partie du jeu  
	 */
	private JButton m_boutonTerminerPartie;
	
	/**
	 * Un bouton pour quitter du jeu  
	 */
	private JButton m_boutonQuitterPartie;
	
	public TronRMIServeur m_tronServeur;

	/**
	 * Constructeur
	 * @throws RemoteException 
	 */

	public Menu() throws RemoteException{
		super("Tron");
		
		/** creer le joueur actif  */		
		m_joueur = new Joueur(JOptionPane.showInputDialog("Nom du joueur"));
		
		m_controle = new Controle(this, m_joueur);

		/** construction d'image du fond  */
		ImageIcon imgBack = new ImageIcon("data/serpent.png");
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
	 * @throws RemoteException 
	 */
	void afficherListePartie() throws RemoteException{
		m_panelStart.removeAll();
		
		//affichage de la liste de partie
		m_nomsPartiesCrees = m_joueur.getObjetDistant().getListeParties();
		m_partiesCrees = new ArrayList<Partie>();
		m_listeParties = new JList<String>();
		m_listeParties.setModel(m_nomsPartiesCrees);
		m_listeParties.setSize(210,210);
		m_listeParties.setLocation(30,450);
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

		repaint();
	}

	/**
	 * affichage de la liste des joueurs
	 * @throws RemoteException 
	 */
	void afficherListeJoueur() throws RemoteException{
		//affichage de la liste des joueurs
		m_nomsPartiesCrees = m_joueur.getObjetDistant().getListeParties();
		m_listeJoueurs = new JList<String>();
		m_listeJoueurs.setModel(m_joueursConnectes);
		m_listeJoueurs.setSize(210,210);
		m_listeJoueurs.setLocation(30,450);

		m_panelStart.add(m_listeJoueurs);

		repaint();

	}

	
	/**
	 * affichage du bouton "start"
	 */
	void afficherBoutonStart(){
		m_buttonStart = new JButton();
		m_buttonStart.setIcon(new ImageIcon("data/start.png"));
		m_buttonStart.setSize(210,210);
		m_buttonStart.setLocation(410,410);
		m_buttonStart.setOpaque(false);
		m_buttonStart.setContentAreaFilled(false);
		m_panelStart.add(m_buttonStart);
		m_buttonStart.addActionListener(m_controle);
	}

	/**
	 * affichage du bouton "Quitter la partie"
	 */
	void afficherBoutonQuitterPartie(){
		m_boutonQuitterPartie = new JButton("Quitter la partie");
		m_boutonQuitterPartie.setSize(300,30);
		m_boutonQuitterPartie.setLocation(400,500);
		m_panelStart.add(m_boutonQuitterPartie);
		m_boutonQuitterPartie.addActionListener(m_controle);
	}
	
	/**
	 * affichage du bouton "Terminer la partie"
	 */
	void afficherBoutonTerminerPartie(){
		m_boutonTerminerPartie = new JButton("Terminer la partie");
		m_boutonTerminerPartie.setSize(300,30);
		m_boutonTerminerPartie.setLocation(400,650);
		m_panelStart.add(m_boutonTerminerPartie);
		m_boutonTerminerPartie.addActionListener(m_controle);
	}

	/**
	 * creeer une nouvelle partie 
	 * @throws RemoteException 
	 */
	public void creerNouvellePartie() throws RemoteException{
		m_panelStart.removeAll();
		
		int nombreJoueursMax = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs ? (2-4)"));
		String[] choixVitesse = {"lent" , "modere", "rapide"};
		int vitesse = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,  choixVitesse, choixVitesse[1]);
		m_partie = new Partie(nombreJoueursMax, (4-vitesse)*15, m_joueur); 
		// serveur --> ajouter la Partie et mettre le createur dans la partie
		m_tronServeur.ajouterPartie(m_partie, m_joueur);
		m_joueur.rejoindrePartie(m_partie);
		m_joueursConnectes = m_tronServeur.getListeJoueurs(m_partie.getm_numero());
		m_partiesCrees.add(m_partie);
		
		afficherListeJoueur();
		afficherBoutonTerminerPartie();
		afficherBoutonStart();
	}

	/**
	 * rejoindre une partie 
	 * @throws RemoteException 
	 */
	public void rejoindrePartie() throws RemoteException{
		m_partiesCrees = m_tronServeur.getM_listeDeParties();
		m_partie = m_partiesCrees.get( m_listeParties.getAnchorSelectionIndex() );		
		m_joueur.getObjetDistant().ajouterJoueur(m_listeParties.getAnchorSelectionIndex(), m_joueur);
		m_joueursConnectes = m_tronServeur.getListeJoueurs(m_partie.getm_numero());
		m_panelStart.removeAll();
		afficherListeJoueur();
		afficherBoutonQuitterPartie();
	}
	
	/**
	 * quitter une partie
	 * @throws RemoteException 
	 */
	public void quitterPartie() throws RemoteException{
		m_panelStart.removeAll();
		
		// serveur --> enlever le joueur de la partie
		afficherListePartie();
	}

	
	/**
	 * terminer la partie
	 */
	public void terminerPartie(){
		// serveur --> faire appel � tous les joueurs de la partie quitterPartie() puis supprimer la partie
	}
	
	/**
	 * lancer la partie
	 */
	public void lancerPartie(){
		setVisible(false);
		m_partie.lancerPartie();
	}
	
	/*public static void main (String[] args){
		Menu menu = new Menu();
		menu.setVisible(true);
	}*/

	
	/**
	 * classe privee pour reagir aux boutons
	 * 
	 * @author MACE DE GASTINES Etienne
	 * @version 1.0
	 * @since 1.0
	 */
	private class Controle implements ActionListener{

		public Controle(Menu unMenu, Joueur unJoueur){

		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getActionCommand() == "Creer une nouvelle partie"){
				try {
					creerNouvellePartie();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			else if (e.getActionCommand() == "Rejoindre une partie"){
				try {
					rejoindrePartie();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // gerer exception si aucune partie selectionee ou si partie remplie
			}
			
			else if (e.getActionCommand() == "Quitter la partie"){
				try {
					quitterPartie();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			else if (e.getActionCommand() == "Terminer la partie"){
				terminerPartie();
			}
			
			else {
				lancerPartie();
			}
		}

	}

}

