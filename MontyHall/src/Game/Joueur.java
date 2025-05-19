package Game;

import java.util.Random;

/**
 * Cette classe permet de créer un joueur
 */

public class Joueur {
    private int nombreDePartiesJouees = 0;
    private double pourcentagePartiesGagnees;
    private int nombrePartiesGagnees = 0;
    private int pourcentageChangementDePortes;


    public Joueur(int pourcentageChangementDePortes) {
        this.pourcentageChangementDePortes = pourcentageChangementDePortes;
    }

    public void jouerPartieAuto() {
        Random r = new Random();
        Partie p = new Partie();

        //Choix aléatoire de la porte
        p.setIndexPorteChoisie(r.nextInt(p.getListePortes().size()));

        //L'animateur ouvre les portes
        p.ouvrirPortes();

        //Changement de porte
        if (r.nextInt(100) < pourcentageChangementDePortes) {
            p.changerPorte();
        }

        //Vérification si victoire
        if (p.getIndexPorteChoisie() == p.getIndexPorteGagnante()) {
            nombrePartiesGagnees++;
        }

        nombreDePartiesJouees++;
    }

    public int getNombrePartiesGagnees() {
        return nombrePartiesGagnees;
    }

    public int getNombreDePartiesJouees() {
        return nombreDePartiesJouees;
    }

    public double getpourcentageChangementDePortes() {
        return pourcentageChangementDePortes;
    }

    public double getPourcentagePartiesGagnees() {
        if (nombreDePartiesJouees > 0) {
            pourcentagePartiesGagnees = ((double) nombrePartiesGagnees / nombreDePartiesJouees) * 100;
        } else {
            pourcentagePartiesGagnees = 0;
        }

        return pourcentagePartiesGagnees;
    }
}
