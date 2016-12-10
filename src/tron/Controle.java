package tron;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controle implements KeyListener{

	Serpent m_serpent;
	public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        
        if(code==KeyEvent.VK_UP){
            m_serpent.deplacerSerpent(2);           
        }
         
        else if(code==KeyEvent.VK_RIGHT){
        	m_serpent.deplacerSerpent(3);
        }
         
        else if(code==KeyEvent.VK_DOWN){
        	m_serpent.deplacerSerpent(4);
        }  
        else if(code==KeyEvent.VK_LEFT){
        	m_serpent.deplacerSerpent(1);
        }
         
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
