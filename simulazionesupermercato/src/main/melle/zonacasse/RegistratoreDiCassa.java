package main.melle.zonacasse;

import java.util.ArrayList;
import java.util.List;

import main.miftari.prodotti.Prodotto;

public class RegistratoreDiCassa {
	
	private double guadagno;
	private List<RegistrazionePagamento> pagamentiEffettuati;
	
	public RegistratoreDiCassa() {
		this.guadagno = 0.0;
		this.pagamentiEffettuati = new ArrayList<>();
	}
	
	// metodo che restituisce l'esito della registrazione del pagamento
	public boolean registraPagamento(List<Prodotto> l, double costo) {
		if(this.calcolaCostoSpesa(l) - costo < 0.001) { // controllo se costo rappresenta la giusta somma da pagare
			RegistrazionePagamento nuovoPagamento = new RegistrazionePagamento(l, costo);
			this.pagamentiEffettuati.add(nuovoPagamento);
			this.guadagno += costo;
			return true;
		}
		return false;
	}
	
	public List<RegistrazionePagamento> getPagamentiEffettuati(){
		return this.pagamentiEffettuati;
	}
	
	public double getGuadagno() {
		System.out.println(this.guadagno);
		return this.guadagno;
	}
	
    public double calcolaCostoSpesa(List<Prodotto> p) {
		// somma del prezzo di ogni prodotto in p
    	double costoTotale = 0.0;
    	for(Prodotto prodotto : p) {
    		costoTotale += prodotto.getPrezzo();
    	}
    	return costoTotale;
	}
}
