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
