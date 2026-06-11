package com.sigep.gim.dto.requestDto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class SitesRequestDto {
	private String nomSite;
	private String secteurCadastre;
	private String sectionCadastre;
	private String lotCadastre;
	private String parcelleCadastre;
	private String autresPrecision;
	private Date dateCreation;
	private BigDecimal superficie;
	private Long coutTerrain;
	private Integer idTypeAcq;
	private Integer nombreMaterielH;
	private Integer nbreBatimentH;
	private Integer nbreUe;
	private Integer nbreAutreInfras;
	private String articleSite;
	private Integer idDepart;
}
