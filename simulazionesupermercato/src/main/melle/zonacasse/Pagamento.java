package main.melle.zonacasse;

import java.util.List;

public class Pagamento {

	private final List<Prodotto> prodottiVenduti;
	private final double costo; // prezzo pagato dal cliente per comprare prodottiVenduti

	public Pagamento(final List<Prodotto> prodottiVenduti, final double costo) {
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
