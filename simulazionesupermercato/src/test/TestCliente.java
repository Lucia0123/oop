package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.melle.clienti.Cliente;
import main.melle.zonacarrelli.CarrelloImpl;
import main.melle.zonacarrelli.Carrello;

class TestCliente {

	@Test
	void testClienteCarrello() {
		Carrello carrello = new CarrelloImpl();
		Cliente conCarrello = new Cliente(carrello);
		assertEquals(conCarrello.getCapacita(), carrello.getCapacitaMax());
	}

	@Test
	void testGetCarrello() {
		Carrello carrello = new CarrelloImpl();
		Cliente conCarrello = new Cliente(carrello);
		Cliente senzaCarrello = new Cliente();
		assertTrue(conCarrello.getCarrello().isPresent());
		assertTrue(senzaCarrello.getCarrello().isEmpty());
	}

	// per fare questi testare prima supermercato
	@Test
	void testFaiSpesa() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProdottiPresi() {
		fail("Not yet implemented");
	}

}
