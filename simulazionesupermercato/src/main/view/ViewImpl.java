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
    
    @Override
    public void setObserver(ViewObserver observer) {
    	this.observer = observer;
    }
    
    @Override
    public Controller getController() {
        return this.frame.getController();
    }

    @Override
    public void setController(Controller controller) {
    	this.controller = controller;
    }

    @Override
    public void mostraGUI() {
    	frame = new SupermercatoFrame(controller, this.observer);
		frame.setVisible(true);
    }
    
    @Override
    public int getDurata() {
    	return frame.getDurataInserita();
    }
    
    @Override
    public void durataSbagliata() {
    	frame.durataSbagliata();
    }
    
    // metodi per aggiornare la view con i nuovi dati
    @Override
    public void aggiornaData(LocalDate data) {
    	frame.aggiornaData(data);
    }

	@Override
	public void aggiornaBilancio(double bilancio) {
		frame.aggiornaBilancio(bilancio);
	}

	@Override
	public void aggiornaInventario(List<Prodotto> inventario) {
		frame.aggiornaInventario(inventario);
	}

	@Override
	public void aggiornaNLavoratori(int n) {
		frame.aggiornaNLavoratori(n);
	}

	@Override
	public void aggiornaNTotClienti(int n) {
		frame.aggiornaNTotClienti(n);
	}

	@Override
	public void aggiornaNCarrelliLiberi(int n) {
		frame.aggiornaNCarrelliLiberi(n);
	}

	@Override
	public void aggiornaNCarrelliOccupati(int n) {
		frame.aggiornaNCarrelliOccupati(n);
	}
}
