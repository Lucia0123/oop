package main.melle.clienti;

import java.util.Optional;

import main.melle.zonacarrelli.Carrello;

public class Cliente {

	private Optional<Carrello> carrello;
	private int capacita;
	private static final int CAPACITASENZACARRELLO = 5;
	
	// costruttore per clienti senza carrello
	public Cliente() {
		carrello = Optional.empty();
		capacita = CAPACITASENZACARRELLO;
	}
	
	// costruttore per clienti con carrello
	public Cliente(Carrello c) {
		carrello = Optional.of(c);
		capacita = c.getCapacitaMax();
	}
	
	public Optional<Carrello> getCarrello(){
		return carrello;
	}
	
	public int getCapacita() {
		return capacita;
	}
	
	public void faiSpesa() {
		
	}
}
