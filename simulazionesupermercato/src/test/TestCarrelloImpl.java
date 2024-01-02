package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.melle.zonacarrelli.CarrelloImpl;
import main.miftari.prodotti.FactoryDiProdotto;
import main.miftari.prodotti.TipoCarne;

class TestCarrelloImpl {
/*
	@Test
	void testGetProdottiInCarrello() {
		CarrelloImpl carrello = new CarrelloImpl();
		
	}
*/
	@Test
	void testGetNProdottiInCarrello() {
		CarrelloImpl carrello = new CarrelloImpl();
		int nProdotti = 0;
		assertEquals(carrello.getNProdottiInCarrello(), nProdotti);
		var factory = new FactoryDiProdotto();
		carrello.aggiungiProdotto(factory.creaCarne(TipoCarne.DI_MANZO));
		nProdotti = 1;
		assertEquals(carrello.getNProdottiInCarrello(), nProdotti);
	}
/*
	@Test
	void testAggiungiProdotto() {
		fail("Not yet implemented");
	}

	@Test
	void testTogliProdotto() {
		fail("Not yet implemented");
	}
*/
}
