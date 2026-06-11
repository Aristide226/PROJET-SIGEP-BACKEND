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
public class FournisseursView {
	
	@Id
	@Column(name = "IdFourn", unique = true, nullable = false, precision = 18, scale = 0)
	private long idFourn;
	
	@Column(name = "RaisonSociale")
	private String raisonSociale;
	
	@Column(name = "BP")
	private String bp;
	
	@Column(name = "Profession", length = 250)
	private String profession;
	
	@Column(name = "Telephone")
	private String telephone;
	
	@Column(name = "IFUMle", length = 50)
	private String ifumle;
	
	@Column(name = "fType", nullable = false, length = 1)
	private String ftype;
	
	@Column(name = "ContactTel", length = 150)
	private String contactTel;
	
	@Column(name = "ContactEmail", length = 150)
	private String contactEmail;
	
	@Column(name = "NbreCompteDestinataire")
	private long nbreCompteDestinataire;
	
	@Column(name = "OccurenceFournisseurDansEngagement")
	private long occurenceFournisseurDansEngagement;
	
	@Column(name = "OccurenceFournisseurDansPPM_EXEC")
	private long cccurenceFournisseurDansPPM_EXEC;
}
