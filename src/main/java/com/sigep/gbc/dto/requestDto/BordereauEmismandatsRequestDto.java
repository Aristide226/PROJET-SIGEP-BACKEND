package com.sigep.gbc.dto.requestDto;


import java.util.Date;


import lombok.Data;

@Data
public class BordereauEmismandatsRequestDto {
	private Short gestion;
	private Date journee;
	private Long total;
	private String idLogin;
	private String dossier;
	private Boolean actif;
	private Date dateReception;
	private String userReception;
	private String identiteRecept;
	private Integer idBudget;
}
