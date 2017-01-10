
public class Joueur {
	private int score, vie;
	private final String nom = new String();
	private Pacman pacman;
	private boolean vivant;
	
	public Joueur(){
		score = 0;
		vie = 3;
		vivant = true;
	}
	
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public Pacman getPacman() {
		return pacman;
	}
	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getNom() {
		return nom;
	}
	
	public boolean isVivant()
	{
		return vivant;
	}
	public void setVivant(boolean vivant)
	{
		this.vivant = vivant;
	}
	
}
