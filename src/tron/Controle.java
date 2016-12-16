package tron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
public class Controle implements ActionListener {


	public Menu m_menu;
	public Controle (Menu menu){
		m_menu = menu;
	}
	public void actionPerformed(ActionEvent e){
		int nombreJoueurs = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs ? (2-4)"));
		int vitesse = Integer.parseInt(JOptionPane.showInputDialog("Choisissez une vitesse svp (from 1-100)"));
		Partie p = new Partie(nombreJoueurs,vitesse);
		//p.lancerPartie(); le grille n'est pas bien initialise , je pense que les serpents doivent etre initialise dans la constructeur de Partie
		this.m_menu.dispose();
		p.m_ecran.setVisible(true);
		p.lancerPartie();

	}
}
