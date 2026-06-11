package com.sigep.gbc.dto.responseDto;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


import lombok.Data;

@Data
public class ContratsResponseDto {
	private Long idContrat;
	private String cod1;
	private String cod2;
	private String cod3;
	private String cod4;
	private String cod5;
	private Short annee;
	private Integer numero;
	private String objet;
	private String reference;
	private Long delaiNbre;
	private String delaiText;
	private Date dateSaisie;
	private Date dateApprob;
	private String acteRef;
	private String refNotif;
	private Date dateNotif;
	private Date dateDemmar;
	private Boolean mleAuto;
	private String refPassation;
	private String refArt;
	private BigDecimal tauxappli;
	private Boolean suspens;
	private String idLogin;
	private String idcompte;
	private Long avenant;
	private Long degage;
	private Long engage;
	private Long mandate;
	private Long paie;
	private Long engageValid;
	private Long mandateValid;
	private Long montantMaxHtva;
	private Long montantMinHtva;
	private Long montantMaxTtc;
	private Long montantMinTtc;
	private Boolean avecTva;
	private Boolean avecMiniMax;
	private Long montant;
	private BigInteger montantCorrige;
	private Integer delaiAn;
	private Integer delaiMois;
	private Integer delaiSemaine;
	private Integer delaiJours;
	private Integer delaiEnJours;
	private Date dateCreate;
	private String userUpdate;
	private Date dateUpdate;
	private String idContratParent;
	private String abrevEpe;
	private Date dateAttribution;
	private String codTypeMarche;
	private String codIdentiteExecution;
	private Integer idPpmExe;
	private Integer idLot;
	private String codBud;
	private String idSrceFin;
	private Integer idBudget;
	private String type;
	private Long idFourn;
	private String idDac;
	private List<Long> codLiqs;
	private List<String> idLivraisons;
	private List<String> idPenalites;
	private List<String> idSus;
	private List<Integer> idAvenants;
	private List<String> idRetenus;
	private List<Long> numBes;
	private List<Long> numMands;
}
