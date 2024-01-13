package main.model;

import java.util.EventListener;
import java.util.List;

import main.melle.clienti.GestioneClienti;
import main.melle.supermercato.Supermercato;
import main.melle.supermercato.SupermercatoImpl;
import main.melle.supermercato.Tempo;
import main.miftari.fornitori.Fornitore;
import main.miftari.fornitori.FornitoreDiretto;
import main.miftari.prodotti.Prodotto;
import main.miftari.reparti.Etichetta;

public class ModelImpl implements Model{
	
	private Tempo tempo;
	private Supermercato supermercato;
	private GestioneClienti gestore;
	private Fornitore fornitore;
	private int nCarrelliLiberi;
	
	public ModelImpl() {
		this.tempo = new Tempo();
		this.supermercato = new SupermercatoImpl(this.tempo);
		this.gestore = new GestioneClienti(this.supermercato.getZonaCarrelli());
		this.fornitore = new FornitoreDiretto();
		this.nCarrelliLiberi = this.supermercato.getZonaCarrelli().getNCarrelliLiberi();
	}
	
	public ModelImpl(int numeroReparti, int numeroCasse) {
		this.tempo = new Tempo();
		this.supermercato = new SupermercatoImpl(this.tempo, numeroReparti, numeroCasse);
		this.gestore = new GestioneClienti(this.supermercato.getZonaCarrelli());
		this.fornitore = new FornitoreDiretto();
	}
	
	public void iniziaSimulazione() {
		.
		//this.tempo.startTempo();		
		// fai partire lavoratori
		this.supermercato.startLavoratori();
		// fai partire clienti
		this.gestore.generaClienti(supermercato);
	}
	
	public void finisciSimulazione() {
		this.tempo.stopTempo();
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
	public List<Prodotto> getInventario() {
		return this.supermercato.getUfficioLogistica().aggiornaInventario();
	}
	
	@Override
	public double getBilancio() {
		return this.supermercato.getUfficioAmministrativo().getBilancio();
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
	public void aggiungiObserver(EventListener o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuoviObserver(EventListener o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifica() {
		// TODO Auto-generated method stub
		
	}

}
