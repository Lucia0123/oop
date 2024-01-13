package main.miftari.uffici;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.miftari.fornitori.Fornitore;
import main.miftari.fornitori.FornitoreDiretto;
import main.miftari.magazzino.Magazzino;
import main.miftari.prodotti.Carne;
import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.Farina;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.Taglia;
import main.miftari.prodotti.TipoCarne;
import main.miftari.prodotti.TipoDetersivo;
import main.miftari.prodotti.TipoFarina;
import main.miftari.prodotti.Vestito;
import main.miftari.reparti.Reparto;

public class UfficioLogisticaImpl implements UfficioLogistica{
	
	public final int SOGLIA_MINIMA = 50; // quantità minima che deve essere presente nel supermercato per ogni tipo di prodotto
	public final int QUANTITA_STANDARD_ORDINATA = 200; //
	private List<Prodotto> inventario; // lista di tutti i prodotti contenuti nel supermercato
	private final Magazzino magazzino;
	private final List<Reparto> reparti;
	private Fornitore fornitore;
	
	public UfficioLogisticaImpl(final Magazzino magazzino, final List<Reparto> reparti) {
		this.inventario = new ArrayList<>();
		this.magazzino = magazzino;
		this.reparti = new ArrayList<>();
		this.fornitore = new FornitoreDiretto();
	}
	
	public List<Prodotto> aggiornaInventario() {
		inventario.clear();
		inventario.addAll(this.magazzino.aggiornaProdottiInTot());
		for(Reparto reparto : this.reparti) {
			inventario.addAll(reparto.getProdotti());
		}
		return this.inventario;
	}
	
	public void ordinaProdotti() {
		Carne carne = new Carne(2, LocalDate.now(), 3, TipoCarne.DI_AGNELLO);
		Farina farina = new Farina(2, LocalDate.now(), TipoFarina.DI_GLUTINE, 4);
		Detersivo detersivo = new Detersivo(2, LocalDate.now(), TipoDetersivo.PER_LAVATRICE);
		Vestito vestito = new Vestito(5, Taglia.L);
		
		// se si è raggiunti la soglia minima ordina prodotti dal fornitore
		if(this.contaCarne() < this.SOGLIA_MINIMA) {
			List<Prodotto> prodottiForniti = this.fornitore.fornisci(carne, QUANTITA_STANDARD_ORDINATA);
			// aggiungi ogni prodotto ordinato al magazzino
			for(Prodotto prodotto : prodottiForniti) {
				this.magazzino.aggiungi(prodotto);
			}
		}
		
		if(this.contaFarina() < this.SOGLIA_MINIMA) {
			List<Prodotto> prodottiForniti = this.fornitore.fornisci(farina, QUANTITA_STANDARD_ORDINATA);
			// aggiungi ogni prodotto ordinato al magazzino
			for(Prodotto prodotto : prodottiForniti) {
				this.magazzino.aggiungi(prodotto);
			}
		}
		
		if(this.contaDetersivo() < this.SOGLIA_MINIMA) {
			List<Prodotto> prodottiForniti = this.fornitore.fornisci(detersivo, QUANTITA_STANDARD_ORDINATA);
			// aggiungi ogni prodotto ordinato al magazzino
			for(Prodotto prodotto : prodottiForniti) {
				this.magazzino.aggiungi(prodotto);
			}
		}
		
		if(this.contaVestito() < this.SOGLIA_MINIMA) {
			List<Prodotto> prodottiForniti = this.fornitore.fornisci(vestito, QUANTITA_STANDARD_ORDINATA);
			// aggiungi ogni prodotto ordinato al magazzino
			for(Prodotto prodotto : prodottiForniti) {
				this.magazzino.aggiungi(prodotto);
			}
		}
	}
	
	private int contaCarne() {
		int n = 0;
		for(Prodotto prodotto : this.aggiornaInventario()) {
			if(prodotto instanceof Carne) {
				n++;
			}
		}
		return n;
	}
	
	private int contaFarina() {
		int n = 0;
		for(Prodotto prodotto : this.aggiornaInventario()) {
			if(prodotto instanceof Farina) {
				n++;
			}
		}
		return n;
	}
	
	private int contaDetersivo() {
		int n = 0;
		for(Prodotto prodotto : this.aggiornaInventario()) {
			if(prodotto instanceof Detersivo) {
				n++;
			}
		}
		return n;
	}
	
	private int contaVestito() {
		int n = 0;
		for(Prodotto prodotto : this.aggiornaInventario()) {
			if(prodotto instanceof Vestito) {
				n++;
			}
		}
		return n;
	}
}



