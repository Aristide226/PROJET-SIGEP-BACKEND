package com.sigep.gbc.dto.responseDto;


import java.util.Date;

import lombok.Data;

@Data
public class LiquidationResponseDto {
	private Long codLiq;
	private Short gestion;
	private Integer numBl;
	private Date dateLiq;
	private String objet;
	private Long montant;
	private Long montEngage;
	private Long montDjaLiq;
	private Boolean modifiable;
	private String idUser;
	private String numeroDemande;
	private Date dateModif;
	private Boolean actif;
	private Integer idBudget;
	private String compteFourn;
	private Long idContrat;
	private Long numBe;
	private Long idFourn;
}
