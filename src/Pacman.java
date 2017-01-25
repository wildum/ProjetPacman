import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Pacman extends Personnage{
	
	private Joueur joueur;
	private double tempsChgtImage = 0; 
	private String etat = ""; // erneve ou standard
	private double minuterieEnerveS = -8;
	
	public Pacman(double position_x,double position_y, double width, double speed, String color, Joueur player)
	{
		super(position_x,position_y, width, speed, color);
		this.joueur = player;
		this.etat = "standard";
	}
	
	
	public double getTempsChgtImage () {
		return this.tempsChgtImage;
	}
	
	
	/* Cette méthode permet d'alterner l'image du Pacman pour donner une illusion de mouvement.
	 * Suivant la couleur du pacman la méthode utilise une méthode différente.
	 * Elle prend en argument la direction du pacman et le chrono.
	 * */
	 
	
	public void chgtImage(int direction, Chrono chrono) {
		if (this.getColor() == "y") {
			this.animationPacman1(chrono, direction);
		} else {
			this.animationPacman2(chrono, direction);
		}
		
		if (this.getColor() == "y") {
			this.animationPacman1(chrono, direction);
		} else {
			this.animationPacman2(chrono, direction);
		}
		
		if (this.getColor() == "y") {
			this.animationPacman1(chrono, direction);
		} else {
			this.animationPacman2(chrono, direction);
		}
		
		if (this.getColor() == "y") {
			this.animationPacman1(chrono, direction);
		} else {
			this.animationPacman2(chrono, direction);
		}
	}

	/*
	 * Cette méthode choisie l'image du pacman suivant le chrono et la direction qu'elle prends en argument.
	 * Les images dépendent de l'état du Pacman
	 */
	public void animationPacman1(Chrono chrono, int direction) {
		chrono.pause();
		
		///gestion du mode enerve
		
		if(chrono.getDureeSec() > this.minuterieEnerveS + 8)
		{
			this.setEtat("standard");
		}
		
		
		
		double sous = chrono.getDureeMs() - tempsChgtImage;
		
		if(this.etat == "standard")
		{
			if (sous <= 100) {
				StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune.png", 5, 5);
			} else if (sous <= 200) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_bmi.png", 5, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_hmi.png", 5, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_gmi.png", 5, 5);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_dmi.png", 5, 5);
				}  else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune.png", 5, 5);
				}
			} else if (sous <= 300) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_b.png", 5, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_h.png", 5, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_g.png", 5, 5);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_d.png", 5, 5);
				}  else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune.png", 5, 5);
				}
			} else if (sous <= 400) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_bmi.png", 5, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_hmi.png", 5, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_gmi.png", 5, 5);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune_dmi.png", 5, 5);
				}  else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jaune.png", 5, 5);
				}
			} else {
				tempsChgtImage = chrono.getDureeMs();
				chrono.resume();
			}
		}
		if(this.etat == "enerve")
		{
			if (sous <= 100) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_b.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_h.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_g.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_d.png", 5, 6);
				}  else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_b.png", 5, 6);
				}
			} else if (sous <= 200) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_bmi.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_hmi.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_gmi.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_dmi.png", 5, 6);
				}  else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_b.png", 5, 6);
				}
			} else if (sous <= 300) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_b.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_h.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_g.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_d.png", 5, 6);
				}  else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_b.png", 5, 6);
				}
			} else if (sous <= 400) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_bmi.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_hmi.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_gmi.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_dmi.png", 5, 6);
				}  else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_jenerve_b.png", 5, 6);
				}
			} else {
				tempsChgtImage = chrono.getDureeMs();
				chrono.resume();
			}
		}
	}
	
	public double getMinuterieEnerveS() {
		return minuterieEnerveS;
	}

	public void setMinuterieEnerveS(double minuterieEnerveS) {
		this.minuterieEnerveS = minuterieEnerveS;
	}

	

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public void setTempsChgtImage(double tempsChgtImage) {
		this.tempsChgtImage = tempsChgtImage;
	}
	
	/*
	 * Même méthode qu'animationPacman1 sauf qu'elle gère le pacman vert
	 */

	public void animationPacman2(Chrono chrono, int direction) {
		chrono.pause();
		
		///gestion du mode enerve
		if(chrono.getDureeSec() > this.minuterieEnerveS + 8)
			{
				this.setEtat("standard");
			}
				
				
		double sous = chrono.getDureeMs() - tempsChgtImage;
		
		if(this.etat == "standard")
		{
			if (sous <= 100) {
				StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert.png", 5, 5);
			} else if (sous <= 200) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_bmi.png", 5, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_hmi.png", 5, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_gmi.png", 5, 5);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_dmi.png", 5, 5);
				} else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert.png", 5, 5);
				}
			} else if (sous <= 300) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_b.png", 5, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_h.png", 5, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_g.png", 5, 5);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_d.png", 5, 5);
				} else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert.png", 5, 5);
				}
			} else if (sous <= 400) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_bmi.png", 5, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_hmi.png", 5, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_gmi.png", 5, 5);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert_dmi.png", 5, 5);
				} else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_vert.png", 5, 5);
				}
			} else {
				tempsChgtImage = chrono.getDureeMs();
				chrono.resume();
			}
		}
		if(this.etat == "enerve")
		{
			if (sous <= 100) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_b.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_h.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_g.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_d.png", 5, 6);
				} else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_d.png", 5, 6);
				}
			} else if (sous <= 200) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_bmi.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_hmi.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_gmi.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_dmi.png", 5, 6);
				} else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_d.png", 5, 6);
				}
			} else if (sous <= 300) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_b.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_h.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_g.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_d.png", 5, 6);
				} else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_d.png", 5, 6);
				}
			} else if (sous <= 400) {
				if (direction == 1) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_bmi.png", 6, 5);
				} else if (direction == 2) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_hmi.png", 6, 5);
				} else if (direction == 3) {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_gmi.png", 5, 6);
				} else if (direction == 4){
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_dmi.png", 5, 6);
				} else {
					StdDraw.picture(this.getPosx(),this.getPosy(),"Images/p_venerve_d.png", 5, 6);
				}
			} else {
				tempsChgtImage = chrono.getDureeMs();
				chrono.resume();
			}
		}
	}
	
	
	/*Cette méthode permet au joueur 1 de choisir sa direction en appuyant sur une touche 
	*Elle prend en argument la direction précédente et la renvoie si le joueur n'appuie sur rien
	*/
	public int choixDeLaDirectionP1(int choix)
	{
		if(this.joueur.isVivant())
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
	        else
	        {
	        	return choix; // si rien n'est pressé on garde la même direction
	        }
		}
		else
		{	
			this.position_x = 1000;
			this.position_y = 1000;
			choix = 5;
			return choix;
		}
        
	}
	
	/*Cette méthode permet au joueur 2 de choisir sa direction en appuyant sur une touche
	 * */
	 
	public int choixDeLaDirectionP2(int choix)
	{
		if(this.joueur.isVivant())
		{
			if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
				this.speed = speed_init;
				direction = 1;
	            return choix = 1;
	        }
	        if (StdDraw.isKeyPressed(KeyEvent.VK_Z))  {
	        	this.speed = speed_init;
	        	direction = 2;
	            return choix = 2;
	        }
	        if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
	        	this.speed = speed_init;
	        	direction = 3;
	            return choix = 3;
	        }
	        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
	        	this.speed = speed_init;
	        	direction = 4;
	            return choix = 4;
	        }
	        else
	        {
	        	return choix;
	        }
		}
		else
		{
			this.position_x = 1000;
			this.position_y = 1000;
			choix = 5;
			return choix;
		}
	}
	
	/*Cette méthode s'occupe des interractions entre le pacman avec les graines et les fantômes
	 * Elle prends en argument le tableau de graines, le labyrinthe et les fantomes
	 * 
	 */
	public void interraction(Graine [][] tab_graines,Labyrinthe Labyrinthe,Fantome...fantomes)
	{
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{
				//si contact avec une graine
				if(		
						this.position_x < tab_graines[i][j].gethx2() &&
						this.position_x > tab_graines[i][j].gethx1() &&
						this.position_y < tab_graines[i][j].gethy2() &&
						this.position_y > tab_graines[i][j].gethy1()   )
				{
					//si graine standard
					if(tab_graines[i][j].type == "standard")
					{
						tab_graines[i][j].setType("null");
						this.getJoueur().setScore(this.getJoueur().getScore()+10);
					}
					//si super graine
					if(tab_graines[i][j].type == "super")
					{
						tab_graines[i][j].setType("null");
						this.getJoueur().setScore(this.getJoueur().getScore()+50);
						this.etat = "enerve";
						Labyrinthe.setSetMinuteur(true);
						for(int m = 0; m < fantomes.length;m++)
						{
							if(fantomes[m].getEtat() == "standard")
							{
								fantomes[m].setEtat("apeure");
							}
						}
						GestionDuJeu.getChrono().pause();
						this.minuterieEnerveS = GestionDuJeu.getChrono().getDureeSec();
						GestionDuJeu.getChrono().resume();
					}
				}
			}
		}
		
		for(int a = 0; a < fantomes.length;a++)
		{
			//contact entre le pac et un fantome
			if(this.gethx1() < fantomes[a].getPosx() &&
					this.gethx2() > fantomes[a].getPosx() &&
					this.gethy1() < fantomes[a].getPosy() &&
					this.gethy2()> fantomes[a].getPosy())
			{
				//contact avec pacman standard et fantome standard
				if(this.etat == "standard" || fantomes[a].getEtat() == "standard")
				{
					// on remet le pacamn à sa position initiale :
					this.position_x = this.position_i_x;
					this.position_y = this.position_i_y;
					
					// on remet les fantômes à leur position initiale
					for(int b = 0; b< fantomes.length;b++)
					{
						fantomes[b].position_x = fantomes[b].position_i_x;
						fantomes[b].position_y = fantomes[b].position_i_y;
						fantomes[b].setEtat("initial");
						GestionDuJeu.getChrono().pause();
						fantomes[b].setTimer(GestionDuJeu.getChrono().getDureeSec());
						GestionDuJeu.getChrono().resume();
						fantomes[b].check1 = false;
						fantomes[b].check2 = false;
					}
					
					// on enlève une vie au joueur :
					this.getJoueur().setVie(this.getJoueur().getVie()-1);
					
					this.hitbox_x1 = this.position_x-this.width;
					this.hitbox_x2 = this.position_x+this.width;
					this.hitbox_y1= this.position_y-this.width;
					this.hitbox_y2 = this.position_y+this.width;
				}
				//contact avec fantomes lorsque pacman énervé et fantome apeuré
				if(this.etat == "enerve" && fantomes[a].getEtat().equals("apeure"))
				{
					fantomes[a].position_x = fantomes[a].position_i_x;
					fantomes[a].position_y = fantomes[a].position_i_y;
					fantomes[a].setEtat("initial");
					this.getJoueur().setScore(this.getJoueur().getScore()+200);
					GestionDuJeu.getChrono().pause();
					fantomes[a].setTimer(GestionDuJeu.getChrono().getDureeSec() - 8);
					GestionDuJeu.getChrono().resume();
					fantomes[a].check1 = false;
					fantomes[a].check2 = false;
				}
			}
		}
		
		
		
				
	}
	
	/*
	 * Cette méthode permet de renvoyer le pacman à sa position initiale.
	 * Elle est appelée lorsque l'on passe d'un niveau à un autre
	 */
	public void reset()
	{
		this.setEtat("standard");
		this.setPosx(this.position_i_x);
		this.setPosy(this.position_i_y);
		this.setTempsChgtImage(0);
	}
	
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	public void setEtat(String Etat)
	{
		this.etat = Etat;
	}
	
	public String getEtat()
	{
		return this.etat;
	}
	
}
