package com.sigep.grh.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.grh.dto.AccesCodeDto;
import com.sigep.grh.entity.AccesCode;
import com.sigep.grh.entity.AccesCodeNiveau;
import com.sigep.grh.mapper.GrhMapper;
import com.sigep.grh.repository.GrhAccesCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional("grhTransactionManager")
public class GrhAccesCodeServiceImpl implements GrhAccesCodeService {
	
	private final GrhAccesCodeRepository repository;
	private final GrhAccesCodeNiveauService acnService;
	//private final AgentsService aService;
	private final GrhGrpeCodeService gcService;

	@Override
	public AccesCodeDto add(AccesCodeDto accesCodeDto) {
		int rangCod = ((getMaxRangCod(accesCodeDto.getCode()) == null) ? 1 : getMaxRangCod(accesCodeDto.getCode())) + 1;
		String userName = accesCodeDto.getCode().trim();
		if (rangCod < 10) {
			userName = userName + '0' + String.valueOf(rangCod);
		} else {
			userName = userName + String.valueOf(rangCod);
		}
		repository.insert(
				userName, 
				"l5ZGW6tjHePE+jeHtULffA==", 
				accesCodeDto.getStatu(), 
				null, 
				(short) 0, 
				rangCod, 
				accesCodeDto.getId(), 
				accesCodeDto.getCode(), 
				accesCodeDto.getGrpe(), 
				accesCodeDto.getMle(),
				accesCodeDto.getMotDePasse());
		
		AccesCode accesCode = new AccesCode();
		accesCode.setUserName(userName);
		accesCode.setMotPasse("l5ZGW6tjHePE+jeHtULffA==");
		accesCode.setMotDePasse(accesCodeDto.getMotDePasse());
		accesCode.setStatu(accesCodeDto.getStatu());
		accesCode.setDateChangement(null);
		accesCode.setNbreDeFois((short) 0);
		accesCode.setRangCod(rangCod);
		accesCode.setId(accesCodeDto.getId());
		accesCode.setAccesCodeNiveau(acnService.get(accesCodeDto.getCode()));
		accesCode.setGrpeCode(gcService.get(accesCodeDto.getGrpe()));
		//accesCode.setAgents(aService.get(accesCodeDto.getMle()));
		accesCode.setMle(accesCodeDto.getMle());
		
		return GrhMapper.acToAcDto(accesCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccesCodeDto> getAll() {
		List<AccesCode> accesCodes = repository.findAll();
		return accesCodes
				.stream().map(element  -> GrhMapper.acToAcDto(element))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public AccesCode get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("AccesCode with id: " + id + " could not be found"));
	}

	@Override
	@Transactional(readOnly = true)
	public AccesCodeDto getById(String id) {
		AccesCode accesCode = get(id);
		return GrhMapper.acToAcDto(accesCode);
	}

	@Override
	public AccesCodeDto delete(String id) {
		AccesCode accesCode = get(id);
		repository.delete(accesCode);
		return GrhMapper.acToAcDto(accesCode);
	}

	@Override
	public AccesCodeDto edit(String id, AccesCodeDto accesCodeDto) {
		repository.update(
				accesCodeDto.getMotDePasse(), 
				accesCodeDto.getStatu(), 
				new Date(),  
				accesCodeDto.getNbreDeFois(), 
				accesCodeDto.getId(), 
				accesCodeDto.getCode(), 
				accesCodeDto.getGrpe(), 
				accesCodeDto.getMle(),
				id);
		
		AccesCode accesCode = get(id);
		return GrhMapper.acToAcDto(accesCode);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer getMaxRangCod(String code) {
		return repository.getMaxRangCod(code);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AccesCodeDto> getByAccesCodeNiveau(String code) {
		AccesCodeNiveau accesCodeNiveau = acnService.get(code);
		List<AccesCode> accesCodes = repository.findByAccesCodeNiveau(accesCodeNiveau);
		return accesCodes
				.stream().map(element  -> GrhMapper.acToAcDto(element))
				.collect(Collectors.toList());
	}

}
