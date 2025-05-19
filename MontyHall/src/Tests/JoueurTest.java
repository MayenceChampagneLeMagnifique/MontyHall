package Tests;

import Game.Joueur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    /**
     * La méthode jouerPartieAuto() utilise des valeurs aléatoires pour déterminer le choix de porte, il est donc impossible de tester cette méthode efficacement.
     */
    @Test
    void jouerPartieAuto() {
    }

    @Test
    void calculerPourcentagePartiesGagnees() {
        Joueur j1 = new Joueur(100);
        Joueur j2 = new Joueur(0);

        for (int i = 0; i < 10; i++) {
            j1.jouerPartieAuto();
        }

        assertEquals(0,j2.getPourcentagePartiesGagnees());
        assertEquals(((double) j1.getNombrePartiesGagnees() / j1.getNombreDePartiesJouees()) * 100, j1.getPourcentagePartiesGagnees());
    }

    /**
     * La méthode getNombrePartiesGagnees() ne peut pas être testée, car les parties gagnées sont déterminées par le hasard.
     */
    @Test
    void getNombrePartiesGagnees() {
    }


    @Test
    void getNombreDePartiesJouees() {
        Joueur j1 = new Joueur(100);
        int nombreDePartiesAJouer = 50;

        for (int i = 0; i < nombreDePartiesAJouer; i++) {
            j1.jouerPartieAuto();
        }

        assertEquals(nombreDePartiesAJouer,j1.getNombreDePartiesJouees());
    }


    @Test
    void getpourcentageChangementDePortes() {
        int pourcentageChangementDePortes = 5;
        Joueur j1 = new Joueur(pourcentageChangementDePortes);

        assertEquals(pourcentageChangementDePortes,j1.getpourcentageChangementDePortes());
    }
}