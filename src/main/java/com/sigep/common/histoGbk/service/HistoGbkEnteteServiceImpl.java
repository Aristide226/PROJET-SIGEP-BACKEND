package com.sigep.common.histoGbk.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.common.histoGbk.dto.requestDto.EnteteRequestDto;
import com.sigep.common.histoGbk.dto.responseDto.EnteteResponseDto;
import com.sigep.common.histoGbk.entity.Entete;
import com.sigep.common.histoGbk.entity.EnteteStructure;
import com.sigep.common.histoGbk.mapper.HistoGbkMapper;
import com.sigep.common.histoGbk.repository.HistoGbkEnteteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoGbkEnteteServiceImpl implements HistoGbkEnteteService {

	private final HistoGbkEnteteRepository repository;
	private final HistoGbkEnteteStructureService esService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public EnteteResponseDto add(EnteteRequestDto enteteRequestDto) {
		Entete entete = new Entete();
		entete.setCodUser(enteteRequestDto.getCodUser());
		entete.setNiveau1(enteteRequestDto.getNiveau1());
		entete.setNiveau2(enteteRequestDto.getNiveau2());
		entete.setNiveau3(enteteRequestDto.getNiveau3());
		entete.setNiveau4(enteteRequestDto.getNiveau4());
		entete.setAbv1(enteteRequestDto.getAbv1());
		entete.setAbv2(enteteRequestDto.getAbv2());
		entete.setAbv3(enteteRequestDto.getAbv3());
		entete.setAbv4(enteteRequestDto.getAbv4());
		entete.setComplementNum(enteteRequestDto.getComplementNum());
		if (enteteRequestDto.getAbrevEpe() == null) {
			throw new IllegalArgumentException("Entete need a EnteteStruture");
		}
		EnteteStructure enteteStructure = esService.get(enteteRequestDto.getAbrevEpe());
		entete.setEnteteStructure(enteteStructure);
		
		repository.save(entete);
		return HistoGbkMapper.eToeResponseDto(entete);
	}

	@Override
	public List<EnteteResponseDto> getAll() {
		List<Entete> entetes = repository.findAll();
		return entetes
				.stream().map(element  -> HistoGbkMapper.eToeResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public Entete get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Entete with id: " + id + " could not be found"));
	}

	@Override
	public EnteteResponseDto getById(String id) {
		Entete entete = get(id);
		return HistoGbkMapper.eToeResponseDto(entete);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public EnteteResponseDto delete(String id) {
		Entete entete = get(id);
		repository.delete(entete);
		return HistoGbkMapper.eToeResponseDto(entete);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public EnteteResponseDto edit(String id, EnteteRequestDto enteteRequestDto) {
		Entete entete = get(id);
		entete.setNiveau1(enteteRequestDto.getNiveau1());
		entete.setNiveau2(enteteRequestDto.getNiveau2());
		entete.setNiveau3(enteteRequestDto.getNiveau3());
		entete.setNiveau4(enteteRequestDto.getNiveau4());
		entete.setAbv1(enteteRequestDto.getAbv1());
		entete.setAbv2(enteteRequestDto.getAbv2());
		entete.setAbv3(enteteRequestDto.getAbv3());
		entete.setAbv4(enteteRequestDto.getAbv4());
		entete.setComplementNum(enteteRequestDto.getComplementNum());
		if (enteteRequestDto.getAbrevEpe() != null) {
			EnteteStructure enteteStructure = esService.get(enteteRequestDto.getAbrevEpe());
			entete.setEnteteStructure(enteteStructure);
		}
		
		return HistoGbkMapper.eToeResponseDto(entete);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public EnteteResponseDto addEsToE(String eId, String esId) {
		Entete entete = get(eId);
		EnteteStructure enteteStructure = esService.get(esId);
		if (Objects.nonNull(entete.getEnteteStructure())) {
			throw new IllegalArgumentException("Entete already have a EnteteStructure");
		}
		entete.setEnteteStructure(enteteStructure);
		return HistoGbkMapper.eToeResponseDto(entete);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public EnteteResponseDto removeEsFromE(String eId) {
		Entete entete = get(eId);
		entete.setEnteteStructure(null);
		return HistoGbkMapper.eToeResponseDto(entete);
	}

}
