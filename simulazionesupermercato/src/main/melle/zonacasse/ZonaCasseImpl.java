package main.melle.zonacasse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.melle.clienti.Cliente;

public class ZonaCasseImpl implements ZonaCasse{

	public static final int NUMERO_MINIMO_CASSE = 1;
	public static final int NUMERO_MASSIMO_CASSE = 20;
	private List<Cassa> casse;
	private int numeroCasse;
	
	public ZonaCasseImpl(final int numeroCasse) {
		this.casse = new ArrayList<>();
		this.numeroCasse = numeroCasse;
		for(int n = 0; n < this.numeroCasse; n++) {
			Cassa nuova = new Cassa();
			this.casse.add(nuova);
		}
	}
	
	public int getNCasse() {
		return numeroCasse;
	}
	
	// metodo per aggiungere una cassa alla zona delle casse se non si è raggiunto il numero massimo prestabilito
	public void aggiungiCassa() {
		if(this.numeroCasse < NUMERO_MASSIMO_CASSE) {
			this.casse.add(new Cassa());
		}
	}
	
	public List<Cassa> getCasse(){
		return List.copyOf(this.casse);
	}
	
	public boolean setNCasse(int nuovoNumero) {
		if(nuovoNumero >= NUMERO_MINIMO_CASSE && nuovoNumero <= NUMERO_MASSIMO_CASSE) {
			if(this.numeroCasse < nuovoNumero) {
				for(int i = this.numeroCasse, j = nuovoNumero; i < j; i++) {
					// alla creazione le casse in più aggiunte hanno code vuote
					this.casse.add(new Cassa());
				}
				this.numeroCasse = nuovoNumero;
				return true;
			}
			else {
				if(this.numeroCasse > nuovoNumero) {
					// rimozione delle casse "di troppo" trasferendo i clienti che erano là nelle casse rimanenti
					Queue <Cliente> daSpostare = new LinkedList<>();
					for(int i = 0; i < (numeroCasse - nuovoNumero); i++) {
						daSpostare = this.casse.get(i).getClientiInCoda();
						casse.remove(i);
						for(Cliente cliente : daSpostare) {
							this.aggiungiAllaCodaPiuBreve(cliente);
						}
						daSpostare.clear();
					}
					this.numeroCasse = nuovoNumero;
					return true;
				}
			}
		}
		// se numeroCasse == nuovoNumero non c'è nessun cambiamento da applicare
		return false;
	}

	// metodo per aggiungere un cliente alla coda piu breve nella ZonaCasseImpl (restituisce true se andato a buon fine)
	public void aggiungiAllaCodaPiuBreve(Cliente c) {
		if(c != null && this.cercaCliente(c) == null) {
			this.getCassaConCodaPiuBreve().aggiungiAllaCoda(c);
		}
	}
	
	public void togliDallaCoda(Cliente c, Cassa cassa) {
		if(this.cercaCliente(c) != null) {
			this.cercaCliente(c).togliDallaCoda(c);
		}
	}

	public Cassa getCassaConCodaPiuBreve() {
		Cassa CassaMigliore = this.casse.get(0);
		for(Cassa cassa : this.casse) {
			if(cassa.getNClientiInCoda() < CassaMigliore.getNClientiInCoda())
				CassaMigliore = cassa;
		}
		final Cassa CassaConCodaPiuBreve = CassaMigliore;
		return CassaConCodaPiuBreve;
	}
	
	// verifica se il cliente è già presente in una delle casse di ZonaCasseImpl e restituisce la cassa in cui si trova
	private Cassa cercaCliente(Cliente c) {
		if(c != null) {
			for(Cassa cassa : this.casse) {
				if(cassa.cercaCliente(c) != null)
					return cassa;
			}
		}
		return null;
	}
}
