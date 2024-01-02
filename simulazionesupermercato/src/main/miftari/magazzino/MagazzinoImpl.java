package main.miftari.magazzino;

import java.util.ArrayList;
import java.util.List;

import main.miftari.prodotti.Carne;
import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.Farina;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.Vestito;

public class MagazzinoImpl implements Magazzino{

	private List<Carne> carni;
	private List<Farina> farine;
	private List<Detersivo> detersivi;
	private List<Vestito> vestiti;
	
	public MagazzinoImpl() {
		carni = new ArrayList<>();
		farine = new ArrayList<>();
		detersivi = new ArrayList<>();
	}
	
	public void aggiungi(List<Prodotto> daAggiungere) {
		// TODO Auto-generated method stub
		
	}

	public List<Prodotto> preleva(List<Prodotto> daPrelevare) {
		// TODO Auto-generated method stub
		return null;
	}

	// controllo della data di scadenza dei prodotti
	private void controlla(List<Prodotto> daControllare) {
		
	}
	
	// smistamento dei prodotti nelle diverse categorie
	private void smista(List<Prodotto> daSmistare) {
		
	}

}
