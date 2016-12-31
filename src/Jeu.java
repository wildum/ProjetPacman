import edu.princeton.cs.introcs.StdDraw;

//cette classe ne doit contenir que la fonction main
public class Jeu {

	public static void main(String[] args) {
		
		boolean keepPlaying = true, player2;
		int choixP1 = 0, choixP2 = 0, choixF1 = 1, choixF2 = 2, choixF3 = 3;
		player2 = GestionDuJeu.affichage(); //propose l'ajout d'un 2nd joueur et affiche le menu
		Labyrinthe Lab = new Labyrinthe(100,100); //Labyrinthe de taille 100x100
		Pacman Pac = new Pacman(10,10, 2, 0.5 , "y"); //(pos_x, pos_y, largeur, vitesse, couleur)
		Pacman Pac2 = new Pacman(60,60, 2, 0.5, "g");
		Fantome FantomeRose = new Fantome(50,10, 2, 0.5 , "p");
		Fantome FantomeBleu = new Fantome(10,50, 2, 0.5, "b");
		Fantome FantomeRouge = new Fantome(40,40, 2, 0.5, "r");
		
		
		
		
		do
		{
			// affiche le lab et les personnages
			if(player2)
			{
				Lab.affichage(Lab, Pac, Pac2, FantomeRose, FantomeBleu, FantomeRouge);
			}
			else
			{
				Lab.affichage(Lab, Pac, FantomeRose, FantomeBleu, FantomeRouge);
			}
			
			choixP1 = Pac.choixDeLaDirectionP1(choixP1); //choix direction avec les touches zqsd
			keepPlaying = Pac.deplacer(Lab, choixP1); //deplace le personnage, renvoie false si E a été pressé
			
			if(player2)
			{
				choixP2 = Pac2.choixDeLaDirectionP2(choixP2);
				keepPlaying = Pac2.deplacer(Lab, choixP2);
			}
			
			choixF1 = FantomeRose.choixDirection(Lab, choixF1); //choix de la direction random
			FantomeRose.deplacer(Lab, choixF1); 
		
			choixF2 = FantomeBleu.choixDirection(Lab, choixF2);
			FantomeBleu.deplacer(Lab, choixF2);
			
			choixF3 = FantomeRouge.choixDirection(Lab, choixF3);
			FantomeRouge.deplacer(Lab, choixF3);
			
			
		
		} while(keepPlaying); //on sort de la boucle lorsque E est pressé

	}

}
