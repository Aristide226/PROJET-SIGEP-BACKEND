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
public class MandatsView {
	
	@Id
	@Column(name = "NumMand", unique = true, nullable = false, precision = 18, scale = 0)
	private long numMand;
	
	@Column(name = "CodBud", unique = true, nullable = false)
	private String codBud;
	
	@Column(name = "NumBE", unique = true, nullable = false, precision = 18, scale = 0)
	private long numBe;
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "MandNum", nullable = false)
	private int mandNumb;
	
	@Column(name = "DateMand", nullable = false, length = 23)
	private Date dateMand;
	
	@Column(name = "Montant", nullable = false, precision = 18, scale = 0)
	private long montant;
	
	@Column(name = "Etat", nullable = false)
	private String etat;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateEtat", nullable = false, length = 23)
	private Date dateEtat;
	
	@Column(name = "idFourn", nullable = false)
	private Long idFourn;
	
	@Column(name = "idContrat")
	private Long idContrat;
	
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
	
	@Column(name = "IdUser", nullable = false, length = 5)
	private String idUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePosition", length = 23)
	private Date datePosition;

	@Column(name = "BENum", nullable = false)
	private int benum;

	@Column(name = "NumBL", nullable = false)
	private int numBl;
	
	@Column(name = "Objet", nullable = false)
	private String objet;

	@Column(name = "MontEngage", nullable = false, precision = 18, scale = 0)
	private long montEngage;

	@Column(name = "MontDjaLiq", nullable = false, precision = 18, scale = 0)
	private long montDjaLiq;

	@Column(name = "EtatBL", nullable = false)
	private String etatBl;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateEtatBL", nullable = false, length = 23)
	private Date dateEtatBl;
	
	@Column(name = "NumMandParent")
	private Long numMandParent;
	
	@Column(name = "IdBordEmis")
	private String idBordEmis;
	
	@Column(name = "IDbord")
	private Long idbord;
	
	@Column(name = "idEtatTransM", nullable = false)
	private Integer idEtatTransM;
	
	@Column(name = "idEtatTransL", nullable = false)
	private Integer idEtatTransL;
	
	@Column(name = "IdBudget", nullable = false)
	private Integer idBudget;
	
	@Column(name = "CodLiq")
	private Long codLiq;
	
	@Column(name = "IdLettrage")
	private String idLettrage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePEC", length = 23)
	private Date datePec;
	
	@Column(name = "Receptionne", nullable = false)
	private boolean receptionne;
	
	@Column(name = "GenererOV", nullable = false)
	private boolean genererOv;

	@Column(name = "AvecReversement", nullable = false)
	private boolean avecReversement;

	@Column(name = "Precompte", nullable = false, precision = 18, scale = 0)
	private long precompte;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DatePrecompte", length = 23)
	private Date datePrecompte;

	@Column(name = "UserPrecompte", length = 5)
	private String userPrecompte;

	@Column(name = "DateValid", nullable = false, length = 23)
	private Date dateValid;

	@Column(name = "IdFiche", nullable = false, precision = 18, scale = 0)
	private long idFiche;
	
	@Column(name = "MontantTotalPEC", nullable = false, precision = 18, scale = 0)
	private long montantTotalPec;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date_Creat", nullable = false, length = 23)
	private Date dateCreat;

	@Column(name = "EstOrdre", nullable = false)
	private boolean estOrdre;

	@Column(name = "MandNumApresVisaCf", nullable = false)
	private int mandNumApresVisaCf;
	
	@Column(name = "IFUMle", length = 50) // DESTINATAIRES
	private String ifumle;
	
	@Column(name = "Nom", length = 300)
	private String nom;
	
	@Column(name = "Titre") // NUMNO
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
	
	@Column(name = "Intitule", length = 450)
	private String intitule;
}
