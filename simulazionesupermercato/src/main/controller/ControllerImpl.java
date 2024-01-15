package main.controller;

import main.model.Model;
import main.view.View;
import main.view.ViewObserver;

public class ControllerImpl implements Controller, ModelListener, ViewObserver{

	private static final int DURATA_MASSIMA = 50; // durata massima della simulazione in numero di giorni
	private static final int DURATA_MINIMA = 1; // durata minima della simulazione in numero di giorni
	private Model model;
	private View view;
	private int durata;

    public ControllerImpl(Model model, View view) {
    	this.model = model;
        this.view = view;
        this.model.aggiungiListener(this);
        this.durata = 0;
    }
       
	@Override
	public void setView(View view) {
		this.view = view;
	}

	@Override
	public View getView() {
		return this.view;
	}

	@Override
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public Model getModel() {
		return this.model;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	@Override
	public void simula() {		
		if(this.durata <= DURATA_MASSIMA && this.durata >= DURATA_MINIMA) {
			this.model.setDurata(this.durata);
			this.model.simula();
		}
	}
	
	// metodi attraverso i quali il controller aggiorna la view
	@Override
	public void dataCambiata() {
		this.view.aggiornaData(this.model.getData());
	}

	@Override
	public void bilancioCambiato() {
		this.view.aggiornaBilancio(this.model.getBilancio());
	}

	@Override
	public void inventarioCambiato() {
		this.view.aggiornaInventario(this.model.getInventario());
	}

	@Override
	public void nLavoratoriCambiato() {
		this.view.aggiornaNLavoratori(this.model.getNLavoratori());
	}

	@Override
	public void nTotClientiCambiato() {
		this.view.aggiornaNTotClienti(this.model.getNTotClienti());
	}

	@Override
	public void nCarrelliLiberiCambiato() {
		this.view.aggiornaNCarrelliLiberi(this.model.getNCarrelliLiberi());
	}

	@Override
	public void nCarrelliOccupatiCambiato() {
		this.view.aggiornaNCarrelliOccupati(this.model.getNCarrelliOccupati());
	}

	@Override
	public int getDurataMassimaSimulazione() {
		return DURATA_MASSIMA;
	}

	@Override
	public int getDurataMinimaSimulazione() {
		return DURATA_MINIMA;
	}

	@Override
	public void conferma(int durata) {
		this.durata = durata;
	}
}
