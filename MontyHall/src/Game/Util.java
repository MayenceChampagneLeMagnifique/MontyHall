package Game;

import java.util.Scanner;

/**
 * Interface Utilitaire fournissant des méthodes par défaut
 * pour poser des questions à l'utilisateur dans la console.
 * <p>
 * Cette interface est conçue pour être utilisée dans des jeux interactifs
 * ou des simulations où une entrée utilisateur est requise.
 * </p>
 *
 * <p><b>Javadoc générée automatiquement par une intelligence artificielle (ChatGPT).</b></p>
 */
public interface Util {

    /**
     * Pose une question à l'utilisateur et lit une réponse de type chaîne de caractères.
     *
     * @param question La question à afficher dans la console.
     * @return La réponse saisie par l'utilisateur.
     */
    default String poserQuestionString(String question) {
        Scanner s = new Scanner(System.in);
        String reponse;

        System.out.println(question);
        reponse = s.nextLine();

        return reponse;
    }

    /**
     * Pose une question à l'utilisateur et lit une réponse de type entier.
     * Affiche un message d'erreur si l'entrée n'est pas un entier et redemande la saisie.
     *
     * @param question La question à afficher dans la console.
     * @return La valeur entière saisie par l'utilisateur.
     */
    default int poserQuestionInt(String question) {
        Scanner s = new Scanner(System.in);
        int reponseInt = 0;
        boolean valide = false;

        System.out.println(question);

        while (!valide) {
            if (s.hasNextInt()) {
                reponseInt = s.nextInt();
                valide = true;
            } else {
                System.out.println("Entrer un entier");
                s.next();
            }
        }

        return reponseInt;
    }
}
