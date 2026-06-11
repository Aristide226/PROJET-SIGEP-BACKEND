package com.sigep.gbc.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoActionSHistoConSDto {
	private Date dateAct;
	private String codH;
	private String action;
	private String idl;
	private Date dateConnexion;
	private String pc;
	private String adressMac;
}
