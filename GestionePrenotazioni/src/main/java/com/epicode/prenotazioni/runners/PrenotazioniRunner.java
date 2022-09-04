package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.model.Prenotazioni;
import com.epicode.prenotazioni.services.PrenotazioniService;

@Component
@Order(4)
public class PrenotazioniRunner implements ApplicationRunner {

	@Autowired
	private PrenotazioniService prenotazioneService;

	@Autowired
	ObjectProvider<Prenotazioni> prenotazioneProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		for (int i = 0; i < 10; i++) {
			prenotazioneService.creaPrenotazioni(prenotazioneProvider.getObject());
		}
	}

}
