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
    private Osoite osoite;
    private Yhteystiedot yhteystiedot;

}