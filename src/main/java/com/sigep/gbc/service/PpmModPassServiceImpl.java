package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.PpmModPassRequestDto;
import com.sigep.gbc.dto.responseDto.PpmModPassResponseDto;
import com.sigep.gbc.entity.CodModPass;
import com.sigep.gbc.entity.PpmModePass;
import com.sigep.gbc.repository.PpmModePassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PpmModPassServiceImpl implements PpmModPassService{
	
	private final PpmModePassRepository repository;
	private final CodModPassService codModPassService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmModPassResponseDto add(PpmModPassRequestDto ppmModPassRequestDto) {
		PpmModePass entity = new PpmModePass();
		entity.setAbrevMp(ppmModPassRequestDto.getAbrevMp());
		entity.setLibelleLongMp(ppmModPassRequestDto.getLibelleLongMp());
		entity.setJrsLancemtRemisO(ppmModPassRequestDto.getJrsLancemtRemisO());
		entity.setJrsNecessaireEvalua(ppmModPassRequestDto.getJrsNecessaireEvalua());
		
		if (ppmModPassRequestDto.getCod4() == null) {
			throw new IllegalArgumentException("PpmModePass need a CodModPass");
		}
		CodModPass codModPass = codModPassService.get(ppmModPassRequestDto.getCod4());
		entity.setCodModPass(codModPass);
		
		repository.save(entity);
		return GbcMapper2.ppmModPassToPpmModPassResponseDto(entity);
	}
	
	@Override
	public List<PpmModPassResponseDto> getAll() {
		List<PpmModePass> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.ppmModPassToPpmModPassResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public PpmModePass get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("PpmModePass with id: " + id + " could not be found"));
	}
	
	@Override
	public PpmModPassResponseDto getById(String id) {
		PpmModePass entity = get(id);
		return GbcMapper2.ppmModPassToPpmModPassResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmModPassResponseDto delete(String id) {
		PpmModePass entity = get(id);
		repository.delete(entity);
		return GbcMapper2.ppmModPassToPpmModPassResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public PpmModPassResponseDto edit(String id, PpmModPassRequestDto ppmModPassRequestDto) {
		PpmModePass entity = get(id);
		entity.setLibelleLongMp(ppmModPassRequestDto.getLibelleLongMp());
		entity.setJrsLancemtRemisO(ppmModPassRequestDto.getJrsLancemtRemisO());
		entity.setJrsNecessaireEvalua(ppmModPassRequestDto.getJrsNecessaireEvalua());
		
		if (ppmModPassRequestDto.getCod4() != null) {
			CodModPass codModPass = codModPassService.get(ppmModPassRequestDto.getCod4());
			entity.setCodModPass(codModPass);
		}
		
		return GbcMapper2.ppmModPassToPpmModPassResponseDto(entity);
	}
}
