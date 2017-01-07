import edu.princeton.cs.introcs.StdDraw;

public class Labyrinthe {
	
	private final int max_x = 100; // A ne pas changer
	private final int max_y = 100; // A ne pas changer
	private int f_graines = 4;
	private int ligne = 4, colonne = 4;
	private Mur [][] tab_murs= new Mur[28][31];
	
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
	
	//cette méthode gère l'affichage du lab et des personnages
	public void affichage(Labyrinthe Lab,Graine [][] tab_graines ,Personnage... persos) //on peut ajouter autant de perso que l'on veut
	{
		
		//affichage du terrain
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); // pour placer les points ou on veut
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54.5,60,"Terrain.jpg",115,127); // pour placer l'image (Paint)
		Lab.affiche_graines(tab_graines);
		//Lab.affiche_mur();
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
	public int [][] matrice =
			
			{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
			{0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
			{0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
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
			{0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0},
			{0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
			{0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0},
			{0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	

	
}
