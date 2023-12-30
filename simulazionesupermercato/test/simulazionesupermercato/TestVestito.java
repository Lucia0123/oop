package simulazionesupermercato;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.miftari.prodotti.Colore;
import main.miftari.prodotti.Taglia;
import main.miftari.prodotti.Vestito;

class TestVestito {

	@Test
    public void testCostruttore() {
        double prezzo = 28.02;
        Taglia taglia = Taglia.L;
        Colore colore = Colore.BLU;

        Vestito vestito = new Vestito(prezzo, taglia, colore);

        // Verificare che lo stato iniziale sia corretto
        assertEquals(prezzo, vestito.getPrezzo(), 0.001);
        assertEquals(taglia, vestito.getTaglia());
        assertEquals(colore, vestito.getColore());
    }

    @Test
    public void testGetTaglia() {
        double prezzo = 29.90;
        Taglia taglia = Taglia.S;
        Colore colore = Colore.ROSSO;

        Vestito vestito = new Vestito(prezzo, taglia, colore);

        // Verificare che il metodo getTaglia restituisca il valore corretto
        assertEquals(taglia, vestito.getTaglia());
    }

    @Test
    public void testGetColore() {
        double prezzo = 12.80;
        Taglia taglia = Taglia.M;
        Colore colore = Colore.BLU;

        Vestito vestito = new Vestito(prezzo, taglia, colore);

        // Verificare che il metodo getColore restituisca il valore corretto
        assertEquals(colore, vestito.getColore());
    }


}
