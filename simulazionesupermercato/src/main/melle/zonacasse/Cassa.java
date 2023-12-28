package main.melle.zonacasse;

import java.util.LinkedList;
import java.util.Queue;

import main.melle.clienti.Cliente;

public class Cassa {

	private int ID = 0;
	private final RegistratoreDiCassa registratore;
	private Queue<Cliente> coda;
	private int nClientiInCoda;
	
	public Cassa() {
		ID += 1;
		this.registratore = new RegistratoreDiCassa();
		this.coda = new LinkedList<>();
		nClientiInCoda = 0;
		
	}
	
	public int getID() {
		return this.ID;
	}
	
	public RegistratoreDiCassa getRegistratoreDiCassa() {
		return this.registratore;
	}
	
	public void aggiungiAllaCoda(Cliente cliente) {
		this.coda.add(cliente);
	}
	
	public void togliDallaCoda(Cliente daTogliere) {
		this.coda.remove();
	}
	
	public int getNClientiInCoda() {
		return this.nClientiInCoda;
	}
	
	public Cliente getClienteDaServire() {
		if(!(this.coda.isEmpty())) {
			Cliente daServire = this.coda.element();
			return daServire;
		}
		return null;
	}
	
}
