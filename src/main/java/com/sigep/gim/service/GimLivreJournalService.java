package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.LivreJournalRequestDto;
import com.sigep.gim.dto.responseDto.LivreJournalResponseDto;
import com.sigep.gim.entity.LivreJournal;

@Service
public interface GimLivreJournalService {
	public LivreJournalResponseDto add(LivreJournalRequestDto livreJournalRequestDto);
	public List<LivreJournalResponseDto> getAll();
	public LivreJournal get(long id);
	public LivreJournalResponseDto getById(long id);
	public LivreJournalResponseDto delete(long id);
	public LivreJournalResponseDto edit(long id, LivreJournalRequestDto livreJournalRequestDto);
}