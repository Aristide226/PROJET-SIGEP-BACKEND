package com.sigep.gbc.dto.responseDto;



import java.util.List;

import com.sigep.gbc.entity.PpmBudgId;

import lombok.Data;

@Data
public class CodSourceFinResponseDto {
	private String cod5;
	private String intituleCourt;
	private String abrev;
	private String intituleLong;
	private List<PpmBudgId> ppmBudgIds;
}
