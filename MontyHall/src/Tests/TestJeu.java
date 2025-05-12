package Tests;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TestJeu {

    @Test
    void jouerPartieManuellement_Test(){
        Jeu jeu = new Jeu();

        assertDoesNotThrow(() -> jeu.exporterParties(""));
    }
}
