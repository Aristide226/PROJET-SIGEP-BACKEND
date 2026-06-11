package com.sigep.gbc.dto.requestDto;


import java.util.Date;

import lombok.Data;

@Data
public class PpmActeRequestDto {
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
}
