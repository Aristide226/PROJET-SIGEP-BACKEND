package com.sigep.gim.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CodeAccesDto {
	private int idUser;
	private String userName;
	private String motDePasse;
	private boolean etat;
	private int nbreConnect;
	private Integer nbreCpte;
	private Date dateChangement;
	private String mleAgent;
	private char idCodeAccessType;
}
