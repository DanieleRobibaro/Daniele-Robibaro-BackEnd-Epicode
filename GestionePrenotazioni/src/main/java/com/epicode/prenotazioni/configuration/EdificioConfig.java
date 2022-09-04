package com.epicode.prenotazioni.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.prenotazioni.model.Edificio;
import com.github.javafaker.Faker;

@Configuration
public class EdificioConfig {

	@Bean("edificioProva")
	@Scope("prototype")
	public Edificio newEdificio() {

		Edificio edificioProva = new Edificio();
		edificioProva.setNome(Faker.instance().company().industry());
		edificioProva.setCitta(Faker.instance().address().cityName());
		edificioProva.setIndirizzo(Faker.instance().address().streetAddress());

		return edificioProva;

	}
}
