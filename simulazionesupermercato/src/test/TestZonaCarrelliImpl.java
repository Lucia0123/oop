package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.melle.zonacarrelli.Carrello;
import main.melle.zonacarrelli.CarrelloImpl;
import main.melle.zonacarrelli.ZonaCarrelliImpl;

class TestZonaCarrelliImpl {

	@Test
	void testGetNCarrelliLiberi() {
		ZonaCarrelliImpl zonaCarrelli = new ZonaCarrelliImpl();
		int numeroCarrelliLiberi = zonaCarrelli.getNCarrelliTot();
		assertEquals(numeroCarrelliLiberi, zonaCarrelli.getNCarrelliTot());
		zonaCarrelli.ritiraCarrello();
		assertEquals(numeroCarrelliLiberi, zonaCarrelli.getNCarrelliTot());
	}

	@Test
	void testRitiraCarrello() {
		ZonaCarrelliImpl zonaCarrelli = new ZonaCarrelliImpl();
		assertEquals(zonaCarrelli.getNCarrelliLiberi(), zonaCarrelli.getCarrelliLiberi().size());
		Carrello carrelloRitirato = zonaCarrelli.ritiraCarrello();
		assertEquals(zonaCarrelli.getNCarrelliLiberi(), zonaCarrelli.getCarrelliLiberi().size());
		assertFalse(zonaCarrelli.getCarrelliLiberi().contains(carrelloRitirato));
	}

	@Test
	void testRestituisciCarrello() {
		ZonaCarrelliImpl zonaCarrelli = new ZonaCarrelliImpl();
		Carrello carrelloRitirato = zonaCarrelli.ritiraCarrello();
		// restituisci carrello ritirato
		zonaCarrelli.restituisciCarrello(carrelloRitirato);
		assertTrue(zonaCarrelli.getCarrelliLiberi().contains(carrelloRitirato));
	}

}
