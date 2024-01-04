package main.melle.supermercato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.melle.lavoratori.Cassiere;
import main.melle.lavoratori.Lavoratore;
import main.melle.zonacarrelli.ZonaCarrelli;
import main.melle.zonacarrelli.ZonaCarrelliImpl;
import main.melle.zonacasse.ZonaCasse;
import main.melle.zonacasse.ZonaCasseImpl;
import main.miftari.magazzino.Magazzino;
import main.miftari.magazzino.MagazzinoImpl;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Etichetta;
import main.miftari.reparti.Reparto;
import main.miftari.reparti.RepartoImpl;

public class SupermercatoImpl implements Supermercato{
	
	public static final int NUMERO_MINIMO_REPARTI = 2;
	public static final int NUMERO_MASSIMO_REPARTI = 10;
	public static final double STIPENDIO_MINIMO_LAVORATORE;
	public static final double STIPENDIO_MASSIMO_LAVORATORE;
	private final UfficioAmministrativo ufficioAmm;
	private final UfficioLogistica ufficioLog;
	private final ZonaCasse zonaCasse;
	private int numeroCasse = new Random().nextInt(1, 6); // numero casse fra 1 e 5 casualmente
	private int numeroReparti = new Random().nextInt(NUMERO_MINIMO_REPARTI, (NUMERO_MASSIMO_REPARTI++)); // numero reparti fra 2 e 10 casualmente
	private final Magazzino magazzino;
	private final ZonaCarrelli zonaCarrelli;
	private List<Reparto> reparti;
	private List<Lavoratore> lavoratori;
	private final double stipendioLavoratore;
	private final Tempo tempo;
	
	public SupermercatoImpl() {
		this.ufficioAmm = new UfficioAmministrativo();
		this.uffioLog = new UfficioLogistica();
		this.zonaCasse = new ZonaCasseImpl(this.numeroCasse);
		this.magazzino = new MagazzinoImpl();
		this.zonaCarrelli = new ZonaCarrelliImpl();
		this.reparti = new ArrayList<>();
		for(int i = 0; i < this.numeroReparti; i++) {
			reparti.add(new RepartoImpl());
		}
		this.lavoratori = new ArrayList<>();
		// creo un cassiere per ogni cassa esistente
		for(int i = 0; i < this.numeroCasse; i++) {
			Cassiere daAggiungere = new Cassiere(new Random().nextDouble(STIPENDIO_MINIMO_LAVORATORE, (STIPENDIO_MASSIMO_LAVORATORE++)), this.zonaCasse.getCasse().get(i));
			this.lavoratori.add(daAggiungere);
		}
		this.tempo = new Tempo();
	}
	
	// costruttore con alcuni parametri stabiliti dall'utente
	public SupermercatoImpl(int numeroReparti, int numeroCasse) {	
		this.ufficioAmm = new UfficioAmministrativo();
		this.ufficioLog = new UfficioLogistica();
		this.zonaCasse = new ZonaCasseImpl(ZonaCasseImpl.NUMERO_MINIMO_CASSE);
		
		// setta this.numeroCasse a numeroCasse solo se quest'ultimo è fra NUMERO_MINIMO_CASSE e NUMERO_MASSIMO_CASSE
		// se numeroCasse non è accettabile la zona delle casse avrà NUMERO_MINIMO_CASSE casse
		if(this.zonaCasse.setNCasse(numeroCasse)) {
			this.numeroCasse = numeroCasse;
		}
		
		this.magazzino = new MagazzinoImpl();
		this.zonaCarrelli = new ZonaCarrelliImpl();
		this.reparti = new ArrayList<>();
		
		// controllo su numeroReparti passato come valore al costruttore
		if(numeroReparti <= NUMERO_MASSIMO_REPARTI && numeroReparti >= NUMERO_MINIMO_REPARTI) {
			for(int i = 0; i < numeroReparti; i++) {
				reparti.add(new RepartoImpl());
			}
		}
		this.numeroReparti = numeroReparti;
		
		this.lavoratori = new ArrayList<>();
		// creo un cassiere per ogni cassa esistente
		for(int i = 0; i < this.numeroCasse; i++) {
			Cassiere daAggiungere = new Cassiere(new Random().nextDouble(STIPENDIO_MINIMO_LAVORATORE, (STIPENDIO_MASSIMO_LAVORATORE++)), this.zonaCasse.getCasse().get(i));
			this.lavoratori.add(daAggiungere);
		}
		
		this.tempo = new Tempo();
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
		List.copyOf(this.reparti);
	}

	public List<Prodotto> getProdottiInTotale() {
		return this.magazzino.aggiornaProdottiInTot(); // copyof già usato in magazzino.aggiornaProdottiInTot()
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
	
	public Tempo getTempo() {
		return this.tempo;
	}
	
	public boolean isSimulazioneAttiva() {
		return this.tempo.simulazioneAttiva;
	}
}
