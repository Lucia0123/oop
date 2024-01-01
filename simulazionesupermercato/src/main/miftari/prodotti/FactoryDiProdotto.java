package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Random;

import main.melle.tempo.Tempo;

public class FactoryDiProdotto {

	// creazione random di prodotti per velocizzare la creazione di oggetti di tipo Prodotto
		
	public Carne creaCarne() {
		//Random random = new Random();
		double prezzoRandom = new Random().nextDouble(Prodotto.getPrezzoMin(), Prodotto.getPrezzoMax());
		LocalDate dataRandom = Tempo.getDataCasuale();
		double pesoConfezioneRandom = new Random().nextDouble();
		TipoCarne tipoCarne = TipoCarne.DI_MAIALE;
		return new Carne(prezzoRandom, dataRandom, pesoConfezioneRandom, tipoCarne);
	}
	
	public Farina creaFarina() {
		
	}
	
	public Detersivo creaDetersivo() {
		
	}
	
	public Vestito creaVestito() {
		
	}
}
