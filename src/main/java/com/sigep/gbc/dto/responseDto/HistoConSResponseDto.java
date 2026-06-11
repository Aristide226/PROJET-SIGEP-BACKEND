package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.HistoActionSId;

import lombok.Data;

@Data
public class HistoConSResponseDto {
	private String codH;
	private String idl;
	private Date dateConnexion;
	private String pc;
	private String adressMac;
	private List<HistoActionSId> histoActionSIds;
}
