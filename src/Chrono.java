public class Chrono {

    private long tempsDepart = 0;
    private long tempsFin = 0;
    private long pauseDepart = 0;
    private long pauseFin = 0;
    private long duree = 0;

    public void start() { // pour faire démarrer le chrono
        tempsDepart = System.currentTimeMillis();
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }

    public void pause() { // pause du chrono
        
        pauseDepart = System.currentTimeMillis();
    }

    public void resume() { // reprendre le chrono après une pause
        pauseFin = System.currentTimeMillis();
        tempsDepart = tempsDepart + pauseFin - pauseDepart;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }
        
    public void stop() { // stoper le chrono (définitif)
        tempsFin = System.currentTimeMillis();
        duree = (tempsFin - tempsDepart) - (pauseFin - pauseDepart);
        tempsDepart = 0;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        }        

    public long getDureeSec() { // obtenir la durée en secondes
        return duree/1000;
    }
        
    public long getDureeMs() { // obtenir la durée en millisecondes
        return duree;
    }        
}