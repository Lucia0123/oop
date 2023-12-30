package main.miftari.prodotti;

public abstract class Prodotto {
	
	private double prezzo;
	private Object dataScad;
	
	public Prodotto(double prezzo, Object dataScad) {
		this.prezzo = prezzo;
		this.dataScad = dataScad;
	}

	public double getPrezzo() {
		return this.prezzo;
	}
	
	public Object getDataScad() {
		return this.dataScad;
	}
}
