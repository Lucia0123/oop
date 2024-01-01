package main.melle.tempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Tempo {

	private static LocalDate DATA_ATTUALE = LocalDate.EPOCH;
	
	public static LocalDate getDataAttuale() {
		return DATA_ATTUALE;
	}
	
	public static LocalDate getDataCasuale(){
		LocalDate dataInizio = Tempo.getDataAttuale();
        LocalDate dataFine = LocalDate.of(2022, 12, 31);
        
		long giorniTraLeDate = ChronoUnit.DAYS.between(dataInizio, dataFine) + 1;

        // Genera un numero casuale tra 0 e giorniTraLeDate - 1
        long giorniCasuali = new Random().nextLong(giorniTraLeDate);

        // Aggiunge il numero casuale di giorni alla data inizio
        return dataInizio.plusDays(giorniCasuali);
	}
}


