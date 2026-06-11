package com.sigep.gbc.view.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LiquidationView {
	
	@Id
	@Column(name = "CodLiq", unique = true, nullable = false, precision = 18, scale = 0)
	private long codLiq;
	
	@Column(name = "NumBE", unique = true, nullable = false, precision = 18, scale = 0)
	private long numBe;
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "NumBL", nullable = false)
	private int numBl;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateLiq", nullable = false, length = 23)
	private Date dateLiq;
	
	@Column(name = "Objet", nullable = false)
	private String objet;
	
	@Column(name = "Montant", nullable = false, precision = 18, scale = 0)
	private long montant;

	@Column(name = "MontEngage", nullable = false, precision = 18, scale = 0)
	private long montEngage;
	
	@Column(name = "MontDjaLiq", nullable = false, precision = 18, scale = 0)
	private long montDjaLiq;
	
	@Column(name = "Modifiable", nullable = false)
	private boolean modifiable;
	
	@Column(name = "idFourn", nullable = false)
	private Long idFourn;
	
	@Column(name = "idContrat")
	private Long idContrat;
	
	@Column(name = "IdUser", nullable = false, length = 7)
	private String idUser;
	
	@Column(name = "CompteFourn")
	private String compteFourn;
	
	@Column(name = "NumeroDemande")
	private String numeroDemande;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateModif", nullable = false, length = 23)
	private Date dateModif;
	
	@Column(name = "Actif", nullable = false)
	private boolean actif;
	
	@Column(name = "IdBudget", nullable = false)
	private int idBudget;
	
	@Column(name = "CodBud", unique = true, nullable = false)
	private String codBud;
	
	@Column(name = "BENum", nullable = false)
	private int benum;
	
	@Column(name = "Proced", nullable = false)
	private String proced;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateCreationEng", nullable = false, length = 23)
	private Date dateCreationEng;
	
	@Column(name = "MontantEng", nullable = false, precision = 18, scale = 0)
	private long montantEng;
	
	@Column(name = "DejaLiquideEng", nullable = false, precision = 18, scale = 0)
	private long dejaLiquideEng;
	
	@Column(name = "DejaLiquideReelEng", nullable = false, precision = 18, scale = 0)
	private long dejaLiquideReelEng;
	
	@Column(name = "ResteALiquiderEng", nullable = false, precision = 18, scale = 0)
	private long resteALiquiderEng;
	
	@Column(name = "ResteALiquiderReelEng", nullable = false, precision = 18, scale = 0)
	private long resteALiquiderReelEng;
	
	@Column(name = "NbreLiqEng", nullable = false, precision = 18, scale = 0)
	private long nbreLiqEng;
	
	@Column(name = "NbreLiqReelEng", nullable = false, precision = 18, scale = 0)
	private long nbreLiqReelEng;
	
	@Column(name = "IFUMle", length = 50)
	private String ifumle;
	
	@Column(name = "Nom", length = 300)
	private String nom;
	
	@Column(name = "Titre")
	private String titre;
	
	@Column(name = "Section")
	private String section;
	
	@Column(name = "Chap")
	private String chap;
	
	@Column(name = "Art")
	private String art;
	
	@Column(name = "Parag")
	private String parag;
	
	@Column(name = "Rub")
	private String rub;
	
	@Column(name = "Intitule")
	private String intitule;
	
	@Column(name = "NumeroContrat") // Contrat
	private Integer numeroContrat;
	
	@Column(name = "ReferenceContrat")
	private String referenceContrat;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateSaisieContrat", length = 23)
	private Date dateSaisieContrat;
	
	@Column(name = "MontantContrat")
	private Long montantContrat;
	
	@Column(name = "EngageContrat")
	private Long engageContrat;
	
	@Column(name = "MandateContrat")
	private Long mandateContrat;
	
	@Column(name = "EngageValidContrat")
	private Long engageValidContrat;
	
	@Column(name = "MandateValidContrat")
	private Long mandateValidContrat;
	
	@Column(name = "NumMand", unique = true, nullable = false, precision = 18, scale = 0) // Mandat
	private Long numMand;
	
	@Column(name = "MandNum", nullable = false)
	private Integer mandNumb;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateMand", nullable = false, length = 23)
	private Date dateMand;
	
	@Column(name = "MontantMand", nullable = false, precision = 18, scale = 0)
	private Long montantMand;
	
	@Column(name = "EtatMand", nullable = false)
	private String etatMand;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateEtatMand", nullable = false, length = 23)
	private Date dateEtatMand;
	
	@Column(name = "CompteFournMand")
	private String compteFournMand;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePaieMand", length = 23)
	private Date datePaieMand;
	
	@Column(name = "MontantPaieMand", precision = 18, scale = 0)
	private Long montantPaieMand;
	
	@Column(name = "ModePaieMand")
	private String idModePaieMand;
	
	@Column(name = "IdCompteMand")
	private String idCompteMand;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePositionMand", length = 23)
	private Date datePositionMand;
	
	@Column(name = "NumBLMand", nullable = false)
	private Integer numBlMand;
	
	@Column(name = "MontEngageMand", nullable = false, precision = 18, scale = 0)
	private Long montEngageMand;

	@Column(name = "MontDjaLiqMand", nullable = false, precision = 18, scale = 0)
	private Long montDjaLiqMand;
	
	@Column(name = "EtatBLMand", nullable = false)
	private String etatBlMand;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateEtatBLMand", nullable = false, length = 23)
	private Date dateEtatBlMand;
	
	@Column(name = "NumMandParent")
	private Long numMandParent;
	
	@Column(name = "IdBordEmisMand")
	private String idBordEmisMand;
	
	@Column(name = "IDbordMand")
	private Long idbordMand;
	
	@Column(name = "idEtatTransMMand", nullable = false)
	private Integer idEtatTransMMand;
	
	@Column(name = "idEtatTransLMand", nullable = false)
	private Integer idEtatTransLMand;
	
	@Column(name = "IdLettrageMand")
	private String idLettrageMand;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePECMand", length = 23)
	private Date datePecMand;
	
	@Column(name = "ReceptionneMand", nullable = false)
	private Boolean receptionneMand;
	
	@Column(name = "GenererOVMand", nullable = false)
	private Boolean genererOvMand;

	@Column(name = "AvecReversementMand", nullable = false)
	private Boolean avecReversementMand;

	@Column(name = "PrecompteMand", nullable = false, precision = 18, scale = 0)
	private Long precompteMand;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePrecompteMand", length = 23)
	private Date datePrecompteMand;

	@Column(name = "UserPrecompteMand", length = 5)
	private String userPrecompteMand;
	
	@Column(name = "DateValidMand", nullable = false, length = 23)
	private Date dateValidMand;

	@Column(name = "IdFicheMand", nullable = false, precision = 18, scale = 0)
	private Long idFicheMand;
	
	@Column(name = "MontantTotalPECMand", nullable = false, precision = 18, scale = 0)
	private Long montantTotalPecMand;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_CreatMand", nullable = false, length = 23)
	private Date date_CreatMand;
	
	@Column(name = "EstOrdreMand", nullable = false) 
	private Boolean estOrdreMand;
	
	@Column(name = "MandNumApresVisaCf", nullable = false)
	private Integer mandNumApresVisaCf;	
	
	@Column(name = "Abreviation", unique = true, nullable = false, length = 20)
	private String abreviation;
	
	@Column(name = "CodeBanque", nullable = false)
	private String codeBanque;
	
	@Column(name = "CodeAgence", nullable = false)
	private String codeAgence;
	
	@Column(name = "NumCompte", nullable = false)
	private String numCompte;
	
	@Column(name = "CleRIB", nullable = false)
	private String cleRib;
	
	@Column(name = "CaissePop")
	private String caissePop;
	
	@Column(name = "numCaissePop")
	private String numCaissePop;
	
	@Column(name = "IdAgence", unique = true, nullable = false, length = 36)
	private String idAgence;
	
	@Column(name = "CodeBIC", length = 50)
	private String codeBic;
	
	@Column(name = "IBAN", length = 50)
	private String iban;
	
	@Column(name = "IdCaissePop", nullable = false)
	private Long idCaissePop;
	
	@Column(name = "LibelleAgence", nullable = false, length = 50)
	private String libelleAgence;
	
	@Column(name = "DomicilieA", nullable = false, length = 150)
	private String domicilieA;
}
