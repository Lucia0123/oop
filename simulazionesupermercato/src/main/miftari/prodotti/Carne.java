package main.miftari.prodotti;

import java.time.LocalDate;

public class Carne extends ProdottoAlimentare{

	private TipoCarne tipoCarne;

    // Costruttore che chiama il costruttore della classe base e imposta dati specifici della carne
    public Carne (double prezzo, LocalDate dataScadenza, double pesoConfezione, TipoCarne tipoCarne) {
    	super(prezzo, dataScadenza, pesoConfezione);
    	
        this.tipoCarne = tipoCarne;
    }

    // Metodo per ottenere il tipo di carne
    public TipoCarne getTipoCarne() {
    	return this.tipoCarne;
    }
}