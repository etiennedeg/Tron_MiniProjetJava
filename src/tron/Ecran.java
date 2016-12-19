package tron;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Ecran extends JFrame{
	Partie m_partie;
	int m_MargeW,m_MargeH;
	BufferedImage m_buffer;

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
		for (int i=1 ; i < m_partie.TAILLE_X-1 ; i++){
			for (int j=1 ; j < m_partie.TAILLE_Y-1 ; j++){
				int k = m_partie.getGrille(i,j);
				if (k != 0)	unG.setColor(m_partie.getSerpent(k).getCouleur());
				//if (k == 0)	unG.setColor(Color.red);	
				else continue;
				unG.fillRect(m_MargeW+i*5, m_MargeH+j*5, 5, 5);
			}
		}
	} 
	/*public void editerBuff (int unNum, int X, int Y){
		BufferedImage buff = new BufferedImage (getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
		buff.getGraphics().setColor(m_partie.getSerpent(unNum).getCouleur());
		buff.getGraphics().fillRect(m_MargeW+X*5, m_MargeH+Y*5, 5, 5);
		//this.getContentPane().add(new JLabel(new ImageIcon(buff)));
	}*/
		
}
