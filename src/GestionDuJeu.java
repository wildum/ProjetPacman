import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;


public class GestionDuJeu {
	
	// Chronomètre du jeu :
	static Chrono chrono = new Chrono();
	
	public static Chrono getChrono() {
		return chrono;
	}

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
			System.out.println("P1:                          P2:");
			System.out.println("UP pour monter               Z pour monter");
			System.out.println("DOWN pour descendre          S pour descendre");
			System.out.println("LEFT pour aller a gauche     Q pour aller a gauche");
			System.out.println("RIGHT pour aller a droite    D pour aller a droite");
			System.out.println("               E pour quitter");
		}
		else //affichage sans 2nd joueur
		{
			System.out.println("Les touches sont: ");
			System.out.println("");
			System.out.println("UP pour monter");
			System.out.println("DOWN pour descendre");
			System.out.println("LEFT pour aller a gauche");
			System.out.println("RIGHT pour aller a droite");
			System.out.println("E pour quitter");
		}
		
		
		return p2; 
	}
	
	public static int affichageMenuPage1()
	{
		boolean cliqueCase = true;
		int choixDuJoueur = 0;
		StdDraw.setCanvasSize(500,760); 
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); 
		Font font = new Font("SHOWCARD GOTHIC", Font.BOLD, 20);
		StdDraw.setFont(font);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54,114,"Images/TitreMenu.png",80,30);
		
		while(cliqueCase)
		{
		while(StdDraw.mousePressed() == false)
		{
			cliqueCase = true;
			if(StdDraw.mouseX() > 24.5 && StdDraw.mouseX() < 84.5 && StdDraw.mouseY() > 71 && StdDraw.mouseY() < 91)
			{
				choixDuJoueur = 1;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(54.5, 76, 30, 10);
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(54.5, 76, 30, 10);
			}
			if(StdDraw.mouseX() > 24.5 && StdDraw.mouseX() < 84.5 && StdDraw.mouseY() > 41 && StdDraw.mouseY() < 61)
			{
				choixDuJoueur = 2;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(54.5, 46, 30, 10);
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(54.5, 46, 30, 10);
			}
			if(StdDraw.mouseX() > 24.5 && StdDraw.mouseX() < 84.5 && StdDraw.mouseY() > 11 && StdDraw.mouseY() < 31)
			{
				choixDuJoueur = 3;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(54.5, 16, 30, 10);
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(54.5, 16, 30, 10);
			}
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(54, 74, "One Player");
			StdDraw.text(54, 44, "Two Players");
			StdDraw.text(54, 14, "High Scores");
			StdDraw.show(20);
		}
		}
		return choixDuJoueur;
	}
	
	public static boolean affichageMenuPause()
	{
		boolean cliqueCase = true;
		boolean choixDuJoueur = true;
		Font font = new Font("SHOWCARD GOTHIC", Font.BOLD, 40);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(55, 77, "PAUSED");
		Font font2 = new Font("SHOWCARD GOTHIC", Font.BOLD, 20);
		StdDraw.setFont(font2);
		while(cliqueCase)
		{
		while(StdDraw.mousePressed() == false)
		{
			cliqueCase = true;
			if(StdDraw.mouseX() > 21.5 && StdDraw.mouseX() < 51.5 && StdDraw.mouseY() > 59.5 && StdDraw.mouseY() < 70.5)
			{
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
				choixDuJoueur = true;
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
			}
			if(StdDraw.mouseX() > 56.5 && StdDraw.mouseX() < 86.5 && StdDraw.mouseY() > 59.5 && StdDraw.mouseY() < 70.5)
			{
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(71.5, 64, 15, 5);
				choixDuJoueur = false;
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(71.5, 64, 15, 5);
			}
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(36, 62, "Resume");
			StdDraw.text(71, 62, "Quit");
			StdDraw.show(20);
		}
		}
		
		return choixDuJoueur;
	}
	
}
