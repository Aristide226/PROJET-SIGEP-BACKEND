package com.sigep.gbc.dto.responseDto;


import java.util.Date;
import java.util.List;

import com.sigep.gbc.entity.BordTitreId;

import lombok.Data;

@Data
public class TitreDetailResponseDto {
	private Long idDetailTitre;
	private Long montant;
	private Short gestion;
	private Date date;
	private String reftitre;
	private String idLogin;
	private Date dateEtat;
	private Long numero;
	private Boolean numAuto;
	private String titreSignataire;
	private String numComplema;
	private Date datePec;
	private Boolean receptionne;
	private Date dateValid;
	private Long mle;
	private Integer idBudget;
	private String codBud;
	private String idBordEmis;
	private Long codBord;
	private String etat;
	private Integer idEtatTrans;
	private Integer idApartir;
	private List<BordTitreId> bordTitreIds;
	private List<String> codTitrs;
	private List<Long> idAcomptes;
}
