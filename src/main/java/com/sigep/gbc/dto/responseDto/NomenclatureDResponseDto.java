package com.sigep.gbc.dto.responseDto;


import lombok.Data;

@Data
public class NomenclatureDResponseDto {
	private String numNo;
	private String titre;
	private String section;
	private String chap;
	private String art;
	private String parag;
	private String rub;
	private String intitule;
	private String idPlan;
	private Boolean dotEstExec;
	private String codHierarchiq;
}
