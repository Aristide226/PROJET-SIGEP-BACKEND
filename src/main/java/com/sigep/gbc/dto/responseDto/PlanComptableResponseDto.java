package com.sigep.gbc.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class PlanComptableResponseDto {
	private String idPlan;
	private String intitulePlan;
	private Integer niveau;
	private List<String> codBuds;
}
