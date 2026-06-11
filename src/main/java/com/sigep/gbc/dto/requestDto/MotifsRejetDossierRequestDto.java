package com.sigep.gbc.dto.requestDto;



import java.util.Date;

import lombok.Data;

@Data
public class MotifsRejetDossierRequestDto {
	private String motifs;
	private Date dateSaisie;
	private Long numBe;
	private Long numMand;
	private Long codLiq;
	private Long idTitre;
	private String userName;
	private Date dateEnreg;
	private boolean actif;
}
