package main.melle.zonacarrelli;

import java.util.List;
import java.util.Stack;

public class ZonaCarrelliImpl implements ZonaCarrelli{

	private Stack<Carrello> carrelli;
	private static final int NUMEROTOTALECARRELLI = 100;
	private int nCarrelliLiberi;
	
	public ZonaCarrelliImpl() {
		this.carrelli = new Stack<>();
		for(int i = 0; i < NUMEROTOTALECARRELLI; i++) {
			this.carrelli.push(new CarrelloImpl());
		}
		this.nCarrelliLiberi = this.carrelli.size();
	}
	
	public int getNCarrelliTot() {
		return NUMEROTOTALECARRELLI;
	}

	public int getNCarrelliLiberi() {
		this.nCarrelliLiberi = this.carrelli.size();
		return this.nCarrelliLiberi;
	}
	
	public List<Carrello> getCarrelliLiberi(){
		return List.copyOf(this.carrelli);
	}
	
	public Carrello ritiraCarrello() {
		if(this.nCarrelliLiberi > 0) {
			Carrello carrelloRitirato = this.carrelli.pop();
			return carrelloRitirato;
		}
		return null;
	}

	public void restituisciCarrello(Carrello carrelloRestituito) {
		this.carrelli.push(carrelloRestituito);
	}

}
