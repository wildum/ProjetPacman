import java.util.Random;

public class Fantome extends Personnage{
	
	protected int directionInverse = 1;
	
	public Fantome(double position_x,double position_y, double width, double speed, String color)
	{
		super(position_x,position_y, width, speed, color);
	}
	
	
	
	static Random rd = new Random(System.currentTimeMillis());
	
	//choix de la direction du fantome
	//elle prend en argument le labyrinthe pour le obstacles et le choix
	//le choix est gardé s'il n'y a pas d'obstacle, sinon on le change
	public int choixDirection(Labyrinthe Lab, int choix)
	{
	
			
		if(choix == 1 || choix == 3)
		{
			directionInverse = choix+1;
		}
		else
		{
			directionInverse = choix-1;
		}
		while(directionInverse == choix || Lab.checkMur(choix, this.position_x, this.position_y) == false) 
			{	
				this.speed = speed_init;
				choix = rd.nextInt(4)+1;
			}
		
		
	
		return choix;
		
	}

}
