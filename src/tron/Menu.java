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

public class Menu extends JFrame{


	private JPanel m_panelStart;
	private Controle m_controle;
	private Joueur m_joueur;
	private Partie m_partie;
	private DefaultListModel<String> m_joueursConnectes;
	private JList<String> m_listeJoueurs;
	private DefaultListModel<String> m_nomsPartiesCrees;
	private ArrayList<Partie> m_partiesCrees;
	private JList<String> m_listeParties;
	private JButton m_buttonStart;
	private JButton m_boutonCreerPartie;
	private JButton m_boutonRejoindrePartie;



	public Menu(){
		super("Tron");
		m_joueur = new Joueur(JOptionPane.showInputDialog("Nom du joueur"));
		m_controle = new Controle(this, m_joueur);

		//ajout du background
		ImageIcon imgBack = new ImageIcon("serpent.png");
		JLabel backGround = new JLabel(imgBack);
		backGround.setBounds(0,0, imgBack.getIconWidth(), imgBack.getIconHeight());
		getLayeredPane().add(backGround , new Integer(Integer.MIN_VALUE));

		//ajout du panel
		m_panelStart = new JPanel();
		m_panelStart.setLayout(null);
		m_panelStart.setOpaque(false);
		setContentPane(m_panelStart);

		//affichage
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(imgBack.getIconWidth(), imgBack.getIconHeight());
		setVisible(true);

		//afficherListePartie();
		afficherListePartie();
	}

	void afficherListePartie(){
		//affichage de la liste de partie
		m_nomsPartiesCrees = new DefaultListModel<String>();
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

		// chercher les parties crées dans le serveur
		
		repaint();
	}

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


	public void creerNouvellePartie(){
		int nombreJoueursMax = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs ? (2-4)"));
		String[] choixVitesse = {"lent" , "modere", "rapide"};
		int vitesse = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,  choixVitesse, choixVitesse[1]);
		m_partie = new Partie(nombreJoueursMax, vitesse*5000, m_joueur); //ajout Partie au serveur
		
		afficherListeJoueur();
		afficherBoutonStart();
	}

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

	//classe privee pour reagir aux boutons
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
				rejoindrePartie(); // gerer exception si aucune partie selectionÃ©e ou si partie remplie
			}
			
			else {
				lancerPartie();
			}
		}

	}

}

