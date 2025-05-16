package Game;

/**
 * Cette classe permet de créer une porte
 */

public class Porte {
    private boolean gagnante;
    private boolean choisie;
    private boolean ouverte;

    public Porte() {
        this.gagnante = false;
        this.choisie = false;
        this.ouverte = false;
    }

    public boolean isGagnante() {
        return gagnante;
    }

    public void setGagnante() {
        gagnante = true;
    }

    public void setChoisie(boolean choisie) {
        this.choisie = choisie;
    }

    public boolean isChoisie() {
        return choisie;
    }

    public boolean isOuverte() {
        return ouverte;
    }

    public void setOuverte(boolean ouverte) {
        this.ouverte = ouverte;
    }
}
