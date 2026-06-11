package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TemtableRequestDto;
import com.sigep.gim.dto.responseDto.TemtableResponseDto;
import com.sigep.gim.entity.Temtable;

@Service
public interface GimTemtableService {
	public TemtableResponseDto add(TemtableRequestDto temtableRequestDto);
	public List<TemtableResponseDto> getAll();
	public Temtable get(String id);
	public TemtableResponseDto getById(String id);
	public TemtableResponseDto delete(String id);
	public TemtableResponseDto edit(String id, TemtableRequestDto temtableRequestDto);
}