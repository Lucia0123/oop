package main.miftari.magazzino;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public interface Magazzino {

	void aggiungi(Prodotto daAggiungere);
	
	Prodotto preleva(Prodotto daPrelevare);

	public List<Prodotto> aggiornaProdottiInTot();
}
