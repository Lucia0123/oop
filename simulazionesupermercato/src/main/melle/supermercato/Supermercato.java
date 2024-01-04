package main.melle.supermercato;

import java.time.LocalDate;
import java.util.List;

import main.melle.zonacarrelli.ZonaCarrelli;
import main.melle.zonacasse.ZonaCasse;
import main.miftari.magazzino.Magazzino;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Etichetta;
import main.miftari.reparti.Reparto;

public interface Supermercato {

	UfficioAmministrativo getUfficioAmministrativo();
	
	UfficioLogistica getUfficioLogistica();
	
	ZonaCarrelli getZonaCarrelli();
	
	ZonaCasse getZonaCasse();
	
	Magazzino getMagazzino();
	
	List<Reparto> getReparti();
	
	List<Prodotto> getProdottiInTotale();

	void aggiungiReparto(Etichetta etichetta);
	
	void aggiungiReparto();
	
	Tempo getTempo();
	
	boolean isSimulazioneAttiva();
}
