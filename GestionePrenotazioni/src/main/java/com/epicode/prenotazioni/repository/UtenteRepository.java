package com.epicode.prenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.model.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long> {

}
