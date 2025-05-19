package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente une partie du jeu de Monty Hall.
 * <p>
 * Une partie comporte 3 portes, dont une seule cache un prix.
 * Le joueur choisit une porte, l'animateur en ouvre une autre (vide),
 * puis le joueur peut décider de changer ou non sa sélection.
 * </p>
 *
 * Javadoc générée par une intelligence artificielle (ChatGPT).
 */
public class Partie {

    private final int NOMBRE_PORTES = 3;
    private List<Porte> listePortes = new ArrayList<>();
    private int indexPorteGagnante;
    private int indexPorteRestante;
    private int indexPorteChoisie;

    /**
     * Crée une nouvelle partie en initialisant les portes et en plaçant le prix derrière l'une d'elles.
     */
    public Partie() {
        creerPortes();
    }

    /**
     * Initialise les portes du jeu et détermine aléatoirement laquelle est gagnante.
     */
    private void creerPortes() {
        Random r = new Random();

        for (int i = 0; i < NOMBRE_PORTES; i++) {
            listePortes.add(new Porte());
        }

        indexPorteGagnante = r.nextInt(NOMBRE_PORTES);
        listePortes.get(indexPorteGagnante).setGagnante();
    }

    /**
     * L'animateur ouvre une porte vide (ni choisie ni gagnante),
     * puis identifie la dernière porte restante.
     */
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

        // Identifier la dernière porte non ouverte et non choisie
        for (int i = 0; i < listePortes.size(); i++) {
            Porte p = listePortes.get(i);
            if (!p.isOuverte() && !p.isChoisie()) {
                indexPorteRestante = i;
                break;
            }
        }
    }

    /**
     * Change la sélection du joueur vers la dernière porte restante.
     */
    public void changerPorte() {
        for (Porte p : listePortes) {
            if (p.isChoisie()) {
                p.setChoisie(false);
            }
        }

        listePortes.get(indexPorteRestante).setChoisie(true);
        setIndexPorteChoisie(indexPorteRestante);
    }

    /**
     * Renvoie la liste des portes de la partie.
     *
     * @return Liste des objets {@link Porte}.
     */
    public List<Porte> getListePortes() {
        return listePortes;
    }

    /**
     * Renvoie le nombre total de portes dans la partie.
     *
     * @return Le nombre de portes (en général 3).
     */
    public int getNOMBRE_PORTES() {
        return NOMBRE_PORTES;
    }

    /**
     * Renvoie l'indice de la porte gagnante (celle qui cache le prix).
     *
     * @return Indice de la porte gagnante.
     */
    public int getIndexPorteGagnante() {
        return indexPorteGagnante;
    }

    /**
     * Renvoie l'indice de la porte actuellement choisie par le joueur.
     *
     * @return Indice de la porte choisie.
     */
    public int getIndexPorteChoisie() {
        return indexPorteChoisie;
    }

    /**
     * Définit l'indice de la porte choisie et marque cette porte comme "choisie".
     *
     * @param indexPorteChoisie Indice de la porte choisie.
     */
    public void setIndexPorteChoisie(int indexPorteChoisie) {
        this.indexPorteChoisie = indexPorteChoisie;
        listePortes.get(indexPorteChoisie).setChoisie(true);
    }
}
