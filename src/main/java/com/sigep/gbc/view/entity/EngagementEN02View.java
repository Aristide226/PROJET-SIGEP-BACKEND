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
public class EngagementEN02View {
	
	@Id
	@Column(name = "NumBE", unique = true, nullable = false, precision = 18, scale = 0)
	private long numBe;
	
	@Column(name = "CodBud", unique = true, nullable = false)
	private String codBud;
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "BENum", nullable = false)
	private int benum;
	
	@Column(name = "Proced", nullable = false)
	private String proced;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateCreation", nullable = false, length = 23)
	private Date dateCreation;
	
	@Column(name = "NatDepense", nullable = false, length = 850)
	private String natDepense;
	
	@Column(name = "AuProfit")
	private String auProfit;
	
	@Column(name = "Montant", nullable = false, precision = 18, scale = 0)
	private long montant;
	
	@Column(name = "Dot_Initiale", precision = 18, scale = 0)
	private Long dot_Initiale;
	
	@Column(name = "DispoAvant", precision = 18, scale = 0)
	private Long dispoAvant;
	
	@Column(name = "Etat", nullable = false)
	private String etat;
	
	@Column(name = "DateEtat", nullable = false, length = 23)
	private Date dateEtat;
	
	@Column(name = "IdBord")
	private Long idBord;
	
	@Column(name = "idFourn", nullable = false)
	private Long idFourn;
	
	@Column(name = "idContrat")
	private Long idContrat;
	
	@Column(name = "idEng")
	private Long idEng;
	
	@Column(name = "IdUser", nullable = false, length = 5)
	private String idUser;
	
	@Column(name = "idEtatTrans", nullable = false)
	private Integer idEtatTrans;
	
	@Column(name = "IdBudget", nullable = false)
	private Integer idBudget;
	
	@Column(name = "AvecDecision", nullable = false)
	private boolean avecDecision;
	
	@Column(name = "CodLiq")
	private Long codLiq;
	
	@Column(name = "ApartirDemandLiq", nullable = false)
	private boolean apartirDemandLiq;
	
	@Column(name = "GRH", nullable = false)
	private boolean grh;
	
	@Column(name = "Receptionne", nullable = false)
	private boolean receptionne;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateValid", nullable = false, length = 23)
	private Date dateValid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_Creat", nullable = false, length = 23)
	private Date dateCreat;
	
	@Column(name = "Intitule")
	private String intitule;
	
	@Column(name = "DotInitiale", nullable = false, precision = 18, scale = 0)
	private long dotInitiale;
	
	@Column(name = "TotalEngag", nullable = false, precision = 18, scale = 0)
	private long totalEngag;
	
	@Column(name = "DotationCorrigee")
	private Long dotationCorrigee;
	
	@Column(name = "DotationDefinitive")
	private Long dotationDefinitive;
	
	@Column(name = "Disponible")
	private Long disponible;
	
	@Column(name = "NbreEngag")
	private long nbreEngag;
	
	@Column(name = "IFUMle", length = 50)
	private String ifumle;
	
	@Column(name = "fType", nullable = false, length = 1)
	private String ftype;
	
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
	
	@Column(name = "NumeroContrat") // Contrat
	private Integer numeroContrat;
	
	@Column(name = "ReferenceContrat")
	private String referenceContrat;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateSaisieContrat", length = 23)
	private Date dateSaisieContrat;
	
	@Column(name = "MontantContrat", nullable = false, precision = 18, scale = 0)
	private Long montantContrat;
	
	@Column(name = "EngageContrat")
	private Long engageContrat;
	
	@Column(name = "EngageContratPourModifierEngagement")
	private Long engageContratPourModifierEngagement;
	
	@Column(name = "MandateContrat")
	private Long mandateContrat;
	
	@Column(name = "EngageValidContrat")
	private Long engageValidContrat;
	
	@Column(name = "MandateValidContrat")
	private Long mandateValidContrat;
	
	@Column(name = "ResteAEngagerContrat")
	private Long resteAEngagerContrat;
	
	@Column(name = "ResteAEngagerContratPourModifierEngagement")
	private Long resteAEngagerContratPourModifierEngagement;
	
	@Column(name = "ResteALiquiderContrat")
	private Long resteALiquiderContrat;
	
	@Column(name = "NumMand", unique = true, nullable = false, precision = 18, scale = 0) // Mandat
	private Long numMand;
	
	@Column(name = "MandNum", nullable = false)
	private Integer mandNumb; // Pour faciliter le parse model maper
	
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
	
	@Column(name = "CompteFourn")
	private String compteFourn;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePaie", length = 23)
	private Date datePaie;
	
	@Column(name = "MontantPaie", precision = 18, scale = 0)
	private Long montantPaie;
	
	@Column(name = "ModePaie")
	private String idModePaie;
	
	@Column(name = "IdCompte")
	private String idCompte;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePosition", length = 23)
	private Date datePosition;
	
	@Column(name = "NumBL", nullable = false)
	private Integer numBl;
	
	@Column(name = "MontEngage", nullable = false, precision = 18, scale = 0)
	private Long montEngage;

	@Column(name = "MontDjaLiq", nullable = false, precision = 18, scale = 0)
	private Long montDjaLiq;
	
	@Column(name = "EtatBL", nullable = false)
	private String etatBl;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateEtatBL", nullable = false, length = 23)
	private Date dateEtatBl;
	
	@Column(name = "NumMandParent")
	private Long numMandParent;
	
	@Column(name = "IdBordEmisMand")
	private String idBordEmisMand;
	
	@Column(name = "IDbordMand")
	private Long idbordMand;
	
	@Column(name = "idEtatTransM", nullable = false)
	private Integer idEtatTransM;
	
	@Column(name = "idEtatTransL", nullable = false)
	private Integer idEtatTransL;
	
	@Column(name = "IdLettrage")
	private String idLettrage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePEC", length = 23)
	private Date datePec;
	
	@Column(name = "ReceptionneMand", nullable = false)
	private Boolean receptionneMand;
	
	@Column(name = "GenererOV", nullable = false)
	private Boolean genererOv;

	@Column(name = "AvecReversement", nullable = false)
	private Boolean avecReversement;

	@Column(name = "Precompte", nullable = false, precision = 18, scale = 0)
	private Long precompte;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePrecompte", length = 23)
	private Date datePrecompte;

	@Column(name = "UserPrecompte", length = 5)
	private String userPrecompte;
	
	@Column(name = "DateValidMand", nullable = false, length = 23)
	private Date dateValidMand;

	@Column(name = "IdFiche", nullable = false, precision = 18, scale = 0)
	private Long idFiche;
	
	@Column(name = "MontantTotalPEC", nullable = false, precision = 18, scale = 0)
	private Long montantTotalPec;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_CreatMand", nullable = false, length = 23)
	private Date date_CreatMand;
	
	@Column(name = "EstOrdre", nullable = false) 
	private Boolean estOrdre;
	
	@Column(name = "MandNumApresVisaCf", nullable = false)
	private Integer mandNumApresVisaCf;
	
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
	
	@Column(name = "CodeBIC", length = 50)
	private String codeBic;
	
	@Column(name = "IBAN", length = 50)
	private String iban;
	
	@Column(name = "IdCaissePop", nullable = false)
	private Long idCaissePop;
	
	@Column(name = "Abreviation", unique = true, nullable = false, length = 20)
	private String abreviation;
	
	@Column(name = "IdAgence", unique = true, nullable = false, length = 36)
	private String idAgence;
	
	@Column(name = "LibelleAgence", nullable = false, length = 50)
	private String libelleAgence;
	
	@Column(name = "DomicilieA", nullable = false, length = 150)
	private String domicilieA;
	
	@Column(name = "DejaLiquide")
	private Long dejaLiquide;
	
	@Column(name = "ResteALiquider")
	private Long resteALiquider;
	
	@Column(name = "Id_motif", unique = true, nullable = false, length = 36)
	private String id_motif;
	
	@Column(name = "Motifs", nullable = false)
	private String motifs;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateSaisieMotif", nullable = false, length = 23)
	private Date dateSaisieMotif;
	
	@Column(name = "IdTitreMotif", precision = 18, scale = 0)
	private Long idTitreMotif;
	
	@Column(name = "UserNameMotif", nullable = false, length = 5)
	private String userNameMotif;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateEnregMotif", nullable = false, length = 23)
	private Date dateEnregMotif;
	
	@Column(name = "ActifMotif", nullable = false)
	private boolean actifMotif;
}
