package tron;

public class PartieThread extends Thread{

	Partie m_partie;

	public PartieThread(Partie unePartie){
		m_partie = unePartie;

	}

	public void run(){
		if ( m_partie.deplacerSerpents() ) {
			m_partie.getEcran().repaint();
		}
		else {
			m_partie.designerGagnants();
		}

	}
}
