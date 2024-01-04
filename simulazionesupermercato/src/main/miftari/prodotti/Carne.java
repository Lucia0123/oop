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
    
    @Override
    public boolean equals(Object o) {
    	if(o instanceof Carne) {
    		if(((Carne)o).getPrezzo() - this.getPrezzo() < 0.001 && ((Carne)o).getDataScad().isEqual(this.getDataScad())
    	    	&& ((Carne)o).getPesoConfezione() - this.getPesoConfezione() < 0.001 && (((Carne)o).getTipoCarne().compareTo(this.getTipoCarne()) == 0)) {
    	    		return true;
    	    }
    	}
    	return false;
    }
}