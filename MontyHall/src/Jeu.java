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



        if (reponse.equalsIgnoreCase("M")) {
            System.out.println("Quel est votre nom ?");
            String nom = s.nextLine();
            Joueur joueur = new Joueur(nom);
            jouerPartieManuellement(joueur);
        }

        if (reponse.equalsIgnoreCase("A")) {

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

//    public void LancerAnalyse(int nombreParties) {
//
//    }

    public void jouerPartiesAuto() {
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

    public void jouerPartieManuellement(Joueur joueur) {
        Scanner s = new Scanner(System.in);
        System.out.println("Quelle porte voulez vous choisir ? ( 0, 1, 2, ...)");
        int indexPorte = s.nextInt();
        Partie partie = new Partie();

        int indexGagnant = partie.getPorteGagnante();

        Random r = new Random();
        int rand = r.nextInt(2);
        int porteChoisiParAnimateur = 0;
        int porteDisponible = 0;

        switch (indexGagnant) {
            case 0:
                if (rand == 0) {
                    porteChoisiParAnimateur = 1;
                } else porteChoisiParAnimateur = 2;
                break;
            case 1:
                if (rand == 0) {
                    porteChoisiParAnimateur = 0;
                } else porteChoisiParAnimateur = 2;
                break;
            case 2:
                if (rand == 0) {
                    porteChoisiParAnimateur = 0;
                } else porteChoisiParAnimateur = 1;
                break;
        }

        if (porteChoisiParAnimateur == 1 && indexPorte == 0) {
            porteDisponible = 2;
        } else if (porteChoisiParAnimateur == 2 && indexPorte == 0) {
            porteDisponible = 1;
        } else if (porteChoisiParAnimateur == 0 && indexPorte == 1) {
            porteDisponible = 2;
        }else if (porteChoisiParAnimateur == 2 && indexPorte == 1) {
            porteDisponible = 0;
        }else if (porteChoisiParAnimateur == 0 && indexPorte == 2) {
            porteDisponible = 1;
        }else if (porteChoisiParAnimateur == 1 && indexPorte == 2) {
            porteDisponible = 0;
        }
        System.out.println("Debug Gagnant: " + indexGagnant);
        System.out.println("L'animateur ouvre la porte numéro " + porteChoisiParAnimateur + ", il n'y a rien derrière");
        System.out.println("Voulez vous changez votre porte pour la porte numéro " + porteDisponible + " ? ou gardez votre porte " + indexPorte + " ?");
        String reponse = s.nextLine();

    }

    public static void main(String[] args) {
        new Jeu();
    }
}

