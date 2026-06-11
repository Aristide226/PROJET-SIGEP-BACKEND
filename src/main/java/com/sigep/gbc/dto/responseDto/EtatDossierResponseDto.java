package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class EtatDossierResponseDto {
	private String etat;
	private String libEtat;
	private Boolean avecMotifR;
	private List<String> codRecouvs;
	private List<Long> numBes;
	private List<Long> idDetailTitres;
	private List<Long> numMandsByEtats;
	private List<Long> numMandsByEtatBls;
	private List<Long> idompteMouvements;
}
