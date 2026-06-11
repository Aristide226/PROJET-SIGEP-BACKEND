package com.sigep.gbc.view.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sigep.gbc.view.entity.FournisseursView;
import com.sigep.gbc.view.dto.FournisseursViewDto;
import com.sigep.gbc.view.repository.FournisseursViewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(
		value = "gbcTransactionManager",
		readOnly = true
)
public class FournisseursViewServiceImpl implements FournisseursViewService {
	private final FournisseursViewRepository repository;
	private final ModelMapper modelMapper;

	@Override
	public List<FournisseursViewDto> getAll() {
		List<FournisseursView> list = repository.findAll();
		return list
				.stream().map(element  -> modelMapper.map(element, FournisseursViewDto.class))
				.collect(Collectors.toList());
	}	
}
