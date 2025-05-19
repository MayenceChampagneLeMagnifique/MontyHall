package Game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jeu implements Util {
    private List<Joueur> listeJoueurs = new ArrayList<>();

    public Jeu() {
        System.out.println("Bienvenue au problème de Monty Hall !" + "\n");

        System.out.println("Ce problème est défini comme suit : vous avez 3 portes devant vous, une des portes possède un prix et les deux autres sont vides.");
        System.out.println("Vous devez choisir une porte. Ensuite, l'animateur ouvre une des portes restantes, qui est vide.");
        System.out.println("Le dilemme est le suivant : changez-vous votre choix de porte ?" + "\n");

        System.out.println("Ce programme comporte deux modes :");
        System.out.println("1. Mode manuel (vous jouez vous-même)");
        System.out.println("2. Mode automatique (le programme simule des parties)" + "\n");

        int choix = -1;
        while (choix != 1 && choix != 2) {
            choix = poserQuestionInt("Choisissez le mode :\n1. Manuel\n2. Automatique");
        }

        if (choix == 1) {
            jouerPartieManuellement();
        } else {
            jouerPartiesAuto();
        }
    }

    public void exporterResultats(String path) {
        if (listeJoueurs.isEmpty()) {
            System.out.println("Aucun joueur à exporter.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.println("PourcentageChangement,NombreParties,NombreVictoires,PourcentageVictoires");

            for (Joueur joueur : listeJoueurs) {
                writer.println(
                        joueur.getpourcentageChangementDePortes() + "," +
                                joueur.getNombreDePartiesJouees() + "," +
                                joueur.getNombrePartiesGagnees() + "," +
                                joueur.getPourcentagePartiesGagnees()
                );
            }

            System.out.println("Les résultats des joueurs ont été exportés vers : " + path);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'exportation : " + e.getMessage());
        }
    }

    public void jouerPartiesAuto() {
        listeJoueurs = new ArrayList<>();
        int choix = 0;

        while (choix != 2) {
            choix = poserQuestionInt("Que voulez-vous faire ?\n1. Ajouter un joueur\n2. Lancer les parties");

            if (choix == 1) {
                int changement = -1;
                while (changement < 0 || changement > 100) {
                    changement = poserQuestionInt("Combien de fois sur 100 voulez-vous que ce joueur change de porte ? (0-100)");
                }

                Joueur joueur = new Joueur(changement);
                listeJoueurs.add(joueur);
            }
        }

        int nombreParties = poserQuestionInt("Combien de parties par joueur voulez-vous faire ?");

        for (Joueur j : listeJoueurs) {
            for (int i = 0; i < nombreParties; i++) {
                j.jouerPartieAuto();
            }
        }
        String fSep = File.separator;
        String path = "MontyHall" + fSep + "src" + fSep + "Export" + fSep + "donnees.csv";
        exporterResultats(path);
    }

    public void jouerPartieManuellement() {
        Random r = new Random();
        Partie partie = new Partie();

        int indexGagnant = partie.getIndexPorteGagnante();

        int indexPorte = -1;
        while (indexPorte < 0 || indexPorte > 2) {
            indexPorte = poserQuestionInt("Choisissez une porte :\n0. Porte 0\n1. Porte 1\n2. Porte 2");
        }

        List<Integer> portesPossibles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (i != indexPorte && i != indexGagnant) {
                portesPossibles.add(i);
            }
        }

        int porteOuverte = portesPossibles.get(r.nextInt(portesPossibles.size()));
        System.out.println("L'animateur ouvre la porte " + porteOuverte + " (vide).");

        int choixChangement = -1;
        while (choixChangement != 1 && choixChangement != 2) {
            choixChangement = poserQuestionInt("Souhaitez-vous :\n1. Changer de porte\n2. Garder votre choix");
        }

        if (choixChangement == 1) {
            for (int i = 0; i < 3; i++) {
                if (i != indexPorte && i != porteOuverte) {
                    indexPorte = i;
                    break;
                }
            }
        }

        boolean aGagne = (indexPorte == indexGagnant);

        if (aGagne) {
            System.out.println("🎉 Vous avez gagné ! Le prix était derrière la porte " + indexGagnant);
        } else {
            System.out.println("😢 Vous avez perdu. Le prix était derrière la porte " + indexGagnant);
        }

        int rejouer = -1;
        while (rejouer != 1 && rejouer != 2) {
            rejouer = poserQuestionInt("Voulez-vous rejouer ?\n1. Oui\n2. Non");
        }

        if (rejouer == 1) {
            jouerPartieManuellement();
        } else {
            System.out.println("Bonne journée !");
        }
    }

    public static void main(String[] args) {
        new Jeu();
    }
}
