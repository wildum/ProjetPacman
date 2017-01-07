public class Chrono {

    private long tempsDepart = 0;
    private long tempsFin = 0;
    private long pauseDepart = 0;
    private long pauseFin = 0;
    private long duree = 0;

    public void start() {
        tempsDepart = System.currentTimeMillis();
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }

    public void pause() {
        
        pauseDepart = System.currentTimeMillis();
    }

    public void resume() {
        pauseFin = System.currentTimeMillis();
        tempsDepart = tempsDepart + pauseFin - pauseDepart;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }
        
    public void stop() {
        tempsFin = System.currentTimeMillis();
        duree = (tempsFin - tempsDepart) - (pauseFin - pauseDepart);
        tempsDepart = 0;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        }        

    public long getDureeSec() {
        return duree/1000;
    }
        
    public long getDureeMs() {
        return duree;
    }        
}