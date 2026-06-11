package com.sigep.gbc.view.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LignesModifieesDepensesPourValidationReamenagementView {
	
	@Id
	@Column(name = "CodBud", unique = true, nullable = false)
	private String codBud;
	
	@Column(name = "Intitule")
	private String intitule;
	
	@Column(name = "DotInitiale", nullable = false, precision = 18, scale = 0)
	private long dotInitiale;
	
	@Column(name = "CAajout", nullable = false, precision = 18, scale = 0)
	private long caajout;
	
	@Column(name = "CAannul", nullable = false, precision = 18, scale = 0)
	private long caannul;
	
	@Column(name = "Ream", nullable = false, precision = 18, scale = 0)
	private long ream;
	
	@Column(name = "TotalEngag", nullable = false, precision = 18, scale = 0)
	private long totalEngag;
	
	@Column(name = "DotN1", precision = 18, scale = 0)
	private Long dotN1;
	
	@Column(name = "ExecN1", precision = 18, scale = 0)
	private Long execN1;
	
	@Column(name = "DotN2", precision = 18, scale = 0)
	private Long dotN2;
	
	@Column(name = "ExecN2", precision = 18, scale = 0)
	private Long execN2;
	
	@Column(name = "DotN3", precision = 18, scale = 0)
	private Long dotN3;
	
	@Column(name = "ExecN3", precision = 18, scale = 0)
	private Long execN3;
	
	@Column(name = "CodReam")
	private Long codReam;
	
	@Column(name = "Ouvert")
	private Long ouvert;
	
	@Column(name = "Annule")
	private Long annule;
	
	@Column(name = "Nouvelle")
	private Boolean nouvelle;
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "NumNo", nullable = false)
	private String numNo;
	
	@Column(name = "IdBudget", nullable = false)
	private int idBudget;
	
	@Column(name = "IdPlan", nullable = false)
	private String idPlan;
	
	@Column(name = "DotationCorrigee")
	private Long dotationCorrigee;
	
	@Column(name = "DotationDefinitive")
	private Long dotationDefinitive;
}
