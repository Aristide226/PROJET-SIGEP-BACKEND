package com.sigep.gbc.view.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sigep.gbc.view.dto.LiquidationsPourCreationEngagementViewDto;


@Service
public interface LiquidationsPourCreationEngagementViewService {
	public List<LiquidationsPourCreationEngagementViewDto> getByGestion(Short gestion);
}
