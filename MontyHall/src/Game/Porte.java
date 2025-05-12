package Game;

/**
 * Cette classe permet de créer une porte
 */

public class Porte {
    private Prix prix;

    public Porte(Prix prix) {
        setPrix(prix);
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }
}
