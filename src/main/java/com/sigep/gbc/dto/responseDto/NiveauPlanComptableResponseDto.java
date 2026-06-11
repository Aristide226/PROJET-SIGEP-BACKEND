package com.sigep.gbc.dto.responseDto;


import java.util.List;

import lombok.Data;

@Data
public class NiveauPlanComptableResponseDto {
	private Integer niveau;
	private String intituleNiveau;
	private String description;
	private List<String> idPlans;
}
