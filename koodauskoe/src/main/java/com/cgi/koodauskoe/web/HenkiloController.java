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

    @PostMapping
    public void luoHenkilo(@RequestBody Henkilo henkilo) {
        henkiloService.lisaaHenkilo(henkilo);
    }

    @GetMapping
    public List<Henkilo> tuoHenkilot() {
        return henkiloService.tuoHenkilot();
    }

    @GetMapping("/{id}")
    public Henkilo tuoHenkiloById(@PathVariable Long id) {
        return henkiloService.tuoHenkiloById(id);
    }
}
