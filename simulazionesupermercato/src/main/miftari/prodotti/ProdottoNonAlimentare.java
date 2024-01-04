package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Optional;

public abstract class ProdottoNonAlimentare extends Prodotto{
		
    // costruttore che chiama il costruttore della classe base
	public ProdottoNonAlimentare(double prezzo, Optional<LocalDate> dataScadenza) {
		super(prezzo, dataScadenza.orElse(null));
	}

}
