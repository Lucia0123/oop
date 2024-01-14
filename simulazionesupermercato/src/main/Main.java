package main;

import main.model.*;
import main.controller.*;
import main.view.*;

public class Main {

	public static void main(String[] args) {
		// Crea model, view e controller
        Model model = new ModelImpl(4);
        View view = new ViewImpl();
        Controller controller = new ControllerImpl(model, view);

        // Collega il controller alla view
        view.setController(controller);

        // Mostra la GUI
        view.creaEMostraGUI();
	}
}
