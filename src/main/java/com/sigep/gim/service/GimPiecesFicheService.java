package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PiecesFicheRequestDto;
import com.sigep.gim.dto.responseDto.PiecesFicheResponseDto;
import com.sigep.gim.entity.PiecesFiche;

@Service
public interface GimPiecesFicheService {
	public PiecesFicheResponseDto add(PiecesFicheRequestDto piecesFicheRequestDto);
	public List<PiecesFicheResponseDto> getAll();
	public PiecesFiche get(long id);
	public PiecesFicheResponseDto getById(long id);
	public PiecesFicheResponseDto delete(long id);
	public PiecesFicheResponseDto edit(long id, PiecesFicheRequestDto piecesFicheRequestDto);
}