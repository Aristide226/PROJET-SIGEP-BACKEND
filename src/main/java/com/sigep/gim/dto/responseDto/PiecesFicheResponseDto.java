package com.sigep.gim.dto.responseDto;

import java.util.Date;

import lombok.Data;

@Data
public class PiecesFicheResponseDto {
	private long idPieceFiche;
	private String refPiece;
	private Date datePiece;
	private Long idPieces;
	private Long idFiche;
}
