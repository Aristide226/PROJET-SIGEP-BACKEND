package com.sigep.grh.dto.responseDto;

import java.util.List;

import com.sigep.grh.model.Grpe;

import lombok.Data;

@Data
public class AccesCodeNiveauResponseDto {
	private String code;
	private String intituleCode;
	private String nomStruct;
	private List<Grpe> grpes;
}
