package main.melle.supermercato;

import java.time.LocalDate;
import java.util.Random;

public class Tempo {

	private static LocalDate dataAttuale = LocalDate.EPOCH; // 1970-01-01
	private final LocalDate dataInizio;
	private final LocalDate dataFine;
	
	public Tempo(final long durataInGiorni){
		this.dataInizio = Tempo.dataAttuale;
		this.dataFine = this.dataInizio.plusDays(durataInGiorni);
	}
	
	public static LocalDate getDataAttuale() {
		return dataAttuale;
	}
	
	// metodo sfruttato durante la crezione di prodotti per stabilire la data di scadenza
	// massimoValoreInGiorni viene richiesto come parametro di ingresso in modo da poter avere prodotti di diversa durata
	public static LocalDate getDataCasuale(long massimoValoreInGiorni){
		LocalDate dataInizio = Tempo.getDataAttuale();
        //LocalDate dataFine = LocalDate.of(2022, 12, 31);
        
        // Aggiunge il numero casuale di giorni alla data di inizio
        return dataInizio.plusDays(new Random().nextLong(1, massimoValoreInGiorni));
	}
	
	public boolean vaiAvantiDiUnGiorno() {
		if(dataAttuale.isBefore(dataFine)) {
			dataAttuale = dataAttuale.plusDays(1);
			return true;
		}
		return false;
	}
}


