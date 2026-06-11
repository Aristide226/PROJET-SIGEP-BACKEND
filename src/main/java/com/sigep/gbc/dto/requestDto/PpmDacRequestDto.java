package com.sigep.gbc.dto.requestDto;


import java.util.Date;


import lombok.Data;

@Data
public class PpmDacRequestDto {
	private String refPassation;
	private Date dateCreation;
	private Date dateDac;
	private Date dateLancement;
	private String idPpm;
}
