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
	
	public void setDurata(int durata) {
		this.tempo.setDataFine(durata);
	}
	
	public void simula() {
		while(this.tempo.vaiAvantiDiUnGiorno()) {
			this.notificaDataCambiata();
			this.notificaBilancioCambiato();
			this.notificaInventarioCambiato();
			this.notificaNLavoratoriCambiato();
			// fai partire gli uffici
			this.supermercato.getUfficioAmministrativo().getBilancio();
			this.notificaBilancioCambiato();
			this.supermercato.getUfficioLogistica().aggiornaInventario();
			this.notificaInventarioCambiato();
			this.supermercato.getUfficioLogistica().ordinaProdotti();
			this.notificaInventarioCambiato();
			// fai partire lavoratori
			this.supermercato.startLavoratori();
			// fai partire clienti
			this.gestore.generaClienti(supermercato);
			this.notificaNCarrelliLiberiCambiato();
			this.notificaNCarrelliOccupatiCambiato();
			this.notificaNTotClientiCambiato();
		}
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
		return Math.round(this.supermercato.getUfficioAmministrativo().getBilancio());
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
	public void notificaDataCambiata() {
		for(ModelListener listener : listener) {
            listener.dataCambiata();
        }		
	}

	public void notificaBilancioCambiato() {
		for(ModelListener listener : listener) {
            listener.bilancioCambiato();
        }
	}

	public void notificaInventarioCambiato() {
		for(ModelListener listener : listener) {
            listener.inventarioCambiato();
        }
	}

	public void notificaNLavoratoriCambiato() {
		for(ModelListener listener : listener) {
            listener.nLavoratoriCambiato();
        }
	}

	public void notificaNTotClientiCambiato() {
		for(ModelListener listener : listener) {
            listener.nTotClientiCambiato();
        }
	}

	public void notificaNCarrelliLiberiCambiato() {
		for(ModelListener listener : listener) {
            listener.nCarrelliLiberiCambiato();
        }
	}

	public void notificaNCarrelliOccupatiCambiato() {
		for(ModelListener listener : listener) {
            listener.nCarrelliOccupatiCambiato();
        }
	}
}
