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
public class AccesLigneBudgetaireNomenclatureDBudgetView {
	
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
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "NumNo", nullable = false)
	private String numNo;
	
	@Column(name = "IdBudget", nullable = false)
	private int idBudget;
	
	@Column(name = "IdPlan", nullable = false)
	private String idPlan;
	
	@Column(name = "UserName")
	private String userName;
	
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
	
	@Column(name = "Dot_Est_Exec", nullable = false)
	private Boolean dotEstExec;
	
	@Column(name = "CodHierarchiq")
	private String codHierarchiq;
}
