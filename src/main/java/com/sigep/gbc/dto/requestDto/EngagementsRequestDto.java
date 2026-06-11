package com.sigep.gbc.dto.requestDto;


import java.util.Date;

import lombok.Data;

@Data
public class EngagementsRequestDto {
	private Date dateCreation;
	private String natDepense;
	private String auProfit;
	private Long montant;
	private Long dotInitiale;
	private Long dispoAvant;
	private Date dateEtat;
	private String idUser;
	private Boolean avecDecision;
	private Boolean apartirDemandLiq;
	private Boolean grh;
	private Boolean receptionne;
	private Date dateValid;
	private Date dateCreat;
	private Long codLiq;
	private Long codBord;
	private Long idContrat;
	private Long idEngParent;
	//private Long idEngementByNumBe;
	private String etat;
	private Integer idEtatTrans;
	private String proced;
	private String codBud;
	private Integer idBudget;
	private Long idFourn;
	private Short gestion;
}
