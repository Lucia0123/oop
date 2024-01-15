package main.melle.lavoratori;

import main.melle.supermercato.Supermercato;

public abstract class Lavoratore {

	private double stipendioAlGiorno;
	
	public Lavoratore(double stipendio) {
		this.stipendioAlGiorno = stipendio;
	}
	
	public double getStipendio() {
		return stipendioAlGiorno;
	}
	
	public abstract void lavora(Supermercato supermercato);
}
