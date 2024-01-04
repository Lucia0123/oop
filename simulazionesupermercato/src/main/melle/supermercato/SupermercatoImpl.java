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
import main.miftari.reparti.Etichetta;
import main.miftari.reparti.Reparto;
import main.miftari.reparti.RepartoImpl;

public class SupermercatoImpl implements Supermercato{
	
	public static final int NUMERO_MINIMO_REPARTI = 2;
	public static final int NUMERO_MASSIMO_REPARTI = 10;
	private final UfficioAmministrativo ufficioAmm;
	private final UfficioLogistica ufficioLog;
	private int numeroCasse = new Random().nextInt(1, 6); // numero casse fra 1 e 5 casualmente
	private int numeroReparti = new Random().nextInt(1, 6); // numero reparti fra 1 e 5 casualmente
	private final Magazzino magazzino;
	private final ZonaCarrelli zonaCarrelli;
	private List<Reparto> reparti;
	private final Tempo tempo;
	
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
		
		this.magazzino = new MagazzinoImpl();
		this.zonaCarrelli = new ZonaCarrelliImpl();
		this.reparti = new ArrayList<>();
		
		// controllo su numeroReparti passato come valore al costruttore
		if(numeroReparti <= NUMERO_MASSIMO_REPARTI && numeroReparti >= NUMERO_MINIMO_REPARTI) {
			for(int i = 0; i < numeroReparti; i++) {
				reparti.add(new RepartoImpl());
			}
		}
		else {
			// se numeroReparti non è accettabile gli viene assegnato un valore casuale entro i limiti prestabiliti
			numeroReparti = new Random().nextInt(NUMERO_MINIMO_REPARTI, (NUMERO_MASSIMO_REPARTI--));
		}
		this.numeroReparti = numeroReparti;
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
}
