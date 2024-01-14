package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.melle.supermercato.Tempo;
import main.miftari.prodotti.Carne;
import main.miftari.prodotti.FactoryDiProdotto;
import main.miftari.prodotti.Farina;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.TipoCarne;
import main.miftari.prodotti.TipoDetersivo;
import main.miftari.prodotti.TipoFarina;
import main.miftari.reparti.Etichetta;
import main.miftari.reparti.*;

class TestRepartoImpl {
	
	@Test
	void testAggiungiProdotto() {
		FactoryDiProdotto factory = new FactoryDiProdotto();
		RepartoImpl repartoAl = new RepartoImpl(Etichetta.REPARTO_ALIMENTARE);
		RepartoImpl repartoNonAl = new RepartoImpl(Etichetta.REPARTO_NON_ALIMENTARE);
		
		// verifica del funzionamento di aggiungiProdotto() quando prodotto = null
		repartoAl.aggiungiProdotto(null);
		assertTrue(repartoAl.getProdotti().isEmpty());
		
		// in un reparto alimentare si accettano solo prodotti alimentari, nei reparti non alimentari solo prodotti non alimentari
		Prodotto prodottoAl = factory.creaFarina(TipoFarina.TIPO_0);
		Prodotto prodottoNonAl = factory.creaDetersivo(TipoDetersivo.PER_PIATTI);
		repartoAl.aggiungiProdotto(prodottoNonAl);
		assertFalse(repartoAl.getProdotti().contains(prodottoNonAl));
		repartoNonAl.aggiungiProdotto(prodottoAl);
		assertFalse(repartoNonAl.getProdotti().contains(prodottoAl));
		
		repartoAl.aggiungiProdotto(prodottoAl);
		assertTrue(repartoAl.getProdotti().contains(prodottoAl));
		repartoNonAl.aggiungiProdotto(prodottoNonAl);
		assertTrue(repartoNonAl.getProdotti().contains(prodottoNonAl));
	}
	
	@Test
	void testPrendiProdotto() {
		FactoryDiProdotto factory = new FactoryDiProdotto();
		
		// verifica del funzionamento di prendiProdotto() quando prodotto = null
		RepartoImpl repartoAl = new RepartoImpl(Etichetta.REPARTO_ALIMENTARE);
		assertEquals(null, repartoAl.prendiProdotto(null));
		
		// verifica del valore di ritorno in caso si voglia prendere un prodotto non presente in reparto
		RepartoImpl repartoNonAl = new RepartoImpl(Etichetta.REPARTO_NON_ALIMENTARE);
		Prodotto prodottoAl = factory.creaFarina(TipoFarina.TIPO_0);
		Prodotto prodottoNonAl = factory.creaDetersivo(TipoDetersivo.PER_PIATTI);
				
		repartoAl.aggiungiProdotto(prodottoAl);
		repartoNonAl.aggiungiProdotto(prodottoNonAl);
		assertEquals(null, repartoAl.prendiProdotto(prodottoNonAl)); // si vuole prendere un prodotto non presente
		repartoAl.prendiProdotto(prodottoAl);
		repartoNonAl.prendiProdotto(prodottoNonAl);
		assertTrue(repartoAl.getProdotti().isEmpty());
		assertTrue(repartoNonAl.getProdotti().isEmpty());

	}

	@Test
    void testRimuoviProdottiScaduti() {
        // Configurazione di base
        Reparto reparto = new RepartoImpl(Etichetta.REPARTO_ALIMENTARE);

        // Aggiungi prodotti al reparto
        Prodotto prodottoScaduto = new Carne(9.45, Tempo.getDataAttuale().minusDays(30), 3, TipoCarne.DI_MAIALE);
        Prodotto prodottoNonScaduto = new Farina(10, Tempo.getDataCasuale(0), TipoFarina.DI_GLUTINE, 12);

        reparto.aggiungiProdotto(prodottoScaduto);
        reparto.aggiungiProdotto(prodottoNonScaduto);

        // Esegui il metodo di rimozione dei prodotti scaduti
        reparto.rimuoviProdottiScaduti();

        // Verifica che il prodotto scaduto sia stato rimosso
        List<Prodotto> prodottiInReparto = reparto.getProdotti();
        assertEquals(1, prodottiInReparto.size());
        assertTrue(prodottiInReparto.contains(prodottoNonScaduto));
        assertFalse(prodottiInReparto.contains(prodottoScaduto));
    }
}
