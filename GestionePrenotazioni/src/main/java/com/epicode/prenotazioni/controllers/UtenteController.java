package com.epicode.prenotazioni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.prenotazioni.model.Utente;
import com.epicode.prenotazioni.services.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@PostMapping("/crea")
	public void creaUtente(@RequestBody Utente utente) {

		utenteService.creaUtente(utente);
	}

	@GetMapping
	public List<Utente> trovaTuttiUtenti() {
		return utenteService.trovaTuttiUtenti();
	}

	@GetMapping("/{id}")
	public Utente trovaUtentePerId(@PathVariable Long id) {
		return utenteService.trovaUtentePerId(id);
	}
}
