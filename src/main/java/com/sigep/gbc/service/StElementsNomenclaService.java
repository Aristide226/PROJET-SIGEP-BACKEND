package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.StElementsNomenclaDto;
import com.sigep.gbc.entity.StElementsNomencla;


@Service
public interface StElementsNomenclaService {
	public StElementsNomenclaDto add(StElementsNomenclaDto stElementsNomenclaDto);
	public List<StElementsNomenclaDto> getAll();
	public StElementsNomencla get(String idStElts, Short gestion, String idPlan);
	public StElementsNomenclaDto getById(String idStElts, Short gestion, String idPlan);
	public StElementsNomenclaDto delete(String idStElts, Short gestion, String idPlan);
	public List<StElementsNomenclaDto> getByIdStEltsAndGestion(String idStElts, Short gestion);
}
