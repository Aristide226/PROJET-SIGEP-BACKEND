package com.sigep.gbc.dto.requestDto;


import lombok.Data;

@Data
public class ActeNatureRequestDto {
	private String acte;
	private String acteTitre;
	private String acteNumComplema;
	private String dernierArticleDebloc;
	private String dernierArticleReam;
}
