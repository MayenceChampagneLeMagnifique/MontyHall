import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Cette classe permet de créer le jeu
 */
public class Jeu {
    private List<Partie> listeParties = new ArrayList();

    public void LancerPartie(){
        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenue au problème de Monty Hall");

        System.out.println("Vous allez avoir 3 portes devant vous et aller devoir choisir une des 3.");
        System.out.println("Dans 1 des 3 ce trouve un prix et dans les autres, rien.");
        System.out.println("Voulez vous jouer manuellement ( M ) ou plutot analyser les chances de tomber sur la porte avec le prix ? ( A )");

        String reponse = s.nextLine();

        System.out.println("Quel est votre nom ?");
        String nom = s.nextLine();
        Joueur joueur = new Joueur(nom);

        if (reponse.equalsIgnoreCase("M")){
            JouerPartieManuel(joueur);
        }

        if (reponse.equalsIgnoreCase("A")){
            System.out.println("Combien de partie voulez-vous jouer ?");
            int nombrePartie = s.nextInt();
            JouerParties(joueur, nombrePartie);
        }
    }

    public void ExporterParties(String path){
        try {
            PrintWriter fichier = new PrintWriter(new FileWriter(path));
            for (Partie partie : listeParties){
                fichier.println(partie);
                fichier.println("\n");
            }

            fichier.flush();
            fichier.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void LancerAnalyse(int nombreParties){

    }

    public void JouerParties(Joueur joueur, int NombreParties){
        Scanner s = new Scanner(System.in);

        System.out.println("Combien de fois sur 100 voulez vous changer de porte si la première est vide ?");
        String pourcentage = s.nextLine();

    }

    public void JouerPartieManuel(Joueur joueur){
        Scanner s = new Scanner(System.in);

        System.out.println();
        String s1 = s.nextLine();

    }
}

