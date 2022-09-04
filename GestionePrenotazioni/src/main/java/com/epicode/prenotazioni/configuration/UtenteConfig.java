package com.epicode.prenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.prenotazioni.model.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfig {

	@Bean
	@Scope("prototype")
	public Utente newUtente() {

		Utente utenteProva = new Utente();
		utenteProva.setUsername(Faker.instance().name().firstName());
		utenteProva.setNomeCompleto(Faker.instance().name().fullName());
		utenteProva.setEmail(Faker.instance().internet().emailAddress());

		return utenteProva;

	}
}
