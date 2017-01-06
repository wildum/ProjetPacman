import edu.princeton.cs.introcs.StdDraw;

public class Personnage {
	
	protected double width, speed, speed_init, position_x, position_y, position_i_x, position_i_y;
	protected String color;
	protected double hitbox_x1, hitbox_x2, hitbox_y1, hitbox_y2;
	protected int choix_precedent = 0;
	
	
	public Personnage(double position_x,double position_y, double width, double speed, String color)
	{
		this.width = width;
		this.speed = speed; //vitesse actuelle du personnage
		this.speed_init = speed; //vitesse de base du personnage
		this.color = color;
		this.position_x = position_x;
		this.position_y = position_y;
		this.position_i_x = position_x;
		this.position_i_y = position_y;
		
		this.hitbox_x1 = position_x-width;
		this.hitbox_x2 = position_x+width;
		this.hitbox_y1= position_y-width;
		this.hitbox_y2 = position_y+width;
	}
	
	//cette méthode déplace les personnages dans le labyrinthe
	//elle prend en argument le Labyrinthe et le la direction choisie
	//elle renvoie false si le joueur a décidé d'arrêter de jouer, true sinon
	public boolean deplacer(Labyrinthe Lab, int choix)
	{
		
		if(Math.round(this.position_x) == 4 && (Math.round(this.position_y) == 64 ||  Math.round(this.position_y) == 65) && choix == 3)
		{
			this.position_x = 104;
		}
		
		if(Math.round(this.position_x) == 104 && (Math.round(this.position_y) == 64 ||  Math.round(this.position_y) == 65) && choix == 4)
		{
			this.position_x = 4;
		}
		
		switch(choix){

			case 1:
				if(Lab.checkMur(choix,this.position_x,this.position_y)) //on verifie qu'il n'y a pas d'obstacle
				{	
					this.position_y -= speed; //pas d'obstacle -> on avance
					this.choix_precedent = choix;
				}
				else
				{
					choix = this.choix_precedent;
				}
				break;
				
			case 2:
				if(Lab.checkMur(choix,this.position_x,this.position_y))
				{	
					this.position_y += speed;
					this.choix_precedent = choix;
				}
				else
				{
					choix = this.choix_precedent;
				}
				break;
			case 3:
				if(Lab.checkMur(choix,this.position_x,this.position_y))
				{
					this.position_x -= speed;
					this.choix_precedent = choix;
				}
				else
				{
					choix = this.choix_precedent;
				}
				break;
			case 4:
				if(Lab.checkMur(choix,this.position_x,this.position_y))
				{
					this.position_x += speed;
					this.choix_precedent = choix;
				}
				else
				{
					choix = this.choix_precedent;
				}
				break;
			case 5:
				return false; //E a été choisi
			
			default:
				break;
		}
		this.hitbox_x1 = this.position_x-this.width;
		this.hitbox_x2 = this. position_x+this.width;
		this.hitbox_y1= this.position_y-this.width;
		this.hitbox_y2 = this.position_y+this.width;
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
	
	public double gethx1()
	{
		return this.hitbox_x1;
	}
	public double gethx2()
	{
		return this.hitbox_x2;
	}
	public double gethy1()
	{
		return this.hitbox_y1;
	}
	public double gethy2()
	{
		return this.hitbox_y2;
	}
	
	
	
}
