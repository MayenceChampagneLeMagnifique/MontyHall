import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Cette classe permet de créer le jeu
 */
public class Jeu {

    private List<Partie> listeParties = new ArrayList();

    public void lancerPartie() {
        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenue au problème de Monty Hall");

        System.out.println("Vous allez avoir 3 portes devant vous et aller devoir choisir une des 3.");
        System.out.println("Dans 1 des 3 ce trouve un prix et dans les autres, rien.");
        System.out.println("Voulez vous jouer manuellement ( M ) ou plutot analyser les chances de tomber sur la porte avec le prix ? ( A )");

        String reponse = s.nextLine();

        System.out.println("Quel est votre nom ?");
        String nom = s.nextLine();
        Joueur joueur = new Joueur(nom);

        if (reponse.equalsIgnoreCase("M")) {
            JouerPartieManuellement(joueur);
        }

        if (reponse.equalsIgnoreCase("A")) {
            System.out.println("Combien de partie voulez-vous jouer ?");
            int nombrePartie = s.nextInt();
            JouerPartiesAuto(joueur, nombrePartie);
        }
    }

    public void ExporterParties(String path) {
        try {
            PrintWriter fichier = new PrintWriter(new FileWriter(path));
            for (Partie partie : listeParties) {
                fichier.println(partie.toString());
                fichier.println("\n");
            }

            fichier.flush();
            fichier.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public void LancerAnalyse(int nombreParties) {
//
//    }

    public void JouerPartiesAuto(Joueur joueur, int NombreParties) {
        Scanner s = new Scanner(System.in);

        System.out.println("Combien de fois sur 100 voulez vous changer de porte si la première est vide ?");
        int pourcentage = 150;
        do {
            pourcentage = s.nextInt();
            if (pourcentage < 0 || pourcentage > 100) {
                System.out.println("Vous n'avez pas entrée une valeur entre 0 et 100");
            }
        }
        while (pourcentage < 0 || pourcentage > 100);

    }

    public void JouerPartieManuellement(Joueur joueur) {
        Scanner s = new Scanner(System.in);
        System.out.println("Quelle porte voulez vous choisir ? ( 1, 2, 3, ...)");
        int indexPorte = s.nextInt();
        Partie partie = new Partie();

        Porte porteIndex = partie.getListePortes().get(indexPorte - 1);
        int indexGagnant = partie.getPorteGagnante();

        Random r = new Random();
        int rand = r.nextInt(1);
        int porteChoisiParAnimateur;

        switch(indexGagnant){
            case 0:
                if (rand == 0){
                    porteChoisiParAnimateur = 1;
                } else porteChoisiParAnimateur = 2;
            case 1:


            case 2:

        }
        System.out.println("L'animateur ouvre la porte numéro " + "" + ", il n'y a rien derrière");

    }
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.lancerPartie();

    }
}

