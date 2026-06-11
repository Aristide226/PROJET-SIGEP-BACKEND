package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gim.dto.requestDto.CodeAccesTypeRequestDto;
import com.sigep.gim.dto.responseDto.CodeAccesTypeResponseDto;
import com.sigep.gim.entity.CodeAccesType;
import com.sigep.gim.repository.GimCodeAcessTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional("gimTransactionManager")
@RequiredArgsConstructor
public class GimCodeAccesTypeServiceImpl implements GimCodeAccesTypeService {
	
	private final GimCodeAcessTypeRepository repository;
	private final ModelMapper modelMapper;
	
	@Override
	public CodeAccesTypeResponseDto add(CodeAccesTypeRequestDto codeAccesTypeRequestDto) {
		CodeAccesType entity = new CodeAccesType();
		entity.setIdCodeAccessType(codeAccesTypeRequestDto.getIdCodeAccessType());
		entity.setLibCodeAccessType(codeAccesTypeRequestDto.getLibCodeAccessType());
		entity.setDescriptions(codeAccesTypeRequestDto.getDescriptions());
		return modelMapper.map(entity, CodeAccesTypeResponseDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CodeAccesTypeResponseDto> getAll() {
		List<CodeAccesType> list = repository.findAll();
		return list
				.stream().map(element -> modelMapper.map(element, CodeAccesTypeResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public CodeAccesType get(char id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("CodeAccesType with id "+id+" could not be found")
		);
	}

	@Override
	@Transactional(readOnly = true)
	public CodeAccesTypeResponseDto getById(char id) {
		CodeAccesType entity = get(id);
		return modelMapper.map(entity, CodeAccesTypeResponseDto.class);
	}

	@Override
	public CodeAccesTypeResponseDto delete(char id) {
		CodeAccesType entity = get(id);
		repository.delete(entity);
		return modelMapper.map(entity, CodeAccesTypeResponseDto.class);
	}

	@Override
	public CodeAccesTypeResponseDto edit(char id, CodeAccesTypeRequestDto codeAccesTypeRequestDto) {
		CodeAccesType entity = get(id);
		return modelMapper.map(entity, CodeAccesTypeResponseDto.class);
	}

}
