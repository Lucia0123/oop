package simulazionesupermercato;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.Tipo;

class TestDetersivo {

	@Test
    public void testCostruttore() {
        double prezzo = 15.99;
        LocalDate dataScadenza = LocalDate.of(2023, 12, 31);
        Tipo tipo = Tipo.PER_PIATTI;

        Detersivo detersivo = new Detersivo(prezzo, dataScadenza, tipo);

        // Verificare che lo stato iniziale sia corretto
        assertEquals(prezzo, detersivo.getPrezzo(), 0.001);
        assertEquals(dataScadenza, detersivo.getDataScad());
        assertEquals(tipo, detersivo.getTipo());
    }

    @Test
    public void testGetTipo() {
        double prezzo = 20.49;
        LocalDate dataScadenza = LocalDate.of(2023, 12, 31);
        Tipo tipo = Tipo.PER_LAVATRICE;

        Detersivo detersivo = new Detersivo(prezzo, dataScadenza, tipo);

        // Verificare che il metodo getTipo() restituisca il valore corretto
        assertEquals(tipo, detersivo.getTipo());
    }

}