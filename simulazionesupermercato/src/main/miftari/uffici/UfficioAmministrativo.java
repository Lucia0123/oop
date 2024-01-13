package main.miftari.uffici;

import java.util.List;

import main.melle.lavoratori.Lavoratore;
import main.melle.zonacasse.ZonaCasse;

public interface UfficioAmministrativo {

	double aggiornaEntrate(ZonaCasse zonaCasse); // aggiorna e restituisce le entrate
	
	double aggiornaUscite(List<Lavoratore> lavoratori);
	
	double getBilancio();
}
