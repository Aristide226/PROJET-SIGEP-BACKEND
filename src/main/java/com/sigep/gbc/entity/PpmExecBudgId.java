//Aristide
package com.sigep.gbc.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PpmExecBudgId implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "IdPPMExe", nullable = false)
    private int idPpmExe;
	
	@Column(name = "IdLot", nullable = false)
    private int idLot;
	
	@Column(name = "IdBudget", nullable = false)
    private Integer idBudget;
	
	@Column(name = "Exercice", nullable = false)
    private short exercice;
	
	@Column(name = "CodBud", nullable = false)
    private String codBud;
    
    @Column(name = "IdSrceFin", nullable = false)
    private String idSrceFin;
}