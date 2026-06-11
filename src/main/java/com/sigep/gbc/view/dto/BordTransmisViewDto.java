package com.sigep.gbc.view.dto;

import java.util.Date;
import lombok.Data;;

@Data
public class BordTransmisViewDto {
	private long codBord;
	private short gestion;
	private String dossier;
	private Date dateCreation;
	private String expeditaire;
	private String destinataire;
	private String idLogin;
	private Date dateReception;
	private String idLoginRecep;
	private Integer numero;
	private String bordNumero;
	private Integer idBudget;
	private String identiteRecept;
	private long nombreEng;
}
