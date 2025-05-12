package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Cette classe permet d'initialiser une partie
 */

public class Partie {
    private final int NOMBRE_PORTES = 3;
    private List<Porte> listePortes = new ArrayList<>();
    private static final Prix PRIX_DEFAUT = Prix.AUCUN_PRIX;
    private int porteGagnante;

    public Partie() {
        creerPortes();
    }

    private void creerPortes() {
        Random r = new Random();

        for (int i = 0; i < NOMBRE_PORTES; i++) {
            listePortes.add(new Porte(PRIX_DEFAUT));
        }

        porteGagnante = r.nextInt(NOMBRE_PORTES);

        listePortes.get(porteGagnante).setPrix(Prix.VOITURE);
    }

    public List<Porte> getListePortes() {
        return listePortes;

}
    public int getNOMBRE_PORTES() {
        return NOMBRE_PORTES;
    }

    public int getPorteGagnante() {
        return porteGagnante;
    }

    @Override
    public String toString() {
        return "Game.Partie : " + getListePortes() + " | Game.Porte Gagnante : " + porteGagnante;
    }
}
