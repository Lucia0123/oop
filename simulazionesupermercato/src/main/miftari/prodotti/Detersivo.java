package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Optional;

public class Detersivo extends ProdottoNonAlimentare{

	 private TipoDetersivo tipoDetersivo;

	 // Costruttore che chiama il costruttore della classe base e imposta dati specifici del Detersivo
	 public Detersivo(double prezzo, LocalDate dataScadenza, TipoDetersivo tipoDetersivo) {
		 super(prezzo, Optional.ofNullable(dataScadenza));
	     this.tipoDetersivo = tipoDetersivo;
	 }

	 // Metodo per ottenere il tipo di detersivo
	 public TipoDetersivo getTipo() {
		 return this.tipoDetersivo;
	 }
}
