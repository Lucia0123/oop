package main.melle.zonacasse;

import java.util.LinkedList;
import java.util.Queue;

import main.melle.clienti.Cliente;

public class Cassa {

	private int ID;
	private static int prossimoID = 1;
	private final RegistratoreDiCassa registratore;
	private Queue<Cliente> coda;
	private int nClientiInCoda;
	
	public Cassa() {
		ID = prossimoID++;
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
		if(cliente != null && (!coda.contains(cliente))) {
			this.coda.add(cliente);
		}
	}
	
	public void togliDallaCoda(Cliente daTogliere) {
		if(!(this.coda.isEmpty()) && daTogliere != null && daTogliere == this.getClienteDaServire()) { // si può togliere solo il cliente in testa alla coda
			this.coda.remove();
		}
	}
	
	public int getNClientiInCoda() {
		this.nClientiInCoda = coda.size();
		return this.nClientiInCoda;
	}
	
	public Cliente getClienteDaServire() {
		return this.coda.peek();
	}
	
}
