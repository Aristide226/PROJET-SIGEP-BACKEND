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
public class LiquidationsPourCreationEngagementView {
	
	@Id
	@Column(name = "CodLiq", unique = true, nullable = false, precision = 18, scale = 0)
	private long codLiq;
	
	@Column(name = "Gestion", nullable = false)
	private short gestion;
	
	@Column(name = "NumBL", nullable = false)
	private int numBl;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateLiq", nullable = false, length = 23)
	private Date dateLiq;
	
	@Column(name = "Objet", nullable = false)
	private String objet;
	
	@Column(name = "Montant", nullable = false, precision = 18, scale = 0)
	private long montant;

	@Column(name = "MontEngage", nullable = false, precision = 18, scale = 0)
	private long montEngage;
	
	@Column(name = "MontDjaLiq", nullable = false, precision = 18, scale = 0)
	private long montDjaLiq;
	
	@Column(name = "Modifiable", nullable = false)
	private boolean modifiable;
	
	@Column(name = "IdUser", nullable = false, length = 7)
	private String idUser;
	
	@Column(name = "NumeroDemande")
	private String numeroDemande;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateModif", nullable = false, length = 23)
	private Date dateModif;
	
	@Column(name = "Actif", nullable = false)
	private boolean actif;
	
	@Column(name = "IdBudget", nullable = false)
	private int idBudget;
	
	@Column(name = "CompteFourn")
	private String compteFourn;
	
	@Column(name = "idContrat")
	private Long idContrat;
	
	@Column(name = "NumBE")
	private Long numBe;
	
	@Column(name = "idFourn", nullable = false)
	private long idFourn;
	
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
}
