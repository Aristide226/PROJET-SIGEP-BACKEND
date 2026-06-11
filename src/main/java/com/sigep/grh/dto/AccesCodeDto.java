package com.sigep.grh.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AccesCodeDto {
	private String userName;
	private String motPasse;
	private String motDePasse;
	private String statu;
	private Date dateChangement;
	private Short nbreDeFois;
	private Integer rangCod;
	private Integer id;
	private String code;
	private String grpe;
	private Integer mle;
}
