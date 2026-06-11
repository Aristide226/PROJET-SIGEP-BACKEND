package com.sigep.gim.dto.responseDto;

import java.util.Date;

import lombok.Data;

@Data
public class PatrimoineSortieResponseDto {
	private Long idFiche;
	private String mle;
	private Long valeurAffectation;
	private String observ;
	private Boolean temporaire;
	private Date dateRetourPossible;
	private Date dateRetourEffective;
	private String etatRetour;
	private String observRetour;
	private Long idFicheH;
	private String statPatriH;
	private String mleAffectH;
	private Integer idMagasinH;
	private Integer codeSite;
	private Integer codDirectH;
	private Integer codServiceH;
	private Integer codProvH;
	private String etatActuelH;
	private Long idInventH;
	private Long idFicheRetour;
	private String etatB;
}
