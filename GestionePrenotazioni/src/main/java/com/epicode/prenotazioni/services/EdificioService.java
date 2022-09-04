package com.epicode.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.model.Edificio;
import com.epicode.prenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRep;

	public void creaEdificio(Edificio edificio) {
		edificioRep.save(edificio);
	}

	public List<Edificio> trovaTuttiEdifici() {
		return (List<Edificio>) edificioRep.findAll();
	}

	public Edificio trovaEdificioPerId(Long id) {
		return edificioRep.findById(id).get();
	}
}
