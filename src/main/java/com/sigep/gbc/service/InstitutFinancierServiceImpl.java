package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.DestinatairesRequestDto;
import com.sigep.gbc.dto.requestDto.InstitutFinancierRequestDto;
import com.sigep.gbc.dto.responseDto.InstitutFinancierResponseDto;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.InstitutFinancier;
import com.sigep.gbc.repository.InstitutFinancierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstitutFinancierServiceImpl implements InstitutFinancierService{

	private final InstitutFinancierRepository repository;
	private final DestinatairesService dService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public InstitutFinancierResponseDto add(InstitutFinancierRequestDto institutFinancierRequestDto) {
		InstitutFinancier institutFinancier = new InstitutFinancier();
		institutFinancier.setAbreviation(institutFinancierRequestDto.getAbreviation());
		institutFinancier.setLibelle(institutFinancierRequestDto.getLibelle());
		institutFinancier.setAddresseA(institutFinancierRequestDto.getAddresseA());
		institutFinancier.setTransiArct(institutFinancierRequestDto.getTransiArct());
		institutFinancier.setCodeBanque(institutFinancierRequestDto.getCodeBanque());
		institutFinancier.setLibCourtMajus(institutFinancierRequestDto.getLibCourtMajus());
		institutFinancier.setLibCourtMinus(institutFinancierRequestDto.getLibCourtMinus());
		
		DestinatairesRequestDto destinatairesRequestDto = new DestinatairesRequestDto();
		destinatairesRequestDto.setFtype("I");
		dService.add(destinatairesRequestDto);
		
		Destinataires destinataires = dService.findTopByOrderByIdDest();
		institutFinancier.setDestinataires(destinataires);
		
		repository.save(institutFinancier);
		return GbcMapper.iFtoIfResponseDto(institutFinancier);
	}
	
	@Override
	public List<InstitutFinancierResponseDto> getAll() {
		List<InstitutFinancier> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.iFtoIfResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public InstitutFinancier get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("InstitutFinancier with id: " + id + " could not be found"));
	}
	
	@Override
	public InstitutFinancierResponseDto getById(String id) {
		InstitutFinancier entity = get(id);
		return GbcMapper.iFtoIfResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public InstitutFinancierResponseDto delete(String id) {
		InstitutFinancier entity = get(id);
		repository.delete(entity);
		return GbcMapper.iFtoIfResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public InstitutFinancierResponseDto edit(String id, InstitutFinancierRequestDto institutFinancierRequestDto) {
		InstitutFinancier institutFinancier = get(id);
		institutFinancier.setLibelle(institutFinancierRequestDto.getLibelle());
		institutFinancier.setAddresseA(institutFinancierRequestDto.getAddresseA());
		institutFinancier.setTransiArct(institutFinancierRequestDto.getTransiArct());
		institutFinancier.setCodeBanque(institutFinancierRequestDto.getCodeBanque());
		institutFinancier.setLibCourtMajus(institutFinancierRequestDto.getLibCourtMajus());
		institutFinancier.setLibCourtMinus(institutFinancierRequestDto.getLibCourtMinus());
		
		return GbcMapper.iFtoIfResponseDto(institutFinancier);
	}
	
	

}
