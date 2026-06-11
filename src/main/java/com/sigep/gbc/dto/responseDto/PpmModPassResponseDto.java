package com.sigep.gbc.dto.responseDto;



import java.util.List;

import lombok.Data;

@Data
public class PpmModPassResponseDto {
	private String abrevMp;
	private String libelleLongMp;
	private Integer jrsLancemtRemisO;
	private Integer jrsNecessaireEvalua;
	private String cod4;
	private List<String> idPpms;
}
