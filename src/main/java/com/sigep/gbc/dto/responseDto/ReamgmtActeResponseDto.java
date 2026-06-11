package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.ReamHampliationId;
import com.sigep.gbc.entity.ReamHvisaId;
import com.sigep.gbc.entity.ReamgmtId;

import lombok.Data;

@Data
public class ReamgmtActeResponseDto {
	private Long codReam;
	private Date dateSaisie;
	private Boolean valide;
	private String acte;
	private String numero;
	private Date dateActe;
	private String idLogin;
	private Date dateValid;
	private String idValid;
	private Boolean dep;
	private String acteTitre;
	private Short acteAn;
	private Integer acteNum;
	private String acteNumComplema;
	private Boolean numAuto;
	private String signataireFonct;
	private String signataireNom;
	private String signataireTh;
	private String complemaVisa;
	private String complemaVisaLib;
	private String dernierArticleReam;
	private Integer idActe;
	private Integer idBudget;
	private Short gestion;
	List<ReamgmtId> reamgmtIds;
	List<ReamHampliationId> reamHampliationIds;
	List<ReamHvisaId> reamHvisaIds;
}
