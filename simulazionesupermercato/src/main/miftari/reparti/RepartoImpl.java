package main.miftari.reparti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.melle.supermercato.Tempo;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.ProdottoAlimentare;
import main.miftari.prodotti.ProdottoNonAlimentare;

public class RepartoImpl implements Reparto{

	private static final int CAPACITA_MAX = 150; // numero massimo di prodotti teoricamente aggiungibili a questo reparto
	private int numeroAttualeProdotti; // numero di prodotti presenti in questo reparto attualmente
	private Etichetta etichetta; // etichetta che identifica il reparto come alimentare o non alimentare
	private List<Prodotto> prodottiInReparto;
	
	// costruttore per creare un reparto con una specifica etichetta
	public RepartoImpl(Etichetta etichetta) {
		this();
		this.etichetta = etichetta;
	}
	
	// costruttore per creare un reparto con Etichetta random
	public RepartoImpl() {
		int numeroCasuale = new Random().nextInt(2); // numero casuale 0 o 1
		if(numeroCasuale == 0) {
			this.etichetta = Etichetta.REPARTO_ALIMENTARE;
		}
		else {
			this.etichetta = Etichetta.REPARTO_ALIMENTARE;
		}
		this.numeroAttualeProdotti = 0;
		this.prodottiInReparto = new ArrayList<>();
	}

	public Etichetta getEtichetta() {
		return this.etichetta;
	}

	public int getCapacitaMax() {
		return CAPACITA_MAX;
	}

	// aggiorna e restituisce il numero attuale di prodotti contenuti nel reparto
	public int aggiornaNumeroAttualeProdotti() {
		this.numeroAttualeProdotti = this.prodottiInReparto.size();
		return this.numeroAttualeProdotti;
	}

	// metodo per aggiungere un prodotto in reparto
	public void aggiungiProdotto(Prodotto prodotto) {
		if(prodotto != null && this.numeroAttualeProdotti < CAPACITA_MAX) {
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
		this.aggiornaNumeroAttualeProdotti();
		return List.copyOf(this.prodottiInReparto);
	}

	public void rimuoviProdottiScaduti() {
		if(this.prodottiInReparto != null) {
			for(Prodotto prodotto : this.prodottiInReparto) {
				// controllo della data di scadenza del prodotto
				if(prodotto.getDataScad().isBefore(Tempo.getDataAttuale())) {
					this.rimuoviERestituisci(prodotto);
				}
			}
			// alla fine si aggiorna il numeroAttualeProdotti
			this.aggiornaNumeroAttualeProdotti();
		}
	}
	
	private Prodotto rimuoviERestituisci(Prodotto prodotto) {
		Prodotto daPrendere = this.prodottiInReparto.get(this.prodottiInReparto.indexOf(prodotto));
		if(this.prodottiInReparto.remove(daPrendere));
		return daPrendere;
	}
}
