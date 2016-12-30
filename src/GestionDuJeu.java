import java.util.Scanner;

public class GestionDuJeu {
	
	//cette méthode gère l'affichage du menu
	//elle renvoie si oui ou non un 2nd joueur a été choisi
	public static boolean affichage()
	{	
		boolean p2 = false, check_1;
		Scanner in = new Scanner(System.in);
		do{
		 System.out.println("Souhaitez-vous jouer a deux? (y/n)");
		 String rep = in.nextLine();
		 if(rep.equals("y"))
		 {	
			 p2 = true; //entrée du 2nd joueur
			 check_1 = false;//sortie de la boucle
		 }
		 else if(rep.equals("n"))
		 {	
			 p2 = false; //pas de 2nd joueur
			 check_1 = false; //sortie de la boucle
		 }
		 else
		 {
			 check_1 = true;
		 }
		} while(check_1); //tant qu'on ne met pas y ou n, la question est réposée
		
		if(p2) //affichage avec 2nd joueur
		{
			System.out.println("Les touches sont: ");
			System.out.println("");
			System.out.println("P1:                       P2:");
			System.out.println("Z pour monter             UP pour monter");
			System.out.println("S pour descendre          DOWN pour descendre");
			System.out.println("Q pour aller a gauche     LEFT pour aller a gauche");
			System.out.println("D pour aller a droite     RIGHT pour aller a droite");
			System.out.println("E pour quitter");
		}
		else //affichage sans 2nd joueur
		{
			System.out.println("Les touches sont: ");
			System.out.println("");
			System.out.println("Z pour monter");
			System.out.println("S pour descendre");
			System.out.println("Q pour aller a gauche");
			System.out.println("D pour aller a droite");
			System.out.println("E pour quitter");
		}
		
		
		return p2; 
	}
	
}
