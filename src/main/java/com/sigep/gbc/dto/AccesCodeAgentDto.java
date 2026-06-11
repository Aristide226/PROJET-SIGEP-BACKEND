package com.sigep.gbc.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccesCodeAgentDto {
	private String userName;
	private String motPasse;
	private String motDePasse;
	private String statu;
	private Date dateChangement;
	private Short nbreDeFois;
	private Integer rangCod;
	private Integer id;
	private Date dateCreat;
	private String code;
	private String grpe;
	private Long mle;
	private String nom;
	private String prenom;
	private char sexe;
	private String signataire;
	private String titreHonoSign;
	private Integer idService;
}
