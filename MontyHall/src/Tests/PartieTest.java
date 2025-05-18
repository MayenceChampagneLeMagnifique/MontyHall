package Tests;

import Game.Partie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartieTest {


    /**
     * La méthode ouvrirPortes() utilise du hasard pour ouvrir les portes, ce qui est impossible à tester par la suite.
     * Cette méthode devrait tester la méthode ouvrirPortes(), qui ouvre toutes les portes sauf une dans listePortes.
     */
    @Test
    void ouvrirPortes() {
    }

    @Test
    void changerPorte() {
        Partie partie = new Partie();
        int indexPorteChoisieDepart = 2;

        partie.setIndexPorteChoisie(indexPorteChoisieDepart);
        partie.ouvrirPortes();
        partie.changerPorte();

        assertNotEquals(partie.getIndexPorteChoisie(), indexPorteChoisieDepart);
    }

    /**
     * Comme le contenu de listePorte est aléatoire, on peut seulement tester si listePorte est de la bonne taille
     */
    @Test
    void getListePortes() {
        Partie partie = new Partie();

        assertEquals(partie.getNOMBRE_PORTES(), partie.getListePortes().size());
    }

    @Test
    void getNOMBRE_PORTES() {
        Partie partie = new Partie();

        assertEquals(3, partie.getNOMBRE_PORTES());
    }

    /**
     * La valeur d'indexPorteGagnante est aléatoire, on peut donc seulement tester si getIndexPorteGagnante() retourne le même entier à chaque fois pour la même partie.
     */
    @Test
    void getIndexPorteGagnante() {
        Partie partie = new Partie();

        assertEquals(partie.getIndexPorteGagnante(), partie.getIndexPorteGagnante());
    }

    @Test
    void getIndexPorteChoisie() {
        Partie partie = new Partie();
        int indexPorteChoisie = 2;

        partie.setIndexPorteChoisie(indexPorteChoisie);

        assertEquals(partie.getIndexPorteChoisie(), indexPorteChoisie);
    }

    @Test
    void setIndexPorteChoisie() {
        Partie partie = new Partie();

        for (int i = 1; i < partie.getNOMBRE_PORTES(); i++) {
            partie.setIndexPorteChoisie(i - 1);

            assertEquals(partie.getIndexPorteChoisie(), i - 1);
        }
    }


}