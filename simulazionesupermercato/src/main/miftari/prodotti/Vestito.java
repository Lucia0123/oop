package main.miftari.prodotti;

import java.util.Optional;

public class Vestito extends ProdottoNonAlimentare{

	private Taglia taglia;

    // Costruttore che chiama il costruttore della classe base e imposta dati specifici del Vestito
    public Vestito(double prezzo, Taglia taglia) {
        super(prezzo, Optional.empty());
        this.taglia = taglia;
    }

    // Metodo per ottenere la taglia del vestito
    public Taglia getTaglia() {
        return this.taglia;
    }

    @Override
    public boolean equals(Object o) {
    	if(o instanceof Vestito) {
    		if(((Vestito)o).getPrezzo() - this.getPrezzo() < 0.001 && (((Vestito)o).getTaglia().compareTo(this.getTaglia()) == 0)) {
        		return true;
        	}
    	}
    	return false;
    }
    
    @Override
	public String toString() {
		return "[ " + Math.round(this.getPrezzo()) + ", " + this.taglia +  " ]";
	}
}
