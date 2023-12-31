package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Optional;

public class Carne extends ProdottoAlimentare{

         private TipoCarne tipoCarne;

            // Costruttore che chiama il costruttore della classe base e imposta dati specifici della carne
            public Carne (double prezzo, LocalDate dataScadenza, TipoCarne tipoCarne) {
                super(prezzo, Optional.ofNullable(dataScadenza));
                
  this.tipoCarne = tipoCarne;
            }

            // Metodo per ottenere il tipo di carne
            public TipoCarne getTipoCarne() {
                return this.tipoCarne;
            }
}