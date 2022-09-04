package com.epicode.prenotazioni.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.model.Prenotazioni;

@Repository
public interface PrenotazioniRepository extends CrudRepository<Prenotazioni, Long> {

	public boolean existsByUtenteIdAndData(Long id, LocalDate data);

	@Query("SELECT p FROM Prenotazioni p WHERE p.utente.id = :id")
	public List<Prenotazioni> trovaPrenotazionePerUtenteId(Long id);
}
