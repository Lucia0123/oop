package main.miftari.uffici;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public interface UfficioLogistica {

	List<Prodotto> aggiornaInventario();
	
	void ordinaProdotti();

}
