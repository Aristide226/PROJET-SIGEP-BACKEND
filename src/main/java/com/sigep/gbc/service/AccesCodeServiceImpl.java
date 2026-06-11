package com.sigep.gbc.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigep.gbc.dto.AccesCodeAgentDto;
import com.sigep.gbc.dto.AccesCodeDto;
import com.sigep.gbc.mapper.GbcMapper;
import com.sigep.gbc.entity.AccesCode;
import com.sigep.gbc.entity.AccesCodeNiveau;
import com.sigep.gbc.repository.AccesCodeRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccesCodeServiceImpl implements AccesCodeService{
	
	private final AccesCodeRepository repository;
	private final AccesCodeNiveauService acnService;
	private final AgentsService aService;
	private final GrpeCodeService gcService;

	@Override
	@Transactional("gbcTransactionManager")
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
				new Date(), 
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
		accesCode.setDateCreat(new Date());
		accesCode.setAccesCodeNiveau(acnService.get(accesCodeDto.getCode()));
		accesCode.setGrpeCode(gcService.get(accesCodeDto.getGrpe()));
		accesCode.setAgents(aService.get(accesCodeDto.getMle()));
		
		return GbcMapper.acToAcDto(accesCode);
	}

	@Override
	public List<AccesCodeDto> getAll() {
		List<AccesCode> accesCodes = repository.findAll();
		return accesCodes
				.stream().map(element  -> GbcMapper.acToAcDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public AccesCode get(String id) {
		return repository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("AccesCode with id: " + id + " could not be found"));
	}

	@Override
	public AccesCodeDto getById(String id) {
		AccesCode accesCode = get(id);
		return GbcMapper.acToAcDto(accesCode);
	}

	@Override
	@Transactional("gbcTransactionManager")
	public AccesCodeDto delete(String id) {
		AccesCode accesCode = get(id);
		repository.delete(accesCode);
		return GbcMapper.acToAcDto(accesCode);
	}

	@Override
	@Transactional("gbcTransactionManager")
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
		return GbcMapper.acToAcDto(accesCode);
	}

	@Override
	public Integer getMaxRangCod(String code) {
		return repository.getMaxRangCod(code);
	}

	@Override
	public List<AccesCodeDto> getByAccesCodeNiveau(String code) {
		AccesCodeNiveau accesCodeNiveau = acnService.get(code);
		List<AccesCode> accesCodes = repository.findByAccesCodeNiveau(accesCodeNiveau);
		return accesCodes
				.stream().map(element  -> GbcMapper.acToAcDto(element))
				.collect(Collectors.toList());
	}

	@Override
	public List<AccesCodeAgentDto> getUtilisateur() {
		return repository.getUtilisateur();
	}

}
