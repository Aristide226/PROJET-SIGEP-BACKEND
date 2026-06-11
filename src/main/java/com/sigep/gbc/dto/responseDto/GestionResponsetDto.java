package com.sigep.gbc.dto.responseDto;


import java.util.List;

import com.sigep.gbc.entity.AccesLigneBudgetaireId;

import lombok.Data;

@Data
public class GestionResponsetDto {
	private Short courante;
	private String libelle;
	private String etat;
	private String utilisation;
	private List<AccesLigneBudgetaireId> idAccesLigneBudgetaires;
}
