//Aristide
package com.sigep.gbc.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PPM_EXEC", schema = "dbo")

public class PpmExec implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name ="idPpmExec", column = @Column(name="IdPPMExe", nullable = false)),
		@AttributeOverride(name ="idLot", column = @Column(name="IdLot", nullable = false)),
		@AttributeOverride(name ="idBudget", column = @Column(name="IdBudget", nullable = false)),
		@AttributeOverride(name ="exercice", column = @Column(name="Exercice", nullable = false))
	})
	private PpmExecId id;
	
	@Column(name = "NbLot", nullable = false)
	private int nbLot;
	
	@Column(name = "Num", nullable = false)
	private int num;
	
	@Column(name = "MontantEstime", nullable = false)
	private Long montantEstime;
	
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
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateLanceEffect", nullable = false)
	private Date dateLanceEffect;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateButoire", nullable = false)
	private Date dateButoire;
	
	@Column(name = "Execut", nullable = false)
	private boolean execution;
	
	@Column(name = "IdFourm", nullable = false)
	private int idFourm;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdModPassation", nullable = false)
	private PpmModePass ppmModePass;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPPM", nullable = false)
    private Ppm ppm;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DateRemiseEtOuvertureDesPlis", nullable = true)
	private Date dateRemiseEtOuvertureDesPlis;
	
}





