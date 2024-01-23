package com.cgi.koodauskoe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Henkilo {
    private Long id;
    private String etunimi;
    private String sukunimi;
    private String syntymaaika;
    private Hetu hetu;
    private String katuosoite;
    private String postinumero;
    private String kaupunki;
    private String email;
    private String puhnmr;

    /*
    Näin tämä siis oli minulla alkuun ja ensin ajattelin että saisin näin haettua kaikki tiedot Yhteistietojen alla
    Kun ei toiminut koitin muokata tätä parilla eri tavalla, mm. lisäämällä Osoite-luokkaan yhden
    osoite-arvon joka yhdistäisi kaikki muut osoitetiedot yhdeksi pitkäksi kokonaiseksi osoitteeksi.

    Kun tarkistelen /api/henkilot henkilot-listassa yhteistiedot ja osoite ovat nulleja

    Tällä tavalla koodi kuitenkin tallentaa ja hakee Hetu-luokan kanssa toimivasti
    private Osoite osoite;
    private Yhteystiedot yhteystiedot;
      */



}