package main.melle.supermercato;

import java.time.LocalDate;

public class Tempo {

	boolean simulazioneAttiva = false;
	private static LocalDate dataAttuale = LocalDate.EPOCH; // 1970-01-01
	
	public Tempo(){
		this.simulazioneAttiva = true;
	}
	
	public static LocalDate getDataAttuale() {
		return dataAttuale;
	}
	
	// metodo sfruttato durante la crezione di prodotti per stabilire la data di scadenza
	// giorniCasuali viene richiesto come parametro di ingresso in modo da poter avere prodotti di diversa durata
	public static LocalDate getDataCasuale(long giorniCasuali){
		LocalDate dataInizio = Tempo.getDataAttuale();
        //LocalDate dataFine = LocalDate.of(2022, 12, 31);
        
        // Aggiunge il numero casuale di giorni alla data inizio
        return dataInizio.plusDays(giorniCasuali);
	}
		
	public void startTempo() {
		this.simulazioneAttiva = true;
		while(simulazioneAttiva) {
			this.vaiAvantiDiUnGiorno();
		}
	}
	
	public void vaiAvantiDiUnGiorno() {
		dataAttuale = dataAttuale.plusDays(1);
	}
	
	public void stopTempo() {
		this.simulazioneAttiva = false;
	}
}


