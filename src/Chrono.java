public class Chrono {

    private double tempsDepart = 0;
    private double tempsFin = 0;
    private double pauseDepart = 0;
    private double pauseFin = 0;
    private double duree = 0;

    public void start() { // départ chrono
        tempsDepart = System.currentTimeMillis();
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }

    public void pause() { // pause chrono
        pauseDepart = System.currentTimeMillis();
        duree = (tempsFin - tempsDepart) - (pauseFin - pauseDepart);
    }

    public void resume() { // reprise chrono
        pauseFin = System.currentTimeMillis();
        tempsDepart = tempsDepart + pauseFin - pauseDepart;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }
        
    public void stop() { // arrêt chrono
        tempsFin = System.currentTimeMillis();
        duree = (tempsFin - tempsDepart) - (pauseFin - pauseDepart);
        tempsDepart = 0;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        }        

    public double getDureeSec() { // permet d'obtenir la durée du chrono en secondes
        return duree/1000;
    }
        
    public double getDureeMs() { // permet d'obtenir la durée du chrono en millisecondes
        return duree;
    }      

}