package com.sigep.gbc.dto.responseDto;

import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.BordTransRecouvId;

import lombok.Data;

@Data
public class BordTransmisResponseDto {
	private Long codBord;
	private Short gestion;
	private String dossier;
	private Date dateCreation;
	private String expeditaire;
	private String destinataire;
	private String idLogin;
	private Date dateReception;
	private String idLoginRecep;
	private Integer numero;
	private String bordNumero;
	private String identiteRecept;
	private Integer idBudget;
	private List<Long> numBesBordTransEng;
	private List<Long> numMandsBordTransMand;
	private List<Long> numMandsBordTransLiq;
	private List<String> idMotifs;
	private List<Long> idDetailTitres;
	private List<Long> numBes;
	private List<Long> numMands;
	private List<BordTransRecouvId> bordTransRecouvIds;
}
