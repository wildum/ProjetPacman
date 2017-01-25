import java.awt.Font;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;

public class GestionDuJeu {
	
	// Chronomètre du jeu :
	private static Chrono chrono = new Chrono(), chronoMenu1 = new Chrono();
	private static Font trespetite = new Font("SHOWCARD GOTHIC", Font.BOLD, 15), petite = new Font("SHOWCARD GOTHIC", Font.BOLD, 18), normale = new Font("SHOWCARD GOTHIC", Font.BOLD, 20), selection = new Font("SHOWCARD GOTHIC", Font.BOLD, 22), grande = new Font("SHOWCARD GOTHIC", Font.BOLD, 40);
	
	// Variables méthode affichageMenuPage1() :
	private static boolean clic1, position1;
	private static int choixDuJoueur1;
	
	// Variables méthode affichageMenuPause() :
	private static boolean choixDuJoueur2, loop2;
	
	
	// Variables méthode affichageMenuControle() :
	private static boolean clic3, position3, choixDuJoueur3;
	
	// Variables méthode affichageMenuFin() :
	private static boolean choixDuJoueur4;
	
	// Variables méthode highscores() :
	private static boolean clic5, position5, choixDuJoueur5, stay5, enter, enter2;
	
	//Variables méthode switchComportementFantomes() :
	protected static int fantMin, fantMax;
	protected static double minD, maxD;
	protected static double x,y;
		
	public static Chrono getChrono() {
		return chrono;
	}
		
	
	// affichageMenuPage1() gère l'affiche du menu principal	
	public static int affichageMenuPage1()
		{
		clic1 = true;
		position1 = true;
		choixDuJoueur1 = 0;
			StdDraw.setCanvasSize(500,760); 
			StdDraw.setXscale(-2,110);
			StdDraw.setYscale(-27,149);
			StdDraw.setFont(normale);
			StdDraw.clear(StdDraw.BLACK);
			StdDraw.picture(54,105,"Images/Pacman_menu.png",110,69);
			do
			{
				position1 = true;			
				
				// ONE PLAYER :
				if(StdDraw.mouseX() > 39.5 && StdDraw.mouseX() < 69 && StdDraw.mouseY() > 33 && StdDraw.mouseY() < 42) // choix du mode 1 joueur
				{
					choixDuJoueur1 = 1;
					position1 = false;
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 34, 30, 5);
					StdDraw.setFont(selection);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(54, 31.8, "One Player");
					
				}
				else
				{
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 34, 30, 3.5);
					StdDraw.setFont(normale);
					StdDraw.setPenColor(200,200,200);
					StdDraw.text(54, 32, "One Player");
				}
				
				// TWO PLAYER :
				if(StdDraw.mouseX() > 37.2 && StdDraw.mouseX() < 71.1 && StdDraw.mouseY() > 23.5 && StdDraw.mouseY() < 33) // choix du mode 2 joueurs
				{
					choixDuJoueur1 = 2;
					position1 = false;
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 25, 30, 3.5);
					StdDraw.setFont(selection);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(54, 21.77, "Two Players");
				}
				else
				{
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 25, 30, 4);
					StdDraw.setFont(normale);
					StdDraw.setPenColor(200,200,200);
					StdDraw.text(54, 22, "Two Players");
				}
				
				// HIGHSCORE :
				if(StdDraw.mouseX() > 39.5 && StdDraw.mouseX() < 69.5 && StdDraw.mouseY() > 15 && StdDraw.mouseY() < 23.5) // choix de regarder les meilleurs scores
				{
					choixDuJoueur1 = 3;
					position1 = false;
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 16, 30, 5);
					StdDraw.setFont(selection);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(54, 12.75, "High Scores");
					
				}
				else
				{
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 16, 30, 5);
					StdDraw.setFont(normale);
					StdDraw.setPenColor(200,200,200);
					StdDraw.text(54, 13, "High Scores");
				}
				
				// CONTROLS :
				if(StdDraw.mouseX() > 41 && StdDraw.mouseX() < 66 && StdDraw.mouseY() > 6 && StdDraw.mouseY() < 15)
				{
					choixDuJoueur1 = 5;
					position1 = false;
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 6, 30, 5);
					StdDraw.setFont(selection);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(54, 3.7, "Controls");
				}
				else
				{
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, 6, 30, 5);
					StdDraw.setFont(normale);
					StdDraw.setPenColor(200,200,200);
					StdDraw.text(54, 4, "Controls");
				}
				
				
				// QUIT :
				if(StdDraw.mouseX() > 47 && StdDraw.mouseX() < 61 && StdDraw.mouseY() > -4 && StdDraw.mouseY() < 6) // choix de quitter
				{
					choixDuJoueur1 = 4;
					position1 = false;
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, -4, 30, 5);
					StdDraw.setFont(selection);
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.text(54, -5.2, "Quit");
				}
				else
				{
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledRectangle(54.5, -4, 30, 5);
					StdDraw.setFont(normale);
					StdDraw.setPenColor(200,200,200);
					StdDraw.text(54, -5, "Quit");
				}
				StdDraw.pause(50);
				if(StdDraw.mousePressed())
				{
					StdDraw.pause(50);
					clic1 = false;
				}
				else
				{
					clic1 = true;
				}
				
				
				
				StdDraw.show(20);
				StdDraw.pause(50);
				} while(clic1 || position1);
			StdDraw.pause(150);
			return choixDuJoueur1;
		}

	public static boolean affichageMenuPause()
	{
		choixDuJoueur2 = true;
		loop2 = true;
		StdDraw.setFont(selection);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(54.5, 74.5, "PAUSED");
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(normale);
		StdDraw.text(54, 51, "QUIT? Y/N");
		while(loop2)
		{
			StdDraw.show(20);
			if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) || StdDraw.isKeyPressed(KeyEvent.VK_N))
			{
				loop2 = false;
				choixDuJoueur2 = true;
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE) || StdDraw.isKeyPressed(KeyEvent.VK_Y))
			{
				loop2 = false;
				choixDuJoueur2 = false;
			}
		}
		return choixDuJoueur2;
	}
	
	
	public static boolean affichageMenuControl() {
		clic3 = true;
		position3 = true;
		choixDuJoueur3 = false;
		StdDraw.setCanvasSize(500,760); 
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); 
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54,105,"Images/Pacman_menu.png",110,69);
		
		StdDraw.setFont(normale);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(24, 60, "PLAYER 1:");
		StdDraw.setPenColor(50, 235, 70);
		StdDraw.text(81, 60, "PLAYER 2:");
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(56, 27, "GAME:");
						
		StdDraw.setPenColor(180, 180, 180);
		StdDraw.setFont(petite);
		StdDraw.text(22, 53, "ARROW KEYS");
		StdDraw.text(79, 53, "Z: UP");
		StdDraw.text(79, 47, "Q: LEFT");
		StdDraw.text(79, 41, "S: DOWN");
		StdDraw.text(79, 35, "D: RIGHT");
		StdDraw.text(55, 20, "P: PAUSE/RESUME");
		StdDraw.text(55, 14, "ESCAPE: EXIT");
		
		do {
			position3 = true;
			
			if (StdDraw.mouseX() > 43 && StdDraw.mouseX() < 66 && StdDraw.mouseY() > -3 && StdDraw.mouseY() < 6) {
				choixDuJoueur3 = true;
				position3 = false;
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(55, -4, 30, 5);
				StdDraw.setFont(selection);
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.text(54, -4.3, "GO BACK");
			} else {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledRectangle(55, -4, 30, 5);
				StdDraw.setFont(normale);
				StdDraw.setPenColor(200, 200, 200);
				StdDraw.text(54, -4, "GO BACK");				
			}
			
			StdDraw.pause(50);
			if (StdDraw.mousePressed()) {
				StdDraw.pause(300);
				clic3 = false;
			} else {
				clic3 = true;
			}
			StdDraw.show(20);
		} while(clic3 || position3);
		
		return choixDuJoueur3;
	}
	
	public static int checkWinLoose(Graine [][] tab_graines, Joueur...joueurs)
	{
		int fin = 0, compteur = 0, compteur2 = 0;
		
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{
				if(tab_graines[i][j].type == "standard" || tab_graines[i][j].type == "super")
				{
					compteur++;
				}
			}
		}
		
		if(compteur == 0)
		{
			fin = 1; //win
		}
		
		for(int a = 0; a < joueurs.length; a++)
		{
			if(joueurs[a].getVie() <= 0)
			{
				compteur2++;
				joueurs[a].setVivant(false);
			}
		}
		if(compteur2 == joueurs.length)
		{
			fin = 2; //loose
		}
		
		return fin;
	}
	
	public static boolean affichageFin(int fin)
	{
		choixDuJoueur4 = true;
		StdDraw.setFont(grande);
		
			if(fin == 1)
			{
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.text(52, 74.5, "WIN");
			}
			else
			{
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.text(53, 74.5, "GAME OVER");
			}
			StdDraw.setFont(trespetite);
			StdDraw.setPenColor(200,200,200);
			
			StdDraw.pause(50);
			while(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) != true)
			{
				StdDraw.show(20);
				StdDraw.text(54, 51, "(PRESS SPACE TO CONTINUE)");
			}		
		return choixDuJoueur4;
	}
	
	public static void highscores(boolean save, boolean P2, int fin, Joueur...joueurs)
	{
		clic5 = true;
		position5 = true;
		choixDuJoueur5 = false;	
		stay5 = true;
		enter = false;
		enter2 = false;
		int y = 90;
		int a = 0;
		File f = new File("sauvegardes.txt");
		FileWriter fw;
		FileReader fr;
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		String dataOut = "";
		String dataIn = "";
		String sample = "";
		String [] tab_pseudo;
		int [] tab_scores;
		int numberScore;
		int tailleTab = 0;
		int compteur = 0;
		int change, tailleMax;
		String changement = "";
		StdDraw.setFont(normale);
		int bonusChrono = 0;
		if(GestionDuJeu.getChrono().getDureeSec() < 60 && fin == 1)
			bonusChrono = 400;
		else if(GestionDuJeu.getChrono().getDureeSec() < 90 && fin == 1)
			bonusChrono = 400;
		else
			bonusChrono = 0;
		while(StdDraw.hasNextKeyTyped())
		{
			StdDraw.nextKeyTyped();
		}
		    try {
		    	if(save)
		    	{
		    		fw = new FileWriter(f,true);
		    		while(enter || dataIn == "")
		    		{
		    			StdDraw.pause(50);
		    			if(StdDraw.hasNextKeyTyped() && dataIn.length() < 15)
		    			{
		    				dataIn += StdDraw.nextKeyTyped();
		    			}
		    			if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER))
		    			{
		    				enter = false;
		    			}
		    			else
		    			{
		    				enter = true;
		    			}
		    			if(StdDraw.isKeyPressed(KeyEvent.VK_BACK_SPACE) && dataIn.length() > 1)
		    			{
		    				dataIn = dataIn.substring(0, dataIn.length()-2);
		    				StdDraw.clear(StdDraw.BLACK);
		    				StdDraw.pause(50);
		    			}
		    			StdDraw.setFont(grande);
			    		StdDraw.text(50, 100, "SAVE YOUR SCORE");
			    		StdDraw.setFont(petite);
			    		StdDraw.line(20,79,60,79);
			    		StdDraw.picture(18, 81, "Images/fleche_droite.png");
		    			StdDraw.setPenColor(StdDraw.YELLOW);
		    			StdDraw.text(10, 80, "J1");
		    			StdDraw.textLeft(23, 80, dataIn);
		    			StdDraw.setPenColor(StdDraw.WHITE);
		    			int sj1 = joueurs[0].getScore() + joueurs[0].getVie()*200 + bonusChrono;
		    			StdDraw.textRight(83, 80, Integer.toString(sj1));
		    			StdDraw.show(20);
		    		}
		    		fw.write("\r\n");
		    		for(int u = 0; u<dataIn.length();u++)
		    		{
			    		fw.write(dataIn.charAt(u));
		    		}
		    		fw.write('$');
		    		int sj1 = joueurs[0].getScore() + joueurs[0].getVie()*200 + bonusChrono;
		    		String scoreJ1 = Integer.toString(sj1);
		    		fw.write(scoreJ1);
		    		fw.write('@');
		    		if(P2)
		    		{
		    			StdDraw.clear(StdDraw.BLACK);
		    			String dataJ1 = dataIn;
		    			dataIn = "";
		    			while(enter2 || dataIn == "")
			    		{
			    			StdDraw.pause(50);
			    			if(StdDraw.hasNextKeyTyped() && dataIn.length() < 15)
			    			{
			    				dataIn += StdDraw.nextKeyTyped();
			    			}
			    			if(StdDraw.isKeyPressed(KeyEvent.VK_ENTER))
			    			{
			    				enter2 = false;
			    			}
			    			else
			    			{
			    				enter2 = true;
			    			}
			    			if(StdDraw.isKeyPressed(KeyEvent.VK_BACK_SPACE) && dataIn.length() > 1)
			    			{
			    				dataIn = dataIn.substring(0, dataIn.length()-2);
			    				StdDraw.clear(StdDraw.BLACK);
			    				StdDraw.pause(50);
			    			}
			    			StdDraw.setFont(grande);
				    		StdDraw.text(50, 100, "SAVE YOUR SCORE");
				    		StdDraw.setFont(petite);
				    		StdDraw.line(20,69,60,69);
				    		StdDraw.picture(18, 71, "Images/fleche_droite.png");
				    		StdDraw.setPenColor(StdDraw.YELLOW);
			    			StdDraw.textLeft(23, 80, dataJ1);
			    			StdDraw.text(10, 80, "J1");
			    			StdDraw.setPenColor(50, 255, 70);
			    			StdDraw.textLeft(23, 70, dataIn);
			    			StdDraw.text(10, 70, "J2");
			    			StdDraw.setPenColor(StdDraw.WHITE);
			    			int sj2 = joueurs[1].getScore() + joueurs[1].getVie()*200 + bonusChrono;
			    			StdDraw.textRight(80, 80, Integer.toString(sj1));
			    			StdDraw.textRight(80, 70, Integer.toString(sj2));
			    			StdDraw.show(20);
			    		}
		    			fw.write("\r\n");
		    			for(int w = 0; w<dataIn.length();w++)
			    		{
				    		fw.write(dataIn.charAt(w));
			    		}		    		
		    			fw.write('$');
		    			int sj2 = joueurs[1].getScore() + joueurs[1].getVie()*200 + bonusChrono;
			    		String scoreJ2 = Integer.toString(sj2);
			    		fw.write(scoreJ2);
			    		fw.write('@');
		    		}
		    		fw.close();
		    		StdDraw.clear(StdDraw.BLACK);
		    	}
		        fr = new FileReader(f);
		        int i = 0;
		        while((i = fr.read()) != -1)
		        {
		          dataOut += (char)i;
		        }
		        for(int b = 0; b< dataOut.length(); b++)
		        {
		        	if(dataOut.charAt(b) == '$')
		        	{
		        		tailleTab++;
		        	}
		        }
		        tab_pseudo = new String[tailleTab];
	        	tab_scores = new int[tailleTab];
		       while(a < dataOut.length())
		        {
		        	while(dataOut.charAt(a) != '$')
		        	{
		        		sample += dataOut.charAt(a);
		        		a++;
		        	}
		        	a++;
		        	tab_pseudo[compteur] = sample;
		        	sample = "";
		        	while(dataOut.charAt(a) != '@')
		        	{
		        		sample += dataOut.charAt(a);
		        		a++;
		        	} 
		        	a++;
		        	numberScore = Integer.parseInt(sample);
		        	sample = "";
		        	tab_scores[compteur] = numberScore;
		        	compteur++;
		        }
		       
		       for(int s = 0; s < tab_scores.length; s++)
		       {
		    	   for(int t = 0; t < s; t++)
		    	   {
		    		   if(tab_scores[t] < tab_scores[s])
		    		   {
		    			   change = tab_scores[t];
		    			   tab_scores[t] = tab_scores[s];
		    			   tab_scores[s] = change;
		    			   changement = tab_pseudo[t];
		    			   tab_pseudo[t] = tab_pseudo[s];
		    			   tab_pseudo[s] = changement;
		    		   }
		    	   }
		       }
		       if(tab_scores.length < 10)
		       {
		    	   tailleMax = tab_scores.length;
		       }
		       else
		       {
		    	   tailleMax = 10;
		       }
		       
		       StdDraw.picture(54,118,"Images/Pacman_menu.png",73.3,46);
		       for(int l = 0; l < tailleMax; l++)
		       {
		    	   StdDraw.setPenColor(StdDraw.YELLOW);
		    	   StdDraw.textLeft(2, y, Integer.toString(l+1) + ".");
		    	   StdDraw.textRight(105, y, Integer.toString(tab_scores[l]));
		    	   StdDraw.setPenColor(StdDraw.WHITE);
		    	   StdDraw.textLeft(10, y, tab_pseudo[l]);	    	   
		    	   y -= 8.7;
		       }
				
				do {
					position5 = true;
					
					if (StdDraw.mouseX() > 43 && StdDraw.mouseX() < 66 && StdDraw.mouseY() > -3 && StdDraw.mouseY() < 6) {
						choixDuJoueur5 = true;
						position5 = false;
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.filledRectangle(55, -4, 30, 5);
						StdDraw.setFont(selection);
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.text(54, -4.3, "GO BACK");
					} else {
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.filledRectangle(55, -4, 30, 5);
						StdDraw.setFont(normale);
						StdDraw.setPenColor(200, 200, 200);
						StdDraw.text(54, -4, "GO BACK");				
					}
					
					StdDraw.pause(50);
					if (StdDraw.mousePressed()) {
						StdDraw.pause(300);
						clic5 = false;
						stay5 = false;
					} else {
						clic5 = true;
					}
					StdDraw.show(20);
				} while(clic5 || position5);
		      } catch (FileNotFoundException e) {
		        e.printStackTrace();
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		    StdDraw.show(20);
		    
	}

	public static int getHighscore()
	{
		int score = 0;
		int a = 0;
		File f = new File("sauvegardes.txt");
		FileReader fr;
		String dataOut = "";
		String sample = "";
		int [] tab_scores;
		int numberScore;
		int tailleTab = 0;
		int compteur = 0;
		int change;
	    int i = 0;
	    try
	    {
	    	fr = new FileReader(f);
	    while((i = fr.read()) != -1)
	    {
	      dataOut += (char)i;
	    }
	    for(int b = 0; b< dataOut.length(); b++)
	    {
	    	if(dataOut.charAt(b) == '$')
	    	{
	    		tailleTab++;
	    	}
	    }
		tab_scores = new int[tailleTab];
	   while(a < dataOut.length())
	    {
		   while(dataOut.charAt(a) != '$')
	   	{
	   		a++;
	   	} 
		   a++;
	    	while(dataOut.charAt(a) != '@')
	    	{
	    		sample += dataOut.charAt(a);
	    		a++;
	    	} 
	    	a++;
	    	numberScore = Integer.parseInt(sample);
	    	sample = "";
	    	tab_scores[compteur] = numberScore;
	    	compteur++;
	    }
	   
	   for(int s = 0; s < tab_scores.length; s++)
	   {
		   for(int t = 0; t < s; t++)
		   {
			   if(tab_scores[t] < tab_scores[s])
			   {
				   change = tab_scores[t];
				   tab_scores[t] = tab_scores[s];
				   tab_scores[s] = change;
			   }
		   }
	   }
	   
	   score = tab_scores[0];
	
	  } catch (FileNotFoundException e) {
	    e.printStackTrace();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
		return score;
	}
	
	public static boolean setDifficulty(int level, Fantome...fantomes)
	{
		boolean enableSwitch = false;
		switch(level)
		{
			case 1:
				fantomes[0].setComportement("traqueur");
				break;
			case 2:
				fantomes[0].setComportement("traqueur");
				fantomes[1].setComportement("traqueur");
				break;
			case 3:
				fantomes[0].setComportement("traqueur");
				fantomes[1].setComportement("embuscadeur");
				break;
			case 4:
				fantomes[0].setComportement("traqueur");
				fantomes[1].setComportement("traqueur");
				fantomes[2].setComportement("embuscadeur");
				break;
			case 5:
				fantomes[0].setComportement("traqueur");
				fantomes[1].setComportement("traqueur");
				fantomes[2].setComportement("embuscadeur");
				fantomes[3].setComportement("embuscadeur");
				enableSwitch = true;
				break;
			default:
				fantomes[0].setComportement("traqueur");
				fantomes[1].setComportement("traqueur");
				fantomes[2].setComportement("traqueur");
				fantomes[3].setComportement("traqueur");
				enableSwitch = true;
				break;
		}
		return enableSwitch;
	}
	
	public static void switchComportementFantome(Pacman p, Fantome...fantomes)
	{
		x = p.getPosx() - fantomes[0].getPosx();
		y = p.getPosy() - fantomes[0].getPosy();
		minD = Math.sqrt(x*x + y*y);
		maxD = Math.sqrt(x*x + y*y);
		fantMin = 0;
		fantMax = 0;
		for(int i = 1; i < fantomes.length; i++)
		{
			x = p.getPosx() - fantomes[i].getPosx();
			y = p.getPosy() - fantomes[i].getPosy();
			if(Math.sqrt(x*x + y*y) < minD)
			{
				minD = Math.sqrt(x*x + y*y);
				fantMin = i;
			}
			if(Math.sqrt(x*x + y*y) > maxD)
			{
				maxD = Math.sqrt(x*x + y*y);
				fantMax = i;
			}
		}
		
		fantomes[fantMin].setComportement("traqueur");
		fantomes[fantMax].setComportement("embuscadeur");
	}
	
	
	


}