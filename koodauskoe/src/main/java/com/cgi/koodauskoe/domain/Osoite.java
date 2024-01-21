package com.cgi.koodauskoe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Osoite {
    private String katuosoite;
    private int postinumero;
    private String kaupunki;
}
