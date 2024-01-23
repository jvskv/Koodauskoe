package com.cgi.koodauskoe.web;

import com.cgi.koodauskoe.domain.Henkilo;
import com.cgi.koodauskoe.domain.Osoite;
import com.cgi.koodauskoe.domain.Yhteystiedot;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HenkiloService {

    private final Map<Long, Henkilo> henkilot = new HashMap<>();
    private Long currentId = 1L;

    public void lisaaHenkilo(Henkilo henkilo) {
        Long id = currentId++;
        henkilo.setId(id);
        henkilot.put(id, henkilo);
    }

    public void poistaHenkilo(Long id) {
        henkilot.remove(id);
    }

    public List<Henkilo> tuoHenkilot() {
        return new ArrayList<>(henkilot.values());
    }

    public Henkilo tuoHenkiloById(Long id) {
        return henkilot.get(id);
    }
}