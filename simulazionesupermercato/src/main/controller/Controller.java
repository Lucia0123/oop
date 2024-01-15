package main.controller;

import main.model.Model;
import main.view.View;

public interface Controller{

	void setView(View view);
	
	View getView();
	
	void setModel(Model model);
	
	Model getModel();
	
	void setDurata(int durata);
	
	void simula();
	
	int getDurataMassimaSimulazione();
	
	int getDurataMinimaSimulazione();
}
