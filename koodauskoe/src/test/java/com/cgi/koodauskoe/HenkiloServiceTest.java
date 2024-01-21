package com.cgi.koodauskoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.cgi.koodauskoe.domain.Henkilo;
import com.cgi.koodauskoe.domain.Hetu;
import com.cgi.koodauskoe.domain.Osoite;
import com.cgi.koodauskoe.domain.Yhteystiedot;
import com.cgi.koodauskoe.web.HenkiloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HenkiloServiceTest {

    @Autowired
    private HenkiloService henkiloService;

    @Test
    public void testLisaaHenkilo() {
        Henkilo henkilo = new Henkilo();
        henkilo.setEtunimi("Testi");
        henkilo.setSukunimi("Henkilo");
        henkilo.setSyntymaaika("01.01.2000");
        henkilo.setHetu(new Hetu("1234-567X"));
        henkilo.setOsoite(new Osoite("Testikatu 1", 12345, "Testikaupunki"));
        henkilo.setYhteystiedot(new Yhteystiedot("testi@example.com", 123456789));

        henkiloService.lisaaHenkilo(henkilo);

        List<Henkilo> henkilot = henkiloService.tuoHenkilot();
        assertNotNull(henkilot);
        assertEquals(1, henkilot.size());

        Henkilo lisattyHenkilo = henkilot.get(0);
        assertNotNull(lisattyHenkilo.getId());
        assertEquals("Testi", lisattyHenkilo.getEtunimi());
        assertEquals("Henkilo", lisattyHenkilo.getSukunimi());
        assertEquals("01.01.2000", lisattyHenkilo.getSyntymaaika());
        assertEquals("1234-567X", lisattyHenkilo.getHetu().getHetu());

        assertNotNull(lisattyHenkilo.getOsoite());
        Osoite osoite = lisattyHenkilo.getOsoite();
        String expectedOsoiteString = "Testikatu 1 12345 Testikaupunki";
        String actualOsoiteString = String.format("%s %d %s", osoite.getKatuosoite(), osoite.getPostinumero(), osoite.getKaupunki());
        assertEquals(expectedOsoiteString, actualOsoiteString);

        assertNotNull(lisattyHenkilo.getYhteystiedot());
        assertEquals("testi@example.com", lisattyHenkilo.getYhteystiedot().getEmail());
        assertEquals(123456789, lisattyHenkilo.getYhteystiedot().getPuhnmr());
    }

    @Test
    public void testLuoHenkilo() {
        Henkilo henkilo = new Henkilo();
        henkilo.setEtunimi("Testi");
        henkilo.setSukunimi("Henkilo");
        henkilo.setSyntymaaika("01.01.2000");
        henkilo.setHetu(new Hetu("1234-567X"));
        henkilo.setOsoite(new Osoite("Testikatu 1", 12345, "Testikaupunki"));
        henkilo.setYhteystiedot(new Yhteystiedot("testi@example.com", 123456789));

        henkiloService.lisaaHenkilo(henkilo);

        List<Henkilo> henkilot = henkiloService.tuoHenkilot();
        assertNotNull(henkilot);
        assertEquals(1, henkilot.size());

        Henkilo lisattyHenkilo = henkilot.get(0);
        assertNotNull(lisattyHenkilo.getId());
        assertEquals("Testi", lisattyHenkilo.getEtunimi());
        assertEquals("Henkilo", lisattyHenkilo.getSukunimi());
        assertEquals("01.01.2000", lisattyHenkilo.getSyntymaaika());
        assertEquals("1234-567X", lisattyHenkilo.getHetu().getHetu());

        assertNotNull(lisattyHenkilo.getOsoite());
        Osoite osoite = lisattyHenkilo.getOsoite();
        String expectedOsoiteString = "Testikatu 1 12345 Testikaupunki";
        String actualOsoiteString = String.format("%s %d %s", osoite.getKatuosoite(), osoite.getPostinumero(), osoite.getKaupunki());
        assertEquals(expectedOsoiteString, actualOsoiteString);

        assertNotNull(lisattyHenkilo.getYhteystiedot());
        assertEquals("testi@example.com", lisattyHenkilo.getYhteystiedot().getEmail());
        assertEquals(123456789, lisattyHenkilo.getYhteystiedot().getPuhnmr());
    }
}