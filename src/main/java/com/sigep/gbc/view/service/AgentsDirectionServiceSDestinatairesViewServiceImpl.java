package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.view.entity.AgentsDirectionServiceSDestinatairesView;
import com.sigep.gbc.view.dto.AgentsDirectionServiceSDestinatairesViewDto;
import com.sigep.gbc.view.repository.AgentsDirectionServiceSDestinatairesViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class AgentsDirectionServiceSDestinatairesViewServiceImpl implements AgentsDirectionServiceSDestinatairesViewService{
	private final AgentsDirectionServiceSDestinatairesViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<AgentsDirectionServiceSDestinatairesViewDto> getAll() {
		List<AgentsDirectionServiceSDestinatairesView> list = repository.findAll();
		return list
				.stream().map(element  -> modelMapper.map(element, AgentsDirectionServiceSDestinatairesViewDto.class))
				.collect(Collectors.toList());
	}	
}
