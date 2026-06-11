package com.sigep.gbc.dto.requestDto;


import java.util.Date;

import lombok.Data;

@Data
public class ReamgmtActeRequestDto {
	private Boolean valide;
	private String acte;
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
}
