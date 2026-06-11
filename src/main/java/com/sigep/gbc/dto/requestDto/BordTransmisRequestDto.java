package com.sigep.gbc.dto.requestDto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BordTransmisRequestDto {
	private Short gestion;
	private String dossier;
	private String expeditaire;
	private String idLogin;
	private Date dateReception;
	private String idLoginRecep;
	private String identiteRecept;
	private Integer idBudget;
	private List<Long> numBesBordTransEng;
	private List<Long> numMandsBordTransMand;
	private List<Long> numMandsBordTransLiq;
	private List<String> idMotifs;
}
