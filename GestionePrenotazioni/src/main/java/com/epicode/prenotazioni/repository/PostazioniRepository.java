package com.epicode.prenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.model.Postazioni;
import com.epicode.prenotazioni.model.TipoPostazione;

@Repository
public interface PostazioniRepository extends CrudRepository<Postazioni, Long> {

	@Query("SELECT p FROM Postazioni p WHERE p.edificio.citta = :citta AND p.tipoPostazione = :tipoPostazione")
	public List<Postazioni> findByCittaAndTipoPostazione(String citta, TipoPostazione tipoPostazione);

}
