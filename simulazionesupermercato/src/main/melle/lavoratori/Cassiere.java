package main.melle.lavoratori;

import java.util.List;

import main.melle.clienti.Cliente;
import main.melle.supermercato.Supermercato;
import main.melle.zonacasse.Cassa;
import main.miftari.prodotti.Prodotto;

public class Cassiere extends Lavoratore{

	private Cassa cassaCheGestisco;
	
	public Cassiere(double stipendio, Cassa cassaCheGestisco) {
		super(stipendio);
		this.cassaCheGestisco = cassaCheGestisco;
	}
	
	public Cassa getCassaCheGestisco() {
		return this.cassaCheGestisco;
	}
	
	public void setCassaCheGestisco(Cassa daGestire) {
		this.cassaCheGestisco = daGestire;
	}

	public void lavora(Supermercato supermercato) {
		// chi gli dice la cassa da gestire e come viene scelta??
			if(this.cassaCheGestisco != null) {
				Cliente daServire = this.cassaCheGestisco.getClienteDaServire();
				
				// se c'è un cliente da servire calcolo il costo che ha da pagare e registro il pagamento
				if(daServire != null) {
					System.out.println("Servo il cliente");
					List<Prodotto> prodottiDaPagare = daServire.getProdottiPresi();
					double prezzoTotale = this.cassaCheGestisco.getRegistratoreDiCassa().calcolaCostoSpesa(prodottiDaPagare);
					this.cassaCheGestisco.getRegistratoreDiCassa().registraPagamento(prodottiDaPagare, prezzoTotale);
					// adesso si può togliere il cliente dalla coda
					this.cassaCheGestisco.togliDallaCoda(daServire);
					// quando nessuno ha più il riferimento a cliente, questo oggetto verrà eliminato dal garbage collector
				}
			}		
	}
}
