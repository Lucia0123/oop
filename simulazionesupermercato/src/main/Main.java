package main;

import main.model.*;

import java.awt.EventQueue;

import main.controller.*;
import main.view.*;

public class Main {

	public static void main(String[] args) {
		// Crea model, view e controller
        Model model = new ModelImpl(4);
        View view = new ViewImpl();
        ControllerImpl controller = new ControllerImpl(model, view);

        // Collega il controller alla view
        view.setController(controller);
        
        view.setObserver(controller);

        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Mostra la GUI
			        view.mostraGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
