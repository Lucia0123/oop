package main.miftari.magazzino;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.melle.supermercato.Tempo;
import main.miftari.prodotti.Carne;
import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.Farina;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.ProdottoAlimentare;
import main.miftari.prodotti.Vestito;

public class MagazzinoImpl implements Magazzino{

	private List<Carne> carni;
	private List<Farina> farine;
	private List<Detersivo> detersivi;
	private List<Vestito> vestiti;
	private List<Prodotto> prodottiInTot; // lista contenente gli elementi di carni, farine, detersivi e vestiti
	
	public MagazzinoImpl() {
		carni = new ArrayList<>();
		farine = new ArrayList<>();
		detersivi = new LinkedList<>();
		vestiti = new ArrayList<>();
		prodottiInTot = new ArrayList<>();
	}
	
	// aggiorna e restituisce prodottiInTot
	public List<Prodotto> aggiornaProdottiInTot(){
		this.prodottiInTot.clear();
		this.prodottiInTot.addAll(this.carni);
		this.prodottiInTot.addAll(this.farine);
		this.prodottiInTot.addAll(this.detersivi);
		this.prodottiInTot.addAll(this.vestiti);
		return List.copyOf(this.prodottiInTot);
	}

	public List<Prodotto> getProdottiCarne() {
		return List.copyOf(this.carni);
	}

	public List<Prodotto> getProdottiFarina() {
		return List.copyOf(this.farine);
	}

	public List<Prodotto> getProdottiDetersivo() {
		return List.copyOf(this.detersivi);
	}

	public List<Prodotto> getProdottiVestito() {
		return List.copyOf(this.vestiti);
	}
	
	// aggiunta del prodotto in magazzino se questo non è scaduto e non è già contenuto in magazzino
	public void aggiungi(Prodotto daAggiungere) {
		this.aggiornaProdottiInTot();
		if(daAggiungere != null && !this.prodottiInTot.contains(daAggiungere)) {
			if(daAggiungere instanceof Vestito || !this.scaduto(daAggiungere)) {
				this.smista(daAggiungere);
				this.aggiornaProdottiInTot();
			}
		}
		
	}

	// prelevamento del prodotto dal magazzino se questo è contenuto in magazzino
	public Prodotto preleva(Prodotto daPrelevare) {
		if(daPrelevare != null && this.prodottiInTot.contains(daPrelevare)) {
			// smistamento del prodotto nella lista della sua categoria
				if(this.controllaCategoria(daPrelevare) > 1) {
					if(this.controllaCategoria(daPrelevare) == 2) {
						this.detersivi.remove(daPrelevare);
					}
					else {
						this.vestiti.remove(daPrelevare);					
						}
				}
				else {
					if(this.controllaCategoria(daPrelevare) == 1) {
						this.carni.remove(daPrelevare);	
					}
					else {
						this.farine.remove(daPrelevare);	
					}
				}
		}
		this.aggiornaProdottiInTot();
		return daPrelevare;
	}

	// restituisce 0 se il prodotto passato è farina, 1 se carne, 2 se detersivo, 3 se vestito
	public int controllaCategoria(Prodotto prodotto) {
		if(prodotto instanceof ProdottoAlimentare) {
			if(prodotto instanceof Farina) {
				return 0;
			}	
			return 1;
		}
		else {
			if(prodotto instanceof Detersivo) {
				return 2;
			}
			return 3;
		}
	}
	
	// controllo della data di scadenza dei prodotti, restituisce true se il prodotto è scaduto
	private boolean scaduto(Prodotto daControllare) {
		if(daControllare.getDataScad().isAfter(Tempo.getDataAttuale())) {
			return false;
		}
		return true;
	}
	
	// smistamento del prodotto nella lista della sua categoria
	private void smista(Prodotto daSmistare) {
		if(this.controllaCategoria(daSmistare) > 1) {
			if(this.controllaCategoria(daSmistare) == 2) {
				this.detersivi.add((Detersivo)daSmistare);
			}
			else {
				this.vestiti.add((Vestito)daSmistare);
			}
		}
		else {
			if(this.controllaCategoria(daSmistare) == 1) {
				this.carni.add((Carne)daSmistare);
			}
			else {
				this.farine.add((Farina)daSmistare);
			}
		}
		
	}
}
