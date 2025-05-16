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
    private int porteGagnante;

    public Partie() {
        creerPortes();
    }

    private void creerPortes() {
        Random r = new Random();

        for (int i = 0; i < NOMBRE_PORTES; i++) {
            listePortes.add(new Porte());
        }

        porteGagnante = r.nextInt(NOMBRE_PORTES);

        listePortes.get(porteGagnante).setGagnante();
    }

    //L'animateur qui ouvre la porte
    public void ouvrirPorte() {
        List<Integer> indexPossibles = new ArrayList<>();

        for (int index = 0; index < listePortes.size(); index++) {
            Porte p = listePortes.get(index);

            if (!p.isChoisie() && p.isGagnante()) {
                indexPossibles.add(index);
            }
        }
    }

    public void changerPorte() {

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
        return "Partie : " + getListePortes() + " | Porte Gagnante : " + porteGagnante;
    }
}
