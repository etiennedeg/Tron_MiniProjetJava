package tron.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import javax.swing.JOptionPane;

import tron.*;

//Permet a un utilisateur humain de passer des ordres par le réseau
public class Client {
	
	private Joueur joueur;
	
	private TronRMIServeur tronServeur;

		/**
		 * Constructeur
		 * 
		 * @param t l'objet representant le trader
		 * @param m la reference RMI a un marche boursier distant
		 */
		public Client(Joueur j, TronRMIServeur t) {
			joueur = j;
			tronServeur = t;
		}
		
		// Methode contenant la boucle d'exécution permettant a l'utilisateur de passer des ordres
		public void run() {
			int choix = 1;
			Scanner lecture = new Scanner(System.in);
			while (choix != 0) {
				System.out.println("Que voulez-vous faire ?");
				System.out.println("0 - Quitter");
				System.out.println("1 - Emettre un ordre");
				choix = Integer.parseInt(lecture.nextLine());
				try {
					if (choix == 1) {
						System.out.print("Nom de l'action: ");
						String str = lecture.nextLine();
						//Action a = marche.getAction(str);
						//if (a == null) a = new Action(str,100);
						Action a = new Action(str,100);
						System.out.print("Prix unitaire: ");
						int prix = Integer.parseInt(lecture.nextLine());
						System.out.print("Quantite d'actions: ");
						int qte = Integer.parseInt(lecture.nextLine());
						System.out.print("Vente (V) ou Achat (A): ");
						String type = lecture.nextLine();
						if (type.equals("V"))
							marcheDistant.publieOrdre(new Vente("O" + (Marche.COMPTEUR_ORDRE++),trader,a,qte,prix));
						else if (type.equals("A"))
							marcheDistant.publieOrdre(new Achat("O" + (Marche.COMPTEUR_ORDRE++),trader,a,qte,prix));
					}
				} catch (ActionInconnue e) {
					System.err.println(e.getMessage());
				} catch (RemoteException e) {
					System.err.println(e.getMessage());
				}
			}
			lecture.close();
		}

		/**
		 * La methode main qui lance un client de connexion a un marche financier
		 * 
		 * Les premieres lignes servent a connecter le client au serveur
		 */
		public static void main(String[] args) {

			Joueur j;
			TronRMIServeur t;
			try {
				if (args.length == 0) t = (TronRMIServeur)LocateRegistry.getRegistry(1099).lookup("Partie");
				else t = (TronRMIServeur)LocateRegistry.getRegistry(1099).lookup("Partie");
				j = new Joueur(JOptionPane.showInputDialog("Nom du joueur"),1);
				Client client = new Client(j,t);
				client.run();
			} catch (RemoteException ex) {
				ex.printStackTrace();
			} catch (NotBoundException ex) {
				ex.printStackTrace();
			}
		}
	
	

}
