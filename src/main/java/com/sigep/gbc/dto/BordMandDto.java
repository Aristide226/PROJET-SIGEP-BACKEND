package com.sigep.gbc.dto;


import java.util.Date;


import lombok.Data;

@Data
public class BordMandDto {
	private String idBord;
	private Long numMand;
	private Date datePaieRecouv;
	private String observation;
	private Boolean actifSurBord;
}
