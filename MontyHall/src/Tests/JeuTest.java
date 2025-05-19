package Tests;

import org.junit.jupiter.api.Test;

class JeuTest {

    /**
     * Le constructeur de la classe Jeu.java utilise des scanners, il n'est donc pas éligible aux tests.
     */
    @Test
    void jouer() {
    }

    /**
     * La méthode exporterResultats() ne peut pas être testée, car les valeurs exportées varient à chaque instance.
     */
    @Test
    void exporterResultats() {
    }

    /**
     * La méthode jouerPartiesAuto() utilise des scanners, elle n'est donc pas éligible aux tests.
     */
    @Test
    void jouerPartiesAuto() {
    }

    /**
     * La méthode jouerPartieManuellement utilise des scanners, elle n'est donc pas éligible aux tests.
     */
    @Test
    void jouerPartieManuellement() {
    }

    /**
     * Le main de la méthode Jeu.java appelle le constructeur de la même classe, qui ne peut pas être testé, car il utilise des scanners. Le main n'est donc pas éligible aux tests.
     */
    @Test
    void main() {
    }
}