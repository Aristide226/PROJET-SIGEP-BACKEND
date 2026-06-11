package com.sigep.gbc.view.entity;


import java.util.Date;


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
public class AgentAccesCodeAccesCodeNiveauGrpeCodeView {
	
	@Id
	@Column(name = "UserName", unique = true, nullable = false, length = 5)
	private String userName;
	
	@Column(name = "MotDePasse", nullable = false, length = 256)
	private String motDePasse;
	
	@Column(name = "Statu")
	private String statu;
	
	@Column(name = "DateChangement", length = 16)
	private Date dateChangement;
	
	@Column(name = "NbreDeFois")
	private Short nbreDeFois;
	
	@Column(name = "rangCod")
	private Integer rangCod;
	
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DateCreat", nullable = false, length = 23)
	private Date dateCreat;
	
	@Column(name = "Code")
	private String code;
	
	@Column(name = "IntituleCode")
	private String intituleCode;
	
	@Column(name = "Grpe")
	private String grpe;
	
	@Column(name = "Mle", unique = true, nullable = false, precision = 18, scale = 0, insertable=false, updatable=false)
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
	private int idService;
	
	@Column(name = "LibelleGrpe")
	private String libelleGrpe;

}
