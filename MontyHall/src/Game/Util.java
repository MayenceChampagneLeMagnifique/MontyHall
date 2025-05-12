package Game;

import java.util.Scanner;

public interface Util {
    default String poserQuestionString(String question) {
        Scanner s = new Scanner(System.in);
        String reponse;

        System.out.println(question);
        reponse = s.nextLine();

        return reponse;
    }

    default int poserQuestionInt(String question) {
        Scanner s = new Scanner(System.in);
        String reponse;
        int reponseInt = 0;
        boolean estInt = false;

        while (!estInt) {
            estInt = true;

            System.out.println(question);
            reponse = s.nextLine();

            try {
                reponseInt = Integer.parseInt(reponse);
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Seulement les nombres sont acceptés");
                estInt = false;
            }
        }

        return reponseInt;
    }
}
