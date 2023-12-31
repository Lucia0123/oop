package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Optional;

public class Carne extends ProdottoAlimentare{

         private Tipo tipo;

            // Costruttore che chiama il costruttore della classe base e imposta dati specifici della carne
            public Carne (double prezzo, LocalDate dataScadenza, Tipo tipo) {
                super(prezzo, Optional.ofNullable(dataScadenza));
                this.tipo = tipo;
            }

            // Metodo per ottenere il tipo di carne
            public Tipo getTipo() {
                return this.tipo;
            }
}