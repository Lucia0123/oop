package main.melle.zonacasse;

import main.melle.clienti.Cliente;

public interface ZonaCasse {

	int getNCasse();
	
	boolean setNCasse(int nuovoNumero);
		
	void aggiungiAllaCodaPiuBreve(Cliente c);
	
	void togliDallaCoda(Cliente c, Cassa cassa);
}
