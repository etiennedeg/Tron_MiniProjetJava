package tron;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class Ecran extends JFrame{
	Partie m_partie;
	int m_MargeW,m_MargeH;
	Image imgBack;
	public Ecran(Partie unePartie){
		super("Tron");
		m_partie = unePartie;
		ImageIcon imgBack = new ImageIcon("background.png");
		JLabel backGround = new JLabel(imgBack);
		backGround.setBounds(0,0, imgBack.getIconWidth(), imgBack.getIconHeight());		
		this.getLayeredPane().add(backGround , new Integer(Integer.MIN_VALUE));
		((JPanel)this.getContentPane()).setOpaque(false);
		//imgBack.Width = imgBack.Height = 734
		m_MargeW = (imgBack.getIconWidth()-5*this.m_partie.TAILLE_X)/2;
		m_MargeH = (imgBack.getIconHeight()-5*this.m_partie.TAILLE_Y)/2;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(imgBack.getIconWidth(), imgBack.getIconHeight());
		this.setVisible(true);
	}
	public void paint(Graphics unG){
		super.paint(unG);

		for (int i=0 ; i < this.m_partie.TAILLE_X ; i++){
			for (int j=0 ; j < this.m_partie.TAILLE_Y ; j++){
				
				if (this.m_partie.getGrille(i,j) == 1)	unG.setColor(Color.red);
				else if (this.m_partie.getGrille(i,j) == 2)	unG.setColor(Color.blue);
				else if (this.m_partie.getGrille(i,j) == 3)	unG.setColor(Color.green);
				else if (this.m_partie.getGrille(i,j) == 4)	unG.setColor(Color.yellow);
				else continue;
				unG.fillRect(m_MargeW+i*5, m_MargeH+j*5, 5, 5);
			}
		}
	} 
	/*public static void main (String[] args){
		Partie p = new Partie(2,2);
		p.m_ecran = new Ecran(p);
	}*/

}
