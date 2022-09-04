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

import com.epicode.prenotazioni.model.Postazioni;
import com.epicode.prenotazioni.model.TipoPostazione;
import com.epicode.prenotazioni.services.PostazioniService;

@RestController
@RequestMapping("/postazioni")
public class PostazioniController {

	@Autowired
	PostazioniService postazioniService;

	@PostMapping("/crea")
	public void creaPostazione(@RequestBody Postazioni postazioni) {

		postazioniService.creaPostazione(postazioni);
	}

	@GetMapping
	public List<Postazioni> trovaTuttePostazioni() {
		return postazioniService.trovaTuttePostazioni();
	}

	@GetMapping("/{id}")
	public Postazioni trovaPostazionePerId(@PathVariable Long id) {
		return postazioniService.trovaPostazionePerId(id);
	}

	@GetMapping("/test")
	public List<Postazioni> trovaPostazionePerEdificioETipo(@RequestParam String citta,
			@RequestParam TipoPostazione tipoPostazione) {
		return postazioniService.trovaPostazionePerEdificioETipo(citta, tipoPostazione);
	}
}
