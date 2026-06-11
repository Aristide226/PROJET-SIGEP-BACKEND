package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.EngagementsRequestDto;
import com.sigep.gbc.dto.responseDto.EngagementsResponseDto;
import com.sigep.gbc.entity.Engagements;
import com.sigep.gbc.model.IdEngsCodBord;
import com.sigep.gbc.model.InfosPourAbandonnerEngagement;
import com.sigep.gbc.model.InfosPourRetrograderEngagement;
import com.sigep.gbc.model.InfosPourValiderEngagement;
import com.sigep.gbc.model.InfosPourValiderOuRejeterEngagement;


@Service
public interface EngagementsService {
	public EngagementsResponseDto add(EngagementsRequestDto engagementsRequestDto);
	public List<EngagementsResponseDto> getAll();
	public Engagements get(Long id);
	public EngagementsResponseDto getById(Long id);
	public EngagementsResponseDto delete(Long id);
	public EngagementsResponseDto edit(Long id, EngagementsRequestDto engagementsRequestDto);
	public Boolean abandonner(InfosPourAbandonnerEngagement infosPourAbandonnerEngagement);
	public Boolean valider(InfosPourValiderEngagement infosPourValiderEngagement);
	public Boolean validerOuRejeter(InfosPourValiderOuRejeterEngagement infosPourValiderOuRejeterEngagement);
	public Boolean retrograder(InfosPourRetrograderEngagement infosPourRetrograderEngagement);
	public Boolean transmettre(IdEngsCodBord idEngsCodBord);
	public Boolean receptionner(List<Long> codBords);
}
