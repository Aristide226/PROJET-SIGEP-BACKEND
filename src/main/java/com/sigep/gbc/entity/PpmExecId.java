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
public class PpmExecId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "IdPPMExe", nullable = false, length = 128)
	private int idPpmExec;
	
	@Column(name = "IdLot", nullable = false)
	private int idLot;
	
	@Column(name = "IdBudget", nullable = false)
	private  Integer idBudget;
	
	@Column(name = "Exercice", nullable = false)
	private short exercice;
}
