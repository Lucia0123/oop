package main.controller;

import main.model.Model;
import main.view.View;

public class ControllerImpl implements Controller, ModelListener{

	private Model model;
	private View view;

    public ControllerImpl(Model model, View view) {
        this.model = model;
        this.view = view;
        this.model.aggiungiListener(this);
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

	
	
	
	
	
}
