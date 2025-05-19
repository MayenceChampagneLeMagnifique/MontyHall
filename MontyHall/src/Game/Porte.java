package Game;

/**
 * Représente une porte dans le jeu du type Monty Hall.
 * <p>
 * Une porte peut être :
 * <ul>
 *     <li>Gagnante (elle cache le prix)</li>
 *     <li>Choisie (sélectionnée par le joueur)</li>
 *     <li>Ouverte (ouverte par l'animateur)</li>
 * </ul>
 * </p>
 *
 * Javadoc générée par une intelligence artificielle (ChatGPT).
 */
public class Porte {

    private boolean gagnante;
    private boolean choisie;
    private boolean ouverte;

    /**
     * Constructeur de la classe Porte.
     * Initialise une porte non gagnante, non choisie et fermée.
     */
    public Porte() {
        this.gagnante = false;
        this.choisie = false;
        this.ouverte = false;
    }

    /**
     * Indique si cette porte est la porte gagnante.
     *
     * @return {@code true} si la porte est gagnante, sinon {@code false}.
     */
    public boolean isGagnante() {
        return gagnante;
    }

    /**
     * Définit cette porte comme gagnante.
     */
    public void setGagnante() {
        gagnante = true;
    }

    /**
     * Définit si cette porte est choisie par le joueur.
     *
     * @param choisie {@code true} si la porte est choisie, sinon {@code false}.
     */
    public void setChoisie(boolean choisie) {
        this.choisie = choisie;
    }

    /**
     * Indique si cette porte est actuellement choisie par le joueur.
     *
     * @return {@code true} si la porte est choisie, sinon {@code false}.
     */
    public boolean isChoisie() {
        return choisie;
    }

    /**
     * Indique si cette porte a été ouverte par l'animateur.
     *
     * @return {@code true} si la porte est ouverte, sinon {@code false}.
     */
    public boolean isOuverte() {
        return ouverte;
    }

    /**
     * Définit si cette porte est ouverte.
     *
     * @param ouverte {@code true} pour ouvrir la porte, {@code false} pour la fermer.
     */
    public void setOuverte(boolean ouverte) {
        this.ouverte = ouverte;
    }
}
