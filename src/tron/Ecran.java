package tron;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;


public class Ecran extends JFrame{
	Partie m_partie;
	int m_MargeW,m_MargeH;

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
		//this.setVisible(true);
	}
	public void paint(Graphics unG){
		super.paint(unG);
		unG.drawRect(m_MargeW,m_MargeH,5*this.m_partie.TAILLE_X,5*this.m_partie.TAILLE_Y);
		for (int i=0 ; i < this.m_partie.TAILLE_X ; i++){
			for (int j=0 ; j < m_partie.TAILLE_Y ; j++){
				int k = m_partie.getGrille(i,j);
				if (k != 0)	unG.setColor(m_partie.getSerpent(k).getCouleur());
				else continue;
				unG.fillRect(m_MargeW+i*5, m_MargeH+j*5, 5, 5);
			}
		}
	} 
	/*public void paint(Graphics g){
		super.paint(g);
		g.drawRect(m_MargeW,m_MargeH,5*this.m_partie.TAILLE_X,5*this.m_partie.TAILLE_Y);
	}
	public void mettreAJourBuffer(Graphics g, int x,int y, int numero){
		super.paint(g);
		g.setColor( m_partie.getSerpent(numero).getCouleur()); 
		g.fillRect(m_MargeW+x*5, m_MargeH+y*5, 5, 5);
		}*/
}
