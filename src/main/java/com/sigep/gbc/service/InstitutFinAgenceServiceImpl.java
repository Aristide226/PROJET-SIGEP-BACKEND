package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.InstitutFinAgenceDto;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.entity.InstitutFinAgence;
import com.sigep.gbc.entity.InstitutFinancier;
import com.sigep.gbc.repository.InstitutFinAgenceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstitutFinAgenceServiceImpl implements InstitutFinAgenceService{

	private final InstitutFinAgenceRepository repository;
	private final InstitutFinancierService ifService;
	
	
	@Override
	@Transactional
	public InstitutFinAgenceDto add(InstitutFinAgenceDto institutFinAgenceDto) {
		InstitutFinAgence institutFinAgence = new InstitutFinAgence();
		institutFinAgence.setCodeAgence(institutFinAgenceDto.getCodeAgence());
		institutFinAgence.setLibelleAgence(institutFinAgenceDto.getLibelleAgence());
		institutFinAgence.setDomicilieA(institutFinAgenceDto.getDomicilieA());
		
		if (institutFinAgenceDto.getAbreviation() == null) {
			throw new IllegalArgumentException("InstituFinAgence need a InstitutFinancier");
		}
		InstitutFinancier institutFinancier = ifService.get(institutFinAgenceDto.getAbreviation());
		institutFinAgence.setInstitutFinancier(institutFinancier);
		
		repository.save(institutFinAgence);
		return GbcMapper.ifAtoIfAResponseDto(institutFinAgence);
	}
	
	
	@Override
	public List<InstitutFinAgenceDto> getAll() {
		List<InstitutFinAgence> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper.ifAtoIfAResponseDto(element))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public InstitutFinAgence get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("InstitutFinAgence with id: " + id + " could not be found"));
	}
	
	
	@Override
	public InstitutFinAgenceDto getById(String id) {
		InstitutFinAgence entity = get(id);
		return GbcMapper.ifAtoIfAResponseDto(entity);
	}
	
	
	@Override
	@Transactional
	public InstitutFinAgenceDto delete(String id) {
		InstitutFinAgence entity = get(id);
		repository.delete(entity);
		return GbcMapper.ifAtoIfAResponseDto(entity);
	}
	
	
	@Override
	@Transactional
	public InstitutFinAgenceDto edit(String id, InstitutFinAgenceDto institutFinAgenceDto) {
		InstitutFinAgence institutFinAgence = get(id);
		institutFinAgence.setCodeAgence(institutFinAgenceDto.getCodeAgence());
		institutFinAgence.setLibelleAgence(institutFinAgenceDto.getLibelleAgence());
		institutFinAgence.setDomicilieA(institutFinAgenceDto.getDomicilieA());
		
		if (institutFinAgenceDto.getAbreviation() != null) {
			InstitutFinancier institutFinancier = ifService.get(institutFinAgenceDto.getAbreviation());
			institutFinAgence.setInstitutFinancier(institutFinancier);
		}
		
		return GbcMapper.ifAtoIfAResponseDto(institutFinAgence);
	}


	@Override
	public List<InstitutFinAgenceDto> getByAbreviation(String abreviation) {
		InstitutFinancier institutFinancier = ifService.get(abreviation);
		List<InstitutFinAgence> list = repository.findByInstitutFinancier(institutFinancier);
		return list
				.stream().map(element  -> GbcMapper.ifAtoIfAResponseDto(element))
				.collect(Collectors.toList());
	}
	
	

}
