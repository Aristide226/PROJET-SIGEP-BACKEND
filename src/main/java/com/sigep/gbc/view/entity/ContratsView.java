package com.sigep.gbc.view.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ContratsView {
	
	@Id
	@Column(name = "IdContrat", unique = true, nullable = false, precision = 18, scale = 0)
	private long idContrat;
	
	@Column(name = "Cod1")
	private String cod1;
	
	@Column(name = "Cod2")
	private String cod2;
	
	@Column(name = "Cod3")
	private String cod3;
	
	@Column(name = "Cod4")
	private String cod4;
	
	@Column(name = "Cod5")
	private String cod5;
	
	@Column(name = "annee", nullable = false)
	private short annee;
	
	@Column(name = "Numero")
	private Integer numero;
	
	@Column(name = "Objet", nullable = false)
	private String objet;
	
	@Column(name = "Reference")
	private String reference;
	
	@Column(name = "DelaiNbre", nullable = false, precision = 18, scale = 0)
	private long delaiNbre;
	
	@Column(name = "DelaiText", nullable = false)
	private String delaiText;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateSaisie", length = 23)
	private Date dateSaisie;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateApprob", length = 10)
	private Date dateApprob;
	
	@Column(name = "ActeRef")
	private String acteRef;
	
	@Column(name = "RefNotif")
	private String refNotif;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateNotif", length = 16)
	private Date dateNotif;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateDemmar", length = 16)
	private Date dateDemmar;
	
	@Column(name = "MleAuto", nullable = false)
	private boolean mleAuto;
	
	@Column(name = "RefPassation", length = 150)
	private String refPassation;
	
	@Column(name = "RefArt")
	private String refArt;
	
	@Column(name = "Tauxappli", precision = 18)
	private BigDecimal tauxappli;
	
	@Column(name = "Suspens")
	private Boolean suspens;
	
	@Column(name = "IdLogin", nullable = false, length = 5)
	private String idLogin;
	
	@Column(name = "Idcompte", length = 36)
	private String idcompte;
	
	@Column(name = "Avenant", nullable = false, precision = 18, scale = 0)
	private long avenant;
	
	@Column(name = "Degage", nullable = false, precision = 18, scale = 0)
	private long degage;
	
	@Column(name = "Engage", nullable = false, precision = 18, scale = 0)
	private long engage;

	@Column(name = "Mandate", nullable = false, precision = 18, scale = 0)
	private long mandate;
	
	@Column(name = "Paie", nullable = false, precision = 18, scale = 0)
	private long paie;
	
	@Column(name = "EngageValid", nullable = false, precision = 18, scale = 0)
	private long engageValid;
	
	@Column(name = "MandateValid", nullable = false, precision = 18, scale = 0)
	private long mandateValid;
	
	@Column(name = "MontantMaxHTVA", nullable = false, precision = 18, scale = 0)
	private long montantMaxHtva;
	
	@Column(name = "MontantMinHTVA", nullable = false, precision = 18, scale = 0)
	private long montantMinHtva;
	
	@Column(name = "MontantMaxTTC", nullable = false, precision = 18, scale = 0)
	private long montantMaxTtc;

	@Column(name = "MontantMinTTC", nullable = false, precision = 18, scale = 0)
	private long montantMinTtc;
	
	@Column(name = "AvecTVA", nullable = false)
	private boolean avecTva;
	
	@Column(name = "AvecMiniMax", nullable = false)
	private boolean avecMiniMax;
	
	@ReadOnlyProperty
	@Column(name = "Montant", nullable = false, precision = 18, scale = 0)
	private long montant;
	
	@ReadOnlyProperty
	@Column(name = "MontantCorrige", scale = 0)
	private BigInteger montantCorrige;
	
	@Column(name = "DelaiAn", nullable = false)
	private int delaiAn;
	
	@Column(name = "DelaiMois", nullable = false)
	private int delaiMois;
	
	@Column(name = "DelaiSemaine", nullable = false)
	private int delaiSemaine;
	
	@Column(name = "DelaiJours", nullable = false)
	private int delaiJours;

	@ReadOnlyProperty
	@Column(name = "DelaiEnJours")
	private Integer delaiEnJours;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateCreate", nullable = false, length = 23)
	private Date dateCreate;
	
	@Column(name = "UserUpdate", nullable = false, length = 10)
	private String userUpdate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateUpdate", nullable = false, length = 23)
	private Date dateUpdate;
	
	@Column(name = "IdContratParent", length = 128)
	private String idContratParent;
	
	@Column(name = "AbrevEpe", nullable = false)
	private String abrevEpe;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateAttribution", nullable = false, length = 10)
	private Date dateAttribution;
	
	@Column(name = "CodTypeMarche")
	private String codTypeMarche;
	
	@Column(name = "CodIdentiteExecution")
	private String codIdentiteExecution;
	
	@Column(name = "IdPPMExe", nullable = false)
    private Integer idPpmExe;
	
	@Column(name = "IdLot", nullable = false)
    private Integer idLot;
	
	@Column(name = "CodBud", nullable = false)
    private String codBud;
    
    @Column(name = "IdSrceFin", nullable = false)
    private String idSrceFin;
	
	@Column(name = "IdBudget", nullable = false)
	private int idBudget;
	
	@Column(name = "Type", nullable = false)
	private String type;
	
	@Column(name = "IdFourn", nullable = false)
	private Long idFourn;
	
	@Column(name = "IdDAC")
	private String idDac;
	
	@Column(name = "IFUMle", length = 50)
	private String ifumle;
	
	@Column(name = "fType", nullable = false, length = 1)
	private String ftype;
	
	@Column(name = "ContactTel", length = 150)
	private String contactTel;
	
	@Column(name = "ContactEmail", length = 150)
	private String contactEmail;
	
	@Column(name = "Nom", length = 300)
	private String nom;
	
	@Column(name = "Libelle")
	private String libelle;
	
	@Column(name = "ResteAEngager")
	private long resteAEngager;
	
	@Column(name = "ResteALiquider")
	private long resteALiquider;
	
	@Column(name = "IdPPM", unique = true, nullable = false, length = 128)
	private String idPpm;
	
	@Column(name = "NombreEng")
	private long nombreEng;
}
