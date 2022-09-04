package com.epicode.prenotazioni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postazioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codUnivoco;
	@Column(length = 40)
	private String descrizione;
	@NonNull
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipoPostazione;
	@NonNull
	private Integer nMaxOccupanti;
	@ManyToOne
	private Edificio edificio;
}
