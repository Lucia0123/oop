package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Random;

public abstract class Prodotto {
	
	private double prezzo;
	private LocalDate dataScad;
	private static final double PREZZO_MAX = 30.00;
	private static final double PREZZO_MIN = 1.00;
	
	public Prodotto(double prezzo, LocalDate dataScad){
		if(prezzo <= 0) {
			this.prezzo = new Random().nextDouble(Prodotto.PREZZO_MIN, (Prodotto.PREZZO_MAX));
		}
		this.prezzo = prezzo;
		this.dataScad = dataScad;
	}

	public double getPrezzo() {
		return this.prezzo;
	}
	
	public LocalDate getDataScad() {
		if(this.dataScad != null)
			return this.dataScad;
		return null;
					
	}
	
	public static double getPrezzoMin() {
		return PREZZO_MIN;
	}
	
	public static double getPrezzoMax() {
		return PREZZO_MAX;
	}
}
