package com.epicode.prenotazioni.runners;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.prenotazioni.model.Edificio;
import com.epicode.prenotazioni.services.EdificioService;

@Component
@Order(2)
public class EdificioRunner implements ApplicationRunner {

	@Autowired
	private EdificioService edificioService;

	@Autowired
	ObjectProvider<Edificio> edificioProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		for (int i = 0; i < 10; i++) {

			edificioService.creaEdificio(edificioProvider.getObject());
		}

	}

}
