package com.sigep.gbc.dto.responseDto;


import java.util.List;


import lombok.Data;

@Data
public class EtatTransmissionResponseDto {
	private Integer idEtatTrans;
	private String libEtatTrans;
	private List<Long> idDetailTitres;
	private List<String> codRecouvs;
	private List<Long> numBes;
	private List<Long> numMandByIdEtatTransMs;
	private List<Long> numMandByIdEtatTransLs;
}
