package com.sigep.gbc.view.dto;


import java.util.Date;


import lombok.Data;

@Data
public class AgentAccesCodeAccesCodeNiveauGrpeCodeViewDto {
	private String userName;
	private String motDePasse;
	private String statu;
	private Date dateChangement;
	private Short nbreDeFois;
	private Integer rangCod;
	private Integer id;
	private Date dateCreat;
	private String code;
	private String intituleCode;
	private String grpe;
	private long mle;
	private String nom;
	private String prenom;
	private char sexe;
	private String signataire;
	private String titreHonoSign;
	private boolean actif;
	private int idService;
	private String libelleGrpe;

}
