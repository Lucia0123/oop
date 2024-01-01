package main.melle.zonacasse;

import java.util.List;

import main.miftari.prodotti.Prodotto;

public class RegistrazionePagamento {

	private final List<Prodotto> prodottiVenduti;
	private final double costo; // prezzo pagato dal cliente per comprare prodottiVenduti

	public RegistrazionePagamento(final List<Prodotto> prodottiVenduti, final double costo) {
		this.prodottiVenduti = prodottiVenduti;
		this.costo = costo;
	}

	public List<Prodotto> getProdottiVenduti() {
		return this.prodottiVenduti;
	}

	public double getCosto() {
		return this.costo;
	}

	
}
