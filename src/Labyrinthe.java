import java.awt.Font;
import edu.princeton.cs.introcs.StdDraw;

public class Labyrinthe {
	
	private final int max_x = 100; // A ne pas changer
	private final int max_y = 100; // A ne pas changer
	private int f_graines = 4;
	private int ligne = 4, colonne = 4;
	private Mur [][] tab_murs= new Mur[28][31];
	public int [][] matrice = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							   {0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
							   {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
							   {0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
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
							   {0,1,1,1,0,0,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,0,0,1,1,1,0},
							   {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
							   {0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
							   {0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
							   {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
							   {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
							   {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
							   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
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
	
	//cette méthode gère l'affichage du lab et des personnages :
	public void affichage(Labyrinthe Lab,Graine [][] tab_graines,Chrono chrono,Personnage... persos) //on peut ajouter autant de perso que l'on veut
	{
		Font font = new Font("SHOWCARD GOTHIC", Font.BOLD, 20);
		StdDraw.setFont(font);
		
		//affichage du terrain :
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); // pour placer les points ou on veut
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54.5,60,"Images/Terrain.jpg",115,127); // pour placer l'image (Paint)
		Lab.affiche_graines(tab_graines);
		
		
		// affichage des vies, du chrono et du score :
		if (persos[0].getColor() == "y" && persos[1].getColor() == "g") { // s'il y a 2 joueurs
			double a = 24, b = 94;			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(10, -8, "LIVES P1 :"); // vies P1
			StdDraw.text(80, -8, "LIVES P2 :"); // vies P2
			
			chrono.pause();
			StdDraw.textLeft(-1.8, 135, "TIME : " + chrono.getDureeMs()/1000 + " s"); // Chrono
			chrono.resume();
			
			StdDraw.setPenColor(StdDraw.YELLOW);
			String score1 = Integer.toString(((Pacman)persos[0]).getJoueur().getScore());
			StdDraw.textLeft(-1.5, 125.5, "SCORE P1 : " + score1); // score P1
			StdDraw.setPenColor(StdDraw.GREEN);
			String score2 = Integer.toString(((Pacman)persos[1]).getJoueur().getScore());
			StdDraw.textRight(109.5, 125.5, "SCORE P2 : " + score2); // score P2
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.textRight(109.5, 135, "HIGHSCORE : " + "00000");// meilleur score
			
			StdDraw.setPenColor(StdDraw.YELLOW);
			for(int i = 0; i < ((Pacman)persos[0]).getJoueur().getVie(); i++) { 
				StdDraw.filledCircle(a,-7,2.5);
				a=a+6.5;
			}
			StdDraw.setPenColor(StdDraw.GREEN);
			for(int i = 0; i < ((Pacman)persos[1]).getJoueur().getVie(); i++) {
				StdDraw.filledCircle(b,-7,2.5);
				b=b+6.5;
			}
		} else { //S'il n'y en a qu'un seul
			double a = 17;
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(6, -8, "LIVES :"); // Vies joueur
			
			chrono.pause();
			StdDraw.textLeft(-1.8, 135, "TIME : " + chrono.getDureeMs()/1000 + " s"); // Chrono
			chrono.resume();
			
			String score = Integer.toString(((Pacman)persos[0]).getJoueur().getScore());
			StdDraw.textLeft(-1.5, 125.5, "SCORE : " + score); // score joueur
			
			StdDraw.textRight(109.5, 135, "HIGHSCORE : " + GestionDuJeu.getHighscore());// meilleur score
			
			StdDraw.setPenColor(StdDraw.YELLOW);
			for(int i = 0; i < ((Pacman)persos[0]).getJoueur().getVie(); i++) {
				StdDraw.filledCircle(a,-7,2.5);
				a=a+6.5;
			}
		}
				
		//affichage des persos :
		for(int i = 0; i<persos.length;i++)
		{	
			//change de couleur le crayon suivant le personnage
			if(persos[i].color == "y" )
			{
				affichagePacman((Pacman)persos[i], Lab);
			}
			if(persos[i].color == "g" )
			{
				affichagePacman((Pacman)persos[i], Lab);
				
			}
			if(persos[i].color == "o" )
			{
				//StdDraw.setPenColor(StdDraw.ORANGE);
				//StdDraw.picture(persos[i].getPosx(),persos[i].getPosy(),"Images/forange.jpg", 5, 5);
				affichageFantome((Fantome)persos[i], Lab);
			}
			if(persos[i].color == "p" )
			{
				StdDraw.setPenColor(StdDraw.PINK);
				StdDraw.picture(persos[i].getPosx(),persos[i].getPosy(),"Images/frose.jpg", 5, 5);
			}
			if(persos[i].color == "b" )
			{
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.picture(persos[i].getPosx(),persos[i].getPosy(),"Images/fbleu.jpg", 5, 5);
				
			}
			if(persos[i].color == "r" )
			{
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.picture(persos[i].getPosx(),persos[i].getPosy(),"Images/frouge.jpg", 5, 5);
			}
			
		}
		
		StdDraw.show(20);
	}
	
	public void affichagePacman(Pacman pac, Labyrinthe Lab) {
		int direction = pac.getDirection();
		
		switch (direction) {
			case 1:
				if (pac.color == "y") {
						StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_jaune_b.png", 5, 5);
				} else {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_vert_b.png", 5, 5);
				}
				break;
			
			case 2:
				if (pac.color == "y") {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_jaune_h.png", 5, 5);
				} else {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_vert_h.png", 5, 5);
				}
				break;
				
			case 3:
				if (pac.color == "y") {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_jaune_g.png", 5, 5);
				} else {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_vert_g.png", 5, 5);
				}
				break;
				
			case 4:
				if (pac.color == "y") {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_jaune_d.png", 5, 5);
				} else {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_vert_d.png", 5, 5);
				}
				break;
				
			default:
				if (pac.color == "y") {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_jaune.png", 5, 5);
				} else {
					StdDraw.picture(pac.getPosx(),pac.getPosy(),"Images/p_vert.png", 5, 5);
				}
				break;
		}
		
		/*if (direction == 1 && Lab.checkMur(direction,pac1.position_x,pac1.position_y)) {
			StdDraw.picture(pac1.getPosx(),pac1.getPosy(),"Images/p_jaune_b.png", 5, 5);
		} else if (direction == 2 && Lab.checkMur(direction,pac1.position_x,pac1.position_y)) {
			StdDraw.picture(pac1.getPosx(),pac1.getPosy(),"Images/p_jaune_h.png", 5, 5);
		} else if (direction == 3 && Lab.checkMur(direction,pac1.position_x,pac1.position_y)) {
			StdDraw.picture(pac1.getPosx(),pac1.getPosy(),"Images/p_jaune_g.png", 5, 5);
		} else if (direction == 4 && Lab.checkMur(direction,pac1.position_x,pac1.position_y)) {
			StdDraw.picture(pac1.getPosx(),pac1.getPosy(),"Images/p_jaune_d.png", 5, 5);
		} else {
			StdDraw.picture(pac1.getPosx(),pac1.getPosy(),"Images/p_jaune.png", 5, 5);
		}*/
		
	}

	public void affichageFantome(Fantome fantome, Labyrinthe Lab) {
		int direction = fantome.getDirection();
		
		switch (direction) {
		case 1:
				StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f-orange_b.png", 5, 5);
			break;
		
		case 2:
			StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange_h.png", 5, 5);
			break;
			
		case 3:
			StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange_g.png", 5, 5);
			break;
			
		case 4:
			StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange_d.png", 5, 5);
			break;
			
		default:
			StdDraw.picture(fantome.getPosx(),fantome.getPosy(),"Images/f_orange.png", 5, 5);
			break;
	}
	}
	
	//on vérifie que la direction choisie est correcte (qu'il n'y a pas d'obstacle)
	//elle prend en argument la direction choisie et la position du personnage 
	//méthode a améliorer -> mettre les murs
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
	
	
	public Mur nextMur(double pos_x, double pos_y, int choix)
	{
		
		switch(choix){
		
		case 1:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2)
			{
				pos_y--;
			}
			break;
		case 2:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2)
			{
				pos_y++;
			}
			break;
		case 3:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2)
			{
				pos_x--;
			}
			break;
		case 4:
			while(tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 1 || tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)].getType() == 2)
			{
				pos_x++;
			}
			break;
		}
		return tab_murs[(int) Math.round(pos_x/ligne)][(int) Math.round(pos_y/colonne)];
	}
	
	//on initialise la position des graines
	//cette méthode prends en argument les personnages et utilise leur position
	public Graine [][] i_graines() 
	{
		Graine [][] tab_graines = new Graine[28][31];
		boolean dispo;
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{	
				if(tab_murs[i][j].getType() == 1)
				{
					tab_graines[i][j] = new Graine(i*ligne,j*colonne, "standard");
				}
				else
				{
					tab_graines[i][j] = new Graine(i*ligne,j*colonne, "null");
				}
			}
		}
		
		return tab_graines;
	}
	
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
			}
		}
	}
	
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

	
}
