package Game;

import java.util.Random;

/**
 * Cette classe permet de créer un joueur
 */

public class Joueur {

    private String nom;
    private int nombreDePartiesJouees = 0;
    private double pourcentagePartiesGagnees;
    private int pourcentageChangementDePortes;

    public Joueur(String nom) {
        setNom(nom);
    }

    public Joueur(int pourcentageChangementDePortes) {
        this.pourcentageChangementDePortes = pourcentageChangementDePortes;
    }

    public void jouerPartieAuto() {
        Random r = new Random();
        Partie p = new Partie();

        p.ouvrirPorte();
        if (r.nextInt(100) < pourcentageChangementDePortes) {

        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreDePartiesJouees() {
        return nombreDePartiesJouees;
    }

    public void setNombreDePartiesJouees(int nombreDePartiesJouees) {
        this.nombreDePartiesJouees = nombreDePartiesJouees;
    }

    public double getpourcentageChangementDePortes() {
        return pourcentageChangementDePortes;
    }

    public double getPourcentagePartiesGagnees() {
        return pourcentagePartiesGagnees;
    }

    @Override
    public String toString() {
        return "Game.Joueur :" + getNom() + ". Nombre de parties jouées : " + nombreDePartiesJouees + ". Pourcentage de parties gagnées : " + pourcentagePartiesGagnees + ". Pourcentage de changement de portes : " + pourcentageChangementDePortes + ".";
    }
}
