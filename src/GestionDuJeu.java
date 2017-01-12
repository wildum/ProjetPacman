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
	static Chrono chrono = new Chrono();
	static Font trespetite = new Font("SHOWCARD GOTHIC", Font.BOLD, 15), petite = new Font("SHOWCARD GOTHIC", Font.BOLD, 18), normale = new Font("SHOWCARD GOTHIC", Font.BOLD, 20), selection = new Font("SHOWCARD GOTHIC", Font.BOLD, 22), grande = new Font("SHOWCARD GOTHIC", Font.BOLD, 40);
	
	
	public static Chrono getChrono() {
		return chrono;
	}
	
	// affichageMenuPage1() gère l'affiche du menu principal	
	public static int affichageMenuPage1()
		{
			boolean clic = true;
			boolean position = true;
			int choixDuJoueur = 0;
			StdDraw.setCanvasSize(500,760); 
			StdDraw.setXscale(-2,110);
			StdDraw.setYscale(-27,149);
			StdDraw.setFont(normale);
			StdDraw.clear(StdDraw.BLACK);
			StdDraw.picture(54,105,"Images/Pacman_menu.png",110,69);
			
			do
			{
				position = true;			
				
				// ONE PLAYER :
				if(StdDraw.mouseX() > 39.5 && StdDraw.mouseX() < 69 && StdDraw.mouseY() > 36 && StdDraw.mouseY() < 40.5) // choix du mode 1 joueur
				{
					choixDuJoueur = 1;
					position = false;
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
				if(StdDraw.mouseX() > 37.2 && StdDraw.mouseX() < 71.1 && StdDraw.mouseY() > 26.3 && StdDraw.mouseY() < 30) // choix du mode 2 joueurs
				{
					choixDuJoueur = 2;
					position = false;
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
				if(StdDraw.mouseX() > 39.5 && StdDraw.mouseX() < 69.5 && StdDraw.mouseY() > 17.1 && StdDraw.mouseY() < 21) // choix de regarder les meilleurs scores
				{
					choixDuJoueur = 3;
					position = false;
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
				if(StdDraw.mouseX() > 41 && StdDraw.mouseX() < 66 && StdDraw.mouseY() > 8 && StdDraw.mouseY() < 12)
				{
					choixDuJoueur = 5;
					position = false;
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
				if(StdDraw.mouseX() > 47 && StdDraw.mouseX() < 61 && StdDraw.mouseY() > -2 && StdDraw.mouseY() < 4) // choix de quitter
				{
					choixDuJoueur = 4;
					position = false;
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
					clic = false;
				}
				else
				{
					clic = true;
				}
				
				
				StdDraw.show(20);
				StdDraw.pause(50);
				} while(clic || position);
			
			return choixDuJoueur;
		}

	public static boolean affichageMenuPause()
	{
		boolean choixDuJoueur = true;
		boolean loop = true;;
		StdDraw.setFont(selection);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(54.5, 74.5, "PAUSED");
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(normale);
		StdDraw.text(54, 51, "QUIT? Y/N");
		while(loop)
		{
			StdDraw.show(20);
			if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) || StdDraw.isKeyPressed(KeyEvent.VK_N))
			{
				loop = false;
				choixDuJoueur = true;
			}
			if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE) || StdDraw.isKeyPressed(KeyEvent.VK_Y))
			{
				loop = false;
				choixDuJoueur = false;
			}
		}
		return choixDuJoueur;
	}
	
	
	public static boolean affichageMenuControl() {
		boolean clic = true, position = true, choixDuJoueur = false;
		StdDraw.setCanvasSize(500,760); 
		StdDraw.setXscale(-2,110);
		StdDraw.setYscale(-27,149); 
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.picture(54,114,"Images/TitreMenu.png",80,30);
		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setFont(normale);		
		StdDraw.text(57, 85, "PLAYER 1 : ");
		StdDraw.text(57, 65, "PLAYER 2 : ");
		StdDraw.text(56, 27, "GAME : ");
						
		StdDraw.setPenColor(180, 180, 180);
		StdDraw.setFont(petite);
		StdDraw.text(55, 78, "ARROW KEYS");
		StdDraw.text(55, 58, "Z: UP");
		StdDraw.text(55, 52, "Q: LEFT");
		StdDraw.text(55, 46, "S: DOWN");
		StdDraw.text(55, 40, "D: RIGHT");
		StdDraw.text(55, 20, "SPACE: PAUSE/RESUME");
		StdDraw.text(55, 14, "ECHAP: EXIT");
		
				
		do {
			position = true;
			
			if (StdDraw.mouseX() > 43 && StdDraw.mouseX() < 66 && StdDraw.mouseY() > -1 && StdDraw.mouseY() < 4) {
				choixDuJoueur = true;
				position = false;
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
				clic = false;
			} else {
				clic = true;
			}
			StdDraw.show(20);
		} while(clic || position);
		
		return choixDuJoueur;
	}
	
	public static int checkWinLoose(Graine [][] tab_graines, Joueur...joueurs)
	{
		int fin = 0, compteur = 0, compteur2 = 0;
		
		for(int i = 0; i < tab_graines.length;i++)
		{
			for(int j = 0; j < tab_graines[i].length; j++)
			{
				if(tab_graines[i][j].type == "standard")
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
		StdDraw.setFont(grande);
		boolean loop = true;
		boolean choixDuJoueur = true;
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
			
		
		return choixDuJoueur;
	}
	

public static void highscores(boolean save, boolean P2, Joueur...joueurs)
{
	boolean stay = true;
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
	boolean enter = false;
	boolean enter2 = false;
	String changement = "";
	StdDraw.setFont(normale);
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
	    			if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && dataIn.length() > 1)
	    			{
	    				dataIn = dataIn.substring(0, dataIn.length()-2);
	    				StdDraw.clear(StdDraw.BLACK);
	    				StdDraw.pause(50);
	    			}
	    			StdDraw.setFont(grande);
		    		StdDraw.text(50, 100, "SAVE YOUR SCORE");
		    		StdDraw.setFont(petite);
	    			StdDraw.setPenColor(StdDraw.YELLOW);
	    			StdDraw.textLeft(30, 80, dataIn);
	    			StdDraw.setPenColor(StdDraw.WHITE);
	    			StdDraw.textRight(80, 80, Integer.toString(joueurs[0].getScore()));
	    			StdDraw.show(20);
	    		}
	    		fw.write("\r\n");
	    		for(int u = 0; u<dataIn.length();u++)
	    		{
		    		fw.write(dataIn.charAt(u));
	    		}
	    		fw.write('$');
	    		String scoreJ1 = Integer.toString(joueurs[0].getScore());
	    		fw.write(scoreJ1);
	    		fw.write('@');
	    		if(P2)
	    		{
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
		    			if(StdDraw.isKeyPressed(KeyEvent.VK_SPACE) && dataIn.length() > 1)
		    			{
		    				dataIn = dataIn.substring(0, dataIn.length()-2);
		    				StdDraw.clear(StdDraw.BLACK);
		    				StdDraw.pause(50);
		    			}
		    			StdDraw.setFont(grande);
			    		StdDraw.text(50, 100, "SAVE YOUR SCORE");
			    		StdDraw.setFont(petite);
			    		StdDraw.setPenColor(StdDraw.YELLOW);
		    			StdDraw.textLeft(30, 80, dataJ1);
		    			StdDraw.setPenColor(StdDraw.GREEN);
		    			StdDraw.textLeft(30, 70, dataIn);
		    			StdDraw.setPenColor(StdDraw.WHITE);
		    			StdDraw.textRight(80, 80, Integer.toString(joueurs[0].getScore()));
		    			StdDraw.textRight(80, 70, Integer.toString(joueurs[1].getScore()));
		    			StdDraw.show(20);
		    		}
	    			fw.write("\r\n");
	    			for(int w = 0; w<dataIn.length();w++)
		    		{
			    		fw.write(dataIn.charAt(w));
		    		}		    		
	    			fw.write('$');
		    		String scoreJ2 = Integer.toString(joueurs[1].getScore());
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
	       for(int l = 0; l < tailleMax; l++)
	       {
	    	   StdDraw.textLeft(35, y, Integer.toString(l+1) + "." + tab_pseudo[l] + "     " + Integer.toString(tab_scores[l]));
	    	   y -= 10;
	       }
	
	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    StdDraw.show(20);
	    while(stay)
		{
	    	StdDraw.pause(50);
	    	if(StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE))
	    	{
	    		StdDraw.pause(50);
	    		stay = false;
	    	}
		}
	}
}