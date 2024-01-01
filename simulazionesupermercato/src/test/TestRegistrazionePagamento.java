package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.melle.zonacasse.RegistrazionePagamento;
import main.miftari.prodotti.Detersivo;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.Taglia;
import main.miftari.prodotti.Tipo;
import main.miftari.prodotti.Vestito;

class TestRegistrazionePagamento {

	@Test
	void testGetProdottiVenduti() {
		double prezzoDetersivo = 9.49;
		double prezzoVestito = 20.30;
		LocalDate dataScad = LocalDate.now();
		Tipo tipoDetersivo = Tipo.PER_PIATTI;
		Taglia taglia = Taglia.L;
		double costoDaRegistrare = prezzoDetersivo + prezzoVestito;
		
		List<Prodotto> p = List.of(new Detersivo(prezzoDetersivo, dataScad, tipoDetersivo), new Vestito(prezzoVestito, taglia));
		RegistrazionePagamento pagamento = new RegistrazionePagamento(p, costoDaRegistrare);
		assertArrayEquals(pagamento.getProdottiVenduti().toArray(), p.toArray());
	}

	@Test
	void testGetCosto() {
		double prezzoDetersivo = 9.49;
		double prezzoVestito = 20.30;
		LocalDate dataScad = LocalDate.now();
		Tipo tipoDetersivo = Tipo.PER_PIATTI;
		Taglia taglia = Taglia.L;
		double costoDaRegistrare = prezzoDetersivo + prezzoVestito;
		
		List<Prodotto> p = List.of(new Detersivo(prezzoDetersivo, dataScad, tipoDetersivo), new Vestito(prezzoVestito, taglia));
		RegistrazionePagamento pagamento = new RegistrazionePagamento(p, costoDaRegistrare);
		assertEquals(pagamento.getCosto(), costoDaRegistrare, 0.001);
	}

}
