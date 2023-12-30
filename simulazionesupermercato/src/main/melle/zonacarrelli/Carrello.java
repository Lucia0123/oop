package main.melle.zonacarrelli;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public interface Carrello {

	int getCapacitaMax();
	
	List<Prodotto> getProdottiInCarrello();
	
	int getNProdottiInCarrello();
	
	boolean aggiungiProdotto(Prodotto p);
	
	Prodotto togliProdotto();
}
