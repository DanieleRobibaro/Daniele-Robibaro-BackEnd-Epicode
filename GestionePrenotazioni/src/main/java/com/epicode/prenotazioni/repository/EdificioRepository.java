package com.epicode.prenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.model.Edificio;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio, Long> {

}
