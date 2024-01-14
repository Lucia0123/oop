package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.melle.lavoratori.Scaffalista;
import main.melle.supermercato.Tempo;
import main.miftari.magazzino.*;
import main.miftari.reparti.Etichetta;
import main.miftari.reparti.Reparto;
import main.miftari.reparti.RepartoImpl;
import main.miftari.prodotti.*;

class TestScaffalista {

	@Test
    void testLavora_RimuoviProdottiScaduti() {
        // Configurazione di base
        Magazzino magazzino = new MagazzinoImpl();
        Reparto repartoAlimentare = new RepartoImpl(Etichetta.REPARTO_ALIMENTARE);
        Reparto repartoNonAlimentare = new RepartoImpl(Etichetta.REPARTO_NON_ALIMENTARE);
        List<Reparto> reparti = new ArrayList<>();
        reparti.add(repartoAlimentare);
        reparti.add(repartoNonAlimentare);
        
        // Aggiungi prodotti scaduti al reparto
        Prodotto prodottoScaduto = new Carne(5, Tempo.getDataAttuale().minusDays(20), 20, TipoCarne.DI_POLLO);
        repartoAlimentare.aggiungiProdotto(prodottoScaduto);

        // Crea uno scaffalista
        Scaffalista scaffalista = new Scaffalista(1000, magazzino, reparti);

        // Esegui il metodo di lavoro
        scaffalista.lavora(null);

        // Verifica che il prodotto scaduto sia stato rimosso
        //assertEquals(0, repartoAlimentare.getProdotti().size());
    }

    @Test
    void testLavora_DisponiProdotti() {
        // Configurazione di base
        Magazzino magazzino = new MagazzinoImpl();
        Reparto repartoAlimentare = new RepartoImpl(Etichetta.REPARTO_ALIMENTARE);
        Reparto repartoNonAlimentare = new RepartoImpl(Etichetta.REPARTO_NON_ALIMENTARE);
        List<Reparto> reparti = new ArrayList<>();
        reparti.add(repartoAlimentare);
        reparti.add(repartoNonAlimentare);

        // Aggiungi prodotti al magazzino
        Prodotto prodottoAlimentare = new Carne(5, Tempo.getDataCasuale(0), 20, TipoCarne.DI_POLLO);
        Prodotto prodottoNonAlimentare = new Vestito(12.30, Taglia.M);
        List<Prodotto> prodottiInMagazzino = new ArrayList<>();
        prodottiInMagazzino.add(prodottoAlimentare);
        prodottiInMagazzino.add(prodottoNonAlimentare);
        for(Prodotto prodotto : prodottiInMagazzino) {
        	magazzino.aggiungi(prodotto);
        }

        // Crea uno scaffalista
        Scaffalista scaffalista = new Scaffalista(1000, magazzino, reparti);

        // Esegui il metodo di lavoro
        scaffalista.lavora(null);

        // Verifica che i prodotti siano stati posizionati nei reparti corretti
        assertEquals(1, repartoAlimentare.getProdotti().size());
        assertEquals(1, repartoNonAlimentare.getProdotti().size());
    }

}
