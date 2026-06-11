package com.sigep.gbc.dto.responseDto;


import java.util.Date;

import lombok.Data;

@Data
public class PieceJustifResponseDto {
	private String codPj;
	private Long numBe;
	private Long codLiq;
	private Long numMand;
	private String pieceJustificative;
	private String numero;
	private Date datePj;
	private Long montant;
	private String idRetenu;
	private Long idBord;
}
