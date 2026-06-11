package com.sigep.gim.dto.responseDto;

import java.util.Date;

import lombok.Data;

@Data
public class TableRapportResponseDto {
	private String mle;
	private String id;
	private Long idFiche;
	private Integer codCategorie;
	private String codStruct;
	private String codSourceFin;
	private String codMat;
	private Short anneAcq;
	private Date dateEntre;
	private Integer quantième;
	private String etatEntre;
	private Long valUnit;
	private Integer dureeVie;
	private Boolean amrtisable;
	private Character amorType;
	private String format;
	private String statPatri;
	private Integer idMagasin;
	private Long idFicheAffec;
	private String mleAffect;
	private Integer codDirect;
	private String codeDir;
	private Integer codService;
	private Integer codeSite;
	private Integer codReg;
	private Integer codProv;
	private String etatActuel;
	private Long idInvent;
	private String idFicheEntreProv;
	private Long idFicheEnCours;
	private String nomAgentUtil;
	private String mleAgentUtil;
	private String marqueType;
}
