package main.miftari.fornitori;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.FactoryDiProdotto;
import main.miftari.prodotti.Farina;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.ProdottoAlimentare;
import main.miftari.prodotti.Taglia;
import main.miftari.prodotti.TipoCarne;
import main.miftari.prodotti.TipoDetersivo;
import main.miftari.prodotti.TipoFarina;

// fornitore che è anche produttore dei prodotti che fornisce
public class FornitoreDiretto implements Fornitore{

	private FactoryDiProdotto factory = new FactoryDiProdotto();
	
	public List<Prodotto> fornisci(Prodotto prodotto, int n) {
		List<Prodotto> prodottiOrdinati = new ArrayList<>();	
		if(prodotto instanceof ProdottoAlimentare) {
			if(prodotto instanceof Farina) {
				TipoFarina[] tipi = TipoFarina.values();
				int indiceCasuale = new Random().nextInt(TipoFarina.values().length);
				TipoFarina tipoCasuale = tipi[indiceCasuale];
				for(int i = 0; i < n; i++) {
					prodottiOrdinati.add(this.factory.creaFarina(tipoCasuale));
				}
			}	
			else {
				TipoCarne[] tipi = TipoCarne.values();
				int indiceCasuale = new Random().nextInt(TipoCarne.values().length);
				TipoCarne tipoCasuale = tipi[indiceCasuale];
				for(int i = 0; i < n; i++) {
					this.factory.creaCarne(tipoCasuale);
				}
			}
		}
		else {
			if(prodotto instanceof Detersivo) {
				TipoDetersivo[] tipi = TipoDetersivo.values();
				int indiceCasuale = new Random().nextInt(TipoDetersivo.values().length);
				TipoDetersivo tipoCasuale = tipi[indiceCasuale];
				for(int i = 0; i < n; i++) {
					this.factory.creaDetersivo(tipoCasuale);
				}
			}
			else {
				Taglia[] tipi = Taglia.values();
				int indiceCasuale = new Random().nextInt(Taglia.values().length);
				Taglia tipoCasuale = tipi[indiceCasuale];
				for(int i = 0; i < n; i++) {
					this.factory.creaVestito(tipoCasuale);
				}
			}
		}
		return prodottiOrdinati;
	}
}
