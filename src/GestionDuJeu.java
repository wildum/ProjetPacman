import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.princeton.cs.introcs.StdDraw;


public class GestionDuJeu {
	
	// Chronomètre du jeu :
	static Chrono chrono = new Chrono();
	static Font petite = new Font("SHOWCARD GOTHIC", Font.BOLD, 18), normale = new Font("SHOWCARD GOTHIC", Font.BOLD, 20), selection = new Font("SHOWCARD GOTHIC", Font.BOLD, 22), grande = new Font("SHOWCARD GOTHIC", Font.BOLD, 40);
	
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
		StdDraw.setFont(normale);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54,114,"Images/TitreMenu.png",80,30);
		
		while(cliqueCase)
		{
		while(StdDraw.mousePressed() == false)
		{
			cliqueCase = true;			
			
			// ONE PLAYER :
			if(StdDraw.mouseX() > 39.5 && StdDraw.mouseX() < 69 && StdDraw.mouseY() > 36 && StdDraw.mouseY() < 40.5) // choix du mode 1 joueur
			{
				StdDraw.pause(50);
				choixDuJoueur = 1;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 34, 30, 5);
				StdDraw.setFont(selection);
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.text(54, 31.8, "One Player");
				
			}
			else
			{
				StdDraw.pause(50);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 34, 30, 3.5);
				StdDraw.setFont(normale);
				StdDraw.setPenColor(200,200,200);
				StdDraw.text(54, 32, "One Player");
			}
			
			// TWO PLAYER :
			if(StdDraw.mouseX() > 37.2 && StdDraw.mouseX() < 71.1 && StdDraw.mouseY() > 26.3 && StdDraw.mouseY() < 30) // choix du mode 2 joueurs
			{
				choixDuJoueur = 2;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 25, 30, 3.5);
				StdDraw.setFont(selection);
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.text(54, 21.77, "Two Players");
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 25, 30, 4);
				StdDraw.setFont(normale);
				StdDraw.setPenColor(200,200,200);
				StdDraw.text(54, 22, "Two Players");
				
			}
			
			// HIGHSCORE :
			if(StdDraw.mouseX() > 39.5 && StdDraw.mouseX() < 69.5 && StdDraw.mouseY() > 17.1 && StdDraw.mouseY() < 21) // choix de regarder les meilleurs scores
			{
				choixDuJoueur = 3;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 16, 30, 5);
				StdDraw.setFont(selection);
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.text(54, 12.75, "High Scores");
				
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 16, 30, 5);
				StdDraw.setFont(normale);
				StdDraw.setPenColor(200,200,200);
				StdDraw.text(54, 13, "High Scores");
			}
			
			// CONTROLS :
			if(StdDraw.mouseX() > 41 && StdDraw.mouseX() < 66 && StdDraw.mouseY() > 8 && StdDraw.mouseY() < 12)
			{
				choixDuJoueur = 5;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 6, 30, 5);
				StdDraw.setFont(selection);
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.text(54, 3.7, "Controls");
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, 6, 30, 5);
				StdDraw.setFont(normale);
				StdDraw.setPenColor(200,200,200);
				StdDraw.text(54, 4, "Controls");
			}
			
			
			// QUIT :
			if(StdDraw.mouseX() > 47 && StdDraw.mouseX() < 61 && StdDraw.mouseY() > -2 && StdDraw.mouseY() < 4) // choix de quitter
			{
				choixDuJoueur = 4;
				cliqueCase = false;
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, -4, 30, 5);
				StdDraw.setFont(selection);
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.text(54, -5.2, "Quit");
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(54.5, -4, 30, 5);
				StdDraw.setFont(normale);
				StdDraw.setPenColor(200,200,200);
				StdDraw.text(54, -5, "Quit");
			}
			
			
			StdDraw.show(20);
			StdDraw.pause(50);
			}
		}
		return choixDuJoueur;
	}

	public static boolean affichageMenuPause()
	{
		boolean choixDuJoueur = true;
		boolean loop = true;;
		StdDraw.setFont(grande);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(55, 77, "PAUSED");;
		StdDraw.setFont(normale);
		while(loop)
		{
			if(StdDraw.mouseX() > 21.5 && StdDraw.mouseX() < 51.5 && StdDraw.mouseY() > 64 && StdDraw.mouseY() < 74)
			{
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
				if(Jeu.correctionBugClic)
				{
					if(StdDraw.mousePressed())
					{
						loop = false;
						choixDuJoueur = true; 
					}
				}
				else
				{
					if(StdDraw.mousePressed() == false)
					{
						loop = false;
						choixDuJoueur = true;
						Jeu.correctionBugClic = true;
					}
				}
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
			}
			if(StdDraw.mouseX() > 56.5 && StdDraw.mouseX() < 86.5 && StdDraw.mouseY() > 64 && StdDraw.mouseY() < 74)
			{
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(71.5, 64, 15, 5);
				if(Jeu.correctionBugClic)
				{
					if(StdDraw.mousePressed())
					{
						loop = false;
						choixDuJoueur = false; 
					}
				}
				else
				{
					if(StdDraw.mousePressed() == false)
					{
						loop = false;
						choixDuJoueur = false;
						Jeu.correctionBugClic = true;
					}
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
	
	public static boolean affichageMenuControl() {
		boolean stop = true;
		StdDraw.setCanvasSize(500,760); 
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); 
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54,114,"Images/TitreMenu.png",80,30);
		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(normale);		
		StdDraw.text(57, 85, "PLAYER 1 : ");
		StdDraw.text(57, 65, "PLAYER 2 : ");
		StdDraw.text(56, 27, "GAME : ");
						
		StdDraw.setPenColor(180, 180, 180);
		StdDraw.setFont(petite);
		StdDraw.text(55, 78, "ARROW KEYS");
		StdDraw.text(55, 58, "Z: UP");
		StdDraw.text(55, 52, "Q: LEFT");
		StdDraw.text(55, 46, "S: DOWN");
		StdDraw.text(55, 40, "D: RIGHT");
		StdDraw.text(55, 20, "SPACE: PAUSE/RESUME");
		StdDraw.text(55, 14, "ECHAP: EXIT");
		
		StdDraw.setPenColor(200, 200, 200);
		StdDraw.text(55, -4, "GO BACK");
		
		
		while(stop) {
			stop = true;
			while(StdDraw.mousePressed() == false) {
				if (StdDraw.mouseX()>60 && StdDraw.mouseX()<70 && StdDraw.mouseY()>-10 && StdDraw.mouseY()<0) {
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledRectangle(55, -4, 50, 50);
					System.out.println("T'es dedans !");
					
				} else {
					
					
				}
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) {
				stop = false;
			}
			StdDraw.show(20);
		}
			
		
		
		
		
		
		
		return stop;
	}
	
	public static int checkWinLoose(Graine [][] tab_graines, Joueur...joueurs)
	{
		int fin = 0, compteur = 0, compteur2 = 0;
		
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
			if(joueurs[a].getVie() <= 0)
			{
				compteur2++;
				joueurs[a].setVivant(false);
			}
		}
		if(compteur2 == joueurs.length)
		{
			fin = 2; //loose
		}
		
		return fin;
	}
	
	public static boolean affichageFin(int fin)
	{
		Font font = new Font("SHOWCARD GOTHIC", Font.BOLD, 40);
		StdDraw.setFont(font);
		boolean loop = true;
		boolean choixDuJoueur = true;
			if(fin == 1)
			{
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.text(52, 77, "WIN");
			}
			else
			{
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.text(53, 77, "GAME OVER");
			}
			Font font2 = new Font("SHOWCARD GOTHIC", Font.BOLD, 20);
			StdDraw.setFont(font2);
			StdDraw.setPenColor(StdDraw.GRAY);
			while(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) != true)
			{
				StdDraw.text(54, 67, "(PRESS SPACE TO CONTINUE)");
				StdDraw.show(20);
			}
			StdDraw.clear(StdDraw.BLACK);
		while(loop)
		{
			if(StdDraw.mouseX() > 21.5 && StdDraw.mouseX() < 51.5 && StdDraw.mouseY() > 64 && StdDraw.mouseY() < 74)
			{
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
				if(Jeu.correctionBugClic)
				{
					if(StdDraw.mousePressed())
					{
						loop = false;
						choixDuJoueur = false; 
					}
				}
				else
				{
					if(StdDraw.mousePressed() == false)
					{
						loop = false;
						choixDuJoueur = false;
						Jeu.correctionBugClic = true;
					}
				}
			}
			else
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledRectangle(36.5, 64, 15, 5);
			}
			if(StdDraw.mouseX() > 56.5 && StdDraw.mouseX() < 86.5 && StdDraw.mouseY() > 64 && StdDraw.mouseY() < 74)
			{
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.filledRectangle(71.5, 64, 15, 5);
				if(Jeu.correctionBugClic)
				{
					if(StdDraw.mousePressed())
					{
						loop = false;
						choixDuJoueur = true; 
					}
				}
				else
				{
					if(StdDraw.mousePressed() == false)
					{
						loop = false;
						choixDuJoueur = true;
						Jeu.correctionBugClic = true;
					}
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
			StdDraw.text(36, 62, "Rejouer");
			StdDraw.text(71, 62, "Quit");
			StdDraw.show(20);
		
		}
		return choixDuJoueur;
	}
}
