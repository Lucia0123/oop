package main.melle.supermercato;

import java.time.LocalDate;
import java.util.List;

import main.melle.zonacarrelli.ZonaCarrelli;
import main.miftari.prodotti.Prodotto;

public interface Supermercato {

	public UfficioAmministrativo getUfficioAmministrativo();
	
	public UfficioLogistica getUfficioLogistica();
	
	public ZonaCarrelli getZonaCarrelli();
	
	public Magazzino getMagazzino();
	
	public List<Reparto> getReparti();
	
	public List<Prodotto> getProdottiInTotale();

}
