package main.model;

import java.time.LocalDate;
import java.util.List;

import main.controller.ModelListener;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Etichetta;

public interface Model {
	
	void setDurata(int durata);
	
	void simula();
	
	void aggiungiReparto(Etichetta etichetta);
	
	void aggiungiRepartoCasuale();
	
	LocalDate getData();
	
	double getBilancio();
	
	List<Prodotto> getInventario();
		
	int getNLavoratori();
	
	int getNTotClienti();
	
	int getNCarrelliLiberi();
	
	int getNCarrelliOccupati();
			
	void aggiungiListener(ModelListener o);
	
	void rimuoviListener(ModelListener o);
}
