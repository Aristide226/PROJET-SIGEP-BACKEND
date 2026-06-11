package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineBatimentsRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineBatimentsResponseDto;
import com.sigep.gim.entity.BatimentMateriauxConstrut;
import com.sigep.gim.entity.BatimentUsages;
import com.sigep.gim.entity.ElementEauCourante;
import com.sigep.gim.entity.ElementElectricite;
import com.sigep.gim.entity.Patrimoine;
import com.sigep.gim.entity.PatrimoineBatiments;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimPatrimoineBatimentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimPatrimoineBatimentsServiceImpl implements GimPatrimoineBatimentsService {
	
	private final GimPatrimoineBatimentsRepository repository;
	private final GimPatrimoineService gimPatrimoineService;
	private final GimBatimentMateriauxConstrutService gimBatimentMateriauxConstrutService;
	private final GimBatimentUsagesService gimBatimentUsagesService;
	private final GimElementEauCouranteService gimElementEauCouranteService;
	private final GimElementElectriciteService gimElementElectriciteService;
	
	@Override
	@Transactional
	public PatrimoineBatimentsResponseDto add(PatrimoineBatimentsRequestDto patrimoineBatimentsRequestDto) {
		PatrimoineBatiments entity = new PatrimoineBatiments();
		entity.setNbrePiece(patrimoineBatimentsRequestDto.getNbrePiece());
		entity.setInstallTelephone(patrimoineBatimentsRequestDto.getInstallTelephone());
		entity.setAniveau(patrimoineBatimentsRequestDto.getAniveau());
		entity.setNbNiveau(patrimoineBatimentsRequestDto.getNbNiveau());
		
		if(patrimoineBatimentsRequestDto.getCodMatereiaux() == null) {
			throw new IllegalArgumentException("PatrimoineBatiments need a BatimentMateriauxConstrut");
		}
		BatimentMateriauxConstrut batimentMateriauxConstrut = gimBatimentMateriauxConstrutService.get(patrimoineBatimentsRequestDto.getCodMatereiaux());
		entity.setBatimentMateriauxConstrut(batimentMateriauxConstrut);
		
		if(patrimoineBatimentsRequestDto.getCodeUsage() == null) {
			throw new IllegalArgumentException("PatrimoineBatiments need a BatimentUsages");
		}
		BatimentUsages batimentUsages = gimBatimentUsagesService.get(patrimoineBatimentsRequestDto.getCodeUsage());
		entity.setBatimentUsages(batimentUsages);
		
		if(patrimoineBatimentsRequestDto.getCodeEauCourant() == null) {
			throw new IllegalArgumentException("PatrimoineBatiments need a ElementEauCourante");
		}
		ElementEauCourante elementEauCourante = gimElementEauCouranteService.get(patrimoineBatimentsRequestDto.getCodeEauCourant());
		entity.setElementEauCourante(elementEauCourante);
		
		if(patrimoineBatimentsRequestDto.getCodeElectricite() == null) {
			throw new IllegalArgumentException("PatrimoineBatiments need a ElementElectricite");
		}
		ElementElectricite elementElectricite = gimElementElectriciteService.get(patrimoineBatimentsRequestDto.getCodeElectricite());
		entity.setElementElectricite(elementElectricite);
		
		if(patrimoineBatimentsRequestDto.getMle() == null) {
			throw new IllegalArgumentException("PatrimoineBatiments need a Patrimoine");
		}
		Patrimoine patrimoine = gimPatrimoineService.get(patrimoineBatimentsRequestDto.getMle());
		entity.setPatrimoine(patrimoine);
		
		repository.save(entity);
		return GimMapper.PatrimoineBatimentsToPatrimoineBatimentsResponseDto(entity);
	}
	
	@Override
	public List<PatrimoineBatimentsResponseDto> getAll() {
		List<PatrimoineBatiments> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.PatrimoineBatimentsToPatrimoineBatimentsResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public PatrimoineBatiments get(String id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("PatrimoineBatiments with id "+id+"could not be found")
		);
	}
	
	@Override
	public PatrimoineBatimentsResponseDto getById(String id) {
		PatrimoineBatiments entity = get(id);
		return GimMapper.PatrimoineBatimentsToPatrimoineBatimentsResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineBatimentsResponseDto delete(String id) {
		PatrimoineBatiments entity = get(id);
		repository.delete(entity);
		return GimMapper.PatrimoineBatimentsToPatrimoineBatimentsResponseDto(entity);
	}
	
	@Override
	@Transactional
	public PatrimoineBatimentsResponseDto edit(String id,PatrimoineBatimentsRequestDto patrimoineBatimentsRequestDto) {
		PatrimoineBatiments entity = get(id);
		entity.setNbrePiece(patrimoineBatimentsRequestDto.getNbrePiece());
		entity.setInstallTelephone(patrimoineBatimentsRequestDto.getInstallTelephone());
		entity.setAniveau(patrimoineBatimentsRequestDto.getAniveau());
		entity.setNbNiveau(patrimoineBatimentsRequestDto.getNbNiveau());
		
		if(patrimoineBatimentsRequestDto.getCodMatereiaux() != null) {
			BatimentMateriauxConstrut batimentMateriauxConstrut = gimBatimentMateriauxConstrutService.get(patrimoineBatimentsRequestDto.getCodMatereiaux());
			entity.setBatimentMateriauxConstrut(batimentMateriauxConstrut);
		}
		
		if(patrimoineBatimentsRequestDto.getCodeUsage() != null) {
			BatimentUsages batimentUsages = gimBatimentUsagesService.get(patrimoineBatimentsRequestDto.getCodeUsage());
			entity.setBatimentUsages(batimentUsages);
		}
		
		if(patrimoineBatimentsRequestDto.getCodeEauCourant() != null) {
			ElementEauCourante elementEauCourante = gimElementEauCouranteService.get(patrimoineBatimentsRequestDto.getCodeEauCourant());
			entity.setElementEauCourante(elementEauCourante);
		}
		
		if(patrimoineBatimentsRequestDto.getCodeElectricite() != null) {
			ElementElectricite elementElectricite = gimElementElectriciteService.get(patrimoineBatimentsRequestDto.getCodeElectricite());
			entity.setElementElectricite(elementElectricite);
		}
		
		return GimMapper.PatrimoineBatimentsToPatrimoineBatimentsResponseDto(entity);
	}
}
