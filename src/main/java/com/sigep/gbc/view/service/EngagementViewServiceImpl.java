package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.EngagementView;
import com.sigep.gbc.view.dto.EngagementViewDto;
import com.sigep.gbc.view.repository.EngagementViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class EngagementViewServiceImpl implements EngagementViewService {
	private final EngagementViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<EngagementViewDto> getEngagementModifiables(Short gestion, Integer idBudget) {
		List<EngagementView> list = repository.getEngagementModifiables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<EngagementViewDto> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget) {
		List<EngagementView> list = repository.getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(gestion, idBudget, 0L);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<EngagementViewDto> getEngagementValidables(Short gestion, Integer idBudget) {
		List<EngagementView> list = repository.getEngagementValidables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EngagementViewDto> getEngagementRetrogradables(Short gestion, Integer idBudget, String idUser) {
		List<EngagementView> list = repository.getEngagementRetrogradables(gestion, idBudget, idUser);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EngagementViewDto> getEngagementValideEtNonTransmis(Short gestion, Integer idBudget) {
		List<EngagementView> list = repository.getEngagementValideEtNonTransmis(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EngagementViewDto> getEngagementValideEtTransmisEtReceptionne(Short gestion, Integer idBudget) {
		List<EngagementView> list = repository.getEngagementValideEtTransmisEtReceptionne(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EngagementViewDto> getEngagementValideAE2EtNonTransmis(Short gestion, Integer idBudget) {
		List<EngagementView> list = repository.getEngagementValideAE2EtNonTransmis(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EngagementViewDto> getEngagementRejeteAE3EtNonTransmis(Short gestion, Integer idBudget) {
		List<EngagementView> list = repository.getEngagementRejeteAE3EtNonTransmis(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementViewDto.class))
				.collect(Collectors.toList());
	}
}
