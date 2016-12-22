package tron;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControleKEY implements KeyListener{

	Serpent m_serpent;
	
	public ControleKEY(Serpent unSerpent){
		m_serpent =  unSerpent;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();

        System.out.println("1");
        
        if(code==KeyEvent.VK_UP){
            m_serpent.changerOrientation(-2);           
        }
         
        else if(code==KeyEvent.VK_RIGHT){
        	m_serpent.changerOrientation(1);
        }
         
        else if(code==KeyEvent.VK_DOWN){
        	m_serpent.changerOrientation(2);
        }  
        else if(code==KeyEvent.VK_LEFT){
        	m_serpent.changerOrientation(-1);
        }
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	
}
