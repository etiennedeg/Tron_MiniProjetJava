package tron;

public class Serpent {

	private String m_Couleur;
	private int m_numero;
	private int m_orientation=0;
	private int m_teteX=0;
	private int m_teteY=0;
	
	public void Serpent(int unNumero,String uneCouleur){
		m_numero=unNumero;
		m_Couleur=uneCouleur;
	}
	
	public int getTeteX(){
		return m_teteX;
	}
	
	public int getTeteY(){
		return m_teteY;
	}
	
	public boolean changerTete(int x,int y,int numSerpent){
		m_teteX=x;
		m_teteY=y;
		int[][] uneGrille=.getGrill();
		if (uneGrille(x,y)==0)
		{
			.setGrille(x,y,numSerpent);
			return true;
		}else{
			return false;
		}
	}
	
	public int getOrientation(){
		return m_orientation;
	}
	
	public void changerOrientation(int uneOrientation){
		m_orientation=uneOrientation;
	}
	
}
