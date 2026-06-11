package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.LiquidationView;
import com.sigep.gbc.view.dto.LiquidationViewDto;
import com.sigep.gbc.view.repository.LiquidationViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class LiquidationViewServiceImpl implements LiquidationViewService {
	private final LiquidationViewRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public List<LiquidationViewDto> getByGestionAndIdBudgetOrderByNumBlDesc(Short gestion, Integer idBudget) {
		List<LiquidationView> list = repository.getByGestionAndIdBudgetOrderByNumBlDesc(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<LiquidationViewDto> getReçuModifiables(Short gestion, Integer idBudget) {
		List<LiquidationView> list = repository.getReçuModifiables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<LiquidationViewDto> getReçuSansMandats(Short gestion, Integer idBudget) {
		List<LiquidationView> list = repository.getReçuSansMandats(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationViewDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<LiquidationViewDto> getLiquidationModifiables(Short gestion, Integer idBudget) {
		List<LiquidationView> list = repository.getLiquidationModifiables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationViewDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<LiquidationViewDto> getByGestionAndIdBudgetOrderByNumBeDesc(Short gestion, Integer idBudget) {
		List<LiquidationView> list = repository.getByGestionAndIdBudgetOrderByNumBeDesc(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationViewDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<LiquidationViewDto> getLiquidationValidables(Short gestion, Integer idBudget) {
		List<LiquidationView> list = repository.getLiquidationValidables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<LiquidationViewDto> getLiquidationRetrogradables(Short gestion, Integer idBudget, String idUser) {
		List<LiquidationView> list = repository.getLiquidationRetrogradables(gestion, idBudget, idUser);
		return list
				.stream().map(element  -> modelMapper.map(element, LiquidationViewDto.class))
				.collect(Collectors.toList());
	}
}
