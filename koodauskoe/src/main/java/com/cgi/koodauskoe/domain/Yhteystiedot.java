package com.cgi.koodauskoe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Yhteystiedot {
    private String email;
    private int puhnmr;
}
