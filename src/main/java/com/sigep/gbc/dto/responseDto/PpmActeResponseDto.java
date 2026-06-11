package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.PpmBudgOldId;
import com.sigep.gbc.entity.PpmOldId;

import lombok.Data;

@Data
public class PpmActeResponseDto {
	private String idPpmM;
	private Short gestion;
	private Integer quantieme;
	private Date dateModif;
	private String motifModif;
	private String acteAutorisation;
	private Date dateCreate;
	private String userCreate;
	private Date dateUpdate;
	private String userUpdate;
	private Boolean valide;
	private String userValide;
	private Date dateValide;
	private String idPpmMMP;
	private Integer idBudget;
	private List<PpmOldId> ppmOldIds;
	private List<PpmBudgOldId> ppmBudgOldIds;
	private List<String> idPpmMs;
	private List<String> idPpms;
}
