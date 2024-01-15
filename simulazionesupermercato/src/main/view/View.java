package main.view;

import java.time.LocalDate;
import java.util.List;

import main.controller.Controller;
import main.miftari.prodotti.Prodotto;

public interface View {

	void setObserver(ViewObserver observer);
	
	Controller getController();
	
	void setController(Controller controller);
	
	void mostraGUI();
	
	int getDurata();
	
	void durataSbagliata();
	
	void aggiornaData(LocalDate data);
	
	void aggiornaBilancio(double bilancio);
	
	void aggiornaInventario(List<Prodotto> inventario);
	
	void aggiornaNLavoratori(int n);
	
	void aggiornaNTotClienti(int n);
	
	void aggiornaNCarrelliLiberi(int n);
	
	void aggiornaNCarrelliOccupati(int n);
}
