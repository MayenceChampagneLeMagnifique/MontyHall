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

    private List<Partie> listeParties = new ArrayList<>();
    public Jeu() {
    }

    public void jouer() {
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
        if (listeParties.isEmpty()) {
            System.out.println("Aucune partie à exporter.");
            return;
        }

        try (PrintWriter fichier = new PrintWriter(new FileWriter(path))) {
            for (Partie partie : listeParties) {
                fichier.println(partie.toString());
            }
            System.out.println("Les parties ont été exportées avec succès vers : " + path);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'exportation des parties : " + e.getMessage());
        }
    }



    public void jouerPartiesAuto() {
        Scanner s = new Scanner(System.in);

        System.out.println("Combien de parties voulez-vous simuler ?");
        int nombreParties = s.nextInt();

        System.out.println("Combien de fois sur 100 voulez-vous changer de porte ?");
        int pourcentage = -1;
        while (pourcentage < 0 || pourcentage > 100) {
            pourcentage = s.nextInt();
            if (pourcentage < 0 || pourcentage > 100) {
                System.out.println("Entrez une valeur entre 0 et 100.");
            }
        }

        int victoires = 0;

        Random random = new Random();

        for (int i = 0; i < nombreParties; i++) {
            Partie partie = new Partie();
            int porteChoisie = random.nextInt(3);
            int porteGagnante = partie.getPorteGagnante();

            List<Integer> portesRestantes = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (j != porteChoisie && j != porteGagnante) {
                    portesRestantes.add(j);
                }
            }
            int porteOuverte = portesRestantes.get(random.nextInt(portesRestantes.size()));

            boolean changer = random.nextInt(100) < pourcentage;

            if (changer) {
                for (int j = 0; j < 3; j++) {
                    if (j != porteChoisie && j != porteOuverte) {
                        porteChoisie = j;
                        break;
                    }
                }
            }

            if (porteChoisie == porteGagnante) {
                victoires++;
            }
            listeParties.add(partie);
        }
        double tauxVictoire = (double) victoires / nombreParties * 100;
        System.out.println("Sur " + nombreParties + " parties avec un taux de changement de " + pourcentage + " %, le taux de victoires est de " + tauxVictoire + " %.");
        exporterParties("Export/donnees.txt");
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
        new Jeu().jouer();
    }
}

