import java.util.Random;

public class Fantome extends Personnage{
	
	protected int directionInverse = 1;
	protected double timer_init;
	protected double timer;
	protected String etat;
	protected boolean check1, check2;
	protected String comportement;
	public Fantome(double position_x,double position_y, double width, double speed, String color, Chrono t, String comportement)
	{
		super(position_x,position_y, width, speed, color);
		this.timer = t.getDureeSec();
		this.comportement = comportement;
		if(this.color.equals("r"))
		{
			this.timer_init = 0;
			this.etat = "standard";
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
	public int choixDirection(Labyrinthe Lab, int choix, Pacman...pacmans)
	{
		boolean std = true;
		for(int r = 0; r < pacmans.length; r++)
		{
			if(pacmans[r].getEtat() == "enerve")
				std = false;
		}
		
		if(std)
			this.etat = "standard";
			
		if(choix == 1 || choix == 3)
		{
			directionInverse = choix+1;
		}
		else
		{
			directionInverse = choix-1;
		}
		if(this.etat == "standard" && this.comportement == "random")
		{
			do
			{	
				this.speed = speed_init;
				choix = rd.nextInt(4)+1;
			} while(directionInverse == choix || Lab.checkMur(choix, this.position_x, this.position_y) == false);
		}
		else if(this.etat == "standard" && this.comportement == "traqueur")
		{
			return this.deplacementIntelligent(Lab,this.calculDuPlusProche(pacmans), directionInverse);
		}
		
		if(this.etat == "apeure")
		{
			return this.deplacementIntelligent(Lab,this.calculDuPlusProche(pacmans), directionInverse);
			
		}
	
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
				this.etat = "standard";
			}
		
	}
	
	//on calcul quel pacman est le plus proche de la position du fantome
	public Pacman calculDuPlusProche(Pacman...pacmans)
	{
		double x,y;
		double min = 1000;
		int lePlusProche = 0;
		double [] distance = new double[pacmans.length];
		for(int i = 0; i<pacmans.length;i++)
		{	
			if(pacmans[i].getEtat() == "super" || this.etat == "standard")
			{
				x = this.position_x - pacmans[i].position_x; 
				y = this.position_y - pacmans[i].position_y;
				distance[i] = Math.sqrt(x*x + y*y);
			}
			else
			{
				distance[i] = 0;
			}
		}
		for(int j = 0; j<distance.length;j++)
		{
			if(distance[j] < min)
			{
				min = distance[j];
				lePlusProche = j;
			}
		}
		return pacmans[lePlusProche];
	}
	
	/*prends en argument le pacman le plus proche
	 si le fantome est apeuré, le fuit
	 si le fantome est traqueur, le poursuit */
	public int deplacementIntelligent(Labyrinthe Lab, Pacman p, int directionPrecedente)
	{
		int choix = 0;
		int [] ordreChoix = new int[4];
		double x = this.position_x - p.getPosx();
		double y = this.position_y - p.getPosy();
		if(this.etat.equals("apeure"))
		{
			if(Math.abs(x) > Math.abs(y))
			{
				if(x > 0)
				{
					ordreChoix[0] = 4;
					ordreChoix[3] = 3;
				}
				else
				{
					ordreChoix[0] = 3;
					ordreChoix[3] = 4;
				}
				if(y > 0)
				{
					ordreChoix[1] = 2;
					ordreChoix[2] = 1;
				}
				else
				{
					ordreChoix[1] = 1;
					ordreChoix[2] = 2;
				}
			}
			else
			{
				if(x > 0)
				{
					ordreChoix[1] = 4;
					ordreChoix[2] = 3;
				}
				else
				{
					ordreChoix[1] = 3;
					ordreChoix[2] = 4;
				}
				if(y > 0)
				{
					ordreChoix[0] = 2;
					ordreChoix[3] = 1;
				}
				else
				{
					ordreChoix[0] = 1;
					ordreChoix[3] = 2;
				}
			}
		}
		else if(this.comportement.equals("traqueur"))
		{
			if(Math.abs(x) > Math.abs(y))
			{
				if(x > 0)
				{
					ordreChoix[3] = 4;
					ordreChoix[0] = 3;
				}
				else
				{
					ordreChoix[3] = 3;
					ordreChoix[0] = 4;
				}
				if(y > 0)
				{
					ordreChoix[2] = 2;
					ordreChoix[1] = 1;
				}
				else
				{
					ordreChoix[2] = 1;
					ordreChoix[1] = 2;
				}
			}
			else
			{
				if(x > 0)
				{
					ordreChoix[2] = 4;
					ordreChoix[1] = 3;
				}
				else
				{
					ordreChoix[2] = 3;
					ordreChoix[1] = 4;
				}
				if(y > 0)
				{
					ordreChoix[3] = 2;
					ordreChoix[0] = 1;
				}
				else
				{
					ordreChoix[3] = 1;
					ordreChoix[0] = 2;
				}
			}
		}
		int a = 0;
		while(ordreChoix[a] == directionPrecedente || Lab.checkMur(ordreChoix[a], this.position_x, this.position_y) == false)
		{
			a++;
		}
		
		return ordreChoix[a];
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
