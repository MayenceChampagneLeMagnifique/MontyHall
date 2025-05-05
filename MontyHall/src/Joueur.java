/**
 * Cette classe permet de créer un joueur
 */

public class Joueur {

    private String nom;
    private int nombreDePartiesJouees;
    private double pourcentagePartiesGagnees;
    private double pourcentageChangementDePortes;

    public Joueur(String nom) {
        setNom(nom);
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
        return "Joueur :" + getNom() + ". Nombre de parties jouées : " + nombreDePartiesJouees + ". Pourcentage de parties gagnées : " + pourcentagePartiesGagnees + ". Pourcentage de changement de portes : " + pourcentageChangementDePortes + ".";
    }
}
