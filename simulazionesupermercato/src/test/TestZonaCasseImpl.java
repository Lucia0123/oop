package test;

import main.melle.clienti.Cliente;
import main.melle.zonacasse.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestZonaCasseImpl {

	@Test
	void testZonaCasseImpl() {
		int numeroCasse = 3;
		ZonaCasse zona = new ZonaCasseImpl(numeroCasse);
		assertEquals(numeroCasse, zona.getNCasse());
		assertEquals(numeroCasse, zona.getCasse().size());
	}

    @Test
    public void testAggiungiCassa() {
    	// dentro il limite
        ZonaCasseImpl zonaCasse = new ZonaCasseImpl(2);
        zonaCasse.aggiungiCassa();
        assertEquals(3, zonaCasse.getNCasse());
        assertEquals(3, zonaCasse.getCasse().size());
        
        // al limite
        zonaCasse = new ZonaCasseImpl(20);
        zonaCasse.aggiungiCassa();
        assertEquals(20, zonaCasse.getNCasse());
        assertEquals(20, zonaCasse.getCasse().size());
    }

    @Test
    public void testSetNCasse() {
    	// aumentando il numero di casse
        ZonaCasseImpl zonaCasse = new ZonaCasseImpl(3);
        assertTrue(zonaCasse.setNCasse(18));
        assertEquals(18, zonaCasse.getNCasse());
        assertEquals(18, zonaCasse.getCasse().size());
      
        // diminuendo il numero di casse
        zonaCasse = new ZonaCasseImpl(18);
        assertTrue(zonaCasse.setNCasse(5));
        assertEquals(5, zonaCasse.getNCasse());
        assertEquals(5, zonaCasse.getCasse().size());
        
        // nessun cambiamento
        zonaCasse = new ZonaCasseImpl(4);
        assertTrue(zonaCasse.setNCasse(4));
        assertEquals(4, zonaCasse.getNCasse());
        assertEquals(4, zonaCasse.getCasse().size());
    }

    @Test
    public void testAggiungiAllaCodaPiuBreve() {
        ZonaCasseImpl zonaCasse = new ZonaCasseImpl(3);
        Cliente cliente = new Cliente();

        Cassa cassaConCodaPiuBreve = zonaCasse.getCassaConCodaPiuBreve();
        
        zonaCasse.aggiungiAllaCodaPiuBreve(cliente);

        assertTrue(cassaConCodaPiuBreve.getClientiInCoda().contains(cliente));
    }

    @Test
    public void testTogliDallaCoda() {
        ZonaCasseImpl zonaCasse = new ZonaCasseImpl(3);
        Cliente cliente = new Cliente();
        Cassa cassa = zonaCasse.getCasse().get(0);
        cassa.aggiungiAllaCoda(cliente);

        zonaCasse.togliDallaCoda(cliente, cassa);

        assertFalse(cassa.getClientiInCoda().contains(cliente));
    }
}