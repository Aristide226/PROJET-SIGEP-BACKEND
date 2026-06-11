package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.requestDto.DestinatairesRequestDto;
import com.sigep.gbc.dto.requestDto.FournisseursRequestDto;
import com.sigep.gbc.dto.responseDto.FournisseursResponseDto;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.Fournisseurs;
import com.sigep.gbc.repository.FournisseursRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FournisseursServiceImpl implements FournisseursService{
	
	private final FournisseursRepository repository;
	private final DestinatairesService dService;
	private final ModelMapper modelMapper;

	@Override
	@Transactional("gbcTransactionManager")
	public FournisseursResponseDto add(FournisseursRequestDto fournisseursRequestDto) {
		Fournisseurs entity = new Fournisseurs();
		entity.setRaisonSociale(fournisseursRequestDto.getRaisonSociale());
		entity.setBp(fournisseursRequestDto.getBp());
		entity.setTelephone(fournisseursRequestDto.getTelephone());
		entity.setProfession(fournisseursRequestDto.getProfession());
		
		DestinatairesRequestDto destinatairesRequestDto = new DestinatairesRequestDto();
		destinatairesRequestDto.setFtype("F");
		dService.add(destinatairesRequestDto);
		
		Destinataires destinataires = dService.findTopByOrderByIdDest();
		entity.setDestinataires(destinataires);
		
		repository.save(entity);
		return modelMapper.map(entity, FournisseursResponseDto.class);
	}

	@Override
	public List<FournisseursResponseDto> getAll() {
		List<Fournisseurs> list = repository.findAll();
		return list
				.stream().map(element  -> modelMapper.map(element, FournisseursResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Fournisseurs get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("Fournisseurs with id: " + id + " could not be found"));
	}

	@Override
	public FournisseursResponseDto getById(Long id) {
		Fournisseurs entity = get(id);
		return modelMapper.map(entity, FournisseursResponseDto.class);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public FournisseursResponseDto delete(Long id) {
		Fournisseurs entity = get(id);
		repository.delete(entity);
		dService.delete(id);
		return modelMapper.map(entity, FournisseursResponseDto.class);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public FournisseursResponseDto edit(Long id, FournisseursRequestDto fournisseursRequestDto) {
		Fournisseurs entity = get(id);
		entity.setRaisonSociale(fournisseursRequestDto.getRaisonSociale());
		entity.setBp(fournisseursRequestDto.getBp());
		entity.setTelephone(fournisseursRequestDto.getTelephone());
		entity.setProfession(fournisseursRequestDto.getProfession());
		
		return modelMapper.map(entity, FournisseursResponseDto.class);
	}

}
