package com.cgi.koodauskoe.web;

import com.cgi.koodauskoe.domain.Henkilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/henkilot")
public class HenkiloController {

    @Autowired
    private HenkiloService henkiloService;

    // Henkilön lisäys
    @PostMapping
    public void luoHenkilo(@RequestBody Henkilo henkilo) {
        henkiloService.lisaaHenkilo(henkilo);
    }

    // Henkilön poisto
    @DeleteMapping("/{id}")
    public void poistaHenkilo(@PathVariable Long id) {
        henkiloService.poistaHenkilo(id);
    }

    // Listaus
    @GetMapping
    public List<Henkilo> tuoHenkilot() {
        return henkiloService.tuoHenkilot();
    }

    // Haetaan id:n perusteella
    @GetMapping("/{id}")
    public Henkilo tuoHenkiloById(@PathVariable Long id) {
        return henkiloService.tuoHenkiloById(id);
    }
}
