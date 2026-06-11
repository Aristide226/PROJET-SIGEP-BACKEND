//Aristide
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
public class DepensesLignesBudgetaireEnFonctionDePpmView {
	
	@Id
	@Column(name = "CodBud", nullable = false)
	private String codBud;
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "NumNo", nullable = false)
	private String numNo;
	
	@Column(name= "idPlan", nullable = false)
	private String idPlan;
	
	@Column(name = "intitule")
	private String intitule;
	
	@Column(name = "DotInitiale", nullable = false, precision = 18, scale = 0)
	private long dotInitiale;
	
	@Column(name = "Caajout", nullable= false, precision = 18, scale = 0)
	private long caajout;
	
	@Column(name = "Caannul", nullable = false, precision = 18, scale = 0)
	private long caanul;
	
	@Column(name = "Ream", nullable = false, precision = 18 ,scale = 0)
	private long ream;
	
	@Column(name = "TotalEngag", nullable = false, precision =18, scale = 0)
	private long totalEngag;
	
	@Column(name = "IdBudget", nullable = false)
	private int idBudget;
	
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
	
	@Column(name = "Disponible", precision = 18, scale = 0)
	private long disponible;
	
	@Column(name = "IdPPM", nullable = false)
	private String idPPM;
	
	@Column(name = "IdSrceFin", nullable = false)
	private int idSrceFin;
	
	@Column(name = "DisponibleASaisir", precision = 18, scale = 0)
	private Long disponibleASaisir;
	
	@Column(name = "DejaSaisi", precision = 18, scale = 0)
	private Long dejaSaisi;
	
	@Column(name = "IntituleCourt", nullable = false)
	private String intituleCourt;
	
	@Column(name = "Cod5", nullable = false)
	private String cod5;
	
}
