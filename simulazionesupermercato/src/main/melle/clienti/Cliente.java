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
		if(supermercato.isSimulazioneAttiva()) {
			// il cliente prende prodotti finchè la sua capacità lo permette
			while(capacita > 0) {
				this.selezionaProdotti(supermercato);
			}
			
			// il cliente si mette in fila alla cassa con la coda più breve
			supermercato.getZonaCasse().aggiungiAllaCodaPiuBreve(this);
		}
	}
	
	public List<Prodotto> getProdottiPresi(){
		return List.copyOf(this.prodottiPresi);
	}
	
	// il cliente seleziona prodotti random in reparti random
	private void selezionaProdotti(Supermercato supermercato){
		// visita reparto random
		Reparto visitato = supermercato.getReparti().get(new Random().nextInt(supermercato.getReparti().size()));
		
		// seleziona un prodotto random
		Prodotto scelto = visitato.getProdotti().get(new Random().nextInt(visitato.getProdotti().size()));
		
		// togli il prodotto scelto dal reparto e prendilo
		Prodotto preso = visitato.prendiProdotto(scelto);
		if(preso != null) {
			this.prodottiPresi.add(preso);
			this.capacita--;
		}
	}
}
