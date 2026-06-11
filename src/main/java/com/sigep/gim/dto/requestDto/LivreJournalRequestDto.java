package com.sigep.gim.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class LivreJournalRequestDto {
	private Date dateValide;
	private boolean entree;
	private Long idFiche;
}
