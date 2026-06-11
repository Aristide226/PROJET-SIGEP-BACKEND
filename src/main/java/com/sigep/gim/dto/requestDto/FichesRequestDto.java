package com.sigep.gim.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class FichesRequestDto {
	private Integer numFiche;
	private Date dateSaisie;
	private Date dateEtat;
	private Long montantFiche;
	private Integer idTypeAcq;
	private String codSourceFin;
	private Boolean affect;
	private Integer idMagasin;
	private Integer codDirect;
	private Integer idService;
	private Integer codProv;
	private String mleAgent;
	private Date dateAffect;
	private Integer codDirectOrigi;
	private Integer idServiceOrigi;
	private Integer codProvOrigi;
	private Integer codeSite;
	private Date dateRetourPossible;
	private Date dateRetourEffective;
	private Short typSortie;
	private Long idFicheH;
	private Integer idSourceFin;
	private int idBudget;
	private String fonctSigna1;
	private String prenomNomSigna1;
	private String titreHonoSigna1;
	private String fonctSigna2;
	private String prenomNomSigna2;
	private String titreHonoSigna2;
	private String fonctSigna3;
	private String prenomNomSigna3;
	private String titreHonoSigna3;
	private Long numBe;
	private String benum;
	private int nbBiens;
	private Date dateEntreSortie;
	private boolean bienEnMagasin;
	private Integer codCategorie;
	private String etat;
	private Long idFourn;
	private String idTypFiche;
}
