package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.TipoDetersivo;

class TestDetersivo {

	@Test
    public void testCostruttore() {
        double prezzo = 15.99;
        LocalDate dataScadenza = LocalDate.of(2023, 12, 31);
        TipoDetersivo tipoDetersivo = TipoDetersivo.PER_PIATTI;

        Detersivo detersivo = new Detersivo(prezzo, dataScadenza, tipoDetersivo);

        // Verificare che lo stato iniziale sia corretto
        assertEquals(prezzo, detersivo.getPrezzo(), 0.001);
        assertEquals(dataScadenza, detersivo.getDataScad());
        assertEquals(tipoDetersivo, detersivo.getTipo());
    }

}