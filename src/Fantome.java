import java.util.Random;

public class Fantome extends Personnage{
	
	protected int directionInverse = 1;
	
	public Fantome(double position_x,double position_y, double width, double speed, String color)
	{
		super(position_x,position_y, width, speed, color);
	}
	
	
	
	static Random rd = new Random(System.currentTimeMillis());
	
	//choix de la direction du fantome
	//elle prend en argumente le labyrinthe pour le obstacles et le choix
	//le choix est gardé s'il n'y a pas d'obstacle, sinon on le change
	public int choixDirection(Labyrinthe Lab, int choix)
	{
		if(Lab.checkMur(choix, this.position_x, this.position_y) == false) //il y a un obstacle, la direction n'est plus bonne
		{
			
			int directionPrecedente = choix; 
			
			//on ne veut pas que le fantome puisse choisir de nouveau la même direction ou qu'il fasse demi-tour
			while(directionPrecedente == choix || directionInverse == choix) 
			{	
				this.speed = speed_init;
				choix = rd.nextInt(4)+1;
			}
		
		}
		
		//le fantome avance, on peut donc donner une valeur a directionInverse pour pas que le fantome fasse demi-tour
		//on ne change pas la direction précédente car elle est touche bonne
		else
		{
			
			if(choix == 1 || choix == 3)
			{
				directionInverse = choix+1;
			}
			else
			{
				directionInverse = choix-1;
			}
		}
		
		return choix;
		
	}

}
