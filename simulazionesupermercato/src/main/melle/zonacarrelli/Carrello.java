package main.melle.zonacarrelli;

import java.util.List;

public interface Carrello {

	int getCapacitaMax();
	
	List<Prodotto> getProdottiInCarrello();
	
	int getNProdottiInCarrello();
	
	boolean aggiungiProdotto(Prodotto p);
	
	Prodotto togliProdotto();
}
