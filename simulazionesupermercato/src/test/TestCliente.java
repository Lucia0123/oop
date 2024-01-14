package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.melle.clienti.Cliente;
import main.melle.zonacarrelli.CarrelloImpl;
import main.melle.zonacarrelli.Carrello;
import main.melle.supermercato.*;

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
		Carrello carrello = new CarrelloImpl();
		Cliente conCarrello = new Cliente(carrello);
		Cliente senzaCarrello = new Cliente();
		Supermercato supermercato = new SupermercatoImpl();
		//Lavoratore scaffalista = new Scaffalista(1000, supermercato.getMagazzino(), supermercato.getReparti());
		supermercato.getZonaCasse().setNCasse(1); // IndexOutOfBoundsException!!!
		
		//Lavoratore cassiere = new Cassiere(1000, supermercato.getZonaCasse().getCassaConCodaPiuBreve());
		assertTrue(supermercato.getUfficioLogistica().aggiornaInventario().isEmpty());
		double entratePrima = supermercato.getUfficioAmministrativo().aggiornaEntrate();
		assertTrue(entratePrima == 0);
		supermercato.getUfficioLogistica().ordinaProdotti();
		assertTrue(!supermercato.getUfficioLogistica().aggiornaInventario().isEmpty());
		supermercato.startLavoratori();
		conCarrello.faiSpesa(supermercato);
		senzaCarrello.faiSpesa(supermercato);
		supermercato.startLavoratori();
		assertTrue(supermercato.getZonaCasse().getCassaConCodaPiuBreve().cercaCliente(conCarrello) == null);
		assertTrue(supermercato.getUfficioAmministrativo().aggiornaEntrate() > entratePrima);
	}
}
