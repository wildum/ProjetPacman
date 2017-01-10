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
			if(StdDraw.mouseX() > 24.5 && StdDraw.mouseX() < 84.5 && StdDraw.mouseY() > 76 && StdDraw.mouseY() < 86)
			{
				choixDuJoueur = 1;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(54.5, 76, 30, 5);
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(54.5, 76, 30, 5);
			}
			if(StdDraw.mouseX() > 24.5 && StdDraw.mouseX() < 84.5 && StdDraw.mouseY() > 56 && StdDraw.mouseY() < 66)
			{
				choixDuJoueur = 2;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(54.5, 56, 30, 5);
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(54.5, 56, 30, 5);
			}
			
			if(StdDraw.mouseX() > 24.5 && StdDraw.mouseX() < 84.5 && StdDraw.mouseY() > 36 && StdDraw.mouseY() < 46)
			{
				choixDuJoueur = 3;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(54.5, 36, 30, 5);
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(54.5, 36, 30, 5);
			}
			if(StdDraw.mouseX() > 24.5 && StdDraw.mouseX() < 84.5 && StdDraw.mouseY() > 16 && StdDraw.mouseY() < 26)
			{
				choixDuJoueur = 4;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(54.5, 16, 30, 5);
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(54.5, 16, 30, 5);
			}
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(54, 74, "One Player");
			StdDraw.text(54, 54, "Two Players");
			StdDraw.text(54, 34, "High Scores");
			StdDraw.text(56, 14, "Quit");
			StdDraw.setPenRadius(0.01);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.rectangle(54.5, 76, 30, 5);
			StdDraw.rectangle(54.5, 56, 30, 5);
			StdDraw.rectangle(54.5, 36, 30, 5);
			StdDraw.rectangle(54.5, 16, 30, 5);
			StdDraw.setPenRadius();
			StdDraw.show(20);
		}
		}
		return choixDuJoueur;
	}
	
	public static boolean affichageMenuPause()
	{
		boolean choixDuJoueur = true;
		boolean loop = true;
		Font font = new Font("SHOWCARD GOTHIC", Font.BOLD, 40);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(55, 77, "PAUSED");
		Font font2 = new Font("SHOWCARD GOTHIC", Font.BOLD, 20);
		StdDraw.setFont(font2);
		while(loop)
		{
			if(StdDraw.mouseX() > 21.5 && StdDraw.mouseX() < 51.5 && StdDraw.mouseY() > 59.5 && StdDraw.mouseY() < 70.5)
			{
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
				if(StdDraw.mousePressed())
				{
					loop = false;
					choixDuJoueur = true;
				}
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
			}
			if(StdDraw.mouseX() > 56.5 && StdDraw.mouseX() < 86.5 && StdDraw.mouseY() > 59.5 && StdDraw.mouseY() < 70.5)
			{
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(71.5, 64, 15, 5);
				if(StdDraw.mousePressed())
				{
					loop = false;
					choixDuJoueur = false;
				}
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(71.5, 64, 15, 5);
			}
			StdDraw.setPenRadius(0.01);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.rectangle(71.5, 64, 15, 5);
			StdDraw.rectangle(36.5, 64, 15, 5);
			StdDraw.setPenRadius();
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(36, 62, "Resume");
			StdDraw.text(71, 62, "Quit");
			StdDraw.show(20);
			
			if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE))
			{
				loop = false;
				choixDuJoueur = true;
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE))
			{
				loop = false;
				choixDuJoueur = false;
			}

		}
		
		
		return choixDuJoueur;
	}
	
	public static int checkWinLoose(Graine [][] tab_graines, Joueur...joueurs)
	{
		int fin = 0, compteur = 0;
		
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{
				if(tab_graines[i][j].type == "standard")
				{
					compteur++;
				}
			}
		}
		
		if(compteur == 0)
		{
			fin = 1; //win
		}
		
		for(int a = 0; a < joueurs.length; a++)
		{
			if(joueurs[a].getVie() == 0)
			{
				fin = 2; //loose
			}
		}
		
		return fin;
	}
	
	public static void affichageFin(int fin)
	{
		Font font = new Font("SHOWCARD GOTHIC", Font.BOLD, 40);
		StdDraw.setFont(font);
		if(fin == 1)
		{
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.text(57, 77, "WIN");
		}
		else
		{
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.text(51, 77, "GAME OVER");
		}
		StdDraw.show(20);
		StdDraw.pause(2000);
	}
	
}
