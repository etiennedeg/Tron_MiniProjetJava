package tron;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
	public Menu(){
		super("Tron");
		ImageIcon imgBack = new ImageIcon("serpent.png");
		JLabel backGround = new JLabel(imgBack);
		backGround.setBounds(0,0, imgBack.getIconWidth(), imgBack.getIconHeight());
		this.getLayeredPane().add(backGround , new Integer(Integer.MIN_VALUE));
		((JPanel)this.getContentPane()).setOpaque(false);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		JButton ButtonDeCommencer = new JButton();
		ButtonDeCommencer.setIcon(new ImageIcon("start.png"));
		ButtonDeCommencer.setSize(210,210);
		ButtonDeCommencer.setLocation(410,410);
		panel.add(ButtonDeCommencer);
		ButtonDeCommencer.addActionListener(new Controle());
		this.getContentPane().add(panel);
		this.setSize(imgBack.getIconWidth(), imgBack.getIconHeight());

	}
	public static void main (String[] args){
		Menu menu = new Menu();
		menu.setVisible(true);
	}

}
class Controle implements ActionListener {
	public void actionPerformed(ActionEvent e){
		System.exit(0);//lancerPartie ici !
	}

}
