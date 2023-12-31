package main.melle.zonacarrelli;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.miftari.prodotti.Prodotto;

public class CarrelloImpl implements Carrello{
	
	private static final int CAPACITAMAX = 30;
	private List<Prodotto> prodottiInCarrello; 	// prodotti attualmente nel carrello
	private int NProdottiInCarrello; 			// numero di prodotti attualmente nel carrello
	
	public CarrelloImpl() {
		this.prodottiInCarrello = new ArrayList<>();
		this.NProdottiInCarrello = 0;
	}
	
	public int getCapacitaMax() {
		return CAPACITAMAX;
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
			this.NProdottiInCarrello -= 1;
			return prodottoTolto;
		}
		return null;
	}

}
