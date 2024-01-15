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
					System.out.println(1);
					// Mostra la GUI
			        view.mostraGUI();
			        System.out.println(2);
				} catch (Exception e) {
					System.out.println(".");
					e.printStackTrace();
				}
			}
		});
	}
}
