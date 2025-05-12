package Game;

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
    public Jeu() {
    }

    public void Jouer() {
        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenue au problème de Monty Hall !" + "\n");

        System.out.println("Ce problème est définit comme suit : vous avez 3 portes devant vous, une des portes possède un prix et les deux autres sont vides.");
        System.out.println("Vous devez choirir une porte. Ensuite, l'animateur ouvre une des porte restante, qui est vide.");
        System.out.println("Le dilemme est le suivant : changez-vous votre choix de porte?" + "\n");

        System.out.println("Ce programme comporte deux modes ; un mode manuel et un mode automatique.");
        System.out.println("Le mode manuel vous permet de participer comme si vous étiez en temps réel dans le problème.");
        System.out.println("Le mode automatique simule un nombre de joueurs de votre choix changeant de portes pour un pourcentage de votre choix et faisant un nombre de parties de votre choix." + "\n");

        System.out.println("Désirez-vous lancer le mode manuel ( M ) ou le mode automatique ( A ) ?");

        String reponse = s.nextLine();


        while (!reponse.equalsIgnoreCase("M") && !reponse.equalsIgnoreCase("A")) {
            System.out.println("Réponse incorrecte.");
            System.out.println("Désirez-vous lancer le mode manuel ( M ) ou le mode automatique ( A ) ?");

            reponse = s.nextLine();
        }

        if (reponse.equalsIgnoreCase("M")) {
            jouerPartieManuellement();
        }

        if (reponse.equalsIgnoreCase("A")) {
            jouerPartiesAuto();
        }
    }

    public void exporterParties(String path) {
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


    public void jouerPartiesAuto() {
        Scanner s = new Scanner(System.in);
        List<Joueur> listeJoueurs = new ArrayList<>();
        String reponse = "";
        int reponseInt = -1;

        System.out.println("Voulez vous ajouter ( A ) un joueur ou lancer le jeu ( L )?");

        reponse = s.nextLine();

        while (!reponse.equalsIgnoreCase("L")) {

            //Ajouter des joueurs dans listeJoueurs
            if (reponse.equalsIgnoreCase("A")) {
                boolean bonneReponse = false;

                while (!bonneReponse) {
                    System.out.println("Combien de fois sur 100 voulez vous que ce joueur change de porte?");
                    reponse = s.nextLine();

                    //Teste si la réponse est bien un int
                    try {
                        reponseInt = Integer.parseInt(reponse);
                    } catch (NumberFormatException e) {
                        System.out.println("Erreur : Seulement les nombres entre 0 et 100 sont acceptés");
                    }

                    if (reponseInt >= 0 && reponseInt <= 100) {
                        bonneReponse = true;
                    } else {
                        System.out.println("Entrez un nombre entre 0 et 100");
                    }
                }

                Joueur joueur = new Joueur(reponseInt);

                listeJoueurs.add(joueur);
            } else {
                System.out.println("Voulez vous ajouter ( A ) un joueur ou lancer le jeu ( L )?");

                reponse = s.nextLine();
            }
        }



    }

    public void jouerPartieManuellement() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        Partie partie = new Partie();

        int indexGagnant = partie.getPorteGagnante();

        System.out.println("Choisissez une porte (0, 1 ou 2) : ");
        int indexPorte = -1;
        while (indexPorte < 0 || indexPorte > 2) {
            try {
                indexPorte = Integer.parseInt(s.nextLine());
                if (indexPorte < 0 || indexPorte > 2) {
                    System.out.println("Veuillez choisir une porte entre 0 et 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrez un nombre valide.");
            }
        }

        List<Integer> portesPossibles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (i != indexPorte && i != indexGagnant) {
                portesPossibles.add(i);
            }
        }

        int porteOuverte = portesPossibles.get(r.nextInt(portesPossibles.size()));
        System.out.println("L'animateur ouvre la porte " + porteOuverte + " (vide).");

        System.out.println("Souhaitez-vous changer de porte (C) ou garder votre choix (G) ?");
        String strReponse = "";
        while (!strReponse.equalsIgnoreCase("c") && !strReponse.equalsIgnoreCase("g")) {
            strReponse = s.nextLine();
            if (!strReponse.equalsIgnoreCase("c") && !strReponse.equalsIgnoreCase("g")) {
                System.out.println("Réponse invalide. Entrez 'C' pour changer ou 'G' pour garder.");
            }
        }

        boolean aChange = false;
        if (strReponse.equalsIgnoreCase("c")) {
            for (int i = 0; i < 3; i++) {
                if (i != indexPorte && i != porteOuverte) {
                    indexPorte = i;
                    aChange = true;
                    break;
                }
            }
        }

        boolean aGagne = (indexPorte == indexGagnant);

        if (aGagne) {
            System.out.println("🎉 Vous avez gagné !");
        } else {
            System.out.println("😢 Vous avez perdu. Le prix était derrière la porte " + indexGagnant);
        }

        String rep = s.nextLine();

        System.out.println("Voulez vous rejouer une partie ? Oui (O) ou Non (N)");

        while (!rep.equalsIgnoreCase("o") && !rep.equalsIgnoreCase("n")) {
            System.out.println("Réponse incorrecte.");
            System.out.println("Désirez-vous relancer une partie ? Oui (O) ou Non (N)");

            rep = s.nextLine();
        }

        if (rep.equalsIgnoreCase("o")){
            jouerPartieManuellement();
        } else if (rep.equalsIgnoreCase("n")) {
            System.out.println("Bonne journée !");
        }

    }


    public static void main(String[] args) {
        new Jeu().Jouer();
    }
}

