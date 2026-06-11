//Aristide
package com.sigep.gbc.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PPM_EXEC_BUDG", schema = "dbo")
public class PpmExecBudg implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
    
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "IdPPMExe", referencedColumnName = "IdPPMExe", insertable = false, updatable = false),
        @JoinColumn(name = "IdLot", referencedColumnName = "IdLot", insertable = false, updatable = false),
        @JoinColumn(name = "IdBudget", referencedColumnName = "IdBudget", insertable = false, updatable = false),
        @JoinColumn(name = "Exercice", referencedColumnName = "Exercice", insertable = false, updatable = false)
    })
    private PpmExec ppmExecLot;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodBud", referencedColumnName = "CodBud", insertable = false, updatable = false)
    private Budget budget; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSrceFin", referencedColumnName = "Cod5", insertable = false, updatable = false)
    private CodSourceFin sourceFin;
    
    @Column(name = "MontantEstime")
    private long montantEstime;
    
    
    @Column (name = "MontantMaxHTVA", nullable = false, precision = 18, scale = 0)
    private long montantMaxHtva;

    @Column (name = "MontantMinHTVA" ,nullable = false, precision = 18, scale = 0)
    private long montantMinHtva;

    @Column (name = "MontantMaxTTC", nullable = false, precision = 18, scale = 0)
    private long montantMaxTtc;

    @Column (name = "MontantMinTTC", nullable = false, precision = 18, scale = 0)
    private long montantMinTtc;

    @Column (name = "AvecTVA", nullable = false)
    private boolean avecTva;

    @Column (name = "AvecMiniMax", nullable = false)
    private boolean avecMiniMax;
}