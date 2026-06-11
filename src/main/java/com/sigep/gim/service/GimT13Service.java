package com.sigep.gim.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sigep.gim.dto.requestDto.T13RequestDto;
import com.sigep.gim.dto.responseDto.T13ResponseDto;
import com.sigep.gim.entity.T13;

@Service
public interface GimT13Service {
	public T13ResponseDto add(T13RequestDto t13RequestDto);
	public List<T13ResponseDto> getAll();
	public T13 get(String id);
	public T13ResponseDto getById(String id);
	public T13ResponseDto delete(String id);
	public T13ResponseDto edit(String id, T13RequestDto t13RequestDto);
}