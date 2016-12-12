package tron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame{
	JButton m_ButtonDeConmmencer;
	JPanel m_panelStart;
	public Menu(){
		super("Tron");
		ImageIcon imgBack = new ImageIcon("serpent.png");
		JLabel backGround = new JLabel(imgBack);
		backGround.setBounds(0,0, imgBack.getIconWidth(), imgBack.getIconHeight());		
		this.getLayeredPane().add(backGround , new Integer(Integer.MIN_VALUE));
		((JPanel)this.getContentPane()).setOpaque(false);		
		JPanel m_panelStart = new JPanel();
		m_panelStart.setOpaque(false);
		m_panelStart.setLayout(null);		
		m_ButtonDeConmmencer = new JButton();
		m_ButtonDeConmmencer.setIcon(new ImageIcon("start.png"));
		m_ButtonDeConmmencer.setSize(210,210);
		m_ButtonDeConmmencer.setLocation(410,410);
		m_ButtonDeConmmencer.setOpaque(false);
		m_ButtonDeConmmencer.setContentAreaFilled(false);
		m_panelStart.add(m_ButtonDeConmmencer);
		m_ButtonDeConmmencer.addActionListener(new Control(this));
		this.getContentPane().add(m_panelStart);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(imgBack.getIconWidth(), imgBack.getIconHeight());
		
	}

	public static void main (String[] args){
		Menu menu = new Menu();
		menu.setVisible(true);
	}

}
class Control implements ActionListener {
	public Menu m_menu;
	public Control (Menu menu){
		m_menu = menu;
	}
	public void actionPerformed(ActionEvent e){
		int nombreJoueurs = Integer.parseInt(JOptionPane.showInputDialog("Combien de joueurs ? (2-4)"));
		int vitesse = Integer.parseInt(JOptionPane.showInputDialog("Choisissez une vitesse svp (from 1-100)"));
		Partie p = new Partie(nombreJoueurs,vitesse);
		//p.lancerPartie();
		this.m_menu.dispose();
		new Ecran(p);
	}

}
