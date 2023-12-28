package main.melle.zonacarrelli;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarrelloImpl implements Carrello{
	
	private static final int CAPACITAMAX = 30;  // massimo numero di prodotti aggiungibili al carrello
	private List<Prodotto> prodottiInCarrello; 	// prodotti attualmente nel carrello
	private int NProdottiInCarrello; 			// numero di prodotti attualmente nel carrello
	
	public CarrelloImpl() {
		this.prodottiInCarrello = new ArrayList<>();
		this.NProdottiInCarrello = 0;
	}
	
	public int getCapacitaMax() {
		return this.CAPACITAMAX;
	}

	public List<Prodotto> getProdottiInCarrello() {
		return this.prodottiInCarrello;
	}

	public int getNProdottiInCarrello() {
		return this.NProdottiInCarrello;
	}

	public boolean aggiungiProdotto(Prodotto p) {
		if(this.NProdottiInCarrello < CAPACITAMAX) {
			this.prodottiInCarrello.add(p);
			this.NProdottiInCarrello += 1;
			return true;
		}
		return false;		
	}

	public Prodotto togliProdotto() {
		if(this.NProdottiInCarrello > 0) {
			Prodotto prodottoTolto = this.prodottiInCarrello.remove((new Random()).nextInt(this.prodottiInCarrello.size()));
			return prodottoTolto;
		}
		return null;
	}

}
