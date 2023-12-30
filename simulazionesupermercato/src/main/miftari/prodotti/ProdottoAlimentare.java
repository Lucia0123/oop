package main.miftari.prodotti;

import java.time.LocalDate;

public abstract class ProdottoAlimentare extends Prodotto{

	private double pesoConfezione;
    private int quantitaConfezione;

    // Costruttore che chiama il costruttore della classe base e imposta i dati specifici di ProdottoAlimentare
    public ProdottoAlimentare(double prezzo, LocalDate dataScadenza, double pesoConfezione, int quantitaConfezione) {
        super(prezzo, dataScadenza);
        this.pesoConfezione = pesoConfezione;
        this.quantitaConfezione = quantitaConfezione;
    }

    // Metodo per ottenere il peso della confezione
    public double getPesoConfezione() {
        return this.pesoConfezione;
    }

    // Metodo per ottenere la quantità  della confezione
    public int getQuantitaConfezione() {
        return this.quantitaConfezione;
    }

    // Override del metodo della classe base per ottenere la data di scadenza
    @Override
    public LocalDate getDataScad() {
        // Chiamata al metodo della classe base
        return (LocalDate)super.getDataScad();
    }

	
}
