package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PiecesRequestDto;
import com.sigep.gim.dto.responseDto.PiecesResponseDto;
import com.sigep.gim.entity.Pieces;

@Service
public interface GimPiecesService {
	public PiecesResponseDto add(PiecesRequestDto piecesRequestDto);
	public List<PiecesResponseDto> getAll();
	public Pieces get(long id);
	public PiecesResponseDto getById(long id);
	public PiecesResponseDto delete(long id);
	public PiecesResponseDto edit(long id, PiecesRequestDto piecesRequestDto);
}