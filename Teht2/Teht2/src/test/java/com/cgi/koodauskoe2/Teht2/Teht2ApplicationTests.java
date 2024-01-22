package com.cgi.koodauskoe2.Teht2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Teht2ApplicationTests {


	// Testataan yleinen toiminto
	@Test
	public void testTeht2() {
		int [] taulukko = {1, 4, 10};
		assertEquals(2, Teht2Application.pieninVali(taulukko));
	}


	// Testataan toimiiko jos kaksi samaa numeroa
	@Test
	public void testTeht2_2() {
		int[] toinenTaulukko = {3, 3, 5};
		assertEquals(1, Teht2Application.pieninVali(toinenTaulukko));
	}


	// Testataan toimiiko ilman, että numerojärjestys on kasvava
	@Test
	public void testTeht2_3() {
		int[] toinenTaulukko = {8, 2, 14};
		assertEquals(1, Teht2Application.pieninVali(toinenTaulukko));
	}
}

