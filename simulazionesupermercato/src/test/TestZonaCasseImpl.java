package test;

import main.melle.zonacasse.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestZonaCasseImpl {

	@Test
	void testZonaCasseImpl() {
		int numeroCasse = 3;
		ZonaCasse zona = new ZonaCasseImpl(numeroCasse);
		assertEquals(numeroCasse, zona.getNCasse());
	}

}