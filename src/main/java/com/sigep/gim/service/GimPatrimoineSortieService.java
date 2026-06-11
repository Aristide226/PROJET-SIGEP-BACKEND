package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.PatrimoineSortieRequestDto;
import com.sigep.gim.dto.responseDto.PatrimoineSortieResponseDto;
import com.sigep.gim.entity.PatrimoineSortie;

@Service
public interface GimPatrimoineSortieService {
	public PatrimoineSortieResponseDto add(PatrimoineSortieRequestDto patrimoineSortieRequestDto);
	public List<PatrimoineSortieResponseDto> getAll();
	public PatrimoineSortie get(long idFiche, String mle);
	public PatrimoineSortieResponseDto getById(long idFiche, String mle);
	public PatrimoineSortieResponseDto delete(long idFiche, String mle);
	public PatrimoineSortieResponseDto edit(long idFiche, String mle, PatrimoineSortieRequestDto patrimoineSortieRequestDto);
}