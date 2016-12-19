package tron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
public class Controle implements ActionListener {



	private Menu m_menu;
	private Joueur m_joueur;
	private DefaultListModel<String> m_joueursConnectes;
	private JList<String> m_listeJoueurs;


	public Controle (Menu unMenu, Joueur unJoueur){
		m_menu = unMenu;
		m_joueur = unJoueur;
		m_joueursConnectes = new DefaultListModel<String>();
		m_listeJoueurs = new JList<String>();
		m_listeJoueurs.setModel(m_joueursConnectes);
	}


	public void actionPerformed(ActionEvent e){
		//demande si le joueur veut creer une partie ou en rejoindre une
		String[] choixPartie = {"creer une nouvelle partie", "rejoindre une partie existante"};
		int isPartieCree = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,  choixPartie, choixPartie[0]);
		if (isPartieCree == 0){
			creerPartie();
		}
		else{
			rejoindrePartie();
		}
		/*int nombreJoueurs = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs ? (2-4)"));
		int vitesse = Integer.parseInt(JOptionPane.showInputDialog("Choisissez une vitesse svp (from 1-100)"));
		Partie p = new Partie(nombreJoueurs,vitesse);
		//p.lancerPartie(); le grille n'est pas bien initialise , je pense que les serpents doivent etre initialise dans la constructeur de Partie
		this.m_menu.dispose();
		p.m_ecran.setVisible(true);
		p.lancerPartie();*/

	}

	public void creerPartie(){
		//demande le nombre de joueurs souhaité et la vitesse du serpent
		int nombreJoueursMax = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs ? (2-4)"));
		String[] choixVitesse = {"lent" , "modere", "rapide"};
		int vitesse = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,  choixVitesse, choixVitesse[1]);
		Partie partie = new Partie(nombreJoueursMax,vitesse*5000);
		m_joueursConnectes.addElement(m_joueur.getNom());
	}

	public void rejoindrePartie(){
		Partie p = new Partie(nombreJoueurs,vitesse);
		//p.lancerPartie(); le grille n'est pas bien initialise , je pense que les serpents doivent etre initialise dans la constructeur de Partie
		this.m_menu.dispose();
		p.m_ecran.setVisible(true);
		p.lancerPartie();*/
	}
}
