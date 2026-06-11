package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.DestinatairesRequestDto;
import com.sigep.gbc.dto.responseDto.DestinatairesResponseDto;
import com.sigep.gbc.entity.Destinataires;


@Service
public interface DestinatairesService {
	public void add(DestinatairesRequestDto destinatairesRequestDto);
	public List<DestinatairesResponseDto> getAll();
	public Destinataires get(long id);
	public DestinatairesResponseDto getById(long id);
	public DestinatairesResponseDto delete(long id);
	public void edit(long id, DestinatairesRequestDto destinatairesRequestDto);
	
	public Long getMaxIDest();
	public Boolean existsByIfumleAndIfumleNot(String ifumle, String excludedValue);
	public Boolean existsByIfumleAndIfumleNotOrNom(String ifumle, String excludedValue, String nom);
	public Boolean existsByIfumleAndIfumleNotAndIdDestNotOrNomAndIdDestNot(String ifumle, String excludedValue, Long idDest1, String nom, Long idDest2);
	public Destinataires findTopByOrderByIdDest();
	public List<DestinatairesResponseDto> getDestinataireSansAgents();
	
	//Aristide
	List<DestinatairesResponseDto> getAllFournisseurs();

}
