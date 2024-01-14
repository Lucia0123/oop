package main.melle.clienti;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import main.melle.supermercato.Supermercato;
import main.melle.zonacarrelli.Carrello;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Reparto;

public class Cliente {

	private Optional<Carrello> carrello;
	private int capacita;
	private static final int CAPACITASENZACARRELLO = 5;
	private List<Prodotto> prodottiPresi = new ArrayList<Prodotto>();
	
	// costruttore per clienti senza carrello
	public Cliente() {
		carrello = Optional.empty();
		capacita = CAPACITASENZACARRELLO;
	}
	
	// costruttore per clienti con carrello
	public Cliente(Carrello c) {
		carrello = Optional.of(c);
		capacita = c.getCapacitaMax();
	}
	
	public Optional<Carrello> getCarrello(){
		return carrello;
	}
	
	public int getCapacita() {
		return capacita;
	}
	
	public void faiSpesa(Supermercato supermercato) {
		// il cliente prende prodotti finchè ce ne sono nei reparti e finchè la sua capacità lo permette
		if(this.ciSonoProdottiDaPrendere(supermercato)) {
			for(int i = capacita; i > 0; i--) {
				this.selezionaProdotti(supermercato);
				
				// il cliente si mette in fila alla cassa con la coda più breve
				supermercato.getZonaCasse().aggiungiAllaCodaPiuBreve(this);
			}
		}
	}
	
	public List<Prodotto> getProdottiPresi(){
		return List.copyOf(this.prodottiPresi);
	}
	
	// il cliente seleziona prodotti random dal primo reparto non vuoto che trova
	private void selezionaProdotti(Supermercato supermercato){
		
		// visita reparto non vuoto
		Reparto daVisitare = this.cercaRepartoNonVuoto(supermercato);
			
		if(daVisitare != null) {
			// seleziona un prodotto random
			Prodotto scelto = daVisitare.getProdotti().get(new Random().nextInt(daVisitare.getProdotti().size()));
			// togli il prodotto scelto dal reparto e prendilo
			Prodotto preso = daVisitare.prendiProdotto(scelto);
			if(preso != null) {
				this.prodottiPresi.add(preso);
				this.capacita--;
			}
		}
	}
	// metodo che restituisce true se c'è almeno un reparto non vuoto (cioè con almeno un prodotto dentro)
	private boolean ciSonoProdottiDaPrendere(Supermercato supermercato) {
		int numeroRepartiNonVuoti = 0;
		for(Reparto reparto : supermercato.getReparti()) {
			if(!reparto.getProdotti().isEmpty()) {
				numeroRepartiNonVuoti += 1;
			}
		}
		if(numeroRepartiNonVuoti > 0) {
			return true;
		}
		return false;
	}
	
	// restituisce il primo reparto non vuoto trovato
	private Reparto cercaRepartoNonVuoto(Supermercato supermercato) {
		for(Reparto reparto : supermercato.getReparti()) {
			if(!reparto.getProdotti().isEmpty()) {
				return reparto;
			}
		}
		return null;
	}
}
