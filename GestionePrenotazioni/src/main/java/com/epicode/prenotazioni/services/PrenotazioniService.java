package com.epicode.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.model.Prenotazioni;
import com.epicode.prenotazioni.repository.PrenotazioniRepository;

@Service
public class PrenotazioniService {

	@Autowired
	private PrenotazioniRepository prenotazioniRep;

	public void creaPrenotazioni(Prenotazioni prenotazione) {
		if (!prenotazioniRep.existsByUtenteIdAndData(prenotazione.getUtente().getId(), prenotazione.getData())) {

			prenotazioniRep.save(prenotazione);
		}

	}

	public List<Prenotazioni> trovaTuttePrenotazioni() {

		return (List<Prenotazioni>) prenotazioniRep.findAll();
	}

	public Prenotazioni trovaPrenotazionePerId(Long id) {
		return prenotazioniRep.findById(id).get();
	}

	public List<Prenotazioni> trovaPrenotazionePerIdUtente(Long id) {
		return prenotazioniRep.trovaPrenotazionePerUtenteId(id);
	}
}
