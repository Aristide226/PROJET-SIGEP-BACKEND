package com.sigep.gbc.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.mapper.GbcMapper2;
import com.sigep.gbc.dto.requestDto.TiersCaissePopRequestDto;
import com.sigep.gbc.dto.responseDto.TiersCaissePopResponseDto;
import com.sigep.gbc.entity.Destinataires;
import com.sigep.gbc.entity.TiersCaissePop;
import com.sigep.gbc.repository.TiersCaissePopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TiersCaissePopServiceImpl implements TiersCaissePopService {
	
	private final TiersCaissePopRepository repository;
	private final DestinatairesService dService;
	
	@Override
	@Transactional("gbcTransactionManager")
	public TiersCaissePopResponseDto add(TiersCaissePopRequestDto tiersCaissePopRequestDto) {
		TiersCaissePop entity = new TiersCaissePop();
		entity.setCaissePop(tiersCaissePopRequestDto.getCaissePop());
		entity.setFolio(tiersCaissePopRequestDto.getFolio());
		
		if (tiersCaissePopRequestDto.getIdDest() == null) {
			throw new IllegalArgumentException("TiersCaissePop need a Destinataires");
		}
		Destinataires destinataires = dService.get(tiersCaissePopRequestDto.getIdDest());
		entity.setDestinataires(destinataires);
		
		repository.save(entity);
		return GbcMapper2.tcpToTcpResponseDto(entity);
	}
	
	@Override
	public List<TiersCaissePopResponseDto> getAll() {
		List<TiersCaissePop> list = repository.findAll();
		return list
				.stream().map(element  -> GbcMapper2.tcpToTcpResponseDto(element))
				.collect(Collectors.toList());
	}
	
	@Override
	public TiersCaissePop get(Long id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("TiersCaissePop with id: " + id + " could not be found"));
	}
	
	@Override
	public TiersCaissePopResponseDto getById(Long id) {
		TiersCaissePop entity = get(id);
		return GbcMapper2.tcpToTcpResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public TiersCaissePopResponseDto delete(Long id) {
		TiersCaissePop entity = get(id);
		repository.delete(entity);
		return GbcMapper2.tcpToTcpResponseDto(entity);
	}
	
	@Override
	@Transactional("gbcTransactionManager")
	public TiersCaissePopResponseDto edit(Long id, TiersCaissePopRequestDto tiersCaissePopRequestDto) {
		TiersCaissePop entity = get(id);
		entity.setCaissePop(tiersCaissePopRequestDto.getCaissePop());
		entity.setFolio(tiersCaissePopRequestDto.getFolio());
		return GbcMapper2.tcpToTcpResponseDto(entity);
	}
}
