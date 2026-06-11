package com.sigep.gim.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class PatrimoineRequestDto {
	private String mle;
	private String codStruct;
	private short anneAcq;
	private Date dateEntre;
	private int quantieme;
	private long valUnit;
	private int dureeVie;
	private boolean amrtisable;
	private Character amorType;
	private String format;
	private Integer idMagasin;
	private String mleAffect;
	private Integer codDirect;
	private String codeDir;
	private Integer codService;
	private Integer codReg;
	private Integer codProv;
	private String etatActuel;
	private Long idInvent;
	private String idFicheEntreProv;
	private Long idFicheEnCours;
	private String nomAgentUtil;
	private String mleAgentUtil;
	private boolean dansInventaire;
	private Integer codCategorie;
	private String codMat;
	private String etatB;
	private Long fichesByIdFicheAffec;
	private Long fichesByIdFiche;
	private String statPatri;
	private Integer codeSite;
	private String codSourceFin;
}
