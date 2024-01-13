package main.melle.supermercato;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.melle.lavoratori.Cassiere;
import main.melle.lavoratori.Lavoratore;
import main.melle.lavoratori.Scaffalista;
import main.melle.zonacarrelli.ZonaCarrelli;
import main.melle.zonacarrelli.ZonaCarrelliImpl;
import main.melle.zonacasse.ZonaCasse;
import main.melle.zonacasse.ZonaCasseImpl;
import main.miftari.magazzino.*;
import main.miftari.reparti.*;
import main.miftari.uffici.*;

public class SupermercatoImpl implements Supermercato{
	
	public static final int NUMERO_MINIMO_REPARTI = 2;
	public static final int NUMERO_MASSIMO_REPARTI = 11;
	public static final double STIPENDIO_MINIMO_LAVORATORE = 900.00;
	public static final double STIPENDIO_MASSIMO_LAVORATORE = 2000.00;
	public static final int NUMERO_SCAFFALISTI = 3;
	
	private ZonaCasse zonaCasse;
	private int numeroCasse = new Random().nextInt(1, 6); // numero casse fra 1 e 5 casualmente
	private int numeroReparti = new Random().nextInt(NUMERO_MINIMO_REPARTI, NUMERO_MASSIMO_REPARTI); // numero reparti fra 2 e 10 casualmente
	private final Magazzino magazzino;
	private final ZonaCarrelli zonaCarrelli;
	private List<Reparto> reparti = new ArrayList<>();
	private List<Lavoratore> lavoratori = new ArrayList<>();
	private final Tempo tempo;
	private final UfficioAmministrativo ufficioAmm;
	private final UfficioLogistica ufficioLog;
	
	public SupermercatoImpl(final Tempo tempo) {
		this.zonaCasse = new ZonaCasseImpl(this.numeroCasse);
		for(int i = 0; i < this.numeroReparti; i++) {
			reparti.add(new RepartoImpl());
		}
		// creo un cassiere per ogni cassa esistente
		for(int i = 0; i < this.numeroCasse; i++) {
			double stipendioNuovoLavoratore = new Random().nextDouble(STIPENDIO_MINIMO_LAVORATORE, STIPENDIO_MASSIMO_LAVORATORE);
			Lavoratore daAggiungere = new Cassiere(stipendioNuovoLavoratore, this.zonaCasse.getCasse().get(i));
			this.lavoratori.add(daAggiungere);
		}
		// creo NUMERO_SCAFFALISTI scaffalisti
		for(int i = 0; i < NUMERO_SCAFFALISTI; i++) {
			double stipendioNuovoLavoratore = new Random().nextDouble(STIPENDIO_MINIMO_LAVORATORE, STIPENDIO_MASSIMO_LAVORATORE);
			Lavoratore daAggiungere = new Scaffalista(stipendioNuovoLavoratore, this.getMagazzino(), this.reparti);
			this.lavoratori.add(daAggiungere);
		}
		this.magazzino = new MagazzinoImpl();
		this.zonaCarrelli = new ZonaCarrelliImpl();
		this.tempo = tempo;
		this.ufficioAmm = new UfficioAmministrativoImpl(this.zonaCasse, this.lavoratori);
		this.ufficioLog = new UfficioLogisticaImpl(this.magazzino, this.reparti);
	}
	
	// costruttore con alcuni parametri stabiliti dall'utente
	public SupermercatoImpl(final Tempo tempo, int numeroReparti, int numeroCasse) {
		this(tempo);
		this.zonaCasse = new ZonaCasseImpl(ZonaCasseImpl.NUMERO_MINIMO_CASSE);
		
		// setta this.numeroCasse a numeroCasse solo se quest'ultimo è fra NUMERO_MINIMO_CASSE e NUMERO_MASSIMO_CASSE
		// se numeroCasse non è accettabile la zona delle casse avrà NUMERO_MINIMO_CASSE casse
		if(this.zonaCasse.setNCasse(numeroCasse)) {
			this.numeroCasse = numeroCasse;
		}
		
		// controllo su numeroReparti passato come valore al costruttore
		if(numeroReparti <= NUMERO_MASSIMO_REPARTI && numeroReparti >= NUMERO_MINIMO_REPARTI) {
			this.numeroReparti = numeroReparti;
			for(int i = 0; i < numeroReparti; i++) {
				reparti.add(new RepartoImpl());
			}
		}
				
		// creo un cassiere per ogni cassa esistente
		for(int i = 0; i < this.numeroCasse; i++) {
			Cassiere daAggiungere = new Cassiere(new Random().nextDouble(STIPENDIO_MINIMO_LAVORATORE, STIPENDIO_MASSIMO_LAVORATORE), this.zonaCasse.getCasse().get(i));
			this.lavoratori.add(daAggiungere);
		}		
	}
	
	public UfficioAmministrativo getUfficioAmministrativo() {
		return this.ufficioAmm;
	}

	public UfficioLogistica getUfficioLogistica() {
		return this.ufficioLog;
	}

	public ZonaCarrelli getZonaCarrelli() {
		return this.zonaCarrelli;
	}
	
	public ZonaCasse getZonaCasse() {
		return this.zonaCasse;
	}

	public Magazzino getMagazzino() {
		return this.magazzino;
	}

	public List<Reparto> getReparti() {
		return List.copyOf(this.reparti);
	}

	public List<Lavoratore> getLavoratori(){
		return List.copyOf(this.lavoratori);
	}
	
	public Tempo getTempo() {
		return this.tempo;
	}
	
	public void startLavoratori() {
		for(Lavoratore lavoratore : this.lavoratori) {
			lavoratore.lavora(this);
		}
	}
	
	// metodo per aggiungere un reparto con l'etichetta data
	public void aggiungiReparto(Etichetta etichetta) {
		if(this.numeroReparti < NUMERO_MASSIMO_REPARTI) {
			this.reparti.add(new RepartoImpl(etichetta));
		}
	}
	
	// metodo per aggiungere un reparto casuale
	public void aggiungiReparto() {
		if(this.numeroReparti < NUMERO_MASSIMO_REPARTI) {
			this.reparti.add(new RepartoImpl());
		}
	}

	public boolean isSimulazioneAttiva() {
		return this.tempo.simulazioneAttiva;
	}
}
