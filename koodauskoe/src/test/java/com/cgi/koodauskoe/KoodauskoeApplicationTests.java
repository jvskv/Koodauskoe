package com.cgi.koodauskoe;

import com.cgi.koodauskoe.domain.Henkilo;
import com.cgi.koodauskoe.domain.Hetu;
import com.cgi.koodauskoe.web.HenkiloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KoodauskoeApplicationTests {

	@Autowired
	private HenkiloService henkiloService;

	@Test
	public void testLisaaHenkilo() {

		// Luodaan henkilö
		Henkilo henkilo = new Henkilo();
		henkilo.setEtunimi("Testi");
		henkilo.setSukunimi("Henkilo");
		henkilo.setSyntymaaika("01.01.2000");
		henkilo.setHetu(new Hetu("1234-567X"));
		henkilo.setKatuosoite("Testikatu 1");
		henkilo.setPostinumero("12345");
		henkilo.setKaupunki("Helsinki");
		henkilo.setEmail("testi@esim.com");
		henkilo.setPuhnmr("123456789");
		henkiloService.lisaaHenkilo(henkilo);

		// Tarkistetaan, että henkilö listassa
		List<Henkilo> henkilot = henkiloService.tuoHenkilot();
		assertNotNull(henkilot);
		assertThat(henkilot.size(), greaterThan(0));


		// Haetaan henkilö ja varmistetaan, tiedot ovat oikein
		Henkilo lisattyHenkilo = henkilot.get(0);
		assertNotNull(lisattyHenkilo.getId());
		assertEquals("Testi", lisattyHenkilo.getEtunimi());
		assertEquals("Henkilo", lisattyHenkilo.getSukunimi());
		assertEquals("01.01.2000", lisattyHenkilo.getSyntymaaika());
		assertEquals("1234-567X", lisattyHenkilo.getHetu().getHetu());
		assertEquals("Testikatu 1", lisattyHenkilo.getKatuosoite());
		assertEquals("12345", lisattyHenkilo.getPostinumero());
		assertEquals("Helsinki", lisattyHenkilo.getKaupunki());
		assertEquals("testi@esim.com", lisattyHenkilo.getEmail());
		assertEquals("123456789", lisattyHenkilo.getPuhnmr());
	}

	@Test
	void testPoistaHenkilo() {

		// Lisätään henkilö
		Henkilo testiHenkilo = new Henkilo();
		henkiloService.lisaaHenkilo(testiHenkilo);

		// Poistetaan henkilö
		henkiloService.poistaHenkilo(testiHenkilo.getId());

		// Varmistetaan, että henkilö on poistettu
		assertEquals(0, henkiloService.tuoHenkilot().size());
	}
}

