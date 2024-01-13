package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.melle.clienti.Cliente;
import main.melle.zonacarrelli.CarrelloImpl;
import main.miftari.prodotti.Prodotto;
import main.melle.zonacarrelli.Carrello;
import main.melle.supermercato.*;
import main.melle.lavoratori.*;

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
		Tempo tempo = new Tempo();
		tempo.simulazioneAttiva = true;
		Supermercato supermercato = new SupermercatoImpl(tempo);
		Lavoratore scaffalista = new Scaffalista(1000, supermercato.getMagazzino(), supermercato.getReparti());
		supermercato.getZonaCasse().setNCasse(1);
		Lavoratore cassiere = new Cassiere(1000, supermercato.getZonaCasse().getCassaConCodaPiuBreve());
		List<Prodotto> prodottiPrima = supermercato.getUfficioLogistica().aggiornaInventario();
		assertTrue(supermercato.getUfficioLogistica().aggiornaInventario().isEmpty());
		double bilancioPrima = supermercato.getUfficioAmministrativo().aggiornaEntrate();
		assertTrue(bilancioPrima == 0);
		supermercato.getUfficioLogistica().ordinaProdotti();
		assertTrue(!supermercato.getUfficioLogistica().aggiornaInventario().isEmpty());
		scaffalista.lavora(supermercato);
		conCarrello.faiSpesa(supermercato);
		cassiere.lavora(supermercato);
		
		assertTrue(supermercato.getUfficioAmministrativo().aggiornaEntrate() > bilancioPrima); // !!!
	}
}
