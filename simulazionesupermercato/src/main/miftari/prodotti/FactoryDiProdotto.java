package main.miftari.prodotti;

import java.time.LocalDate;
import java.util.Random;

import main.melle.supermercato.Tempo;

public class FactoryDiProdotto {
	
	// durate massime in giorni
	public static final long MASSIMA_DURATA_CARNE = 30 * 2;
	public static final long MASSIMA_DURATA_FARINA = 30 * 12;
	public static final long MASSIMA_DURATA_DETERSIVO = 30 * 24;

	// generazione casuale del prezzo
	private double generaPrezzo() {
		return new Random().nextDouble(Prodotto.getPrezzoMin(), Prodotto.getPrezzoMax());
	}
	
	// metodi per velocizzare la creazione dei diversi prodotti		
	public Carne creaCarne(TipoCarne tipoCarne) {
		LocalDate dataScadenzaRandom = Tempo.getDataCasuale(MASSIMA_DURATA_CARNE); // genero data casuale
		double pesoConfezioneRandom = new Random().nextDouble();
		return new Carne(generaPrezzo(), dataScadenzaRandom, pesoConfezioneRandom, tipoCarne);
	}
	
	public Farina creaFarina(TipoFarina marca) {
		LocalDate dataScadenzaRandom = Tempo.getDataCasuale(MASSIMA_DURATA_FARINA);
		double pesoConfezioneRandom = new Random().nextDouble();
		return new Farina(generaPrezzo(), dataScadenzaRandom, marca, pesoConfezioneRandom);
	}
	
	public Detersivo creaDetersivo(TipoDetersivo tipoDetersivo) {
		LocalDate dataScadenzaRandom = Tempo.getDataCasuale(MASSIMA_DURATA_DETERSIVO);
		return new Detersivo(generaPrezzo(), dataScadenzaRandom, tipoDetersivo);
	}
	
	public Vestito creaVestito(Taglia taglia) {
		return new Vestito(generaPrezzo(), taglia);
	}
}
