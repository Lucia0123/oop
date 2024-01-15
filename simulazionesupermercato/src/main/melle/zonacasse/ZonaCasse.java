package main.melle.zonacasse;

import java.util.List;

import main.melle.clienti.Cliente;

public interface ZonaCasse {

	int getNCasse();
	
	void aggiungiCassa();
	
	List<Cassa> getCasse();
	
	boolean setNCasse(int nuovoNumero);
		
	void aggiungiAllaCodaPiuBreve(Cliente c);
	
	void togliDallaCoda(Cliente c, Cassa cassa);
	
	Cassa getCassaConCodaPiuBreve();
}
