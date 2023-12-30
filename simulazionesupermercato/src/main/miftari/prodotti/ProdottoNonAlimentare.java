package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Optional;

public abstract class ProdottoNonAlimentare extends Prodotto{
	
	

	public ProdottoNonAlimentare(double prezzo, Optional<LocalDate> dataScad) {
		super(prezzo, dataScad);
	}

	@Override
    public Optional<LocalDate> getDataScad() {
		
		if(getDataScad().isPresent())
			return (Optional<LocalDate>)super.getDataScad();
		return null;
		
    }
}
