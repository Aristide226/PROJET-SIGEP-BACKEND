package com.sigep.gbc.dto.responseDto;



import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MotifsRejetDossierResponseDto {
	private String idMotif;
	private String motifs;
	private Date dateSaisie;
	private Long numBe;
	private Long numMand;
	private Long codLiq;
	private Long idTitre;
	private String userName;
	private Date dateEnreg;
	private boolean actif;
	private List<Long> codBords;
}
