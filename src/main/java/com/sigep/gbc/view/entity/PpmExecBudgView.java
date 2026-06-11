package com.sigep.gbc.view.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

import com.sigep.gbc.entity.PpmExecBudgId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PpmExecBudgView {
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name ="idPpmExe", column = @Column(name="IdPPMExe", nullable = false)),
		@AttributeOverride(name ="idLot", column = @Column(name="IdLot", nullable = false)),
		@AttributeOverride(name ="idBudget", column = @Column(name="IdBudget", nullable = false)),
		@AttributeOverride(name ="exercice", column = @Column(name="Exercice", nullable = false)),
		@AttributeOverride(name ="codBud", column = @Column(name="CodBud", nullable = false)),
		@AttributeOverride(name ="idSrceFin", column = @Column(name="IdSrceFin", nullable = false))
	})
	private PpmExecBudgId id;
	
	@Column(name = "MontantEstime")
    private long montantEstime;
	
	@Column(name = "AvecTVA", nullable = false)
	private boolean avecTva;
	
	@Column(name = "AvecMiniMax", nullable = false)
	private boolean avecMiniMax;
	
	@Column(name = "NbLot", nullable = false)
	private int nbLot;
	
	@Column(name = "Num", nullable = false)
	private int num;
	
	@Column(name = "MontantEstimePpmExec", nullable = false)
	private Long montantEstimePpmExec;
	
	@Column(name = "MontDepEngNonLia", nullable = false)
	private Long montDepEngNonLiq;
	
	@Column(name = "CreditDispo", nullable = false)
	private Long creditDispo;
	
	@Column(name = "NatPrestation", nullable = false)
	private String natPrestation;
	
	@Column(name = "ObjetLot", nullable = false)
	private String objetLot;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateCreat", nullable = false)
	private Date dateCreat;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateLanceEffect", nullable = false)
	private Date dateLanceEffect;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateButoire", nullable = false)
	private Date dateButoire;
	
	@Column(name = "Execut", nullable = false)
	private boolean execution;
	
	@Column(name = "IdFourn", nullable = false)
	private int idFourn;
	
	@Column(name = "MontantAttrib", nullable = false)
	private Long montantAttrib;
	
	@Column(name = "MontantTotalTTC", nullable = true)
	private BigDecimal montantTtc;
	
	@Column(name = "MontantTotalHTVA", nullable = true)
	private BigDecimal montantHtva;
	
	@Column(name = "MontantMaxTTC", nullable = true)
	private BigDecimal montantMaxTtc;
	
	@Column(name = "MontantMaxHTVA", nullable = true)
	private BigDecimal montantMaxHtva;
	
	@Column(name = "MontantMinTTC", nullable = true)
	private BigDecimal montantMinTtc;
	
	@Column(name = "MontantMinHTVA", nullable = true)
	private BigDecimal montantMinHtva;
	
	@Column(name = "IdModPassation", unique = true, nullable = false, length = 10)
	private String abrevMp;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateNotificationProvisoire", nullable = true)
	private Date dateNotificationProvisoire;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateApprobContrat", nullable = true)
	private Date dateApprobContrat;
	
	@Column(name = "NiveauMiseEnOeuvreEtObservation", nullable = false)
	private String NiveauMiseEnOeuvreEtObservation;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateReception", nullable = true)
	private Date dateReception;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateLancementMarchePrevisionnel", nullable = true)
	private Date dateLancementMarchePrevisionnel;
	
	@Column(name = "NbJoursRetardLancement", nullable = true)
	private int nbJoursRetardLancement;
	
	@Column(name = "IdPPM", unique = true, nullable = false, length = 128)
	private String idPpm;
	
	@Column(name = "IFUMle", length = 50)
	private String ifumle;
	
	@Column(name = "Nom", length = 300)
	private String nom;
	
	@Column(name = "IdPlan", nullable = false)
	private String idPlan;
	
	@Column(name = "IntituleBudget")
	private String intituleBudget;
	
	@Column(name = "IntituleCourtCodSourceFin")
	private String intituleCourtCodSourceFin;
	
	@Column(name = "AbrevCodSourceFin")
	private String abrevCodSourceFin;
	
	@Column(name = "IntituleLongCodSourceFin")
	private String intituleLongCodSourceFin;
	
	@Column(name = "LibelleLongMP", nullable = false, length = 150)
	private String libelleLongMp;
	
	@Column(name = "Cod4", unique = true, nullable = false)
	private String cod4;
}
