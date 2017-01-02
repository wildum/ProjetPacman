import edu.princeton.cs.introcs.StdDraw;

public class Labyrinthe {
	
	protected int max_x;
	protected int max_y;
	
	public Labyrinthe(int max_x, int max_y)
	{
		this.max_x = max_x;
		this.max_y = max_y;
	}
	
	//cette méthode gère l'affichage du lab et des personnages
	public void affichage(Labyrinthe Lab, Personnage... persos) //on peut ajouter autant de perso que l'on veut
	{
		
		//affichage du terrain
		StdDraw.setXscale(0,Lab.getMax_x());
		StdDraw.setYscale(0,Lab.getMax_y());
		StdDraw.clear(StdDraw.GRAY); 
		
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
		
		case 1:
			if(pos_y > 4)
			{	
				return true;
			}
			else //trop bas
			{
				return false;
			}
		case 2:
			if(pos_y < max_y-4)
			{	
				return true;
			}
			else //trop haut
			{
				return false;
			}
		case 3:
			if(pos_x > 4)
			{	
				return true;
			}
			else //trop a gauche
			{
				return false;
			}
		case 4:
			if(pos_x < max_x-4)
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
	
	
	public int getMax_x()
	{
		return max_x;
	}
	
	public int getMax_y()
	{
		return max_y;
	}
	
}
