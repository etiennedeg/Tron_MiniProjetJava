package tron;

public class PartieThread extends Thread{

	Partie m_partie;

	public PartieThread(Partie unePartie){
		m_partie = unePartie;

	}

	public void run(){
		while ( m_partie.isPartieEnCours() ){
			try {
				sleep( m_partie.getVitesse() );
				m_partie.jouerPartie();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
