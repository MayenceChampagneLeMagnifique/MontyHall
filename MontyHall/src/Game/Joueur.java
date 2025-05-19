package Game;

import java.util.Random;

/**
 * Représente un joueur simulé dans le problème de Monty Hall.
 * <p>
 * Chaque joueur est défini par un pourcentage de changement de porte lorsqu'une porte vide est révélée.
 * Il peut jouer automatiquement des parties, accumuler ses statistiques, et calculer son taux de victoire.
 * </p>
 *
 * Javadoc générée par une intelligence artificielle (ChatGPT).
 */
public class Joueur {

    private int nombreDePartiesJouees = 0;
    private double pourcentagePartiesGagnees;
    private int nombrePartiesGagnees = 0;
    private int pourcentageChangementDePortes;

    /**
     * Construit un nouveau joueur avec une probabilité définie de changer de porte.
     *
     * @param pourcentageChangementDePortes Pourcentage (0-100) représentant la chance que le joueur change de porte lorsqu'une porte vide est révélée.
     */
    public Joueur(int pourcentageChangementDePortes) {
        this.pourcentageChangementDePortes = pourcentageChangementDePortes;
    }

    /**
     * Fait jouer automatiquement une partie au joueur.
     * <p>
     * Le joueur choisit une porte au hasard, puis peut changer ou non de porte
     * selon sa stratégie. À la fin, les statistiques sont mises à jour.
     * </p>
     */
    public void jouerPartieAuto() {
        Random r = new Random();
        Partie p = new Partie();

        // Choix aléatoire de la porte
        p.setIndexPorteChoisie(r.nextInt(p.getListePortes().size()));

        // L'animateur ouvre une porte vide
        p.ouvrirPortes();

        // Décision de changer de porte selon le pourcentage défini
        if (r.nextInt(100) < pourcentageChangementDePortes) {
            p.changerPorte();
        }

        // Vérification du résultat
        if (p.getIndexPorteChoisie() == p.getIndexPorteGagnante()) {
            nombrePartiesGagnees++;
        }

        nombreDePartiesJouees++;
    }

    /**
     * Renvoie le nombre total de parties gagnées par le joueur.
     *
     * @return Le nombre de victoires.
     */
    public int getNombrePartiesGagnees() {
        return nombrePartiesGagnees;
    }

    /**
     * Renvoie le nombre total de parties jouées par le joueur.
     *
     * @return Le nombre de parties jouées.
     */
    public int getNombreDePartiesJouees() {
        return nombreDePartiesJouees;
    }

    /**
     * Renvoie le pourcentage de changement de porte utilisé par ce joueur.
     *
     * @return Pourcentage de changement de porte (entre 0 et 100).
     */
    public double getpourcentageChangementDePortes() {
        return pourcentageChangementDePortes;
    }

    /**
     * Calcule et renvoie le pourcentage de parties gagnées.
     *
     * @return Pourcentage de victoires (entre 0 et 100).
     */
    public double getPourcentagePartiesGagnees() {
        if (nombreDePartiesJouees > 0) {
            pourcentagePartiesGagnees = ((double) nombrePartiesGagnees / nombreDePartiesJouees) * 100;
        } else {
            pourcentagePartiesGagnees = 0;
        }

        return pourcentagePartiesGagnees;
    }
}
