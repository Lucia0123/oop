package main.melle.zonacasse;

import java.util.List;

public class RegistratoreDiCassa {
	
	private double guadagno;
	private List<Pagamento> pagamentiEffettuati;
	
	public RegistratoreDiCassa() {
		this.guadagno = 0.0;
		this.pagamentiEffettuati = null;
	}
	
	public boolean registraPagamento(List<Prodotto> l, double costo) {
		if(this.calcolaCostoSpesa(l) == costo) {
			Pagamento nuovoPagamento = new Pagamento(l, costo);
			this.pagamentiEffettuati.add(nuovoPagamento);
			return true;
		}
		return false;
	}
	
	public List<Pagamento> getPagamentiEffettuati(){
		return this.pagamentiEffettuati;
	}
	
	public double getGuadagno() {
		return this.guadagno;
	}
	
	public double prelevaGuadagno() {
		double tmp = guadagno;
		guadagno = 0.0;
		return tmp;
	}
	
    private double calcolaCostoSpesa(List<Prodotto> p) {
		// somma del prezzo di ogni prodotto in p
    	double costoTotale = 0.0;
    	for(Prodotto prodotto : p) {
    		costoTotale += prodotto.getPrezzo();
    	}
    	return costoTotale;
	}
}
