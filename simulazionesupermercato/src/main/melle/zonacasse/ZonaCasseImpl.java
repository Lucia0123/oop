package main.melle.zonacasse;

import java.util.List;

public class ZonaCasseImpl implements ZonaCasse{

	private List<Cassa> casse;
	private final int numeroCasse;
	
	public ZonaCasseImpl(final int numeroCasse) {
		this.numeroCasse = numeroCasse;
		for(int n = 0; n <= this.numeroCasse; n++) {
			Cassa nuova = new Cassa();
			this.casse.add(nuova);
		}
	}
	public int getNCasse() {
		return numeroCasse;
	}

	public int getLunghezzaCoda(Cassa cassa) {
		return cassa.getNClientiInCoda();
	}

	public Cassa getCassaConCodaPiuBreve() {
		Cassa CassaMigliore = this.casse.get(0);
		for(Cassa cassa : this.casse) {
			if(cassa.getNClientiInCoda() < CassaMigliore.getNClientiInCoda())
				CassaMigliore = cassa;
		}
		return CassaMigliore;
	}
	
}
