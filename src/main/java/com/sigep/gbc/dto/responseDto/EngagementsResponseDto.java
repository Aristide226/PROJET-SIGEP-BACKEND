package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.PjengBrseZzId;

import lombok.Data;

@Data
public class EngagementsResponseDto {
	private Long numBe;
	private Integer benum;
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
	private Long idBord;
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
	private List<Long> codBords;
	private List<Long> numBesFils;
	//private Long _idEngementByNumBe;
	private List<Long> codLiqs;
	private List<String> idDecisions;
	private List<PjengBrseZzId> idPjengBrseZzs;
	private List<Long> numMands;
}
