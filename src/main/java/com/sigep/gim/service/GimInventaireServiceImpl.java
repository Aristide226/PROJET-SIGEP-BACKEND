package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.InventaireRequestDto;
import com.sigep.gim.dto.responseDto.InventaireResponseDto;
import com.sigep.gim.entity.EtatFiche;
import com.sigep.gim.entity.Inventaire;
import com.sigep.gim.entity.InventaireType;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimInventaireRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimInventaireServiceImpl implements GimInventaireService {
	
	private final GimInventaireRepository repository;
	private final GimEtatFicheService gimEtatFicheService;
	private final GimInventaireTypeService gimInventaireTypeService;
	
	@Override
	@Transactional
	public InventaireResponseDto add(InventaireRequestDto inventaireRequestDto) {
		Inventaire entity = new Inventaire();
		long idInvent = findMaxIdInvent()+1;
		
		entity.setIdInvent(idInvent);
		entity.setDateInvent(inventaireRequestDto.getDateInvent());
		entity.setDateEtat(inventaireRequestDto.getDateEtat());
		entity.setEnStock(inventaireRequestDto.isEnStock());
		
		if(inventaireRequestDto.getEtat() == null) {
			throw new IllegalArgumentException("Inventaire need a EtatFiche");
		}
		EtatFiche etatFiche = gimEtatFicheService.get(inventaireRequestDto.getEtat());
		entity.setEtatFiche(etatFiche);
		
		if(inventaireRequestDto.getIdTypeInvent() == null) {
			throw new IllegalArgumentException("Inventaire need a InventaireType");
		}
		InventaireType inventaireType = gimInventaireTypeService.get(inventaireRequestDto.getIdTypeInvent());
		entity.setInventaireType(inventaireType);
		
		repository.save(entity);
		return GimMapper.InventaireToInventaireResponseDto(entity);
	}
	
	@Override
	public List<InventaireResponseDto> getAll() {
		List<Inventaire> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.InventaireToInventaireResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Inventaire get(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("Inventaire with id "+id+"could not be found")
		);
	}
	
	@Override
	public InventaireResponseDto getById(long id) {
		Inventaire entity = get(id);
		return GimMapper.InventaireToInventaireResponseDto(entity);
	}
	
	@Override
	@Transactional
	public InventaireResponseDto delete(long id) {
		Inventaire entity = get(id);
		repository.delete(entity);
		return GimMapper.InventaireToInventaireResponseDto(entity);
	}
	
	@Override
	@Transactional
	public InventaireResponseDto edit(long id,InventaireRequestDto inventaireRequestDto) {
		Inventaire entity = get(id);
		entity.setDateInvent(inventaireRequestDto.getDateInvent());
		entity.setDateEtat(inventaireRequestDto.getDateEtat());
		entity.setEnStock(inventaireRequestDto.isEnStock());
		
		if(inventaireRequestDto.getEtat() != null) {
			EtatFiche etatFiche = gimEtatFicheService.get(inventaireRequestDto.getEtat());
			entity.setEtatFiche(etatFiche);
		}
		
		if(inventaireRequestDto.getIdTypeInvent() != null) {
			InventaireType inventaireType = gimInventaireTypeService.get(inventaireRequestDto.getIdTypeInvent());
			entity.setInventaireType(inventaireType);
		}
		
		return GimMapper.InventaireToInventaireResponseDto(entity);
	}
	
	@Override
	@Transactional
	public long findMaxIdInvent() {
		return repository.findMaxIdInvent();
	}
}
