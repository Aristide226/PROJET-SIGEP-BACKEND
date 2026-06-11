package com.sigep.gbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sigep.gbc.dto.requestDto.NomenclatureDRequestDto;
import com.sigep.gbc.dto.responseDto.NomenclatureDResponseDto;
import com.sigep.gbc.entity.NomenclatureD;


@Service
public interface NomenclatureDService {
	public void add(NomenclatureDRequestDto nomenclatureDRequestDto);
	public List<NomenclatureDResponseDto> getAll();
	public NomenclatureD get(String id);
	public NomenclatureDResponseDto getById(String id);
	public NomenclatureDResponseDto delete(String id);
	public void edit(String id, NomenclatureDRequestDto nomenclatureDRequestDto);
	public Boolean exists(String titre, String sect, String chap, String art, String parag, String rub);
	public List<NomenclatureDResponseDto> getRecettesEtDepenses();
	public List<NomenclatureDResponseDto> getRecettes();
	public List<NomenclatureDResponseDto> getDepenses();
}
