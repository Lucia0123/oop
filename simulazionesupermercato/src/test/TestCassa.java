package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.melle.clienti.FactoryDiCliente;
import main.melle.zonacasse.Cassa;

class TestCassa {

	@Test
	void testGetID() {
		Cassa cassa1 = new Cassa();
		Cassa cassa2 = new Cassa();
		assertEquals(cassa1.getID(), 1);
		assertEquals(cassa2.getID(), 2);
	}

	@Test
	void testGetRegistratoreDiCassa() {
		Cassa cassa = new Cassa();
		assertNotNull(cassa.getRegistratoreDiCassa());
	}

	@Test
	void testAggiungiAllaCoda() {
		var factory = FactoryDiCliente.getInstance(null);
	}
/*
	@Test
	void testTogliDallaCoda() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNClientiInCoda() {
		fail("Not yet implemented");
	}

	@Test
	void testGetClienteDaServire() {
		fail("Not yet implemented");
	}
*/
}
