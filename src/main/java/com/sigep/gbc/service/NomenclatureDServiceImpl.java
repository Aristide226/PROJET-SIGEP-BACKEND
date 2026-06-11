package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.dto.requestDto.NomenclatureDRequestDto;
import com.sigep.gbc.dto.responseDto.NomenclatureDResponseDto;
import com.sigep.gbc.entity.NomenclatureD;
import com.sigep.gbc.repository.NomenclatureDRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NomenclatureDServiceImpl implements NomenclatureDService {
	
	private final NomenclatureDRepository repository;

	@Transactional("gbcTransactionManager")
	@Override
	public void add(NomenclatureDRequestDto nomenclatureDRequestDto) {
		String numNo = nomenclatureDRequestDto.getTitre();
		if (nomenclatureDRequestDto.getSection() == null) numNo = numNo + ".0"; else numNo = numNo + "." + nomenclatureDRequestDto.getSection();
		if (nomenclatureDRequestDto.getChap() == null) numNo = numNo + ".00"; else numNo = numNo + "." + nomenclatureDRequestDto.getChap();
		if (nomenclatureDRequestDto.getArt() == null) numNo = numNo + ".000"; else numNo = numNo + "." + nomenclatureDRequestDto.getArt();
		if (nomenclatureDRequestDto.getParag() == null) numNo = numNo + ".0000"; else numNo = numNo + "." + nomenclatureDRequestDto.getParag();
		if (nomenclatureDRequestDto.getRub() == null) numNo = numNo + ".000000"; else numNo = numNo + "." + nomenclatureDRequestDto.getRub();
		
		repository.insert(
				numNo,
				nomenclatureDRequestDto.getTitre(),
				nomenclatureDRequestDto.getSection(),
				nomenclatureDRequestDto.getChap(),
				nomenclatureDRequestDto.getArt(),
				nomenclatureDRequestDto.getParag(),
				nomenclatureDRequestDto.getRub(),
				nomenclatureDRequestDto.getIntitule(),
				nomenclatureDRequestDto.getDotEstExec()
				);
	}

	@Override
	public List<NomenclatureDResponseDto> getAll() {
		List<NomenclatureD> nomenclatureDs = repository.findAll();
		return nomenclatureDs
				.stream().map(element  -> GbcMapper.noDToNoDResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public NomenclatureD get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("NomenclatureD with id: " + id + " could not be found"));
	}

	@Override
	public NomenclatureDResponseDto getById(String id) {
		NomenclatureD nomenclatureD = get(id);
		return GbcMapper.noDToNoDResponseDto(nomenclatureD);
	}

	@Transactional("gbcTransactionManager")
	@Override
	public NomenclatureDResponseDto delete(String id) {
		NomenclatureD nomenclatureD = get(id);
		repository.delete(nomenclatureD);
		return GbcMapper.noDToNoDResponseDto(nomenclatureD);
	}

	@Transactional("gbcTransactionManager")
	@Override
	public void edit(String id, NomenclatureDRequestDto nomenclatureDRequestDto) {
		repository.update(
				nomenclatureDRequestDto.getIntitule(),
				nomenclatureDRequestDto.getDotEstExec(),
				id
		);
	}

	@Override
	public Boolean exists(String titre, String sect, String chap, String art, String parag, String rub) {
		String numNo = titre;
		
		if (sect.equals("null")) numNo = numNo + ".0"; else numNo = numNo + "." + sect;
		if (chap.equals("null")) numNo = numNo + ".00"; else numNo = numNo + "." + chap;
		if (art.equals("null")) numNo = numNo + ".000"; else numNo = numNo + "." + art;
		if (parag.equals("null")) numNo = numNo + ".0000"; else numNo = numNo + "." + parag;
		if (rub.equals("null")) numNo = numNo + ".000000"; else numNo = numNo + "." + rub;
		
		return repository.findById(numNo).isPresent();
	}

	@Override
	public List<NomenclatureDResponseDto> getRecettesEtDepenses() {
		List<NomenclatureD> nomenclatureDs = repository.getRecettesEtDepenses();
		return nomenclatureDs
				.stream().map(element  -> GbcMapper.noDToNoDResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public List<NomenclatureDResponseDto> getRecettes() {
		List<NomenclatureD> nomenclatureDs = repository.getRecettes();
		return nomenclatureDs
				.stream().map(element  -> GbcMapper.noDToNoDResponseDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public List<NomenclatureDResponseDto> getDepenses() {
		List<NomenclatureD> nomenclatureDs = repository.getDepenses();
		return nomenclatureDs
				.stream().map(element  -> GbcMapper.noDToNoDResponseDto(element))
				.collect(Collectors.toList());
	}

}
