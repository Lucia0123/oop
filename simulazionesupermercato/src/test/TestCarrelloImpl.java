package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.melle.zonacarrelli.CarrelloImpl;
import main.miftari.prodotti.FactoryDiProdotto;
import main.miftari.prodotti.Farina;
import main.miftari.prodotti.TipoFarina;
import main.miftari.prodotti.TipoCarne;

class TestCarrelloImpl {

	@Test
	void testGetProdottiInCarrello() {
		CarrelloImpl carrello = new CarrelloImpl();
		assertTrue(carrello.getProdottiInCarrello().isEmpty());
		
	}

	@Test
	void testGetNProdottiInCarrello() {
		CarrelloImpl carrello = new CarrelloImpl();
		int nProdotti = 0;
		assertEquals(carrello.getNProdottiInCarrello(), nProdotti);
		var factory = new FactoryDiProdotto();
		carrello.aggiungiProdotto(factory.creaCarne(TipoCarne.DI_MANZO));
		nProdotti = 1;
		assertEquals(carrello.getNProdottiInCarrello(), nProdotti);
		carrello.togliProdotto();
		nProdotti = 0;
		assertEquals(carrello.getNProdottiInCarrello(), nProdotti);
	}

	@Test
	void testAggiungiProdotto() {
		CarrelloImpl carrello = new CarrelloImpl();
		var factory = new FactoryDiProdotto();
		Farina farina = factory.creaFarina(TipoFarina.DI_GLUTINE);
		carrello.aggiungiProdotto(farina);
		assertTrue(carrello.getProdottiInCarrello().contains(farina));
	}

	@Test
	void testTogliProdotto() {
		CarrelloImpl carrello = new CarrelloImpl();
		var factory = new FactoryDiProdotto();
		Farina farina = factory.creaFarina(TipoFarina.TIPO_0);
		carrello.aggiungiProdotto(farina);
		assertTrue(carrello.getProdottiInCarrello().contains(farina));
		carrello.togliProdotto();
		assertFalse(carrello.getProdottiInCarrello().contains(farina));
	}
	
}
