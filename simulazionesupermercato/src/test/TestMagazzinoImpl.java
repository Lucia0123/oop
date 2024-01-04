package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.melle.supermercato.Tempo;
import main.miftari.magazzino.*;
import main.miftari.prodotti.*;
class TestMagazzinoImpl {

	@Test
	void testAggiornaProdottiInTot() {
		Magazzino magazzino = new MagazzinoImpl();
		assertTrue(magazzino.aggiornaProdottiInTot().isEmpty()); // un magazzino appena creato non contiene alcun prodotto
		FactoryDiProdotto factory = new FactoryDiProdotto();
		Detersivo det = factory.creaDetersivo(TipoDetersivo.PER_LAVATRICE);
		magazzino.aggiungi(det);
		assertTrue(magazzino.aggiornaProdottiInTot().contains(det));
	}

	@Test
	void testAggiungi() {
		Magazzino magazzino = new MagazzinoImpl();
		FactoryDiProdotto factory = new FactoryDiProdotto();
		Detersivo detersivo = factory.creaDetersivo(TipoDetersivo.PER_PIATTI);
		magazzino.aggiungi(detersivo);
		assertTrue(magazzino.aggiornaProdottiInTot().contains(detersivo));
		magazzino.aggiungi(detersivo);
		assertTrue(magazzino.aggiornaProdottiInTot().size() == 1); // detersivo non viene aggiunto perchè già presente in magazzino
		
		Farina farina = new Farina(21.30, Tempo.getDataAttuale().minusDays(20), TipoFarina.INTEGRALE, 8);
		magazzino.aggiungi(farina);
		assertFalse(magazzino.aggiornaProdottiInTot().contains(farina)); // farina non viene aggiunta perchè è scaduta
	}

	@Test
	void testPreleva() {
		Magazzino magazzino = new MagazzinoImpl();
		FactoryDiProdotto factory = new FactoryDiProdotto();
		Vestito vestito = factory.creaVestito(Taglia.L);
		magazzino.aggiungi(vestito);
		magazzino.preleva(vestito);
		assertFalse(magazzino.aggiornaProdottiInTot().contains(vestito));
	}

}
