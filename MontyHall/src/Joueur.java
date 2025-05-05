/**
 * Cette classe permet de créer un joueur
 */

public class Joueur {

    private String nom;
    private int nombreDePartiesAJouer;
    private double pourcentagePartiesGagnees;
    private double pourcentageChangementDePortes;

    public Joueur(String nom, int nombreDePartiesAJouer) {
        setNom(nom);
        setNombreDePartiesAJouer(nombreDePartiesAJouer);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreDePartiesAJouer() {
        return nombreDePartiesAJouer;
    }

    public void setNombreDePartiesAJouer(int nombreDePartiesAJouer) {
        this.nombreDePartiesAJouer = nombreDePartiesAJouer;
    }

    public double getpourcentageChangementDePortes() {
        return pourcentageChangementDePortes;
    }

    public double getPourcentagePartiesGagnees() {
        return pourcentagePartiesGagnees;
    }

    @Override
    public String toString() {
        return "Joueur :" + getNom() + ". Nombre de parties jouées : " + nombreDePartiesAJouer + ". Pourcentage de parties gagnées : " + pourcentagePartiesGagnees + ". Pourcentage de changement de portes : " + pourcentageChangementDePortes + ".";
    }
}
