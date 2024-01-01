package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.melle.zonacasse.RegistratoreDiCassa;
import main.melle.zonacasse.RegistrazionePagamento;
import main.miftari.prodotti.Colore;
import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.Taglia;
import main.miftari.prodotti.Tipo;
import main.miftari.prodotti.Vestito;

class TestRegistratoreDiCassa {

	@Test
	void testRegistraPagamento() {
		double prezzoDetersivo = 4.59;
		double prezzoVestito = 13.65;
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		List<Prodotto> lista = List.of(new Detersivo(prezzoDetersivo, LocalDate.now(), Tipo.PER_PIATTI), new Vestito(prezzoVestito, Taglia.S, Colore.ROSSO));
		double costoTotaleGiusto = prezzoDetersivo + prezzoVestito;
		double costoTotaleSbagliato = 20.80;
		assertTrue(registratore.registraPagamento(lista, costoTotaleGiusto));
		assertFalse(registratore.registraPagamento(lista, costoTotaleSbagliato));
	}

	@Test
	void testGetPagamentiEffettuati() {
		double prezzoDetersivo = 4.59;
		double prezzoVestito1 = 13.65;
		double prezzoVestito2 = 17.05;
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		List<Prodotto> lista1 = List.of(new Detersivo(prezzoDetersivo, LocalDate.now(), Tipo.PER_PIATTI), new Vestito(prezzoVestito1, Taglia.S, Colore.ROSSO));
		List<Prodotto> lista2 = List.of(new Vestito(prezzoVestito2, Taglia.S, Colore.ROSSO));
		double costoTotalePagamento1 = prezzoDetersivo + prezzoVestito1;
		double costoTotalePagamento2 = prezzoVestito2;
		registratore.registraPagamento(lista1, costoTotalePagamento1);
		registratore.registraPagamento(lista2, costoTotalePagamento2);
		// verifica per la lista dei prodotti venduti
		assertEquals(registratore.getPagamentiEffettuati().get(0).getProdottiVenduti(), lista1);
		assertEquals(registratore.getPagamentiEffettuati().get(1).getProdottiVenduti(), lista2);
		// verifica per il costo
		assertTrue(registratore.getPagamentiEffettuati().get(0).getCosto() - costoTotalePagamento1 < 0.05);
		assertTrue(registratore.getPagamentiEffettuati().get(1).getCosto() - costoTotalePagamento2 < 0.05);
		}
	

    @Test
	void testGetGuadagno() {
		double prezzoDetersivo = 4.59;
		double prezzoVestito = 13.65;
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		List<Prodotto> lista = List.of(new Detersivo(prezzoDetersivo, LocalDate.now(), Tipo.PER_PIATTI), new Vestito(prezzoVestito, Taglia.S, Colore.ROSSO));
		double costoTotalePagamento = prezzoDetersivo + prezzoVestito;
		double guadagnoInRegistratore = 0.0;
		assertTrue(registratore.getGuadagno() - guadagnoInRegistratore < 0.05);
		registratore.registraPagamento(lista, costoTotalePagamento);
		guadagnoInRegistratore = costoTotalePagamento;
		assertTrue(registratore.getGuadagno() - guadagnoInRegistratore < 0.05);
	}

	@Test
	void testPrelevaGuadagno() {
		double prezzoDetersivo = 4.59;
		double prezzoVestito = 13.65;
		RegistratoreDiCassa registratore = new RegistratoreDiCassa();
		List<Prodotto> lista = List.of(new Detersivo(prezzoDetersivo, LocalDate.now(), Tipo.PER_PIATTI), new Vestito(prezzoVestito, Taglia.S, Colore.ROSSO));
		double costoTotalePagamento = prezzoDetersivo + prezzoVestito;
		double guadagnoInRegistratore = 0.0;
		registratore.registraPagamento(lista, costoTotalePagamento);
		guadagnoInRegistratore = costoTotalePagamento;
		registratore.prelevaGuadagno();
		assertTrue(registratore.getGuadagno() - guadagnoInRegistratore < 0.05);
	}
}
