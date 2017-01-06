import edu.princeton.cs.introcs.StdDraw;

public class Labyrinthe {
	
	protected final int max_x = 100; // A ne pas changer
	protected final int max_y = 100; // A ne pas changer
	protected int f_graines = 4;
	protected int ligne = 4, colonne = 4;
	
	public Labyrinthe()
	{
		StdDraw.setCanvasSize(350,700); // pour gérer la taille de la fenêtre
	}
	
	//cette méthode gère l'affichage du lab et des personnages
	public void affichage(Labyrinthe Lab,Graine [][] tab_graines ,Personnage... persos) //on peut ajouter autant de perso que l'on veut
	{
		
		//affichage du terrain
		StdDraw.setXscale(0,100);
		StdDraw.setYscale(-50,150); // pour placer les points ou on veut
		StdDraw.clear(StdDraw.DARK_GRAY);
		StdDraw.picture(50,50,"Terrain.jpg",100,145); // pour placer l'image (Paint)
		Lab.affiche_graines(tab_graines);
		
		//affichage des persos
		for(int i = 0; i<persos.length;i++)
		{	
			//change de couleur le crayon suivant le personnage
			if(persos[i].color == "y" )
			{
				StdDraw.setPenColor(StdDraw.YELLOW);
			}
			if(persos[i].color == "g" )
			{
				StdDraw.setPenColor(StdDraw.GREEN);
			}
			if(persos[i].color == "o" )
			{
				StdDraw.setPenColor(StdDraw.ORANGE);
			}
			if(persos[i].color == "p" )
			{
				StdDraw.setPenColor(StdDraw.PINK);
			}
			if(persos[i].color == "b" )
			{
				StdDraw.setPenColor(StdDraw.BLUE);
			}
			if(persos[i].color == "r" )
			{
				StdDraw.setPenColor(StdDraw.RED);
			}
			//effectue un cercle représentant le personnage à sa position
			StdDraw.filledCircle(persos[i].getPosx(),persos[i].getPosy(),persos[i].getWidth());
		}
		
		StdDraw.show(20);
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
			if(pos_y > colonne)
			{	
				return true;
			}
			else //trop bas
			{
				return false;
			}
		case 2:
			if(pos_y < max_y-colonne)
			{	
				return true;
			}
			else //trop haut
			{
				return false;
			}
		case 3:
			if(pos_x > ligne)
			{	
				return true;
			}
			else //trop a gauche
			{
				return false;
			}
		case 4:
			if(pos_x < max_x-ligne)
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
	
	//on initialise la position des graines
	//cette méthode prends en argument les personnages et utilise leur position
	public Graine [][] i_graines(Personnage... persos) 
	{
		Graine [][] tab_graines = new Graine[25][25];
		boolean dispo;
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{	
				dispo = false;
				if(this.checkMur(0,i*f_graines,j*f_graines)) // s'il n'y a pas de mur
				{
					for(int a = 0; a < persos.length;a++) //on parcourt l'ensemble des personnages
					{
						if(persos[a].getPosx() != i*f_graines || persos[a].getPosy() != j*f_graines)//on vérifie si la position est occupée
						{
							dispo = true; 
						}
					}
					
				}
				if(dispo) // pas de mur, pas de perso 
				{
					tab_graines[i][j] = new Graine(i*f_graines,j*f_graines,"standard"); // on ajoute une graine
				}
				else
				{
					tab_graines[i][j] = new Graine(i*f_graines,j*f_graines,"null"); // pas de graine sur cette position
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
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.filledCircle(i*f_graines,j*f_graines,Graine.width);

				}
			}
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
