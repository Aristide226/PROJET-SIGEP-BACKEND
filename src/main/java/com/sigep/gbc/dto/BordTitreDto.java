package com.sigep.gbc.dto;


import java.util.Date;


import lombok.Data;

@Data
public class BordTitreDto {
	private String idBord;
	private Long idDetailTitre;
	private Date datePaieRecouv;
	private String observation;
	private Boolean actifSurBord;
}
