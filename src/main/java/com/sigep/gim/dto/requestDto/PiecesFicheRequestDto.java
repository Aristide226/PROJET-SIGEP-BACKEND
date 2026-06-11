package com.sigep.gim.dto.requestDto;

import java.util.Date;

import lombok.Data;

@Data
public class PiecesFicheRequestDto {
	private String refPiece;
	private Date datePiece;
	private Long idPieces;
	private Long idFiche;
}
