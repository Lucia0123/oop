package main.miftari.prodotti;

import java.time.LocalDate;

public class Farina extends ProdottoAlimentare {



    private MarcaFarina marca;


    // Costruttore che chiama il costruttore della classe base e imposta dati specifici della farina
    public Farina(double prezzo, LocalDate dataScadenza, MarcaFarina marca, double pesoConfezione) {
        super(prezzo, dataScadenza, pesoConfezione);
        this.marca = marca;
    }

    // Metodo per ottenere la marca della farina
    public MarcaFarina getMarcaFarina() {
        return this.marca;
    }
}