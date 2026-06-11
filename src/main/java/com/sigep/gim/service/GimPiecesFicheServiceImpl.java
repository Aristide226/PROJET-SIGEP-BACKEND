package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PiecesFicheRequestDto;
import com.sigep.gim.dto.responseDto.PiecesFicheResponseDto;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.Pieces;
import com.sigep.gim.entity.PiecesFiche;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimPiecesFicheRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimPiecesFicheServiceImpl implements GimPiecesFicheService {
	
	private final GimPiecesFicheRepository repository;
	private final GimPiecesService gimPiecesService;
	private final GimFichesService gimFichesService;
	
	@Override
	@Transactional
	public PiecesFicheResponseDto add(PiecesFicheRequestDto piecesFicheRequestDto) {
		PiecesFiche entity = new PiecesFiche();
		entity.setRefPiece(piecesFicheRequestDto.getRefPiece());
		entity.setDatePiece(piecesFicheRequestDto.getDatePiece());
		
		if(piecesFicheRequestDto.getIdPieces() == null) {
			throw new IllegalArgumentException("PiecesFiche need a Pieces");
		}
		Pieces pieces = gimPiecesService.get(piecesFicheRequestDto.getIdPieces());
		entity.setPieces(pieces);
		
		if(piecesFicheRequestDto.getIdFiche() == null) {
			throw new IllegalArgumentException("PiecesFiche need a Fiches");
		}
		Fiches fiches = gimFichesService.get(piecesFicheRequestDto.getIdFiche());
		entity.setFiches(fiches);
		
		repository.save(entity);
		return GimMapper.PiecesFicheToPiecesFicheResponseDto(entity);
	}
	
	@Override
	public List<PiecesFicheResponseDto> getAll() {
		List<PiecesFiche> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.PiecesFicheToPiecesFicheResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public PiecesFiche get(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("PiecesFiche with id "+id+"could not be found")
		);
	}
	
	@Override
	public PiecesFicheResponseDto getById(long id) {
		PiecesFiche entity = get(id);
		return GimMapper.PiecesFicheToPiecesFicheResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PiecesFicheResponseDto delete(long id) {
		PiecesFiche entity = get(id);
		repository.delete(entity);
		return GimMapper.PiecesFicheToPiecesFicheResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PiecesFicheResponseDto edit(long id,PiecesFicheRequestDto piecesFicheRequestDto) {
		PiecesFiche entity = get(id);
		entity.setRefPiece(piecesFicheRequestDto.getRefPiece());
		entity.setDatePiece(piecesFicheRequestDto.getDatePiece());
		
		if(piecesFicheRequestDto.getIdPieces() != null) {
			Pieces pieces = gimPiecesService.get(piecesFicheRequestDto.getIdPieces());
			entity.setPieces(pieces);
		}
		
		if(piecesFicheRequestDto.getIdFiche() != null) {
			Fiches fiches = gimFichesService.get(piecesFicheRequestDto.getIdFiche());
			entity.setFiches(fiches);
		}
		
		return GimMapper.PiecesFicheToPiecesFicheResponseDto(entity);
	}
}
