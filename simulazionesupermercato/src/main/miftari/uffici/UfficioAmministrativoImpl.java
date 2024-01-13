package main.miftari.uffici;

import java.util.List;

import main.melle.lavoratori.Lavoratore;
import main.melle.zonacasse.Cassa;
import main.melle.zonacasse.ZonaCasse;

public class UfficioAmministrativoImpl implements UfficioAmministrativo{

	private double entrate;
	private double uscite;
	private double bilancio;
	private ZonaCasse zonaCasse;
	private final List<Lavoratore> lavoratori;
	
	public UfficioAmministrativoImpl(ZonaCasse zonaCasse, final List<Lavoratore> lavoratori) {
		this.entrate = 0;
		this.uscite = 0;
		this.bilancio = 0;
		this.zonaCasse = zonaCasse;
		this.lavoratori = lavoratori;
	}

	@Override
	public double aggiornaEntrate() {
		this.entrate = 0;
		for(Cassa cassa : this.zonaCasse.getCasse()) {
			this.entrate += cassa.getRegistratoreDiCassa().getGuadagno();
		}
		return this.entrate;
	}

	@Override
	public double aggiornaUscite() {
		for(Lavoratore lavoratore : this.lavoratori) {
			this.uscite += lavoratore.getStipendio();
		}
		return this.uscite;
	}

	@Override
	public double getBilancio() {
		this.bilancio = this.aggiornaEntrate() - this.aggiornaUscite();
		return this.bilancio;
	}

}
