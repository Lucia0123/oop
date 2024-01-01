package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.miftari.prodotti.Farina;
import main.miftari.prodotti.MarcaFarina;

class TestFarina {

        @Test
    public void testCostruttore() {
        double prezzo = 1.60;
        LocalDate dataScadenza = LocalDate.of(2025, 11, 31);
        double pesoConfezione = 1;
        int quantitaConfezione = 1;
        MarcaFarina marca = MarcaFarina.DE_CECCO;

        Farina farina = new Farina(prezzo, dataScadenza, marca, pesoConfezione, quantitaConfezione);

        // Verificare che lo stato iniziale sia corretto
        assertEquals(prezzo, farina.getPrezzo(), 0.001);
        assertEquals(dataScadenza, farina.getDataScad().toLocalDate());
        assertEquals(marca, farina.getMarcaFarina());
    }

    @Test
    public void testGetMarcaFarina() {
        double prezzo = 1.90;
        LocalDate dataScadenza = LocalDate.of(2027, 12, 31);
        double pesoConfezione = 1;
        int quantitaConfezione = 1;
        MarcaFarina marca = MarcaFarina.CAPUTO;

        Farina farina = new Farina(prezzo, dataScadenza, marca, pesoConfezione, quantitaConfezione);

        // Verificare che il metodo getMarcaFarina() restituisca il valore corretto
        assertEquals(marca, farina.getMarcaFarina());
    }

}