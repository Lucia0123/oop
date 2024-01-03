package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.miftari.prodotti.Farina;
import main.miftari.prodotti.TipoFarina;

class TestFarina {

    @Test
    public void testCostruttore() {
        double prezzo = 1.60;
        LocalDate dataScadenza = LocalDate.of(2025, 11, 30);
        double pesoConfezione = 1;
        TipoFarina marca = TipoFarina.INTEGRALE;

        Farina farina = new Farina(prezzo, dataScadenza, marca, pesoConfezione);

        // Verificare che lo stato iniziale sia corretto
        assertEquals(prezzo, farina.getPrezzo(), 0.001);
        assertEquals(dataScadenza, farina.getDataScad());
        assertEquals(pesoConfezione, farina.getPesoConfezione());
        assertEquals(marca, farina.getMarcaFarina());
    }

    @Test
    public void testEquals() {
    	double prezzo1 = 1.60;
        LocalDate dataScadenza1 = LocalDate.of(2025, 11, 30);
        double pesoConfezione1 = 1;
        TipoFarina marca1 = TipoFarina.INTEGRALE;
        
        double prezzo3 = prezzo1;
        LocalDate dataScadenza3 = dataScadenza1;
        double pesoConfezione3 = pesoConfezione1;
        TipoFarina marca3 = marca1;
        
        double prezzo2 = 2.60;
        LocalDate dataScadenza2 = dataScadenza1;
        double pesoConfezione2 = pesoConfezione1;
        TipoFarina marca2 = marca1;

        Farina farina1 = new Farina(prezzo1, dataScadenza1, marca1, pesoConfezione1);
        Farina farina2 = new Farina(prezzo2, dataScadenza2, marca2, pesoConfezione2);
        Farina farina3 = new Farina(prezzo3, dataScadenza3, marca3, pesoConfezione3);
        
        assertNotEquals(farina1, farina2);
        assertEquals(farina1, farina3);
    }
}