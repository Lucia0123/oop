package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.melle.zonacasse.RegistrazionePagamento;
import main.miftari.prodotti.FactoryDiProdotto;
import main.miftari.prodotti.TipoFarina;
import main.miftari.prodotti.Prodotto;
import main.miftari.prodotti.TipoDetersivo;
import main.miftari.prodotti.TipoCarne;

class TestRegistrazionePagamento {

	@Test
	void testGetProdottiVenduti() {
		FactoryDiProdotto factory = new FactoryDiProdotto();
		List<Prodotto> p = List.of(factory.creaCarne(TipoCarne.DI_POLLO), factory.creaFarina(TipoFarina.DI_GLUTINE));
		double costoDaRegistrare = p.get(0).getPrezzo() + p.get(1).getPrezzo();
		RegistrazionePagamento pagamento = new RegistrazionePagamento(p, costoDaRegistrare);
		assertArrayEquals(pagamento.getProdottiVenduti().toArray(), p.toArray());
	}

	@Test
	void testGetCosto() {
		FactoryDiProdotto factory = new FactoryDiProdotto();
		List<Prodotto> p = List.of(factory.creaDetersivo(TipoDetersivo.PER_PIATTI), factory.creaFarina(TipoFarina.INTEGRALE));
		double costoDaRegistrare = p.get(0).getPrezzo() + p.get(1).getPrezzo();
		RegistrazionePagamento pagamento = new RegistrazionePagamento(p, costoDaRegistrare);
		assertEquals(pagamento.getCosto(), costoDaRegistrare, 0.001);
	}

}
