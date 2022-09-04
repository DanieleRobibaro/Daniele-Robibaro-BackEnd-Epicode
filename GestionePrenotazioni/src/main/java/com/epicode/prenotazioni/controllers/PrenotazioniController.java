package com.epicode.prenotazioni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.prenotazioni.model.Prenotazioni;
import com.epicode.prenotazioni.services.PrenotazioniService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@Autowired
	PrenotazioniService prenotazioniService;

	@PostMapping("/crea")
	public void creaPrenotazione(@RequestBody Prenotazioni prenotazione) {

		prenotazioniService.creaPrenotazioni(prenotazione);
	}

	@GetMapping
	public List<Prenotazioni> trovaTuttePrenotazioni() {
		return prenotazioniService.trovaTuttePrenotazioni();
	}

	@GetMapping("/{id}")
	public Prenotazioni trovaPrenotazioniPerId(@PathVariable Long id) {
		return prenotazioniService.trovaPrenotazionePerId(id);
	}

	@GetMapping("/test")
	public List<Prenotazioni> trovaPrenotazionePerIdUtente(@RequestParam Long id) {
		return prenotazioniService.trovaPrenotazionePerIdUtente(id);
	}
}
