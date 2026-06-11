package com.sigep.common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AccesCodeDtoForGrh {
	private String userName;
	private String motDePasse;
	private String statu;
	private Date dateChangement;
	private Short nbreDeFois;
	private Integer rangCod;
	private Integer id;
	private String code;
	private String grpe;
	private Long mle;
}
