package com.sigep.gbc.view.dto;


import java.util.Date;
import lombok.Data;

@Data
public class BordereauEmismandatsViewDto {
	private String id;
	private Short gestion;
	private short num;
	private Date journee;
	private Long total;
	private Long totalAnterieur;
	private Long totalCumul;
	private String idLogin;
	private String dossier;
	private boolean actif;
	private long montDeduit;
	private Date dateReception;
	private String userReception;
	private String identiteRecept;
	private Integer idBudget;
	private long nombreMand;
}
