import edu.princeton.cs.introcs.StdDraw;

public class Personnage {
	
	protected double width, speed, speed_init, position_x, position_y;
	protected String color;
	
	public Personnage(double position_x,double position_y, double width, double speed, String color)
	{
		this.width = width;
		this.speed = speed; //vitesse actuelle du personnage
		this.speed_init = speed; //vitesse de base du personnage
		this.color = color;
		this.position_x = position_x;
		this.position_y = position_y;
	}
	
	//cette méthode déplace les personnages dans le labyrinthe
	//elle prend en argument le Labyrinthe et le la direction choisie
	//elle renvoie false si le joueur a décidé d'arrêter de jouer, true sinon
	public boolean deplacer(Labyrinthe Lab, int choix)
	{
		switch(choix){
			
			case 1:
				if(Lab.checkMur(choix,this.position_x,this.position_y)) //on verifie qu'il n'y a pas d'obstacle
				{	
					this.position_y -= speed; //pas d'obstacle -> on avance
				}
				else
				{
					this.speed = 0; //obstacle -> on met la vitesse actuelle a 0
				}
				break;
				
			case 2:
				if(Lab.checkMur(choix,this.position_x,this.position_y))
				{	
					this.position_y += speed;
				}
				else
				{
					this.speed = 0;
				}
				break;
			case 3:
				if(Lab.checkMur(choix,this.position_x,this.position_y))
				{
					this.position_x -= speed;
				}
				else
				{
					this.speed = 0;
				}
				break;
			case 4:
				if(Lab.checkMur(choix,this.position_x,this.position_y))
				{
					this.position_x += speed;
				}
				else
				{
					this.speed = 0;
				}
				break;
			case 5:
				return false; //E a été choisi
			
			default:
				break;
		}
		return true;
				
	}
	
	
	public double getWidth()
	{
		return this.width;
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public double getPosx()
	{
		return this.position_x;
	}
	
	public double getPosy()
	{
		return this.position_y;
	}
	
	public void setPosx(double newPosx)
	{
		this.position_x = newPosx;
	}
	
	public void setPosy(double newPosy)
	{
		this.position_y = newPosy;
	}
	
	
	
}
