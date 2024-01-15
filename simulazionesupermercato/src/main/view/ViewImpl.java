package main.view;

import java.time.LocalDate;
import java.util.List;

import main.controller.Controller;
import main.miftari.prodotti.Prodotto;

public class ViewImpl implements SwingView{

	private Controller controller;
    private SupermercatoFrame frame;
    private ViewObserver observer;

    public ViewImpl() {
        this.controller = null;
    }

    public void setObserver(ViewObserver observer) {
    	this.observer = observer;
    }

    public Controller getController() {
        return this.frame.getController();
    }

    public void setController(Controller controller) {
    	this.controller = controller;
    }

    public void mostraGUI() {
    	frame = new SupermercatoFrame(controller, this.observer);
		frame.setVisible(true);
    }
    
    public int getDurata() {
    	return frame.getDurataInserita();
    }
    
    // metodi per aggiornare la view con i nuovi dati
    public void aggiornaData(LocalDate data) {
    	frame.aggiornaData(data);
    }

	public void aggiornaBilancio(double bilancio) {
		frame.aggiornaBilancio(bilancio);
	}

	public void aggiornaInventario(List<Prodotto> inventario) {
		frame.aggiornaInventario(inventario);
	}

	public void aggiornaNLavoratori(int n) {
		frame.aggiornaNLavoratori(n);
	}

	public void aggiornaNTotClienti(int n) {
		frame.aggiornaNTotClienti(n);
	}

	public void aggiornaNCarrelliLiberi(int n) {
		frame.aggiornaNCarrelliLiberi(n);
	}

	public void aggiornaNCarrelliOccupati(int n) {
		frame.aggiornaNCarrelliOccupati(n);
	}
}
