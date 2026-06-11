package com.sigep.gim.service;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.HistoEtatRequestDto;
import com.sigep.gim.dto.responseDto.HistoEtatResponseDto;
import com.sigep.gim.entity.HistoEtat;

@Service
public interface GimHistoEtatService {
	public HistoEtatResponseDto add(HistoEtatRequestDto histoEtatRequestDto);
	public List<HistoEtatResponseDto> getAll();
	public HistoEtat get(String etat, long idFiche, Date dateEtat);
	public HistoEtatResponseDto getById(String etat, long idFiche, Date dateEtat);
	public HistoEtatResponseDto delete(String etat, long idFiche, Date dateEtat);
	public HistoEtatResponseDto edit(String etat, long idFiche, Date dateEtat, HistoEtatRequestDto histoEtatRequestDto);
}