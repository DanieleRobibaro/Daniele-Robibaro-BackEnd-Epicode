package com.epicode.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.model.Utente;
import com.epicode.prenotazioni.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRep;

	public void creaUtente(Utente utente) {
		utenteRep.save(utente);
	}

	public List<Utente> trovaTuttiUtenti() {
		return (List<Utente>) utenteRep.findAll();
	}

	public Utente trovaUtentePerId(Long id) {
		return utenteRep.findById(id).get();
	}
}
