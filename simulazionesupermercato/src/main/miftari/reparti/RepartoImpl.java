package main.miftari.reparti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.ProdottoAlimentare;
import main.miftari.prodotti.ProdottoNonAlimentare;

public class RepartoImpl implements Reparto{

	private static final int CAPACITA_MAX = 150;
	private int capacitaAttuale; // numero di prodotti aggiungibili in questo reparto attualmente
	private Etichetta etichetta; // etichetta che identifica il reparto come alimentare o non alimentare
	private List<Prodotto> prodottiInReparto;
	
	// costruttore per creare un reparto con una specifica etichetta
	public RepartoImpl(Etichetta etichetta) {
		this.etichetta = etichetta;
		this.capacitaAttuale = CAPACITA_MAX;
		this.prodottiInReparto = new ArrayList<>();
	}
	
	// costruttore per creare un reparto con Etichetta random
	public RepartoImpl() {
		int numeroCasuale = new Random().nextInt(2); // numero casuale 0 o 1
		if(numeroCasuale == 0) {
			new RepartoImpl(Etichetta.REPARTO_ALIMENTARE);
		}
		new RepartoImpl(Etichetta.REPARTO_NON_ALIMENTARE);
	}

	public Etichetta getEtichetta() {
		return this.etichetta;
	}

	public int getCapacitaMax() {
		return CAPACITA_MAX;
	}

	// aggiorna e restituisce la capacita attuale
	public int aggiornaCapacitaAttuale() {
		this.capacitaAttuale = this.prodottiInReparto.size();
		return this.capacitaAttuale;
	}

	// metodo per prelevare un prodotto dal reparto
	public Prodotto prendiProdotto(Prodotto prodotto) {
		Prodotto valoreDiRitorno = null;
		if(prodotto != null && this.prodottiInReparto.contains(prodotto)) {
			if(this.etichetta == Etichetta.REPARTO_ALIMENTARE) {
				if(prodotto instanceof ProdottoAlimentare) {
					// cerco prodotto alimentare da prelevare, lo elimino dal reparto e lo restituisco
					valoreDiRitorno = this.rimuoviERestituisci(prodotto);
				}	
			}
			else{
				if(prodotto instanceof ProdottoNonAlimentare) {
					// cerco prodotto non alimentare da prelevare, lo elimino dal reparto e lo restituisco
					valoreDiRitorno = this.rimuoviERestituisci(prodotto);
				}		
			}			
		}
		return valoreDiRitorno;
	}
	
	// metodo per ispezionare i prodotti presenti in reparto
	public List<Prodotto> getProdotti() {
		return List.copyOf(this.prodottiInReparto);
	}

	// metodo per aggiungere un prodotto in reparto
	public void aggiungiProdotto(Prodotto prodotto) {
		if(prodotto != null && this.capacitaAttuale > 0) {
			if(this.etichetta == Etichetta.REPARTO_ALIMENTARE) {
				if(prodotto instanceof ProdottoAlimentare) {
					// aggiungo prodotto alimentare in reparto
					this.prodottiInReparto.add(prodotto);
				}	
			}
			else{
				if(prodotto instanceof ProdottoNonAlimentare) {
					// aggiungo prodotto non alimentare in reparto
					this.prodottiInReparto.add(prodotto);
				}		
			}			
		}		
	}
	
	private Prodotto rimuoviERestituisci(Prodotto prodotto) {
		Prodotto daPrendere = this.prodottiInReparto.get(this.prodottiInReparto.indexOf(prodotto));
		this.prodottiInReparto.remove(daPrendere);
		return daPrendere;
	}
	
}
