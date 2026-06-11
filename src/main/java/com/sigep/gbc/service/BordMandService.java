package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.BordMandDto;
import com.sigep.gbc.entity.BordMand;
import com.sigep.gbc.model.IdMandsIdBordEmis;


@Service
public interface BordMandService {
	public BordMandDto add(BordMandDto bordMandDto);
	public List<BordMandDto> getAll();
	public BordMand get(String idBord, Long numMand);
	public BordMandDto getById(String idBord, Long numMand);
	public BordMandDto delete(String idBord, Long numMand);
	public BordMandDto edit(String idBord, Long numMand, BordMandDto bordMandDto);
	public Boolean adds(IdMandsIdBordEmis idMandsIdBordEmis);
	
	public Boolean deleteBordereauEmismandats(String idBord);
}
