package main.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.controller.ModelListener;
import main.melle.clienti.GestioneClienti;
import main.melle.supermercato.Supermercato;
import main.melle.supermercato.SupermercatoImpl;
import main.melle.supermercato.Tempo;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Etichetta;

public class ModelImpl implements Model{
	
	private List<ModelListener> listener = new ArrayList<>();
	private Tempo tempo;
	private Supermercato supermercato;
	private GestioneClienti gestore;
	private int nCarrelliLiberi;
	
	public ModelImpl(final int durata) {
		this.tempo = new Tempo(durata);
		this.supermercato = new SupermercatoImpl();
		this.gestore = new GestioneClienti(this.supermercato.getZonaCarrelli());
		this.nCarrelliLiberi = this.supermercato.getZonaCarrelli().getNCarrelliLiberi();
	}
	
	public ModelImpl(final int durata, int numeroReparti, int numeroCasse) {
		this(durata);
		this.supermercato = new SupermercatoImpl(numeroReparti, numeroCasse);
	}
	
	public void simula() {
		System.out.println("simula4");
		while(this.tempo.vaiAvantiDiUnGiorno()) {
			System.out.println("simula5");
			this.notificaDataCambiata();
			this.notificaBilancioCambiato();
			this.notificaInventarioCambiato();
			this.notificaNLavoratoriCambiato();
			this.notificaNCarrelliLiberiCambiato();
			this.notificaNCarrelliOccupatiCambiato();
			this.notificaNTotClientiCambiato();
			System.out.println("simula7");
			// fai partire gli uffici
			this.supermercato.getUfficioAmministrativo().getBilancio();
			this.notificaBilancioCambiato();
			this.supermercato.getUfficioLogistica().aggiornaInventario();
			this.notificaInventarioCambiato();
			this.supermercato.getUfficioLogistica().ordinaProdotti();
			this.notificaInventarioCambiato();
			System.out.println("simula8");
			// fai partire lavoratori
			this.supermercato.startLavoratori();
			// fai partire clienti
			this.gestore.generaClienti(supermercato);
			this.notificaNCarrelliLiberiCambiato();
			this.notificaNCarrelliOccupatiCambiato();
			this.notificaNTotClientiCambiato();
			System.out.println("simula9");
		}
		System.out.println("simula6");
	}

	@Override
	public void aggiungiReparto(Etichetta etichetta) {
		this.supermercato.aggiungiReparto(etichetta);		
	}

	@Override
	public void aggiungiRepartoCasuale() {
		this.supermercato.aggiungiReparto();		
	}
	
	@Override
	public LocalDate getData() {
		return Tempo.getDataAttuale();
	}
	
	@Override
	public double getBilancio() {
		return this.supermercato.getUfficioAmministrativo().getBilancio();
	}
	
	@Override
	public List<Prodotto> getInventario() {
		return this.supermercato.getUfficioLogistica().aggiornaInventario();
	}

	@Override
	public int getNLavoratori() {
		return this.supermercato.getLavoratori().size();
	}

	@Override
	public int getNTotClienti() {
		return this.gestore.getNTotClienti();
	}

	@Override
	public int getNCarrelliLiberi() {
		return this.nCarrelliLiberi;
	}

	@Override
	public int getNCarrelliOccupati() {
		return this.supermercato.getZonaCarrelli().getNCarrelliTot() - this.nCarrelliLiberi;
	}
	
	@Override
	public void aggiungiListener(ModelListener listener) {
		this.listener.add(listener);		
	}

	@Override
	public void rimuoviListener(ModelListener listener) {
		this.listener.remove(listener);
	}

	// metodi attraverso i quali il model notifica i listener
	@Override
	public void notificaDataCambiata() {
		for(ModelListener listener : listener) {
            listener.dataCambiata();
        }		
	}

	@Override
	public void notificaBilancioCambiato() {
		for(ModelListener listener : listener) {
            listener.bilancioCambiato();
        }
	}

	@Override
	public void notificaInventarioCambiato() {
		for(ModelListener listener : listener) {
            listener.inventarioCambiato();
        }
	}

	@Override
	public void notificaNLavoratoriCambiato() {
		for(ModelListener listener : listener) {
            listener.nLavoratoriCambiato();
        }
	}

	@Override
	public void notificaNTotClientiCambiato() {
		for(ModelListener listener : listener) {
            listener.nTotClientiCambiato();
        }
	}

	@Override
	public void notificaNCarrelliLiberiCambiato() {
		for(ModelListener listener : listener) {
            listener.nCarrelliLiberiCambiato();
        }
	}

	@Override
	public void notificaNCarrelliOccupatiCambiato() {
		for(ModelListener listener : listener) {
            listener.nCarrelliOccupatiCambiato();
        }
	}

}
