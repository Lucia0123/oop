package main.melle.clienti;

import main.melle.supermercato.Supermercato;
import main.melle.zonacarrelli.ZonaCarrelli;

// generatore/gestore dei clienti
public class GestioneClienti {

	private int nTotClienti; // numero totale di clienti nel supermercato
	private final ZonaCarrelli zona;
	
	public GestioneClienti(final ZonaCarrelli zona) {
		this.nTotClienti = 0;
		this.zona = zona;
	}
	
	public int getNTotClienti() {
		return this.nTotClienti;
	}
	
	public void generaClienti(Supermercato supermercato) {
			Cliente clienteConCarrello = FactoryDiCliente.getInstance(zona).creaClienteConCarrello();
			this.nTotClienti++;
			clienteConCarrello.faiSpesa(supermercato);
			this.nTotClienti--;
			Cliente clienteSenzaCarrello = FactoryDiCliente.getInstance(zona).creaClienteSenzaCarrello();
			this.nTotClienti++;
			clienteSenzaCarrello.faiSpesa(supermercato);
			this.nTotClienti--;
	}	
}