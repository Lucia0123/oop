package main.model;

import java.util.EventListener;
import java.util.List;

import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Etichetta;

public interface Model {
	
	void aggiungiReparto(Etichetta etichetta);
	
	void aggiungiRepartoCasuale();
	
	List<Prodotto> getInventario();
	
	double getBilancio();
	
	int getNLavoratori();
	
	int getNTotClienti();
	
	int getNCarrelliLiberi();
	
	int getNCarrelliOccupati();
		
	void aggiungiObserver(EventListener o);
	
	void rimuoviObserver(EventListener o);
	
	void notifica();
}
