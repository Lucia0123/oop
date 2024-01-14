package main.miftari.uffici;

import java.util.List;

import main.miftari.fornitori.Fornitore;
import main.miftari.prodotti.Prodotto;

public interface UfficioLogistica {

	Fornitore getFornitore();
	
	List<Prodotto> aggiornaInventario();
	
	void ordinaProdotti();

}
