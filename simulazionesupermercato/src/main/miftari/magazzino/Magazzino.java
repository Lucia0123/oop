package main.miftari.magazzino;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public interface Magazzino {

	void aggiungi(Prodotto daAggiungere);
	
	Prodotto preleva(Prodotto daPrelevare);
	
	int controllaCategoria(Prodotto prodotto);

	// aggiorna e restituisce una lista contentente tutti i prodotti in magazzino
	public List<Prodotto> aggiornaProdottiInTot();
	
	// aggiorna e restituisce una lista contentente tutti i prodotti di tipo carne in magazzino
	public List<Prodotto> getProdottiCarne();
		
	// aggiorna e restituisce una lista contentente tutti i prodotti di tipo farina in magazzino
	public List<Prodotto> getProdottiFarina();
		
	// aggiorna e restituisce una lista contentente tutti i prodotti di tipo detersivo in magazzino
	public List<Prodotto> getProdottiDetersivo();
	
	// aggiorna e restituisce una lista contentente tutti i prodotti di tipo vestito in magazzino
	public List<Prodotto> getProdottiVestito();
}
