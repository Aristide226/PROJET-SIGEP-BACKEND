package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.TableRapportRequestDto;
import com.sigep.gim.dto.responseDto.TableRapportResponseDto;
import com.sigep.gim.entity.TableRapport;

@Service
public interface GimTableRapportService {
	public TableRapportResponseDto add(TableRapportRequestDto tableRapportRequestDto);
	public List<TableRapportResponseDto> getAll();
	public TableRapport get(String id);
	public TableRapportResponseDto getById(String id);
	public TableRapportResponseDto delete(String id);
	public TableRapportResponseDto edit(String id, TableRapportRequestDto tableRapportRequestDto);
}