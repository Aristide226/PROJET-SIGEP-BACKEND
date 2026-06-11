package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PieceJustifRequestDto;
import com.sigep.gbc.dto.responseDto.PieceJustifResponseDto;
import com.sigep.gbc.entity.PieceJustif;
import com.sigep.gbc.repository.PieceJustifRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PieceJustifServiceImpl implements PieceJustifService {
	
	private final PieceJustifRepository repository;

	@Override
	@Transactional("gbcTransactionManager")
	public PieceJustifResponseDto add(PieceJustifRequestDto pieceJustifRequestDto) {
		PieceJustif entity = new PieceJustif();
		entity.setNumBe(pieceJustifRequestDto.getNumBe());
		entity.setCodLiq(pieceJustifRequestDto.getCodLiq());
		entity.setNumMand(pieceJustifRequestDto.getNumMand());
		entity.setPieceJustificative(pieceJustifRequestDto.getPieceJustificative());
		entity.setNumero(pieceJustifRequestDto.getNumero());
		entity.setDatePj(pieceJustifRequestDto.getDatePj());
		entity.setMontant(pieceJustifRequestDto.getMontant());
		entity.setIdRetenu(pieceJustifRequestDto.getIdRetenu());
		entity.setIdBord(pieceJustifRequestDto.getIdBord());
		
		repository.save(entity);
		return GbcMapper2.pieceJustifToPieceJustfiResponseDto(entity);
	}

	@Override
	public List<PieceJustifResponseDto> getAll() {
		List<PieceJustif> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.pieceJustifToPieceJustfiResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public PieceJustif get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PieceJustif with id: " + id + " could not be found"));
	}

	@Override
	public PieceJustifResponseDto getById(String id) {
		PieceJustif entity = get(id);
		return GbcMapper2.pieceJustifToPieceJustfiResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PieceJustifResponseDto delete(String id) {
		PieceJustif entity = get(id);
		repository.delete(entity);
		return GbcMapper2.pieceJustifToPieceJustfiResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public PieceJustifResponseDto edit(String id, PieceJustifRequestDto pieceJustifRequestDto) {
		PieceJustif entity = get(id);
		entity.setNumBe(pieceJustifRequestDto.getNumBe());
		entity.setCodLiq(pieceJustifRequestDto.getCodLiq());
		entity.setNumMand(pieceJustifRequestDto.getNumMand());
		entity.setPieceJustificative(pieceJustifRequestDto.getPieceJustificative());
		entity.setNumero(pieceJustifRequestDto.getNumero());
		entity.setDatePj(pieceJustifRequestDto.getDatePj());
		entity.setMontant(pieceJustifRequestDto.getMontant());
		entity.setIdRetenu(pieceJustifRequestDto.getIdRetenu());
		entity.setIdBord(pieceJustifRequestDto.getIdBord());
		return GbcMapper2.pieceJustifToPieceJustfiResponseDto(entity);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public Boolean addPiecesJustificatives(Long numBe, List<PieceJustifRequestDto> pieceJustifRequestDtos) {
		try {
			List<PieceJustif> list = repository.deleteByNumBe(numBe);
			for (PieceJustifRequestDto pieceJustifRequestDto : pieceJustifRequestDtos) {
				add(pieceJustifRequestDto);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PieceJustifResponseDto> getByNumBeOrderByPieceJustificative(Long numBe) {
		List<PieceJustif> list = repository.getByNumBeOrderByPieceJustificative(numBe);
		return list
				.stream().map(element  -> GbcMapper2.pieceJustifToPieceJustfiResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional("gbcTransactionManager")
	public List<PieceJustifResponseDto> deleteByNumBe(Long numBe) {
		List<PieceJustif> list = repository.deleteByNumBe(numBe);
		return list
				.stream().map(element  -> GbcMapper2.pieceJustifToPieceJustfiResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public List<PieceJustifResponseDto> deleteByCodLiq(Long codLiq) {
		List<PieceJustif> list = repository.deleteByCodLiq(codLiq);
		return list
				.stream().map(element  -> GbcMapper2.pieceJustifToPieceJustfiResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public List<PieceJustifResponseDto> deleteByNumMand(Long numMand) {
		List<PieceJustif> list = repository.deleteByNumMand(numMand);
		return list
				.stream().map(element  -> GbcMapper2.pieceJustifToPieceJustfiResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean addPiecesJustificativesRDL(Long codLiq, List<PieceJustifRequestDto> pieceJustifRequestDtos) {
		try {
			List<PieceJustif> list = repository.deleteByCodLiq(codLiq);
			for (PieceJustifRequestDto pieceJustifRequestDto : pieceJustifRequestDtos) {
				add(pieceJustifRequestDto);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<PieceJustifResponseDto> getByCodLiqOrderByPieceJustificative(Long codLiq) {
		List<PieceJustif> list = repository.getByCodLiqOrderByPieceJustificative(codLiq);
		return list
				.stream().map(element  -> GbcMapper2.pieceJustifToPieceJustfiResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public Boolean addPiecesJustificativesLiquidation(Long numMand, List<PieceJustifRequestDto> pieceJustifRequestDtos) {
		try {
			List<PieceJustif> list = repository.deleteByNumMand(numMand);
			for (PieceJustifRequestDto pieceJustifRequestDto : pieceJustifRequestDtos) {
				add(pieceJustifRequestDto);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<PieceJustifResponseDto> getByNumMandOrderByPieceJustificative(Long numMand) {
		List<PieceJustif> list = repository.getByNumMandOrderByPieceJustificative(numMand);
		return list
				.stream().map(element  -> GbcMapper2.pieceJustifToPieceJustfiResponseDto(element))
				.collect(Collectors.toList());
	}
}
