package com.sigep.gim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.LivreJournalRequestDto;
import com.sigep.gim.dto.responseDto.LivreJournalResponseDto;
import com.sigep.gim.entity.Fiches;
import com.sigep.gim.entity.LivreJournal;
import com.sigep.gim.mapper.GimMapper;
import com.sigep.gim.repository.GimLivreJournalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GimLivreJournalServiceImpl implements GimLivreJournalService {
	
	private final GimLivreJournalRepository repository;
	private final GimFichesService gimFichesService;
	
	@Override
	@Transactional
	public LivreJournalResponseDto add(LivreJournalRequestDto livreJournalRequestDto) {
		LivreJournal entity = new LivreJournal();
		entity.setDateValide(livreJournalRequestDto.getDateValide());
		entity.setEntree(livreJournalRequestDto.isEntree());
		if(livreJournalRequestDto.getIdFiche() == null) {
			throw new IllegalArgumentException("LivreJournal need a Fiches");
		}
		Fiches fiches = gimFichesService.get(livreJournalRequestDto.getIdFiche());
		entity.setFiches(fiches);
		
		repository.save(entity);
		return GimMapper.LivreJournalToLivreJournalResponseDto(entity);
	}
	
	@Override
	public List<LivreJournalResponseDto> getAll() {
		List<LivreJournal> list = repository.findAll();
		return list
				.stream().map(element -> GimMapper.LivreJournalToLivreJournalResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public LivreJournal get(long id) {
		return repository.findById(id).orElseThrow(() -> 
			new IllegalArgumentException("LivreJournal with id "+id+"could not be found")
		);
	}
	
	@Override
	public LivreJournalResponseDto getById(long id) {
		LivreJournal entity = get(id);
		return GimMapper.LivreJournalToLivreJournalResponseDto(entity);
	}
	
	@Override
	@Transactional
	public LivreJournalResponseDto delete(long id) {
		LivreJournal entity = get(id);
		repository.delete(entity);
		return GimMapper.LivreJournalToLivreJournalResponseDto(entity);
	}
	
	@Override
	@Transactional
	public LivreJournalResponseDto edit(long id,LivreJournalRequestDto livreJournalRequestDto) {
		LivreJournal entity = get(id);
		entity.setDateValide(livreJournalRequestDto.getDateValide());
		entity.setEntree(livreJournalRequestDto.isEntree());
		if(livreJournalRequestDto.getIdFiche() != null) {
			Fiches fiches = gimFichesService.get(livreJournalRequestDto.getIdFiche());
			entity.setFiches(fiches);
		}
		
		return GimMapper.LivreJournalToLivreJournalResponseDto(entity);
	}
}
