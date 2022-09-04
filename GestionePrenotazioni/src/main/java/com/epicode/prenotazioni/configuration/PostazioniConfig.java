package com.epicode.prenotazioni.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.prenotazioni.model.Postazioni;
import com.epicode.prenotazioni.model.TipoPostazione;
import com.epicode.prenotazioni.services.EdificioService;
import com.github.javafaker.Faker;

@Configuration
public class PostazioniConfig {

	@Autowired
	private EdificioService edificioService;

	@Bean
	@Scope("prototype")
	public Postazioni newPostazioni() {

		Postazioni postazioneProva = new Postazioni();
		postazioneProva.setDescrizione(Faker.instance().commerce().department());
		postazioneProva.setTipoPostazione(TipoPostazione.OPENSPACE);
		postazioneProva.setNMaxOccupanti(Faker.instance().number().numberBetween(5, 30));
		postazioneProva
				.setEdificio(edificioService.trovaEdificioPerId((long) Faker.instance().number().numberBetween(1, 10)));

		return postazioneProva;

	}
}
