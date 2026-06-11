package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.view.dto.BordTransmisViewDto;


@Service
public interface BordTransmisViewService {
	public List<BordTransmisViewDto> getBordTransmisEtNonReceptionne(Short gestion, Integer idBudget);
}
