package Tests;

import Game.Porte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PorteTest {

    @Test
    void testConstructeur() {
        Porte p = new Porte();

        assertFalse(p.isChoisie());
        assertFalse(p.isGagnante());
        assertFalse(p.isOuverte());
    }

    @Test
    void isGagnanteEtSetGagnante() {
        Porte p1 = new Porte();
        Porte p2 = new Porte();

        p2.setGagnante();

        assertFalse(p1.isGagnante());
        assertTrue(p2.isGagnante());
    }

    @Test
    void setChoisie() {
        Porte p1 = new Porte();
        Porte p2 = new Porte();

        p2.setChoisie(true);
        p1.setChoisie(false);

        assertFalse(p1.isChoisie());
        assertTrue(p2.isChoisie());
    }

    @Test
    void isChoisie() {
        Porte p1 = new Porte();
        Porte p2 = new Porte();

        p1.setChoisie(true);

        assertTrue(p1.isChoisie());
        assertFalse(p2.isChoisie());
    }

    @Test
    void isOuverte() {
        Porte p1 = new Porte();
        Porte p2 = new Porte();

        p2.setOuverte(true);

        assertFalse(p1.isOuverte());
        assertTrue(p2.isOuverte());
    }

    @Test
    void setOuverte() {
        Porte p1 = new Porte();
        Porte p2 = new Porte();

        p2.setOuverte(true);
        p1.setOuverte(false);

        assertFalse(p1.isOuverte());
        assertTrue(p2.isOuverte());
    }
}