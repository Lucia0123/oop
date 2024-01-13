package main.miftari.uffici;

import java.util.List;

import main.melle.lavoratori.Lavoratore;
import main.melle.zonacasse.Cassa;
import main.melle.zonacasse.ZonaCasse;

public class UfficioAmministrativoImpl implements UfficioAmministrativo{

	private double entrate;
	private double uscite;
	private double bilancio;
	
	public UfficioAmministrativoImpl() {
		this.entrate = 0;
		this.uscite = 0;
		this.bilancio = this.entrate - this.uscite;
	}

	@Override
	public double aggiornaEntrate(ZonaCasse zonaCasse) {
		for(Cassa cassa : zonaCasse.getCasse()) {
			this.entrate += cassa.getRegistratoreDiCassa().getGuadagno();
		}
		return this.entrate;
	}

	@Override
	public double aggiornaUscite(List<Lavoratore> lavoratori) {
		for(Lavoratore lavoratore : lavoratori) {
			this.uscite += lavoratore.getStipendio();
		}
		return this.uscite;
	}

	@Override
	public double getBilancio() {
		return this.bilancio;
	}

}
