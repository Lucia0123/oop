package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.melle.zonacasse.RegistratoreDiCassa;
import main.miftari.prodotti.FactoryDiProdotto;
import main.miftari.prodotti.TipoFarina;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.Taglia;
import main.miftari.prodotti.TipoDetersivo;
import main.miftari.prodotti.TipoCarne;

class TestRegistratoreDiCassa {

	@Test
	void testRegistraPagamento() {
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		var factory = new FactoryDiProdotto();
		List<Prodotto> lista = List.of(factory.creaVestito(Taglia.M), factory.creaCarne(TipoCarne.DI_AGNELLO));
		double costoTotaleGiusto = lista.get(0).getPrezzo() + lista.get(1).getPrezzo();
		double costoTotaleSbagliato = 20.80;
		assertTrue(registratore.registraPagamento(lista, costoTotaleGiusto));
		assertFalse(registratore.registraPagamento(lista, costoTotaleSbagliato));
	}

	@Test
	void testGetPagamentiEffettuati() {
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		var factory = new FactoryDiProdotto();
		List<Prodotto> lista1 = List.of(factory.creaDetersivo(TipoDetersivo.PER_PIATTI), factory.creaVestito(Taglia.L));
		List<Prodotto> lista2 = List.of(factory.creaVestito(Taglia.L));
		double costoTotalePagamento1 = lista1.get(0).getPrezzo() + lista1.get(1).getPrezzo();
		double costoTotalePagamento2 = lista2.get(0).getPrezzo();
		registratore.registraPagamento(lista1, costoTotalePagamento1);
		registratore.registraPagamento(lista2, costoTotalePagamento2);
		// verifica per la lista dei prodotti venduti
		assertEquals(registratore.getPagamentiEffettuati().get(0).getProdottiVenduti(), lista1);
		assertEquals(registratore.getPagamentiEffettuati().get(1).getProdottiVenduti(), lista2);
		// verifica per il costo
		assertEquals(registratore.getPagamentiEffettuati().get(0).getCosto(), costoTotalePagamento1, 0.001);
		assertEquals(registratore.getPagamentiEffettuati().get(1).getCosto(), costoTotalePagamento2, 0.001);
		}
	

    @Test
	void testGetGuadagno() {
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		var factory = new FactoryDiProdotto();
		List<Prodotto> lista = List.of(factory.creaDetersivo(TipoDetersivo.PER_LAVATRICE), factory.creaFarina(TipoFarina.INTEGRALE));
		double costoTotalePagamento = lista.get(0).getPrezzo() + lista.get(1).getPrezzo();
		double guadagnoInRegistratore = 0.0;
		assertEquals(registratore.getGuadagno(), guadagnoInRegistratore, 0.001);
		registratore.registraPagamento(lista, costoTotalePagamento);
		guadagnoInRegistratore = costoTotalePagamento;
		assertEquals(registratore.getGuadagno(), guadagnoInRegistratore, 0.001);
	}

	@Test
	void testPrelevaGuadagno() {
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		var factory = new FactoryDiProdotto();
		List<Prodotto> lista = List.of(factory.creaDetersivo(TipoDetersivo.PER_LAVATRICE), factory.creaFarina(TipoFarina.TIPO_0));
		double costoTotalePagamento = lista.get(0).getPrezzo() + lista.get(1).getPrezzo();
		registratore.registraPagamento(lista, costoTotalePagamento);
		registratore.prelevaGuadagno();
		double guadagnoInRegistratore = 0.0;
		assertEquals(registratore.getGuadagno(), guadagnoInRegistratore, 0.001);
	}
}

