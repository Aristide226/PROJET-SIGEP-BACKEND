package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.FicheSourceFinRequestDto;
import com.sigep.gim.dto.responseDto.FicheSourceFinResponseDto;
import com.sigep.gim.entity.FicheSourceFin;

@Service
public interface GimFicheSourceFinService {
	public FicheSourceFinResponseDto add(FicheSourceFinRequestDto ficheSourceFinRequestDto);
	public List<FicheSourceFinResponseDto> getAll();
	public FicheSourceFin get(long idFiche, String idSourceFin);
	public FicheSourceFinResponseDto getById(long idFiche, String idSourceFin);
	public FicheSourceFinResponseDto delete(long idFiche, String idSourceFin);
	public FicheSourceFinResponseDto edit(long idFiche, String idSourceFin, FicheSourceFinRequestDto ficheSourceFinRequestDto);
}