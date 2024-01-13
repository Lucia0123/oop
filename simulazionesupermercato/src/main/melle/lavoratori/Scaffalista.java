package main.melle.lavoratori;

import java.util.ArrayList;
import java.util.List;

import main.melle.supermercato.Supermercato;
import main.miftari.magazzino.Magazzino;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Etichetta;
import main.miftari.reparti.Reparto;

public class Scaffalista extends Lavoratore{

	private int capacita = 50;
	private Magazzino magazzino;
	private List<Reparto> reparti;
	
	public Scaffalista(double stipendioNuovoLavoratore, Magazzino magazzino, List<Reparto> reparti) {
		super(stipendioNuovoLavoratore);
		this.magazzino = magazzino;
		this.reparti = reparti;
	}

	public void lavora(Supermercato supermercato) {
		while(supermercato.isSimulazioneAttiva()) {
			int i;
			// rimuovi tutti i prodotti scaduti dai reparti (non si applica ai vestiti visto che non hanno data di scadenza)		
			for(Reparto reparto : this.reparti) {
				reparto.rimuoviProdottiScaduti();
			}
			
			// prendi prodotti dal magazzino
			List<Prodotto> prodottiInMagazzino = this.magazzino.aggiornaProdottiInTot();
			List<Prodotto> prodottiPrelevati = new ArrayList<>();
			// finchè ha spazio libero lo scaffalista continua a prelevare prodotti dal magazzino
			for(i = 0; i < this.capacita; i++) {
				// seleziona il prodotto di indice i e lo preleva
				prodottiPrelevati.add(this.magazzino.preleva(prodottiInMagazzino.get(i)));
			}
			// disponi i prodotti presi nei rispettivi reparti
			for(Prodotto prodotto : prodottiPrelevati) {
				// se il prodotto è alimentare..
				if(this.magazzino.controllaCategoria(prodotto) <= 1) {
					// disponi il prodotto in un reparto alimentare
					for(i = 0; i < this.reparti.size() && this.reparti.get(i).getEtichetta() == Etichetta.REPARTO_NON_ALIMENTARE; i++);
					this.reparti.get(i).aggiungiProdotto(prodotto);
				}
				
				// se il prodotto non è alimentare
				else {
					// cerca un reparto adatto
					for(i = 0; i < this.reparti.size() && this.reparti.get(i).getEtichetta() == Etichetta.REPARTO_ALIMENTARE; i++);
					// se il reparto esiste, aggiungi a questo il prodotto
					if(i != this.reparti.size()) {
						this.reparti.get(i).aggiungiProdotto(prodotto);
					}
				}
			}
		}	
	}
}
