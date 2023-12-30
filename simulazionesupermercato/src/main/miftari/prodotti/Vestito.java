package main.miftari.prodotti;

import java.util.Optional;

public class Vestito extends ProdottoNonAlimentare{

	private Taglia taglia;
    private Colore colore;

    // Costruttore che chiama il costruttore della classe base e imposta dati specifici del Vestito
    public Vestito(double prezzo, Taglia taglia, Colore colore) {
        super(prezzo, Optional.empty());
        this.taglia = taglia;
        this.colore = colore;
    }

    // Metodo per ottenere la taglia del vestito
    public Taglia getTaglia() {
        return this.taglia;
    }

    // Metodo per ottenere il colore del vestito
    public Colore getColore() {
        return this.colore;
    }
}
