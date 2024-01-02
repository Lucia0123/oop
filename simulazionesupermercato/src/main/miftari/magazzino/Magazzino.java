package main.miftari.magazzino;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public interface Magazzino {

	void aggiungi(List<Prodotto> daAggiungere);
	
	List<Prodotto> preleva(List<Prodotto> daPrelevare);

}
