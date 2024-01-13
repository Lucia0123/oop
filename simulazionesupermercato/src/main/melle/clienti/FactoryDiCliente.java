package main.melle.clienti;

import main.melle.zonacarrelli.CarrelloImpl;
import main.melle.zonacarrelli.ZonaCarrelli;

// generatore di clienti
public class FactoryDiCliente {
	
	private ZonaCarrelli zona;
	private static FactoryDiCliente factory = null;
	
	private FactoryDiCliente(ZonaCarrelli zona) {
		this.zona = zona;
	}
	
	public static FactoryDiCliente getInstance(ZonaCarrelli zona) {
		if(factory == null) {
			factory = new FactoryDiCliente(zona);
		}
			return factory;
		
	}

	public Cliente creaClienteConCarrello() {
		Cliente creato = null;
		if(zona.getNCarrelliLiberi() > 0){
			creato = new Cliente(new CarrelloImpl());
			return creato;
		}
		return creato;
	}
	
	public Cliente creaClienteSenzaCarrello() {
		return new Cliente();
	}
}
