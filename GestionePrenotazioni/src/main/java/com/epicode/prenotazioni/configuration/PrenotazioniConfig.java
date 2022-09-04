package com.epicode.prenotazioni.configuration;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.prenotazioni.model.Prenotazioni;
import com.epicode.prenotazioni.services.PostazioniService;
import com.epicode.prenotazioni.services.UtenteService;
import com.github.javafaker.Faker;

@Configuration
public class PrenotazioniConfig {

	@Autowired
	private PostazioniService postazioniService;

	@Autowired
	private UtenteService utenteService;

	@Bean
	@Scope("prototype")
	public Prenotazioni newPrenotazione() {

		Prenotazioni prenotazioneProva = new Prenotazioni();

		prenotazioneProva.setData(LocalDate.of(Faker.instance().number().numberBetween(2021, 2022),
				Faker.instance().number().numberBetween(1, 12), Faker.instance().number().numberBetween(1, 31)));
		prenotazioneProva.setPostazione(
				postazioniService.trovaPostazionePerId((long) Faker.instance().number().numberBetween(1, 10)));
		prenotazioneProva
				.setUtente(utenteService.trovaUtentePerId((long) Faker.instance().number().numberBetween(1, 10)));

		return prenotazioneProva;

	}
}
