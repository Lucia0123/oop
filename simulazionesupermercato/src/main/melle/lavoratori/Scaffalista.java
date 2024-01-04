package main.melle.lavoratori;

import main.melle.supermercato.Supermercato;
import main.miftari.reparti.Etichetta;

public class Scaffalista extends Lavoratore{

	public Scaffalista(int stipendio) {
		super(stipendio);
	}

	public void lavora(Supermercato supermercato) {
		while(supermercato.isSimulazioneAttiva()) {
			// rimuovi tutti i prodotti scaduti dai reparti (non si applica ai vestiti visto che non hanno data di scadenza
			// -> prova a sfruttare un if che controlla se dataScadenza == null (in modo che si possa applicare non solo in caso di vestito come è il caso col codice qua sotto
			for(int i = 0; i < supermercato.getReparti().size(); i++) {
				if(supermercato.getReparti().get(i).getEtichetta() == Etichetta.REPARTO_NON_ALIMENTARE && ...)
				supermercato.getReparti().get(i).rimuoviProdottiScaduti(); // mettere metodo rimuovi... in RepartoImpl!!!
			}
			
			// prendi i prodotti specifici dal magazzino e portali nei reparti rispettivi
		}	
	}
}
