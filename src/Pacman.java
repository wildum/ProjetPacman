import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Pacman extends Personnage{
	
	
	
	public Pacman(double position_x,double position_y, double width, double speed, String color)
	{
		super(position_x,position_y, width, speed, color);
	}
	
	//cette méthode permet au joueur 1 de choisir sa direction en appuyant sur une touche 
	//elle prend en argument la direction précédente et la renvoie si le joueur n'appuie sur rien
	public int choixDeLaDirectionP1(int choix)
	{
		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
			this.speed = speed_init; //la vitesse est remise à la vitesse initiale au cas où le pacman serait à l'arrêt
            return choix = 1;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP))  {
        	this.speed = speed_init;
            return choix = 2;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
        	this.speed = speed_init;
            return choix = 3;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
        	this.speed = speed_init;
            return choix = 4;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_E)) {
            return choix = 5;
        }
        else
        {
        	return choix; // si rien n'est pressé on garde la même direction
        }
        
	}
	
	//cette méthode permet au joueur 2 de choisir sa direction en appuyant sur une touche
	public int choixDeLaDirectionP2(int choix)
	{
		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			this.speed = speed_init;
            return choix = 1;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_Z))  {
        	this.speed = speed_init;
            return choix = 2;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
        	this.speed = speed_init;
            return choix = 3;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
        	this.speed = speed_init;
            return choix = 4;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_E)) {
            return choix = 5;
        }
        else
        {
        	return choix;
        }
	}
	
	public void interraction(Graine [][] tab_graines, Fantome...fantomes)
	{
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{
				if(		
						this.hitbox_x1 < tab_graines[i][j].gethx2() &&
						this.hitbox_x2 > tab_graines[i][j].gethx1() &&
						this.hitbox_y1 < tab_graines[i][j].gethy2() &&
						this.hitbox_y2 > tab_graines[i][j].gethy1()   )
				{
					if(tab_graines[i][j].type == "standard")
					{
						tab_graines[i][j].setType("null");
					}
				}
			}
		}
		
		for(int a = 0; a < fantomes.length;a++)
		{
			if(this.hitbox_x1 < fantomes[a].gethx2() &&
					this.hitbox_x2 > fantomes[a].gethx1() &&
					this.hitbox_y1 < fantomes[a].gethy2() &&
					this.hitbox_y2 > fantomes[a].gethy1())
			{
				this.position_x = this.position_i_x;
				this.position_y = this.position_i_y;
				this.hitbox_x1 = this.position_x-this.width;
				this.hitbox_x2 = this.position_x+this.width;
				this.hitbox_y1= this.position_y-this.width;
				this.hitbox_y2 = this.position_y+this.width;

			}
		}
		
		
		
	}
	
	
	
	
}
