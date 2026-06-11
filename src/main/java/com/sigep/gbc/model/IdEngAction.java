package com.sigep.gbc.model;


import com.sigep.gbc.dto.requestDto.MotifsRejetDossierRequestDto;

import lombok.Data;

@Data
public class IdEngAction {
	private Long idEng;
	private String action;
	private MotifsRejetDossierRequestDto motifsRejetDossierRequestDto;
}
