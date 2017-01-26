import java.util.Random;

public class Fantome extends Personnage{
	
	private int directionInverse = 1;
	private double timer_init;
	private double timer;
	private String etat;
	protected boolean check1, check2;
	private String comportement;
	private boolean std;
	private double x,y;
	private double x1,y1;
	private double min;
	private int lePlusProche;
	private double [] distance;
	private int [] ordreChoix;
	private int a;
	private int comptInitial = 0;
	private static Random rd = new Random(System.currentTimeMillis());
	
	/*
	 *  C’est le constructeur de la classe Fantome
o   Le timer de sortie des fantômes est initialisé suivant la couleur du fantôme
	 */
	
	public Fantome(double position_x,double position_y, double width, double speed, String color, String comportement)
	{
		super(position_x,position_y, width, speed, color);
		this.timer = 0;
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
	
	/*
	 *  Gère la direction du fantôme
o   Si le fantome a un etat « standard » et un comportement « random », la direction choisie est aléatoire. 
La direction choisie ne peut pas être égale à l’inverse de la direction précédente et ne peut pas être dans le sens d’un mur. 
Si tel est le cas, le fantôme choisie une nouvelle direction aléatoire. Si un des pacman est énervé, l’état du fantôme est mis à apeuré.
 Si l’état du fantôme est apeuré, il fait un choix de direction intelligent pour fuir le pacman énervé le plus proche de lui. 
Si l’état du fantôme est standard et que son comportement est « traqueur » ou « embuscadeur », il fait un choix de direction intelligent.
o   Cette méthode utilise la méthode calculDePlusProche (cf Fantome) et deplacementIntelligent (cf Fantome)

	 */
	public int choixDirection(Labyrinthe Lab, int choix, Pacman...pacmans)
	{
		std = true;
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
		else if(this.etat == "standard" && (this.comportement == "traqueur" || this.comportement == "embuscadeur"))
		{
			return this.deplacementIntelligent(Lab,this.calculDuPlusProche(pacmans), directionInverse);
		}
		
		if(this.etat == "apeure")
		{
			return this.deplacementIntelligent(Lab,this.calculDuPlusProche(pacmans), directionInverse);
			
		}
	
		return choix;
		
	}
	
	/*
	 * Gère la sortie de la boîte des fantômes et leur permet de passer de l’etat initial à l’état standard
       Cette méthode récupère le Chrono. Si le timer du fantome est écoulé, c’est qu’il peut sortir de la boîte. Dans ce cas là, il est déplacé petit à petit jusqu’à qu’il soit hors de la boîte. 
       Dès qu’il est hors de la boîte, son état est mis à « standard ».
	 */
	
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
	
	/*
	 *   Détermine quel est le Pacman le plus proche du fantôme.
         Cette méthode calcul la distance fantome-Pacmans pour les différents Pacmans présents dans le jeu. Elle renvoie ensuite le Pacman le plus proche.
         Cette méthode n’est utilisée que pour la méthode déplacement intelligent
	 */
	public Pacman calculDuPlusProche(Pacman...pacmans)
	{
		min = 1000;
		lePlusProche = 0;
		distance = new double[pacmans.length];
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
	
	/*
	 *  Cette méthode permet aux fantômes de se déplacer intelligemment en fonction de la position du Pacman le plus proche.
        La méthode compare les coordonnées du fantôme avec celles du Pacman. Suivant le résultat, elle établit un ordre de choix de direction. 
        Cet ordre est déterminé suivant l’angle que fait le vecteur fantôme-Pacman avec les axes x,y. 
        Si l’état du fantôme est apeuré, les directions sont ordonnées du plus grand angle au plus petit.
        Si l’état du fantôme est standard et que son comportement est traqueur, les directions sont ordonnées du plus petit angle au plus grand. Si l’état du fantôme est standard et que son comportement est embuscadeur, l’ordre des déplacements est un peu plus compliqué : on découpe le labyrinthe en 4 quarts. 
        Suivant la position du Pacman et sa direction, la méthode anticipe dans quel quart le Pacman va se retrouver. Elle établit alors un ordre de directions pour que le Fantome se rende dans ce quart et ainsi tendre un piège au Pacman. Pour fonctionner de façon optimale, il est nécessaire de coupler cette méthode avec la méthode switchComportementFantome de la classe GestionDuJeu. 
        En effet, lorsque le fantôme fait une embuscade, il va se retrouver proche du Pacman dans quelques secondes. La méthode switchComportementFantome va alors changer son comportement pour le mettre en traqueur et ainsi foncer sur le Pacman.
        Bien que les déplacements des fantômes apeurés et traqueurs fonctionnent très bien, les déplacements des fantômes embuscadeurs sont souvent assez douteux. Ce comportement n’est pas encore très au point et sera sûrement à retravailler.
	 */
	public int deplacementIntelligent(Labyrinthe Lab, Pacman p, int directionPrecedente)
	{
		ordreChoix = new int[4];
		x1 = this.position_x - p.getPosx();
		y1 = this.position_y - p.getPosy();
		if(this.etat.equals("apeure"))
		{
			if(Math.abs(x1) > Math.abs(y1))
			{
				if(x1 > 0)
				{
					ordreChoix[0] = 4;
					ordreChoix[3] = 3;
				}
				else
				{
					ordreChoix[0] = 3;
					ordreChoix[3] = 4;
				}
				if(y1 > 0)
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
				if(x1 > 0)
				{
					ordreChoix[1] = 4;
					ordreChoix[2] = 3;
				}
				else
				{
					ordreChoix[1] = 3;
					ordreChoix[2] = 4;
				}
				if(y1 > 0)
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
			if(Math.abs(x1) > Math.abs(y1))
			{
				if(x1 > 0)
				{
					ordreChoix[3] = 4;
					ordreChoix[0] = 3;
				}
				else
				{
					ordreChoix[3] = 3;
					ordreChoix[0] = 4;
				}
				if(y1 > 0)
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
				if(x1 > 0)
				{
					ordreChoix[2] = 4;
					ordreChoix[1] = 3;
				}
				else
				{
					ordreChoix[2] = 3;
					ordreChoix[1] = 4;
				}
				if(y1 > 0)
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
		
		else if(this.comportement.equals("embuscadeur"))
		{
			
			if(p.getPosx() < 54.4 && p.getPosy() < 65) // en bas à gauche
			{
				if(p.getDirection() == 1 || p.getDirection() == 4)
				{
					ordreChoix[0] = 4;
					ordreChoix[1] = 1;
					ordreChoix[2] = 3;
					ordreChoix[3] = 2;
				}
				else
				{
					ordreChoix[0] = 2;
					ordreChoix[1] = 3;
					ordreChoix[2] = 4;
					ordreChoix[3] = 1;
				}
			}
			if(p.getPosx() > 54.4 && p.getPosy() < 65) // en bas à droite
			{
				if(p.getDirection() == 2 || p.getDirection() == 4)
				{
					ordreChoix[0] = 4;
					ordreChoix[1] = 2;
					ordreChoix[2] = 1;
					ordreChoix[3] = 3;
				}
				else
				{
					ordreChoix[0] = 3;
					ordreChoix[1] = 1;
					ordreChoix[2] = 2;
					ordreChoix[3] = 4;
				}
			}
			if(p.getPosx() < 54.4 && p.getPosy() > 65) // en haut à gauche
			{
				if(p.getDirection() == 2 || p.getDirection() == 4)
				{
					ordreChoix[0] = 4;
					ordreChoix[1] = 2;
					ordreChoix[2] = 1;
					ordreChoix[3] = 3;
				}
				else
				{
					ordreChoix[0] = 1;
					ordreChoix[1] = 3;
					ordreChoix[2] = 4;
					ordreChoix[3] = 2;
				}
			}
			else
			{
				if(p.getDirection() == 1 || p.getDirection() == 4)
				{
					ordreChoix[0] = 1;
					ordreChoix[1] = 4;
					ordreChoix[2] = 3;
					ordreChoix[3] = 2;
				}
				else
				{
					ordreChoix[0] = 2;
					ordreChoix[1] = 3;
					ordreChoix[2] = 1;
					ordreChoix[3] = 4;
				}
			}
		
			
			
		
		}
		
		a = 0;
		while(ordreChoix[a] == directionPrecedente || Lab.checkMur(ordreChoix[a], this.position_x, this.position_y) == false)
		{
			a++;
		}
		
		return ordreChoix[a];
	}
	
	/*
	 *  Cette méthode renvoie le fantôme à sa position initiale et met son état à « initial »
	 */
	
	public void reset()
	{
		this.position_x = this.position_i_x;
		this.position_y = this.position_i_y;
		this.setEtat("initial");
		GestionDuJeu.getChrono().pause();
		this.setTimer(GestionDuJeu.getChrono().getDureeSec());
		GestionDuJeu.getChrono().resume();
		this.check1 = false;
		this.check2 = false;
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
	
	public void setComportement(String comportement)
	{
		this.comportement = comportement;
	}
	

}
