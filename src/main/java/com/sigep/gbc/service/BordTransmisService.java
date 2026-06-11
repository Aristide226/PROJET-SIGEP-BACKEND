package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.dto.requestDto.BordTransmisRequestDto;
import com.sigep.gbc.dto.responseDto.BordTransmisResponseDto;
import com.sigep.gbc.entity.BordTransmis;
import com.sigep.gbc.model.InfosPourReceptionnerBordTransmis;


@Service
public interface BordTransmisService {
	public BordTransmisResponseDto add(BordTransmisRequestDto bordTransmisRequestDto);
	public List<BordTransmisResponseDto> getAll();
	public BordTransmis get(Long id);
	public BordTransmisResponseDto getById(Long id);
	public BordTransmisResponseDto delete(Long id);
	public BordTransmisResponseDto edit(Long id, BordTransmisRequestDto bordTransmisRequestDto);
	public List<BordTransmisResponseDto> getByGestionAndIdBudgetAndExpeditaire(Short gestion, Integer idBudget, String expeditaire);
	public Boolean receptionner(InfosPourReceptionnerBordTransmis infosPourReceptionnerBordTransmis);
}
