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
		imgBack = Toolkit.getDefaultToolkit().getImage("board.jpg");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	   public Dimension getPreferredSize(){  
	       return new Dimension(m_MargeW*2+20*this.m_partie.TAILLE_X , m_MargeH*2+20*this.m_partie.TAILLE_Y);  
	   }
	public void paint(Graphics unG){
		super.paint(unG);
		m_MargeW = (imgBack.getWidth(this)-20*this.m_partie.TAILLE_X)/2;
		m_MargeH = (imgBack.getWidth(this)-20*this.m_partie.TAILLE_Y)/2;
		
		for (int i=0 ; i < this.m_partie.TAILLE_X ; i++){
			for (int j=0 ; j < this.m_partie.TAILLE_Y ; j++){
				
				if (this.m_partie.getGrille(i,j) == 1)	unG.setColor(Color.red);
				else if (this.m_partie.getGrille(i,j) == 2)	unG.setColor(Color.blue);
				else if (this.m_partie.getGrille(i,j) == 3)	unG.setColor(Color.green);
				else if (this.m_partie.getGrille(i,j) == 4)	unG.setColor(Color.yellow);
				else continue;
				unG.fillRect(m_MargeW+i*20, m_MargeH+j*20, 20, 20);
			}
		}
	} 

}
