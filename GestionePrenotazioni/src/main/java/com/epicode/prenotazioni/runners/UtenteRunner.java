package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.model.Utente;
import com.epicode.prenotazioni.services.UtenteService;

@Component
@Order(1)
public class UtenteRunner implements ApplicationRunner {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	ObjectProvider<Utente> utenteProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		for (int i = 0; i < 10; i++) {

			utenteService.creaUtente(utenteProvider.getObject());
		}
	}

}
