package main.controller;

import java.util.EventListener;

public interface ModelListener extends EventListener{
	
	void dataCambiata();
	
	void bilancioCambiato();
	
	void inventarioCambiato();
	
	void nLavoratoriCambiato();
	
	void nTotClientiCambiato();
	
	void nCarrelliLiberiCambiato();
	
	void nCarrelliOccupatiCambiato();
}
