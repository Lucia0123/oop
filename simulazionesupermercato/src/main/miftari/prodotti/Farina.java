package main.miftari.prodotti;

import java.time.LocalDate;

public class Farina extends ProdottoAlimentare {

    private TipoFarina marca;


    // Costruttore che chiama il costruttore della classe base e imposta dati specifici della farina
    public Farina(double prezzo, LocalDate dataScadenza, TipoFarina marca, double pesoConfezione) {
        super(prezzo, dataScadenza, pesoConfezione);
        this.marca = marca;
    }

    // Metodo per ottenere la marca della farina
    public TipoFarina getMarcaFarina() {
        return this.marca;
    }
    
    @Override
    public boolean equals(Object o) {
    	if(o instanceof Farina) {
    		if(((Farina)o).getPrezzo() - this.getPrezzo() < 0.001 && ((Farina)o).getDataScad().isEqual(this.getDataScad())
    	    	&& ((Farina)o).getPesoConfezione() - this.getPesoConfezione() < 0.001 && (((Farina)o).getMarcaFarina().compareTo(this.getMarcaFarina()) == 0)) {
    	    		return true;
    	    }
    	}
    	return false;
    }
    
    @Override
	public String toString() {
		return "[ " + Math.round(this.getPrezzo()) + ", " + this.getDataScad() + ", "  + this.marca + ", " + this.getPesoConfezione() + " ]";
	}
}