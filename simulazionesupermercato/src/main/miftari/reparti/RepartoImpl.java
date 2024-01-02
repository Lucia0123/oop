package main.miftari.reparti;

import java.util.ArrayList;
import java.util.List;

import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.ProdottoAlimentare;
import main.miftari.prodotti.ProdottoNonAlimentare;

public class RepartoImpl implements Reparto{

	private static final int CAPACITA_MAX = 150;
	private int capacitaAttuale; // numero di prodotti aggiungibili in questo reparto attualmente
	private Etichetta etichetta; // etichetta che identifica il reparto come alimentare o non alimentare
	private List<Prodotto> prodottiInReparto;
	
	public RepartoImpl(Etichetta etichetta) {
		this.etichetta = etichetta;
		this.capacitaAttuale = CAPACITA_MAX;
		this.prodottiInReparto = new ArrayList<>();
	}

	public Etichetta getEtichetta() {
		return this.etichetta;
	}

	public int getCapacitaMax() {
		return CAPACITA_MAX;
	}

	public int getCapacitaAttuale() {
		return this.capacitaAttuale;
	}

	// metodo per prelevare un prodotto dal reparto
	public Prodotto prendiProdotto(Prodotto prodotto) {
		Prodotto valoreDiRitorno = null;
		if(prodotto != null && this.capacitaAttuale > 0 && this.prodottiInReparto.contains(prodotto)) {
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
		// TODO Auto-generated method stub
		
	}
	
	private Prodotto rimuoviERestituisci(Prodotto prodotto) {
		Prodotto daPrendere = this.prodottiInReparto.get(this.prodottiInReparto.indexOf(prodotto));
		this.prodottiInReparto.remove(daPrendere);
		return daPrendere;
	}
	
}
