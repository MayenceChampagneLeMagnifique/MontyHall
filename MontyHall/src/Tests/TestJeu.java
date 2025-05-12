package Tests;

import org.junit.jupiter.api.Test;
import Game.Jeu;

import static org.junit.jupiter.api.Assertions.*;

class TestJeu {

    @Test
    void exporterParties_Test(){
        Jeu jeu = new Jeu();

        assertDoesNotThrow(() -> jeu.exporterParties("MontyHall/src/Export/donnees.csv"));
    }

    @Test
    void _Test(){
    }

}
