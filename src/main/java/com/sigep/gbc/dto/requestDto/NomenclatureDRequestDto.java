package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class NomenclatureDRequestDto {
	private String titre;
	private String section;
	private String chap;
	private String art;
	private String parag;
	private String rub;
	private String intitule;
	private Boolean dotEstExec;
}
