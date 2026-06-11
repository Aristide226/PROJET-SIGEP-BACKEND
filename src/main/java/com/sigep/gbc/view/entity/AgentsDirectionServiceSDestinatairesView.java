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
public class AgentsDirectionServiceSDestinatairesView {
	
	@Id
	@Column(name = "Mle", unique = true, nullable = false, precision = 18, scale = 0)
	private long mle;
	
	@Column(name = "Nom")
	private String nom;
	
	@Column(name = "Prenom")
	private String prenom;
	
	@Column(name = "Sexe", nullable = false, length = 1)
	private char sexe;
	
	@Column(name = "Signataire")
	private String signataire;
	
	@Column(name = "TitreHonoSign")
	private String titreHonoSign;
	
	@Column(name = "Actif", nullable = false)
	private boolean actif;
	
	@Column(name = "IdService")
	private Integer idService;
	
	@Column(name = "libelle", nullable = false, length = 250)
	private String libelle;
	
	@Column(name = "abrev", length = 10)
	private String abrev;
	
	@Column(name = "idHerachique", nullable = false, length = 150)
	private String idHerachique;
	
	@Column(name = "idNiveau", nullable = false)
	private Integer idNiveau;
	
	@Column(name = "codStruct", nullable = false)
	private String codStruct;
	
	@Column(name = "idParent")
	private Integer idParent;
	
	@Column(name = "IFUMle", length = 50)
	private String ifumle;
	
	@Column(name = "fType", nullable = false, length = 1)
	private String ftype;
	
	@Column(name = "ContactTel", length = 150)
	private String contactTel;
	
	@Column(name = "ContactEmail", length = 150)
	private String contactEmail;
}
