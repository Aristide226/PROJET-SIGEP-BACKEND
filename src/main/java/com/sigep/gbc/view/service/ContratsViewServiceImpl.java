package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.ContratsView;
import com.sigep.gbc.view.dto.ContratsViewDto;
import com.sigep.gbc.view.repository.ContratsViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class ContratsViewServiceImpl implements ContratsViewService{
	private final ContratsViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<ContratsViewDto> getByIdBudget(Integer idBudget) {
		List<ContratsView> list = repository.getByIdBudget(idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, ContratsViewDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ContratsViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<ContratsView> list = repository.getByGestionAndIdBudget(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, ContratsViewDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ContratsViewDto> getContratsPartiellementEngages(Short gestion, Integer idBudget) {
		List<ContratsView> list = repository.getContratsPartiellementEngages(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, ContratsViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ContratsViewDto getByIdContrat(Long idContrat) {
		ContratsView entity = repository.getByIdContrat(idContrat);
		return modelMapper.map(entity, ContratsViewDto.class);
	}
}
