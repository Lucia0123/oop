package main.melle.zonacarrelli;

public interface ZonaCarrelli{

	int getNCarrelliTot();
	
	int getNCarrelliLiberi();
	
	Carrello ritiraCarrello();
	
	void restituisciCarrello(Carrello carrelloRestituito);
}
