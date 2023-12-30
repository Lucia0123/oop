package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Optional;

public class Detersivo extends ProdottoNonAlimentare{

	 private Tipo tipo;

	    // Costruttore che chiama il costruttore della classe base e imposta dati specifici del Detersivo
	    public Detersivo(double prezzo, LocalDate dataScadenza, Tipo tipo) {
	        super(prezzo, Optional.ofNullable(dataScadenza));
	        this.tipo = tipo;
	    }

	    // Metodo per ottenere il tipo di detersivo
	    public Tipo getTipo() {
	        return this.tipo;
	    }
}
