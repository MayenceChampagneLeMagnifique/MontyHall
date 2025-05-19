package Game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe principale représentant le jeu du problème de Monty Hall.
 * Cette classe permet d'exécuter le jeu en mode manuel (joué par l'utilisateur)
 * ou en mode automatique (simulation de parties par des joueurs virtuels).
 * Les résultats peuvent être exportés dans un fichier CSV.
 * Javadoc générée automatiquement par une intelligence artificielle (ChatGPT).
 *
 * @author IA
 */
public class Jeu implements Util {
    private List<Joueur> listeJoueurs = new ArrayList<>();

    /**
     * Constructeur de la classe Jeu.
     * Affiche les règles du problème de Monty Hall, puis demande à l'utilisateur
     * de choisir entre le mode manuel ou automatique.
     */
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

    /**
     * Exporte les résultats des joueurs automatiques dans un fichier CSV.
     *
     * @param path Chemin du fichier dans lequel exporter les résultats.
     */
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

    /**
     * Mode de jeu automatique.
     * L'utilisateur peut créer plusieurs joueurs avec des pourcentages de changement de porte,
     * puis simuler un nombre défini de parties pour chacun d'eux.
     * Les résultats sont exportés automatiquement.
     */
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

    /**
     * Mode de jeu manuel.
     * L'utilisateur joue une partie en choisissant une porte, puis décide
     * s'il souhaite changer ou non après qu'une porte vide soit révélée.
     * Le résultat est ensuite affiché, et on propose de rejouer.
     */
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

    /**
     * Point d’entrée de l’application. Instancie une partie de Monty Hall.
     *
     */
    public static void main(String[] args) {
        new Jeu();
    }
}
