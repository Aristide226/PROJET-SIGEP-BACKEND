package com.sigep.gbc.dto.requestDto;


import java.util.Date;

import lombok.Data;

@Data
public class LiquidationRequestDto {
	private Short gestion;
	private Date dateLiq;
	private String objet;
	private Long montant;
	private Long montEngage;
	private Long montDjaLiq;
	private Boolean modifiable;
	private String idUser;
	private Date dateModif;
	private Boolean actif;
	private Integer idBudget;
	private String compteFourn;
	private Long idContrat;
	private Long numBe;
	private Long idFourn;
}
