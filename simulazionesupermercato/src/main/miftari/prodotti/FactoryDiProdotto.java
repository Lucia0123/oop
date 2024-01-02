package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Random;

import main.melle.tempo.Tempo;

public class FactoryDiProdotto {

	// generazione casuale del prezzo
	private double generaPrezzo() {
		return new Random().nextDouble(Prodotto.getPrezzoMin(), Prodotto.getPrezzoMax());
	}
	
	// metodi per la creazione di prodotti per velocizzare la creazione di questi
		
	public Carne creaCarne(TipoCarne tipoCarne) {
		LocalDate dataScadenzaRandom = Tempo.getDataCasuale();
		double pesoConfezioneRandom = new Random().nextDouble();
		return new Carne(generaPrezzo(), dataScadenzaRandom, pesoConfezioneRandom, tipoCarne);
	}
	
	public Farina creaFarina(TipoFarina marca) {
		LocalDate dataScadenzaRandom = Tempo.getDataCasuale();
		double pesoConfezioneRandom = new Random().nextDouble();
		return new Farina(generaPrezzo(), dataScadenzaRandom, marca, pesoConfezioneRandom);
	}
	
	public Detersivo creaDetersivo(Tipo tipo) {
		LocalDate dataScadenzaRandom = Tempo.getDataCasuale();
		return new Detersivo(generaPrezzo(), dataScadenzaRandom, tipo);
	}
	
	public Vestito creaVestito(Taglia taglia) {
		return new Vestito(generaPrezzo(), taglia);
	}
}
