package com.sigep.gim.dto.responseDto;

import java.util.Date;

import lombok.Data;

@Data
public class LivreJournalResponseDto {
	private long idJournal;
	private Date dateValide;
	private boolean entree;
	private Long idFiche;
}
