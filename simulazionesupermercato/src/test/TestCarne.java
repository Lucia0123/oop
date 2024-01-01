package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.miftari.prodotti.Carne;
import main.miftari.prodotti.TipoCarne;

class TestCarne {

        @Test
    public void testCostruttore() {
        double prezzo = 10.00;
        LocalDate dataScadenza = LocalDate.of(2024, 10, 11);
        double pesoConfezione = 0.9;
        TipoCarne tipoCarne = TipoCarne.DI_MANZO;

        Carne carne = new Carne(prezzo, dataScadenza, pesoConfezione, tipoCarne);

        // Verificare che lo stato iniziale sia corretto
        assertEquals(prezzo, carne.getPrezzo(), 0.001);
        assertEquals(dataScadenza, carne.getDataScad());
        assertEquals(tipoCarne, carne.getTipoCarne());
    }

    @Test
    public void testGetTipoCarne() {
        double prezzo = 15.50;
        LocalDate dataScadenza = LocalDate.of(2024, 01, 31);
        double pesoConfezione = 0.8;
        TipoCarne tipoCarne = TipoCarne.DI_POLLO;

        Carne carne = new Carne(prezzo, dataScadenza, pesoConfezione, tipoCarne);

        // Verificare che il metodo getTipoCarne() restituisca il valore corretto
        assertEquals(tipoCarne, carne.getTipoCarne());
    }

}