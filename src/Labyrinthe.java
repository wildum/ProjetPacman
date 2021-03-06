import java.awt.Font;

import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdDraw;

public class Labyrinthe {
	
	private double diff = 0;
	private final int max_x = 100; // A ne pas changer
	private final int max_y = 100; // A ne pas changer
	private int f_graines = 4;
	private int ligne = 4, colonne = 4;
	private boolean setMinuteur = true;
	private double minuteur =0;
	private Mur [][] tab_murs= new Mur[28][31];
	boolean gettingStarted = true;
	private int lvl;
	Graine [][] tab_graines = new Graine[28][31];
	boolean dispo;
	Font normale = new Font("SHOWCARD GOTHIC", Font.BOLD, 20);
	int direction;
	
	
	String file = "Audio/Intro.wav";
	double [] sample = StdAudio.read(file);
	
	public int [][] matrice = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							   {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
							   {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
							   {0,9,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,9,0},
							   {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
							   {0,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,0},
							   {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
							   {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0},
							   {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
							   {0,0,0,0,0,0,1,0,0,0,0,0,2,0,0,2,0,0,0,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,0,0,0,2,0,0,2,0,0,0,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,2,2,2,2,2,2,2,2,2,2,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,2,0,0,0,4,4,0,0,0,2,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,2,0,2,2,2,2,2,2,0,2,0,0,1,0,0,0,0,0,0},
							   {7,2,2,2,2,2,1,2,2,2,0,2,2,2,2,2,2,0,2,2,2,1,2,2,2,2,2,8},
							   {0,0,0,0,0,0,1,0,0,2,0,2,2,2,2,2,2,0,2,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,2,2,2,2,2,2,2,2,2,2,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,2,0,0,0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0},
							   {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
							   {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
							   {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
							   {0,9,1,1,0,0,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,0,0,1,1,9,0},
							   {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
							   {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
							   {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
							   {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
							   {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
							   {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
							   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	
	/*
	 * Constructeur de la classe
Fixe la taille de la fenêtre à 500*760 pixels

	 */
	public Labyrinthe()
	{
		StdDraw.setCanvasSize(500,760); // pour gérer la taille de la fenêtre
		for(int i = 0; i < tab_murs.length;i++)
		{
			for(int j = 0; j<tab_murs[i].length;j++)
			{
				tab_murs[i][j] = new Mur(i*ligne, j*colonne,matrice[30-j][27-i]);
			}
		}
		
	}
	
	/*Gère tout l’affichage dans la fenêtre principale du jeu : elle affiche le terrain, les différents personnages, les graines, le niveau, les vies, le temps, les scores et le meilleur score
	Appelle les fonctions affichageFantome, affiche_graines (cf méthodes ci-dessous) et chgtImage (cf classe Pacman) pour changer les images des personnages en fonction de leur direction et du temps (pour le pacman)
	Joue la musique du pacman (du dossier Audio du projet) au lancement du jeu et au début de chaque niveau (grâce à la classe StdAudio de la librairie stdlib)
	*/
	public void affichage(Labyrinthe Lab,Graine [][] tab_graines,Chrono chrono, int level,Personnage... persos) //on peut ajouter autant de perso que l'on veut
	{
		StdDraw.setFont(normale);
		
		//affichage du terrain :
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); // pour placer les points ou on veut
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54.5,60,"Images/Terrain.jpg",115,127); // pour placer l'image (Paint)
		Lab.affiche_graines(tab_graines);
		StdDraw.setPenColor(StdDraw.WHITE);
		lvl = level+1;
		StdDraw.text(55, 139, "LEVEL: " + lvl);
		// affichage des vies, du chrono et du score :
		if (persos[0].getColor() == "y" && persos[1].getColor() == "g") { // s'il y a 2 joueurs
			double a = 24, b = 94;			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(10, -8, "LIVES P1 :"); // vies P1
			StdDraw.text(80, -8, "LIVES P2 :"); // vies P2
			
			chrono.pause();
			StdDraw.textLeft(-1.8, 134, "TIME : " + Math.round(chrono.getDureeSec()) + " s"); // Chrono
			chrono.resume();
			
			StdDraw.setPenColor(StdDraw.YELLOW);
			String score1 = Integer.toString(((Pacman)persos[0]).getJoueur().getScore());
			StdDraw.textLeft(-1.5, 125.5, "SCORE P1 : " + score1); // score P1
			StdDraw.setPenColor(50, 235, 70);
			String score2 = Integer.toString(((Pacman)persos[1]).getJoueur().getScore());
			StdDraw.textRight(109.5, 125.5, "SCORE P2 : " + score2); // score P2
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.textRight(109.5, 134, "HIGHSCORE : " + GestionDuJeu.getHighscore());// meilleur score
			
			for(int i = 0; i < ((Pacman)persos[0]).getJoueur().getVie(); i++) { 
				StdDraw.picture(a,-7,"Images/p_jaune_d.png", 5, 5);
				a=a+6.5;
			}
			
			for(int i = 0; i < ((Pacman)persos[1]).getJoueur().getVie(); i++) {
				StdDraw.picture(b,-7,"Images/p_vert_d.png", 5, 5);
				b=b+6.5;
			}
		} else { //S'il n'y en a qu'un seul
			double a = 17;
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(6, -8, "LIVES :"); // Vies joueur
			
			chrono.pause();
			StdDraw.textLeft(-1.8, 134, "TIME : " + Math.round(chrono.getDureeSec()) + " s"); // Chrono
			chrono.resume();
			String score = Integer.toString(((Pacman)persos[0]).getJoueur().getScore());
			StdDraw.textLeft(-1.5, 125.5, "SCORE : " + score); // score joueur
			
			StdDraw.textRight(109.5, 134, "HIGHSCORE : " + GestionDuJeu.getHighscore());// meilleur score
			
			for(int i = 0; i < ((Pacman)persos[0]).getJoueur().getVie(); i++) {
				StdDraw.picture(a,-7,"Images/p_jaune_d.png", 5, 5);
				a=a+6.5;
			}
		}
				
		//affichage des persos :
		for(int i = 0; i<persos.length;i++)
		{	
			//change de couleur le crayon suivant le personnage
			if(persos[i].color == "y" )
			{
				((Pacman)persos[i]).chgtImage(((Pacman)persos[i]).getDirection(), chrono);
			}
			if(persos[i].color == "g" )
			{
				((Pacman)persos[i]).chgtImage(((Pacman)persos[i]).getDirection(), chrono);
				
			}
			if(persos[i].color == "o")
			{
				affichageFantome((Fantome)persos[i], Lab);
			}
			if(persos[i].color == "p")
			{
				affichageFantome((Fantome)persos[i], Lab);
			}
			if(persos[i].color == "b")
			{
				affichageFantome((Fantome)persos[i], Lab);
			}
			if(persos[i].color == "r")
			{
				affichageFantome((Fantome)persos[i], Lab);
			}
			
		}
		
		if (gettingStarted) {
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.text(54, 51, "GET READY !");
			StdDraw.show(); 
			StdAudio.play(sample);
			gettingStarted = false;
		} 
		
		StdDraw.show(20);
	}

	/*
	 * Gère le changement d’image des fantômes en fonction de leur direction de déplacement et de leur état (standard ou apeuré)
Utilise les images présentes dans le dossier Images du projet

	 */
	
	public void affichageFantome(Fantome fantome, Labyrinthe Lab) {
		direction = fantome.getDirection();
		
		if(fantome.getEtat() == "standard")
		{
			switch (direction) {
			case 1:
				if (fantome.color == "o") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange_b.png", 5, 5);
				} else if (fantome.color == "p") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rose_b.png", 5, 5);
				} else if (fantome.color == "b") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_bleu_b.png", 5, 5);
				} else {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rouge_b.png", 5, 5);
				} 
				break;
			
			case 2:
				if (fantome.color == "o") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange_h.png", 5, 5);
				} else if (fantome.color == "p") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rose_h.png", 5, 5);
				} else if (fantome.color == "b") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_bleu_h.png", 5, 5);
				} else {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rouge_h.png", 5, 5);
				}
				break;
				
			case 3:
				if (fantome.color == "o") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange_g.png", 5, 5);
				} else if (fantome.color == "p") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rose_g.png", 5, 5);
				} else if (fantome.color == "b") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_bleu_g.png", 5, 5);
				} else {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rouge_g.png", 5, 5);
				}
				break;
				
			case 4:
				if (fantome.color == "o") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange_d.png", 5, 5);
				} else if (fantome.color == "p") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rose_d.png", 5, 5);
				} else if (fantome.color == "b") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_bleu_d.png", 5, 5);
				} else {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rouge_d.png", 5, 5);
				}
				break;
				
			default:
				if (fantome.color == "o") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange.png", 5, 5);
				} else if (fantome.color == "p") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rose.png", 5, 5);
				} else if (fantome.color == "b") {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_bleu.png", 5, 5);
				} else {
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rouge.png", 5, 5);
				}
				break;
			}
		}
		
		if(fantome.getEtat() == "apeure")
		{
			GestionDuJeu.getChrono().pause();
			if(setMinuteur)
			{
				minuteur = GestionDuJeu.getChrono().getDureeSec();
				setMinuteur = false;
			}
			diff = GestionDuJeu.getChrono().getDureeSec() - minuteur;
			switch (direction) {
			case 1:
				if(diff > 6)
				{
					if(diff < 6.4)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc.png", 5, 5);
					}
					else if(diff < 6.8)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu.png", 5, 5);
					}
					else if(diff < 7.2)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc.png", 5, 5);
					}
					else if(diff < 7.6)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu.png", 5, 5);
					}
					else
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc.png", 5, 5);
					}
				}
				else
				{
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu.png", 5, 5);
				}
				break;
			
			case 2:
				if(diff > 6)
				{
					if(diff < 6.4)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_h.png", 5, 5);
					}
					else if(diff < 6.8)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_h.png", 5, 5);
					}
					else if(diff < 7.2)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_h.png", 5, 5);
					}
					else if(diff < 7.6)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_h.png", 5, 5);
					}
					else
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_h.png", 5, 5);
					}
				}
				else
				{
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_h.png", 5, 5);
				}
				break;
				
			case 3:
				if(diff > 6)
				{
					if(diff < 6.4)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_g.png", 5, 5);
					}
					else if(diff < 6.8)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_g.png", 5, 5);
					}
					else if(diff < 7.2)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_g.png", 5, 5);
					}
					else if(diff < 7.6)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_g.png", 5, 5);
					}
					else
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_g.png", 5, 5);
					}
				}
				else
				{
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_g.png", 5, 5);
				}
				break;
				
			case 4:
				if(diff > 6)
				{
					if(diff < 6.4)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_d.png", 5, 5);
					}
					else if(diff < 6.8)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_d.png", 5, 5);
					}
					else if(diff < 7.2)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_d.png", 5, 5);
					}
					else if(diff < 7.6)
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_d.png", 5, 5);
					}
					else
					{
						StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ablanc_d.png", 5, 5);
					}
				}
				else
				{
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu_d.png", 5, 5);
				}
				break;
				
			default:
					StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_ableu.png", 5, 5);
				break;
			}
			GestionDuJeu.getChrono().resume();
		}
		
		if(fantome.getEtat() == "initial")
		{
			if (fantome.color == "o") {
				StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange.png", 5, 5);
			} else if (fantome.color == "p") {
				StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rose.png", 5, 5);
			} else if (fantome.color == "b") {
				StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_bleu.png", 5, 5);
			} else {
				StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_rouge.png", 5, 5);
			}
		}
	}
	
	/*
	 * Gère le déplacement des personnages dans le labyrinthe en vérifiant la présence de murs ou non
Permet également que tous les personnages soient sur les mêmes trajectoires et ne sortent pas du labyrinthe
Prend en argument la direction choisi par l’utilisateur/la direction du fantôme ainsi que les positions en x et en y du personnage

	 */
	public boolean checkMur(int choix, double pos_x, double pos_y)
	{	
		
		switch(choix){
		
		case 0:
			if( ligne <= pos_x && pos_x <= max_x-ligne && colonne <= pos_y && pos_y<= max_y-colonne) // check si la case est libre
			{
				return true;
			}
			else
			{
				return false;
			}
		
		case 1:
			if(pos_y> this.nextMur(pos_x,pos_y,1).hitbox_y2 && pos_x-ligne/2 - this.nextCase(pos_x,pos_y,1).hitbox_x2 == -6 && pos_x+ligne/2 - this.nextCase(pos_x,pos_y,1).hitbox_x1 == 6)
			{	 
				return true;
			}
			else //trop bas
			{
				return false;
			}
		case 2:
			if(pos_y < this.nextMur(pos_x,pos_y,2).hitbox_y1 && pos_x-ligne/2 - this.nextCase(pos_x,pos_y,2).hitbox_x2 == -6 && pos_x+ligne/2 - this.nextCase(pos_x,pos_y,2).hitbox_x1 == 6)
			{	
				return true;
			}
			else //trop haut
			{
				return false;
			}
		case 3:
			if(pos_x > this.nextMur(pos_x,pos_y,3).hitbox_x2 && pos_y-ligne/2 - this.nextCase(pos_x,pos_y,3).hitbox_y2 == -6 && pos_y+ligne/2 - this.nextCase(pos_x,pos_y,3).hitbox_y1 == 6)
			{	
				return true;
			}
			else //trop a gauche
			{
				return false;
			}
		case 4:
			if(pos_x < this.nextMur(pos_x,pos_y,4).hitbox_x1 && pos_y-ligne/2 - this.nextCase(pos_x,pos_y,4).hitbox_y2 == -6 && pos_y+ligne/2 - this.nextCase(pos_x,pos_y,4).hitbox_y1 == 6)
			{	
				return true;
			}
			else //trop a droite
			{
				return false;
			}
		}
		return false;
	}
	
	/*
	 * Méthode utilisée lors du débugage
Affiche des carrés bleus aux emplacement des murs de la matrice du jeu

	 */
	public void affiche_mur()
	{
	StdDraw.setPenColor(StdDraw.BLUE);
	for(int i = 0; i < tab_murs.length;i++)
	{
		for(int j = 0; j<tab_murs[i].length;j++)
		{
			if(tab_murs[i][j].getType() == 0)
			{
				StdDraw.filledRectangle(i*ligne, j*colonne, 2, 2);
			}
		}
	}
}
	/*
	 * Donne la localisation du mur le plus proche dans la direction que suit le personnage
Prend en argument les positions en x et y du personnage ainsi que son choix de direction
Renvoie un objet Mur indiquant la position du mur en question

	 */
	
	public Mur nextMur(double pos_x, double pos_y, int choix)
	{
		
		switch(choix){
		
		case 1:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 9)
			{
				pos_y--;
			}
			break;
		case 2:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 9)
			{
				pos_y++;
			}
			break;
		case 3:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 9)
			{
				pos_x--;
			}
			break;
		case 4:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 9)
			{
				pos_x++;
			}
			break;
		}
		return tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)];
	}
	
	/*
	 * Initialise la position des graines (= fromages) à leur état initial en prenant en compte la matrice du jeu 
La fonction parcours la matrice du jeu et initialise l’état des graines : si l’entier vaut 1, l’état de la graine est “standard” ; s’il vaut 9, l’état est “super” et s’il vaut 2, l’état est “null”
Renvoie un tableau 2D d’objets Graines initialisés

	 */
	public Graine [][] i_graines() 
	{
		
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{	
				if(tab_murs[i][j].getType() == 1)
				{
					tab_graines[i][j] = new Graine(i*ligne,j*colonne, "standard");
				}
				else if(tab_murs[i][j].getType() == 9)
				{
					tab_graines[i][j] = new Graine(i*ligne,j*colonne, "super");
				}
				else
				{
					tab_graines[i][j] = new Graine(i*ligne,j*colonne, "null");
				}
			}
		}
		
		return tab_graines;
	}
	/*
	 * Gère l’affichage des graines en fonction de leur initialisation dans la méthode i_graines
	 * Elle n’affiche que les graines qui ont pour type “standard” ou “super”. Lorsque le Pacman mange une graine et que le type de la graine devient “null”, 
	 * elle n’est plus affiché par cette méthode
	 */
	
	public void affiche_graines(Graine [][] tab_graines)
	{
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{
				if(tab_graines[i][j].type == "standard")
				{	
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledCircle(i*f_graines,j*f_graines,Graine.width);
				}
				if(tab_graines[i][j].type == "super")
				{	
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledCircle(i*f_graines,j*f_graines,Graine.width+0.8);
				}
			}
		}
	}
	/*
	 * Donne la case suivante selon la direction que suit le personnage
Prend en argument les positions en x et y du personnage ainsi que son choix de direction
Retourne un objet Mur indiquant le type de la case adjacente

	 */
	public Mur nextCase(double pos_x, double pos_y, int choix)
	{
		switch(choix){
		
		case 1:
			return tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)-1];
		case 2:
			return tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)+1];
		case 3:
			return tab_murs[(int) Math.round(pos_x/ligne)-1][(int) Math.round(pos_y/colonne)];
		default:
			return tab_murs[(int) Math.round(pos_x/ligne)+1][(int) Math.round(pos_y/colonne)];
		}
	}
	

	public int getMax_x()
	{
		return max_x;
	}
	
	public int getMax_y()
	{
		return max_y;
	}

	public void setSetMinuteur (boolean m)
	{
		this.setMinuteur = m;
	}
	
	public void setGettingStarted(boolean t)
	{
		this.gettingStarted = t;
	}
	
}
