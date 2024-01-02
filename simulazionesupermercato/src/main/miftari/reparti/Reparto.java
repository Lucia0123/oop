package main.miftari.reparti;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public interface Reparto {

	Etichetta getEtichetta();
	
	int getCapacitaMax();
	
	int aggiornaCapacitaAttuale();

	void aggiungiProdotto(Prodotto prodotto);
	
	Prodotto prendiProdotto(Prodotto prodotto);
	
	List<Prodotto> getProdotti();
}
