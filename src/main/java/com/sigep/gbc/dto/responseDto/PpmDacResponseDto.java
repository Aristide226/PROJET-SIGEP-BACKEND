package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;


import lombok.Data;

@Data
public class PpmDacResponseDto {
	private String idDac;
	private String refPassation;
	private Date dateCreation;
	private Date dateDac;
	private Date dateLancement;
	private String idPpm;
	private List<Long> idContrats;
}
