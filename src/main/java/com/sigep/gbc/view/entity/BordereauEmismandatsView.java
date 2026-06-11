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
public class BordereauEmismandatsView {

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	private String id;
	
	@Column(name = "Gestion")
	private Short gestion;
	
	@Column(name = "Num", nullable = false)
	private short num;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Journee", length = 23)
	private Date journee;
	
	@Column(name = "Total", precision = 18, scale = 0)
	private Long total;
	
	@Column(name = "TotalAnterieur", precision = 18, scale = 0)
	private Long totalAnterieur;
	
	@Column(name = "TotalCumul", precision = 18, scale = 0)
	private Long totalCumul;
	
	@Column(name = "IdLogin", nullable = false, length = 5)
	private String idLogin;
	
	@Column(name = "Dossier", nullable = false, length = 1)
	private String dossier;
	
	@Column(name = "Actif", nullable = false)
	private boolean actif;
	
	@Column(name = "MontDeduit", nullable = false, precision = 18, scale = 0)
	private long montDeduit;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateReception", length = 23)
	private Date dateReception;
	
	@Column(name = "UserReception", length = 5)
	private String userReception;
	
	@Column(name = "IdentiteRecept", length = 150)
	private String identiteRecept;
	
	@Column(name = "IdBudget", nullable = false)
	private Integer idBudget;
	
	@Column(name = "NombreMand")
	private long nombreMand;
}
