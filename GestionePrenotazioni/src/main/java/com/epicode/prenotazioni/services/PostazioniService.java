package com.epicode.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.model.Postazioni;
import com.epicode.prenotazioni.model.TipoPostazione;
import com.epicode.prenotazioni.repository.PostazioniRepository;

@Service
public class PostazioniService {

	@Autowired
	private PostazioniRepository postazioneRep;

	public void creaPostazione(Postazioni postazione) {
		postazioneRep.save(postazione);
	}

	public List<Postazioni> trovaTuttePostazioni() {
		return (List<Postazioni>) postazioneRep.findAll();
	}

	public Postazioni trovaPostazionePerId(Long id) {
		return postazioneRep.findById(id).get();

	}

	public List<Postazioni> trovaPostazionePerEdificioETipo(String citta, TipoPostazione tipoPostazione) {
		return postazioneRep.findByCittaAndTipoPostazione(citta, tipoPostazione);
	}

}
