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
        List<Integer> indexPossibles = new ArrayList<>();
        Random r = new Random();
        int indexPorteFermee;

        for (int index = 0; index < listePortes.size(); index++) {
            Porte p = listePortes.get(index);

            if (!p.isChoisie() && !p.isGagnante()) {
                indexPossibles.add(index);
            }
        }

        indexPorteFermee= r.nextInt(indexPossibles.size());

        for (int index = 0; index < listePortes.size(); index++) {
            if (index != indexPorteFermee) {
                listePortes.get(index).setOuverte(true);
            } else {
                indexPorteRestante = index;
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
    }

    @Override
    public String toString() {
        return "Partie : " + getListePortes() + " | Porte Gagnante : " + indexPorteGagnante;
    }
}
