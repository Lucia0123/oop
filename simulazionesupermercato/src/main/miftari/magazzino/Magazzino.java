package main.miftari.magazzino;

import main.miftari.prodotti.Prodotto;

public interface Magazzino {

	void aggiungi(Prodotto daAggiungere);
	
	Prodotto preleva(Prodotto daPrelevare);

}
