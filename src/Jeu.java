import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdDraw;


//Ce programme a été réalisé par William DUMONT et Eliott DE SEGUIER en Janvier 2017

//cette classe ne doit contenir que la fonction main

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * =========================== DESCRIPTION DU FONCTIONNEMENT DE LA MAIN ======================== *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/*
La méthode  par initialiser les différentes variables et par créer la fenêtre. Juste après, nous entrons dans une boucle while regroupant le reste du programme. Sortir de cette boucle while, c’est quitter le jeu. 
Ensuite est affiché le menu principal via la méthode affichageMenuPage1 de la méthode GestionDuJeu qui va renvoyer un entier. Suivant la valeur de cet entier, nous allons soit commencer une partie (choix 1 pour un joueur, choix 2 pour deux joueurs), soit afficher le menu des scores (choix 3), soit afficher le menu des contrôles (choix 5) soit quitter le jeu (choix 4). 
Les choix 3, 4 et 5 faisant référence directement à l’utilisation des méthodes décrites dans la classe GestionDuJeu, nous allons nous concentrer sur les choix 1 et 2. Juste avant d’entrer dans la boucle while de la partie ; le labyrinthe, les fantômes, les Pacmans et les joueurs sont créés. 
Les graines sont initialisées dans le labyrinthe. Les actions suivantes tournent très rapidement en boucle : affichage de tous les éléments graphiques, choix des directions, déplacements des personnages (pacmans et fantômes, les méthodes appelées pour les fantômes dépendent de leurs états) et check des interactions entre Pacman, les graines et les fantômes. 
Dans cette boucle while, on vérifie si le joueur appuie sur « pause » et si le joueur gagne ou s’il perd. Si le joueur gagne, nous restons dans la boucle mais les positions des personnages sont réinitialisées et le labyrinthe est de nouveau rempli de graines. 
De plus, la difficulté augmente d’un cran avec l’appel de la méthode setDifficulty de la classe GestionDuJeu. 
Lorsque le joueur perd, il sort de la boucle et est invité à sauvegarder son score via la méthode getHighscore. Lorsque le joueur a fini de sauvegarder son score et de consulter le tableau des scores, il est renvoyé au menu principal.
 */


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
		boolean enableSwitch = false;
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
					enableSwitch = GestionDuJeu.setDifficulty(level, FantomeRouge, FantomeRose, FantomeBleu, FantomeOrange);
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
					
					J1.setVivant(true);
					J2.setVivant(true);
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
					if(StdDraw.isKeyPressed(KeyEvent.VK_P))
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
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(),level, Pac1, Pac2, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
							GestionDuJeu.getChrono().resume();
							boucle1 = false;
						} else {
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(),level, Pac1, Pac2, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
						}
						fin = GestionDuJeu.checkWinLoose(graines, J1, J2);
						
					}
					else
					{
						Pac1.interraction(graines,Lab ,FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
						
						//switch l'etat des fantomes
						if(enableSwitch)
						GestionDuJeu.switchComportementFantome(Pac1, FantomeRose, FantomeOrange, FantomeBleu, FantomeRouge);
						
						if (boucle1) {
							GestionDuJeu.getChrono().pause();
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(),level, Pac1, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
							GestionDuJeu.getChrono().resume();
							boucle1 = false;
						} else {
							Lab.affichage(Lab, graines, GestionDuJeu.getChrono(),level, Pac1, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
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
						keepPlaying = true;
						nePasRejouer = false;
						level++;
						Lab.setGettingStarted(true);
						int bonusChrono = 0;
						if(GestionDuJeu.getChrono().getDureeSec() < 60 && fin == 1)
							bonusChrono = 400;
						else if(GestionDuJeu.getChrono().getDureeSec() < 90 && fin == 1)
							bonusChrono = 400;
						else
							bonusChrono = 0;
						if(choixApresMenu1 == 2)
						{
							J1.setScore(J1.getScore() + J1.getVie()*200 + bonusChrono);
							J2.setScore(J2.getScore() + J2.getVie()*200 + bonusChrono);
						}
						else
						{
							J1.setScore(J1.getScore() + J1.getVie()*200 + bonusChrono);
						}
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
