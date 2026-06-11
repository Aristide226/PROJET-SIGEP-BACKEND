package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.ReamgmtBudgetDto;
import com.sigep.gbc.dto.requestDto.ReamgmtRequestDto;
import com.sigep.gbc.dto.responseDto.ReamgmtResponseDto;
import com.sigep.gbc.entity.Reamgmt;


@Service
public interface ReamgmtService {
	public ReamgmtResponseDto add(ReamgmtRequestDto reamgmtRequestDto);
	public List<ReamgmtResponseDto> getAll();
	public Reamgmt get(Long codReam, String codBud);
	public ReamgmtResponseDto getById(Long codReam, String codBud);
	public ReamgmtResponseDto delete(Long codReam, String codBud);
	public ReamgmtResponseDto edit(Long codReam, String codBud, ReamgmtRequestDto reamgmtRequestDto);
	
	public List<ReamgmtResponseDto> getByCodReam(Long codReam); // Reamenagement liés a l'acte
	public List<ReamgmtBudgetDto> getLigneModifieesRecettesDepenses(Long codReam); // Les lignes qui ont été reamenagé
	public Boolean addLignesModifiees(List<ReamgmtRequestDto> reamgmtRequestDtos); // Ajout les lignes reamenagées
	public Boolean deleteLignesModifiees(Long codReam); // Suppression des lignes réamengées
	public Boolean exists(Long codReam, String codBud); // Verifier si la ligne existe déja pour un action acte donnée
	public Boolean editAllReam(Long codReam); // Calcul le reamanegement pour chaque ligne de l'acte
}
