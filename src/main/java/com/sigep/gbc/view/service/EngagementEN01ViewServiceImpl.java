package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.EngagementEN01View;
import com.sigep.gbc.view.dto.EngagementEN01ViewDto;
import com.sigep.gbc.view.repository.EngagementEN01ViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class EngagementEN01ViewServiceImpl implements EngagementEN01ViewService {
	private final EngagementEN01ViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<EngagementEN01ViewDto> getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(Short gestion, Integer idBudget) {
		List<EngagementEN01View> list = repository.getByGestionAndIdBudgetAndMontantGreaterThanOrderByBenumDesc(gestion, idBudget, 0L);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementEN01ViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public EngagementEN01ViewDto getByGestionAndIdBudgetAndBenum(Short gestion, Integer idBudget, Integer benum) {
		EngagementEN01View entity  = repository.getByGestionAndIdBudgetAndBenum(gestion, idBudget, benum);
		return modelMapper.map(entity, EngagementEN01ViewDto.class);
	}
	
	@Override
	public List<EngagementEN01ViewDto> getEngagementModifiables(Short gestion, Integer idBudget) {
		List<EngagementEN01View> list = repository.getEngagementModifiables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementEN01ViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EngagementEN01ViewDto> getLesEngagementsPartiellementLiquides(Short gestion, Integer idBudget) {
		List<EngagementEN01View> list = repository.getLesEngagementsPartiellementLiquides(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementEN01ViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EngagementEN01ViewDto> getBonDAnnulationModifiables(Short gestion, Integer idBudget) {
		List<EngagementEN01View> list = repository.getBonDAnnulationModifiables(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementEN01ViewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public EngagementEN01ViewDto getByNumBe(Long numbe) {
		EngagementEN01View entity  = repository.getByNumBe(numbe);
		return modelMapper.map(entity, EngagementEN01ViewDto.class);
	}
	
	@Override
	public List<EngagementEN01ViewDto> getEngagementEN01ValideAE2EtTransmisEtPartiellementLiquides(Short gestion, Integer idBudget) {
		List<EngagementEN01View> list = repository.getEngagementEN01ValideAE2EtTransmisEtPartiellementLiquides(gestion, idBudget);
		return list
				.stream().map(element  -> modelMapper.map(element, EngagementEN01ViewDto.class))
				.collect(Collectors.toList());
	}
}
