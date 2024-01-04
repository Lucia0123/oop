package main.miftari.prodotti;

import java.time.LocalDate;

public abstract class ProdottoAlimentare extends Prodotto{

	private double pesoConfezione;

    // Costruttore che chiama il costruttore della classe base e imposta i dati specifici di ProdottoAlimentare
    public ProdottoAlimentare(double prezzo, LocalDate dataScadenza, double pesoConfezione) {
        super(prezzo, dataScadenza);
        this.pesoConfezione = pesoConfezione;
    }

    // Metodo per ottenere il peso della confezione
    public double getPesoConfezione() {
        return this.pesoConfezione;
    }

    // Override del metodo della classe base per ottenere la data di scadenza
    @Override
    public LocalDate getDataScad() {
        // Chiamata al metodo della classe base
        return super.getDataScad();
    }

	
}
