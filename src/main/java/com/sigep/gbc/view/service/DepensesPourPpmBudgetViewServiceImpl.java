//Aristide
package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.DepensesPourPpmBudgetView;
import com.sigep.gbc.view.dto.DepensesPourPpmBudgetViewDto;
import com.sigep.gbc.view.repository.DepensesPourPpmBudgetViewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class DepensesPourPpmBudgetViewServiceImpl implements DepensesPourPpmBudgetViewService {
	private final DepensesPourPpmBudgetViewRepository repository;
	
	private final ModelMapper modelMapper;
	
	@Override
	public List<DepensesPourPpmBudgetViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget) {
		List<DepensesPourPpmBudgetView> list = repository.findByGestionAndIdBudget(gestion, idBudget);
		return list 
				.stream().map(element -> modelMapper.map(element, DepensesPourPpmBudgetViewDto.class))
				.collect(Collectors.toList());
	}
}
