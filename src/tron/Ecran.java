package tron;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Ecran du jeu
 * 
 * @author JIANG Shangwei
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public class Ecran extends JFrame{
	
	/**
	 * L'objet contenant les informations d'une partie du jeu
	 */
	Partie m_partie;
	
	/**
	 * La marge horizontale et la large verticale 
	 */
	
	int m_MargeW,m_MargeH;
	
	/**
	 * Un buffer d'image de serpents 
	 */
	BufferedImage m_buffer;

	/**
	 * Constructeur
	 * 
	 * @param unePartie L'objet contenant les informations d'une partie du jeu
	 */
	public Ecran(Partie unePartie){
		super("Tron");
		m_partie = unePartie;
		
		/** Construction d'image du fond */
		
		ImageIcon imgBack = new ImageIcon("background.png");
		JLabel backGround = new JLabel(imgBack);
		backGround.setBounds(0,0, imgBack.getIconWidth(), imgBack.getIconHeight());
		getLayeredPane().add(backGround , new Integer(Integer.MIN_VALUE));

		/** Construction du panel principal */
		
		JPanel PanelSerpents = new JPanel();
		PanelSerpents.setOpaque(false);
		PanelSerpents.setLayout(null);
		setContentPane(PanelSerpents);

		/** Configuration de l'ecran */
		
		//imgBack.Width = imgBack.Height = 734
		m_MargeW = (imgBack.getIconWidth()-5*this.m_partie.TAILLE_X)/2;
		m_MargeH = (imgBack.getIconHeight()-5*this.m_partie.TAILLE_Y)/2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(imgBack.getIconWidth(), imgBack.getIconHeight());
		//setVisible(true);
		
		/** Configuration du buffer d'image de serpents */

		m_buffer = new BufferedImage (getSize().width, getSize().height, BufferedImage.TYPE_INT_ARGB);
		JLabel affichage = new JLabel(new ImageIcon(m_buffer));
		affichage.setOpaque(false);
		affichage.setSize(getSize().width, getSize().height);
		PanelSerpents.add(affichage);

	}
	
	@Override	
	public void paint(Graphics unG){
		
		/** l'image du fond */
		
		super.paint(unG);
		
		/** dessiner les serpents */
		
		unG = m_buffer.getGraphics();
		
		/** dessiner le bord de l'écran  */
		
		unG.setColor(Color.gray);
		unG.drawRect(m_MargeW,m_MargeH,5*this.m_partie.TAILLE_X,5*this.m_partie.TAILLE_Y);
		/*for (int i=1 ; i < m_partie.TAILLE_X-1 ; i++){
			for (int j=1 ; j < m_partie.TAILLE_Y-1 ; j++){
				int k = m_partie.getGrille(i,j);
				if (k != 0)	unG.setColor(m_partie.getSerpent(k).getCouleur());
				//if (k == 0)	unG.setColor(Color.red);
				else continue;
				unG.fillRect(m_MargeW+i*5, m_MargeH+j*5, 5, 5);
			}
		}*/
	}

	/**
	 * La méthode d'éditer le buffer d'image de serpents
	 * 
	 * @param unNUM Le numéro de serpent 
	 * @param X L'abscisse de la position du tête de serpent 
	 * @param Y L'ordonnée de la position du tête de serpent 
	 */
		
	public void editerBuff (int unNum, int X, int Y){
		Graphics g = m_buffer.getGraphics();
		g.setColor(m_partie.getSerpent(unNum).getCouleur());
		g.fillRect(m_MargeW + X * 5, m_MargeH + Y * 5, 5, 5);
		g.dispose();
	}

}
