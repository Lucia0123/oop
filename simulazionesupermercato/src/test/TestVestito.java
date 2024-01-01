package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.miftari.prodotti.Taglia;
import main.miftari.prodotti.Vestito;

class TestVestito {

	@Test
    public void testCostruttore() {
        double prezzo = 28.02;
        Taglia taglia = Taglia.L;

        Vestito vestito = new Vestito(prezzo, taglia);

        // Verificare che lo stato iniziale sia corretto
        assertEquals(prezzo, vestito.getPrezzo(), 0.001);
        assertEquals(taglia, vestito.getTaglia());
    }

    @Test
    public void testGetTaglia() {
        double prezzo = 29.90;
        Taglia taglia = Taglia.S;

        Vestito vestito = new Vestito(prezzo, taglia);

        // Verificare che il metodo getTaglia restituisca il valore corretto
        assertEquals(taglia, vestito.getTaglia());
    }

}
