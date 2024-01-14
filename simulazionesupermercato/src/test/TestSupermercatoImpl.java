package test;

import static org.junit.jupiter.api.Assertions.*;
import main.melle.supermercato.*;
import main.miftari.reparti.Etichetta;

import org.junit.jupiter.api.Test;

class TestSupermercatoImpl {
	
	@Test
	void testSupermercatoImplTempoIntInt() {
		int nReparti = 3;
		int nCasse = 5;
		Supermercato supermercato = new SupermercatoImpl(nReparti, nCasse);
		assertEquals(3, supermercato.getReparti().size());
		assertEquals(nCasse, supermercato.getZonaCasse().getNCasse());
	}


	@Test
	void testAggiungiRepartoEtichetta() {
		int nRepartiPrima = 3;
		int nCasse = 5;
		Supermercato supermercato = new SupermercatoImpl(nRepartiPrima, nCasse);
		supermercato.aggiungiReparto(Etichetta.REPARTO_NON_ALIMENTARE);
		int nRepartiDopo = nRepartiPrima + 1;
		assertEquals(nRepartiDopo, supermercato.getReparti().size());
		// l'etichetta del nuovo reparto è quella passata come parametro ad aggiungiReparto()
		assertTrue(supermercato.getReparti().get(nRepartiDopo - 1).getEtichetta() == Etichetta.REPARTO_NON_ALIMENTARE);
	}
}
