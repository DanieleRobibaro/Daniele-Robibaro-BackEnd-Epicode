package com.epicode.prenotazioni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.prenotazioni.model.Edificio;
import com.epicode.prenotazioni.services.EdificioService;

@RestController
@RequestMapping("/edificio")
public class EdificioController {

	@Autowired
	EdificioService edificioService;

	@PostMapping("/crea")
	public void creaEdificio(@RequestBody Edificio edificio) {

		edificioService.creaEdificio(edificio);
	}

	@GetMapping
	public List<Edificio> trovaTuttiEdifici() {
		return edificioService.trovaTuttiEdifici();
	}

	@GetMapping("/{id}")
	public Edificio trovaEdificioPerId(@PathVariable Long id) {
		return edificioService.trovaEdificioPerId(id);
	}
}
