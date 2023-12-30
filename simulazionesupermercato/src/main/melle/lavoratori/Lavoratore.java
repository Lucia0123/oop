package main.melle.lavoratori;

public abstract class Lavoratore {

	private double stipendio;
	
	public Lavoratore(int stipendio) {
		this.stipendio = stipendio;
	}
	
	public double getStipendio() {
		return stipendio;
	}
	
	public abstract void lavora();
}
