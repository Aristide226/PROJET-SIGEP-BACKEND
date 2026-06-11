//Aristide
package com.sigep.gbc.view.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sigep.gbc.view.dto.DepensesPourPpmBudgetViewDto;

@Service
public interface DepensesPourPpmBudgetViewService {
	public List<DepensesPourPpmBudgetViewDto> getByGestionAndIdBudget(Short gestion, Integer idBudget);
}
