package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import main.melle.clienti.Cliente;
import main.melle.zonacarrelli.CarrelloImpl;
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
		Cassa cassa = new Cassa();
		Cliente daAggiungere = new Cliente();
		int clientiInCoda = 0;
		cassa.aggiungiAllaCoda(daAggiungere);
		clientiInCoda = 1;
		assertEquals(clientiInCoda, cassa.getNClientiInCoda()); // verifica dell'aggiunta di un cliente
		cassa.aggiungiAllaCoda(daAggiungere);
		assertEquals(clientiInCoda, cassa.getNClientiInCoda()); // nessuna modifica se il cliente è gia stato inserito
	}
	
	@Test
	void testTogliDallaCoda() {
		Cassa cassa = new Cassa();
		Cliente Cliente1 = new Cliente();
		Cliente Cliente2 = new Cliente(new CarrelloImpl());
		int nClientiInCoda = 0;
		cassa.togliDallaCoda(Cliente1);
		assertEquals(nClientiInCoda, cassa.getNClientiInCoda()); // nessuna modifica se la coda è vuota
		cassa.aggiungiAllaCoda(Cliente1);
		nClientiInCoda = 1;
		cassa.aggiungiAllaCoda(Cliente2);
		nClientiInCoda = 2;
		cassa.togliDallaCoda(Cliente2); // nessuna modifica perché Cliente2 non è in testa alla coda
		assertEquals(nClientiInCoda, cassa.getNClientiInCoda());
		cassa.togliDallaCoda(Cliente1); // Cliente1 può essere tolto dalla coda perché è in testa
		nClientiInCoda = 1;
		assertEquals(nClientiInCoda, cassa.getNClientiInCoda());
		
	}

	@Test
	void testGetClienteDaServire() {
		Cassa cassa = new Cassa();
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente(new CarrelloImpl());
		assertEquals(null, cassa.getClienteDaServire());
		cassa.aggiungiAllaCoda(cliente1);
		cassa.aggiungiAllaCoda(cliente2);
		assertEquals(cliente1, cassa.getClienteDaServire());
	}

}
