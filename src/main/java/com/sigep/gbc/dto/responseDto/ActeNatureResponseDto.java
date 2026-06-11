package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class ActeNatureResponseDto {
	private Integer idActe;
	private String acte;
	private String acteTitre;
	private String acteNumComplema;
	private String dernierArticleDebloc;
	private String dernierArticleReam;
	private List<Long> idReamgmtActes;
}
