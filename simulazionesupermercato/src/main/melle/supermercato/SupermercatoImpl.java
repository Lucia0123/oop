package main.melle.supermercato;

import java.time.LocalDate;
import java.util.List;

import main.melle.zonacarrelli.ZonaCarrelli;
import main.melle.zonacasse.ZonaCasse;
import main.miftari.prodotti.Prodotto;

public class SupermercatoImpl implements Supermercato{
	
	private final UfficioAmministrativo ufficioAmministrativo;
	private final UfficioLogistica ufficioLogistica;
	private final ZonaCasse zonaCasse;
	private final Magazzino magazzino;
	private final ZonaCarrelli zonaCarrelli;
	private List<Reparto> reparti;
	
	public SupermercatoImpl() {
		
	}
	
	public UfficioAmministrativo getUfficioAmministrativo() {
		// TODO Auto-generated method stub
		return null;
	}

	public UfficioLogistica getUfficioLogistica() {
		// TODO Auto-generated method stub
		return null;
	}

	public ZonaCarrelli getZonaCarrelli() {
		// TODO Auto-generated method stub
		return null;
	}

	public Magazzino getMagazzino() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reparto> getReparti() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Prodotto> getProdottiInTotale() {
		// TODO Auto-generated method stub
		return null;
	}

}
