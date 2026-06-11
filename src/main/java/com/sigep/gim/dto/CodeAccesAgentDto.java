package com.sigep.gim.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeAccesAgentDto {
	private int idUser;
	private String userName;
	private String motDePasse;
	private boolean etat;
	private int nbreConnect;
	private Integer nbreCpte;
	private Date dateChangement;
	private String mleAgent;
	private char idCodeAccessType;
	private String nom;
	private String prenom;
	private String sexe;
	private String fonctActuelle;
	private String titreHono;
	private int codDirect;
}
