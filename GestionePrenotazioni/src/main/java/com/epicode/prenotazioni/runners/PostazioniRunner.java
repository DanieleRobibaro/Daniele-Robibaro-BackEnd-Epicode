package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.model.Postazioni;
import com.epicode.prenotazioni.services.PostazioniService;

@Component
@Order(3)
public class PostazioniRunner implements ApplicationRunner {

	@Autowired
	private PostazioniService postazioniService;

	@Autowired
	ObjectProvider<Postazioni> postazioniProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		for (int i = 0; i < 10; i++) {

			postazioniService.creaPostazione(postazioniProvider.getObject());

		}

	}

}
