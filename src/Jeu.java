import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdDraw;

//cette classe ne doit contenir que la fonction main
public class Jeu {
	
	public static void main(String[] args) {
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * ======================================= INITILISATION ======================================= *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		boolean keepPlaying = true; 
		boolean resterDansLeJeu = true;
		boolean nePasRejouer = true;
		boolean affichageFin = true; 
		boolean nextLevel = true;
		int fin = 0, choixApresMenu1 = 0;
		int choixP1 = 0, choixP2 = 0, choixF1 = 1, choixF2 = 2, choixF3 = 3, choixF4 = 3;
		int level = 0;
		
		Graine [][] graines; 
		StdDraw.setCanvasSize(500,760);
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); 
		
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * ============================================ BOUCLE ============================================= *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		while(resterDansLeJeu)
		{
			if(nePasRejouer)
			{
				choixApresMenu1 = GestionDuJeu.affichageMenuPage1();
				level = 0;
				nextLevel = true;
			}
			keepPlaying = true;
			affichageFin = true;
			 
			// Init labyrinthe :
			Labyrinthe Lab = new Labyrinthe(); //Labyrinthe de taille 500x760
			
			// Init Joueur(s) :
			Joueur J1 = new Joueur(); 
			Joueur J2 = new Joueur();
			
			// Init Pacman(s)
			Pacman Pac1 = new Pacman(54, 28, 2.5, 0.5, "y",J1); //(pos_x, pos_y, largeur, vitesse, couleur)
			Pacman Pac2 = new Pacman(54, 100, 2.5, 0.5, "g",J2);
							
			// Init Fantômes :
			Fantome FantomeRouge = new Fantome(54, 76, 2.5, 0.5, "r", "random"); // déjà dehors
			Fantome FantomeRose = new Fantome(54, 64, 2.5, 0.5, "p", "random"); // 2e à sortir (au lancement du jeu)
			Fantome FantomeBleu = new Fantome(46, 64, 2.5, 0.5, "b", "random"); // 3e à sortir (après 4 secondes de jeu)
			Fantome FantomeOrange = new Fantome(62, 64, 2.5, 0.5, "o", "random"); // 4e à sortir (après 8 secondes de jeu)
			
			
			while(nextLevel)
			{
				if(level > 0)
				{
					GestionDuJeu.setDifficulty(level, FantomeRouge, FantomeRose, FantomeBleu, FantomeOrange);
					GestionDuJeu.getChrono().start();
					FantomeRouge.reset();
					FantomeRose.reset();
					FantomeBleu.reset();
					FantomeOrange.reset();
					Pac1.reset();
					Pac2.reset();
					if(J1.getVie() < 3)
					J1.setVie(J1.getVie()+1);
					if(J2.getVie() < 3)
					J2.setVie(J2.getVie()+1);
				}
				
				// Init graines : 
				graines = Lab.i_graines();
					
				boolean boucle1 = true;
				
				
				if(choixApresMenu1 == 3)
				{
					GestionDuJeu.highscores(false, false, 0);
					nextLevel = false;
				}
				
				if (choixApresMenu1 == 5)
				{
					GestionDuJeu.affichageMenuControl();
					nextLevel = false;
				}
				
				
				if(choixApresMenu1 == 1 || choixApresMenu1 == 2)
				{
					GestionDuJeu.getChrono().start(); // on lance le chrono du jeu
				do
				{
					// affichage du menu pause si la touche Espace est pressée :
					if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE))
					{
						GestionDuJeu.getChrono().pause(); // on met le chrono en pause pour qu'il ne continue pas le temps de la pause
						StdDraw.pause(300);
						keepPlaying = GestionDuJeu.affichageMenuPause();
						if(keepPlaying == false)
						{
							affichageFin = false;
							nextLevel = false;
							nePasRejouer = true;
						}
						StdDraw.pause(300);
						GestionDuJeu.getChrono().resume(); // on fait repartir le chrono
					}
					
					
					// affiche le lab et les personnages :
					if(choixApresMenu1 == 2)
					{
						Pac1.interraction(graines,Lab ,FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
						Pac2.interraction(graines,Lab ,FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
						if (boucle1) {
							GestionDuJeu.getChrono().pause();
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(), Pac1, Pac2, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
							GestionDuJeu.getChrono().resume();
							boucle1 = false;
						} else {
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(), Pac1, Pac2, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
						}
						fin = GestionDuJeu.checkWinLoose(graines, J1, J2);
						
					}
					else
					{
						Pac1.interraction(graines,Lab ,FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
						
						//switch l'etat des fantomes
						//Lab.switchComportementFantome(Pac1, FantomeRose, FantomeOrange, FantomeBleu, FantomeRouge);
						
						if (boucle1) {
							GestionDuJeu.getChrono().pause();
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(), Pac1, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
							GestionDuJeu.getChrono().resume();
							boucle1 = false;
						} else {
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(), Pac1, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
						}
						fin = GestionDuJeu.checkWinLoose(graines, J1);
					}
					
					choixP1 = Pac1.choixDeLaDirectionP1(choixP1); //choix direction avec les touches zqsd
					Pac1.deplacer(Lab, choixP1); //deplace le personnage, renvoie false si E a été pressé
	
					if(choixApresMenu1 == 2)
					{
						choixP2 = Pac2.choixDeLaDirectionP2(choixP2);
						Pac2.deplacer(Lab, choixP2);
					}
					//etat initial des fantômes
					GestionDuJeu.getChrono().pause();
					if(FantomeRose.getEtat().equals("initial"))
					{
						FantomeRose.transitionBox();
					}
					if(FantomeBleu.getEtat().equals("initial"))
					{
						FantomeBleu.transitionBox();
					}
					if(FantomeRouge.getEtat().equals("initial"))
					{
						FantomeRouge.transitionBox();
					}
					if(FantomeOrange.getEtat().equals("initial"))
					{
						FantomeOrange.transitionBox();
					}
					GestionDuJeu.getChrono().resume();
					
					
					
					
					//etat normal des fantomes
					if(FantomeRose.getEtat().equals("standard") || FantomeRose.getEtat().equals("apeure"))
					{
						if(choixApresMenu1 == 2)
						{
							choixF1 = FantomeRose.choixDirection(Lab, choixF1,Pac1,Pac2); 
						}
						else
						{
							choixF1 = FantomeRose.choixDirection(Lab, choixF1,Pac1);
						}
						FantomeRose.deplacer(Lab, choixF1); 
					}
					if(FantomeBleu.getEtat().equals("standard") || FantomeBleu.getEtat().equals("apeure"))
					{
						if(choixApresMenu1 == 2)
						{
							choixF2 = FantomeBleu.choixDirection(Lab, choixF2,Pac1,Pac2);
						}
						else
						{
							choixF2 = FantomeBleu.choixDirection(Lab, choixF2,Pac1);
						}
						FantomeBleu.deplacer(Lab, choixF2);
					}
					if(FantomeRouge.getEtat().equals("standard") || FantomeRouge.getEtat().equals("apeure"))
					{
						if(choixApresMenu1 == 2)
						{
							choixF3 = FantomeRouge.choixDirection(Lab, choixF3,Pac1,Pac2);
						}
						else
						{
							choixF3 = FantomeRouge.choixDirection(Lab, choixF3,Pac1);
						}
						FantomeRouge.deplacer(Lab, choixF3);
					}
					if(FantomeOrange.getEtat().equals("standard") || FantomeOrange.getEtat().equals("apeure"))
					{
						if(choixApresMenu1 == 2)
						{
							choixF4 = FantomeOrange.choixDirection(Lab, choixF4,Pac1,Pac2);
						}
						else
						{
							choixF4 = FantomeOrange.choixDirection(Lab, choixF4,Pac1);
						}
						FantomeOrange.deplacer(Lab, choixF4);
					}
					
					if(fin == 1 || fin == 2)
					{
						keepPlaying = false;
					}
				
				} while(keepPlaying); 
				GestionDuJeu.getChrono().stop();
				if(affichageFin)
				{
					nePasRejouer = GestionDuJeu.affichageFin(fin);
					if(fin == 2)
					{
						if(choixApresMenu1 == 2)
						{
							GestionDuJeu.highscores(true, true, fin, J1, J2);
						}
						else
						{
							GestionDuJeu.highscores(true, false, fin, J1);
						}
						nextLevel = false;
					}
					else
					{
						nePasRejouer = false;
						level++;
						StdDraw.setXscale(-2,110);
						StdDraw.setYscale(-27,149);
						StdDraw.clear(StdDraw.BLACK);
						nextLevel = true;
					}
				}
				else
				{
					affichageFin = false;
				}
	
			}
			}
			
			if(choixApresMenu1 == 4)
			{
				resterDansLeJeu = false;
			}
			}
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149);
		StdDraw.clear(StdDraw.BLACK);
	}
	

}
