package main.melle.supermercato;

import java.util.List;

import main.melle.lavoratori.Lavoratore;
import main.melle.zonacarrelli.ZonaCarrelli;
import main.melle.zonacasse.ZonaCasse;
import main.miftari.magazzino.Magazzino;
import main.miftari.reparti.Etichetta;
import main.miftari.reparti.Reparto;
import main.miftari.uffici.UfficioAmministrativo;
import main.miftari.uffici.UfficioLogistica;

public interface Supermercato {

	UfficioAmministrativo getUfficioAmministrativo();
	
	UfficioLogistica getUfficioLogistica();
	
	ZonaCarrelli getZonaCarrelli();
	
	ZonaCasse getZonaCasse();
	
	Magazzino getMagazzino();
	
	List<Reparto> getReparti();
	
	List<Lavoratore> getLavoratori();

	Tempo getTempo();
	
	void startLavoratori();

	void aggiungiReparto(Etichetta etichetta);
	
	void aggiungiReparto();
		
	boolean isSimulazioneAttiva();
}
