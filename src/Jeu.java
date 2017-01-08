

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

//cette classe ne doit contenir que la fonction main
public class Jeu {

	public static void main(String[] args) {
		
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * ======================================= INITILISATION ======================================= *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		boolean keepPlaying = true;
		int choixP1 = 0, choixP2 = 0, choixF1 = 1, choixF2 = 2, choixF3 = 3, choixF4 = 3;
		
		// Init labyrinthe :
		Labyrinthe Lab = new Labyrinthe(); //Labyrinthe de taille 500x760
		
		// Init Joueur(s) :
		Joueur J1 = new Joueur(); 
		Joueur J2 = new Joueur();
		
		// Init Pacman(s)
		Pacman Pac1 = new Pacman(54, 28, 2.5, 0.5, "y",J1); //(pos_x, pos_y, largeur, vitesse, couleur)
		Pacman Pac2 = new Pacman(54,100, 2.5, 0.5, "g",J2);
						
		// Init Fantômes :
		Fantome FantomeRouge = new Fantome(54, 76, 2.5, 0.5, "r"); // déjà dehors
		Fantome FantomeRose = new Fantome(54, 64, 2.5, 0.5, "p"); // 2e à sortir (au lancement du jeu)
		Fantome FantomeBleu = new Fantome(46, 64, 2.5, 0.5, "b"); // 3e à sortir (après 4 secondes de jeu)
		Fantome FantomeOrange = new Fantome(62, 64, 2.5, 0.5, "o"); // 4e à sortir (après 8 secondes de jeu)
		
		
		Graine [][] graines; 
		
		graines = Lab.i_graines();
		
		
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * ============================================ BOUCLE ============================================= *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		int choixApresMenu1 = GestionDuJeu.affichageMenuPage1();
		GestionDuJeu.getChrono().start(); // on lance le chrono du jeu
		do
		{
			// affichage du menu pause si la touche ECHAP est pressée :
			if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE))
			{
				GestionDuJeu.getChrono().pause(); // on met le chrono en pause pour qu'il ne continue pas le temps de la pause
				keepPlaying = GestionDuJeu.affichageMenuPause();
				GestionDuJeu.getChrono().resume(); // on fait repartir le chrono
			}
			
			
			
			// affiche le lab et les personnages :
			if(choixApresMenu1 == 2)
			{
				Pac1.interraction(graines, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
				Pac2.interraction(graines, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
				Lab.affichage(Lab, graines, GestionDuJeu.getChrono(), Pac1, Pac2, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
				
			}
			else
			{
				Pac1.interraction(graines, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
				Lab.affichage(Lab, graines, GestionDuJeu.getChrono(), Pac1, FantomeRose, FantomeBleu, FantomeRouge, FantomeOrange);
				
			}
			
			choixP1 = Pac1.choixDeLaDirectionP1(choixP1); //choix direction avec les touches zqsd
			Pac1.deplacer(Lab, choixP1); //deplace le personnage, renvoie false si E a été pressé
			
			if(choixApresMenu1 == 2)
			{
				choixP2 = Pac2.choixDeLaDirectionP2(choixP2);
				Pac2.deplacer(Lab, choixP2);
			}
			
			
			
			choixF1 = FantomeRose.choixDirection(Lab, choixF1); //choix de la direction random
			FantomeRose.deplacer(Lab, choixF1); 
		
			choixF2 = FantomeBleu.choixDirection(Lab, choixF2);
			FantomeBleu.deplacer(Lab, choixF2);
			
			choixF3 = FantomeRouge.choixDirection(Lab, choixF3);
			FantomeRouge.deplacer(Lab, choixF3);
			
			choixF4 = FantomeOrange.choixDirection(Lab, choixF4);
			FantomeOrange.deplacer(Lab, choixF4);
			
		
		} while(keepPlaying); //on sort de la boucle lorsque E est pressé
		GestionDuJeu.getChrono().stop();
	}

}
