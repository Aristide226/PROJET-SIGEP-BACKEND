package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.PieceJustifRequestDto;
import com.sigep.gbc.dto.responseDto.PieceJustifResponseDto;
import com.sigep.gbc.entity.PieceJustif;


@Service
public interface PieceJustifService {
	public PieceJustifResponseDto add(PieceJustifRequestDto pieceJustifRequestDto);
	public List<PieceJustifResponseDto> getAll();
	public PieceJustif get(String id);
	public PieceJustifResponseDto getById(String id);
	public PieceJustifResponseDto delete(String id);
	public List<PieceJustifResponseDto> deleteByNumBe(Long numBe);
	public List<PieceJustifResponseDto> deleteByCodLiq(Long codLiq);
	public List<PieceJustifResponseDto> deleteByNumMand(Long numMand);
	public PieceJustifResponseDto edit(String id, PieceJustifRequestDto pieceJustifRequestDto);
	public Boolean addPiecesJustificatives(Long numBe, List<PieceJustifRequestDto> pieceJustifRequestDtos);
	public List<PieceJustifResponseDto> getByNumBeOrderByPieceJustificative(Long numBe);
	public Boolean addPiecesJustificativesRDL(Long codLiq, List<PieceJustifRequestDto> pieceJustifRequestDtos);
	public List<PieceJustifResponseDto> getByCodLiqOrderByPieceJustificative(Long codLiq);
	public Boolean addPiecesJustificativesLiquidation(Long numMand, List<PieceJustifRequestDto> pieceJustifRequestDtos);
	public List<PieceJustifResponseDto> getByNumMandOrderByPieceJustificative(Long numMand);
	

}
