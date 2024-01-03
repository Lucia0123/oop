package main.melle.supermercato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.melle.zonacarrelli.ZonaCarrelli;
import main.melle.zonacarrelli.ZonaCarrelliImpl;
import main.melle.zonacasse.ZonaCasse;
import main.melle.zonacasse.ZonaCasseImpl;
import main.miftari.magazzino.Magazzino;
import main.miftari.magazzino.MagazzinoImpl;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Reparto;
import main.miftari.reparti.RepartoImpl;

public class SupermercatoImpl implements Supermercato{
	
	private final UfficioAmministrativo ufficioAmm;
	private final UfficioLogistica ufficioLog;
	private int numeroCasse = new Random().nextInt(1, 6); // numero casse fra 1 e 5 casualmente
	private int numeroReparti = new Random().nextInt(1, 6); // numero reparti fra 1 e 5 casualmente
	private final Magazzino magazzino;
	private final ZonaCarrelli zonaCarrelli;
	private List<Reparto> reparti;
	private Tempo tempo;
	
	public SupermercatoImpl() {
		this.ufficioAmm = new UfficioAmministrativo();
		this.uffioLog = new UfficioLogistica();
		ZonaCasse zonaCasse = new ZonaCasseImpl(this.numeroCasse);
		this.magazzino = new MagazzinoImpl();
		this.zonaCarrelli = new ZonaCarrelliImpl();
		this.reparti = new ArrayList<>();
		for(int i = 0; i < this.numeroReparti; i++) {
			reparti.add(new RepartoImpl());
		}
		this.tempo = new Tempo();
	}
	
	// costruttore con alcuni parametri stabiliti dall'utente
	public SupermercatoImpl(int numeroReparti, int numeroCasse) {	
		this.ufficioAmm = new UfficioAmministrativo();
		this.uffioLog = new UfficioLogistica();
		ZonaCasse zonaCasse = new ZonaCasseImpl(ZonaCasseImpl.NUMERO_MINIMO_CASSE);
		
		// setta this.numeroCasse a numeroCasse solo se quest'ultimo è fra NUMERO_MINIMO_CASSE e NUMERO_MASSIMO_CASSE
		// se numeroCasse non è accettabile la zona delle casse avrà NUMERO_MINIMO_CASSE casse
		if(zonaCasse.setNCasse(numeroCasse)) {
			this.numeroCasse = numeroCasse;
		}
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

	public void setNReparti(int nuovoNumero) {
		
	}
}
