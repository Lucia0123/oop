package main.miftari.fornitori;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public interface Fornitore {

	// fornisce n prodotti di tipo Prodotto
	List<Prodotto> fornisci(Prodotto prodotto, int n);
}
