import java.util.Random;

public class Fantome extends Personnage{
	
	protected int directionInverse = 1;
	protected double timer_init;
	protected double timer;
	protected String etat;
	protected boolean check1, check2;
	public Fantome(double position_x,double position_y, double width, double speed, String color, Chrono t)
	{
		super(position_x,position_y, width, speed, color);
		this.timer = t.getDureeSec();
		
		if(this.color.equals("r"))
		{
			this.timer_init = 0;
			this.etat = "normal";
		}
		if(this.color.equals("p"))
		{
			this.timer_init = 0.1;
			this.etat = "initial";
			this.check1 = false;
			this.check2 = false;
		}
		if(this.color.equals("b"))
		{
			this.timer_init = 4;
			this.etat = "initial";
			this.check1 = false;
			this.check2 = false;
		}
		if(this.color.equals("o"))
		{
			this.timer_init = 8;
			this.etat = "initial";
			this.check1 = false;
			this.check2 = false;
		}
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
			do
			{	
				this.speed = speed_init;
				choix = rd.nextInt(4)+1;
			} while(directionInverse == choix || Lab.checkMur(choix, this.position_x, this.position_y) == false);
		
		
	
		return choix;
		
	}
	
	public void transitionBox()
	{		
			if(GestionDuJeu.getChrono().getDureeSec() - this.timer > this.timer_init && this.check2 == false)
			{
				if(this.position_x != 54)
				{
					if(this.position_x > 54)
					{
						this.position_x-=this.speed;
					}
					if(this.position_x < 54)
					{
						this.position_x+=this.speed;
					}
				}
				else
				{
					this.check1 = true;
				}
				
				if(this.position_y < 76 && this.check1)
				{
					this.position_y += this.speed;
				}
				if(this.position_y >= 76 && this.check1)
				{
					this.check2 = true;
				}
			}
			if(this.check2)
			{
				this.etat = "normal";
			}
		
	}
	
	public String getEtat()
	{
		return etat;
	}
	
	public void setEtat(String etat)
	{
		this.etat = etat;
	}
	
	public void setTimer(double t)
	{
		this.timer = t;
	}

}
