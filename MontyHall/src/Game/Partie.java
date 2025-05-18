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
    private int indexPorteGagnante;
    private int indexPorteRestante;
    private int indexPorteChoisie;

    public Partie() {
        creerPortes();
    }

    private void creerPortes() {
        Random r = new Random();

        for (int i = 0; i < NOMBRE_PORTES; i++) {
            listePortes.add(new Porte());
        }

        indexPorteGagnante = r.nextInt(NOMBRE_PORTES);

        listePortes.get(indexPorteGagnante).setGagnante();
    }

    //L'animateur qui ouvre la porte
    public void ouvrirPortes() {
        List<Integer> candidats = new ArrayList<>();
        for (int i = 0; i < listePortes.size(); i++) {
            Porte p = listePortes.get(i);
            if (!p.isChoisie() && !p.isGagnante()) {
                candidats.add(i);
            }
        }
        Random r = new Random();
        int porteOuverte = candidats.get(r.nextInt(candidats.size()));
        listePortes.get(porteOuverte).setOuverte(true);

        for (int i = 0; i < listePortes.size(); i++) {
            Porte p = listePortes.get(i);
            if (!p.isOuverte() && !p.isChoisie()) {
                indexPorteRestante = i;
                break;
            }
        }
    }

    public void changerPorte() {
        for (Porte p : listePortes) {
            if (p.isChoisie()) {
                p.setChoisie(false);
            }
        }

        listePortes.get(indexPorteRestante).setChoisie(true);
        setIndexPorteChoisie(indexPorteRestante);
    }

    public List<Porte> getListePortes() {
        return listePortes;

    }
    public int getNOMBRE_PORTES() {
        return NOMBRE_PORTES;
    }

    public int getIndexPorteGagnante() {
        return indexPorteGagnante;
    }

    public int getIndexPorteChoisie() {
        return indexPorteChoisie;
    }

    public void setIndexPorteChoisie(int indexPorteChoisie) {
        this.indexPorteChoisie = indexPorteChoisie;
        listePortes.get(indexPorteChoisie).setChoisie(true);

    }
}
