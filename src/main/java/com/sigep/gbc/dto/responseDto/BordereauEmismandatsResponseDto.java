package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.BordMandId;
import com.sigep.gbc.entity.BordTitreId;

import lombok.Data;

@Data
public class BordereauEmismandatsResponseDto {
	private String id;
	private Short gestion;
	private Short num;
	private Date journee;
	private Long total;
	private Long totalAnterieur;
	private Long totalCumul;
	private String idLogin;
	private String dossier;
	private Boolean actif;
	private Long montDeduit;
	private Date dateReception;
	private String userReception;
	private String identiteRecept;
	private Integer idBudget;
	private List<Long> numMands;
	private List<BordTitreId> bordTitreIds;
	private List<BordMandId> bordMandIds;
	private List<Long> idDetailTitres;
}
